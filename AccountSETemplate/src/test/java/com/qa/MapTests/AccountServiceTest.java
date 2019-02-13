package com.qa.MapTests;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.qa.persistence.domain.Account;
import com.qa.persistence.repository.AccountMapRepository;

public class AccountServiceTest {
	
	AccountMapRepository repo;

	@Before
	public void setup() {
	repo = new AccountMapRepository(0);
	}
	
	@Test
	public void addAccountTest() {
		assertEquals("Account created.", repo.createAccount("{\"firstName\":\"Bobby\",\"lastName\":\"Bobson\",\"accountNumber\":666}"));
	}
	
	@Test
	public void add2AccountsTest() {
		//fail("TODO");	
	}

	@Test
	public void removeAccountTest() {
		//fail("TODO");	
	}
	
	@Test
	public void remove2AccountsTest() {
		//fail("TODO");	
	}
	
	@Test
	public void remove2AccountTestAnd1ThatDoesntExist() {
		//fail("TODO");	
	}
	
	@Test
	public void jsonStringToAccountConversionTest() {
		// testing JSONUtil
		////fail("TODO");	
	}


	@Test
	public void accountConversionToJSONTest() {
		//testing JSONUtil
		////fail("TODO");	
	}

	@Test
	public void getCountForFirstNamesInAccountWhenZeroOccurances() {
		//For a later piece of functionality
		////fail("TODO");	
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
