package com.qa.business.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.business.service.AccountServiceImpl;
import com.qa.persistence.repository.AccountRepository;
import com.qa.util.JSONUtil;

@RunWith(MockitoJUnitRunner.class)
public class ServiceTest {

	
	
	@InjectMocks
	private  AccountServiceImpl service;
	
	@Mock
	AccountRepository repo;
	
	@Mock
	private JSONUtil util;
	
	private static final String MOCK_OBJECT = "{\"firstName\":\"Aidan\",\"lastName\":\"Lang\",\"accountNumber\":1234}";
	@Before
	public void setup() {
		
		util = new JSONUtil();
		service.setRepo(repo);
		service.setUtil(util);
	}

	@Test
	public void addAccountTest() {
		Mockito.when(repo.createAccount(MOCK_OBJECT)).thenReturn(MOCK_OBJECT);
		assertEquals(MOCK_OBJECT,service.addAcount(MOCK_OBJECT));
		Mockito.verify(repo).createAccount(MOCK_OBJECT);
	}
	
	@Test
	public void getAllAccountsTest() {
		Mockito.when(repo.getAllAccounts()).thenReturn(MOCK_OBJECT);
		assertEquals(MOCK_OBJECT, service.getAllAccounts());
	}
	
	@Test
	public void deleteAccountTest() {
		String reply = repo.deleteAccount(1L);
		//assertEquals(reply,"{\"message\": \"account successfully deleted\"}" );
	}





}
