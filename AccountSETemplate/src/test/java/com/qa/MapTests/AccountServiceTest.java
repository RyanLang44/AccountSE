package com.qa.MapTests;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.qa.persistence.domain.Account;
import com.qa.persistence.repository.AccountMapRepository;

public class AccountServiceTest {
	
	AccountMapRepository repo = new AccountMapRepository();

	@Before
	public void setup() {
	//comment
	}
	
	@Test
	public void addAccountTest() {
		assertEquals("Account created.", repo.createAccount("{\"firstName\":\"Bobby\",\"lastName\":\"Bobson\",\"accountNumber\":666}"));
	}
	
	@Test
	public void add2AccountsTest() {
		fail("TODO");	
	}

	@Test
	public void removeAccountTest() {
		fail("TODO");	
	}
	
	@Test
	public void remove2AccountsTest() {
		fail("TODO");	
	}
	
	@Test
	public void remove2AccountTestAnd1ThatDoesntExist() {
		fail("TODO");	
	}
	
	@Test
	public void jsonStringToAccountConversionTest() {
		// testing JSONUtil
		fail("TODO");	
	}


	@Test
	public void accountConversionToJSONTest() {
		//testing JSONUtil
		fail("TODO");	
	}

	@Test
	public void getCountForFirstNamesInAccountWhenZeroOccurances() {
		//For a later piece of functionality
		fail("TODO");	
	}
	
	@Test
	public void getCountForFirstNamesInAccountWhenOne() {
		//For a later piece of functionality
		fail("TODO");	
	}

	@Test
	public void getCountForFirstNamesInAccountWhenTwo() {
		//For a later piece of functionality
		fail("TODO");	
	}

}
