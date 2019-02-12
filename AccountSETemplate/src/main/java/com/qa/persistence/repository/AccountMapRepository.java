package com.qa.persistence.repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.qa.persistence.domain.Account;
import com.qa.util.JSONUtil;
import com.qa.util.JackSonUtil;

public class AccountMapRepository implements AccountRepository{
	
	//JackSonUtil util = new JackSonUtil();
	JSONUtil util = new JSONUtil();
	private static long id;
	
	Map<Long, Account> accountMap = new HashMap<Long, Account>();
	
	//You must provide concrete implementation for each of these methods
	//do not change the method signature

	public String getAllAccounts() {
		String str = "";
		for (Entry<Long, Account> entry: accountMap.entrySet()) {
			str += util.getJSONForObject(entry.getValue());
		}
		return str;
	}

	public String createAccount(String account) {
		this.accountMap.put(id++, util.getObjectForJSON(account, Account.class));
		return "Account created.";
	}

	public String deleteAccount(Long id) {
		this.accountMap.remove(id);
		return "Account has been removed.";
	}

	public String updateAccount(Long id, String account) {
		this.accountMap.replace(id, util.getObjectForJSON(account, Account.class));
		return "Account updated.";
	}
	public int getFirstNameCount(String name) {
		int count = 0;
		System.out.println(accountMap);
		for (Long i=(long) 0; i < accountMap.size();i++) {
			if(accountMap.get(i).getFirstName().equals(name)) {
				count++;
			}
		}
		return count;
	}

}
