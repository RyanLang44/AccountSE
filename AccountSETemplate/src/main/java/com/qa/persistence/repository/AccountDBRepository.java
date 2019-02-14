package com.qa.persistence.repository;

import java.util.Collection;
import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.qa.persistence.domain.Account;
import com.qa.util.JSONUtil; 

@Transactional(SUPPORTS)
@Default
public class AccountDBRepository implements AccountRepository {

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil util;


	
	@Transactional(REQUIRED)
	public String getAllAccounts() {
		// TODO Auto-generated method stub
		Query query = manager.createQuery("Select a FROM Account a");
		Collection<Account> accounts = (Collection<Account>) query.getResultList();
		return util.getJSONForObject(accounts);
	}
	
	@Transactional(REQUIRED)
	public String createAccount(String account) {
		// TODO Auto-generated method stub
		Account newAccount = util.getObjectForJSON(account, Account.class);
		manager.persist(newAccount);
		return "{\"message\": \" account created successfully\"}";
	}

	@Transactional(REQUIRED)
	public String deleteAccount(Long id) {

		Account accountInDB = util.getObjectForJSON(getAnAccount(id), Account.class);

		if (manager.contains(manager.find(Account.class, id))) {
			manager.remove(manager.find(Account.class, id));
		}

		return "{\"message\": \"account successfully deleted\"}";
	}

	@Transactional(REQUIRED)
	public String updateAccount(Long id, String account) {
		Account temp = new Account();
		temp = util.getObjectForJSON(account, Account.class);
		manager.persist(temp);
		deleteAccount(id);
		
		return "{\"message\": \"account updated\"}";
	}

	@Transactional(REQUIRED)
	public String getAnAccount(Long id) {
		// TODO Auto-generated method stub
		return util.getJSONForObject(manager.find(Account.class, id));
	}
	
	public void setManager(EntityManager manager) {
		this.manager = manager;
	}
	
	public void setUtil(JSONUtil util) {
		this.util = util;
	}

}
