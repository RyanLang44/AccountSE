package com.qa.MapTests;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.business.service.AccountServiceImpl;
import com.qa.persistence.domain.Account;
import com.qa.persistence.repository.AccountDBRepository;
import com.qa.persistence.repository.AccountMapRepository;
import com.qa.persistence.repository.AccountRepository;
import com.qa.util.JSONUtil;


public class AccountServiceTest {

	AccountMapRepository repo;
	
	
	
	@Before
	public void setup() {
		repo = new AccountMapRepository(0);
		
	}

	@Test
	public void addAccountTest() {
			}

	@Test
	public void removeAccountTest() {
		
	}


	@Test
	public void getCountForFirstNamesInAccountWhenOne() {

		repo.createAccount("{\"firstName\":\"John\",\"lastName\":\"Bobson\",\"accountNumber\":666}");
		repo.createAccount("{\"firstName\":\"Frank\",\"lastName\":\"Paul\",\"accountNumber\":667}");
		repo.createAccount("{\"firstName\":\"Bobby\",\"lastName\":\"Bobson\",\"accountNumber\":668}");
		assertEquals(1, repo.getFirstNameCount("John"));
	}

	@Test
	public void getCountForFirstNamesInAccountWhenTwo() {

		repo.createAccount("{\"firstName\":\"John\",\"lastName\":\"Bobson\",\"accountNumber\":666}");
		repo.createAccount("{\"firstName\":\"Frank\",\"lastName\":\"Paul\",\"accountNumber\":667}");
		repo.createAccount("{\"firstName\":\"John\",\"lastName\":\"Bobson\",\"accountNumber\":668}");
		assertEquals(2, repo.getFirstNameCount("John"));
	}

}
