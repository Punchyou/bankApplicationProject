package com.example.demo;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.persistence.domain.Account;
import com.example.persistence.repo.AccountNumGenService;
import com.example.persistence.repo.AccountRepo;
import com.example.persistence.repo.AccountService;
import com.example.persistence.repo.PrizeGenService;

@RunWith(SpringRunner.class)
public class AccountServiceUnitTest {
	
	private final Account ACCOUNT = new Account("Mariah", "Punchyou");
	private final Long ID = 2L;
	private final Long ACCNUM = 2468102945L;
	private final String PRIZE = "£2387429837";
	
	@Before
	public void init() {
		this.ACCOUNT.setId(ID);
		this.ACCOUNT.setAccountNumber(ACCNUM);
		this.ACCOUNT.setPrizeNumber(PRIZE);

	}
	
	@Test
	public void createAccount() {
		Mockito.when(this.repo.save(ACCOUNT)).thenReturn(ACCOUNT);
//		Mockito.when(this.accountNum.genNumber(ACCOUNT)).thenReturn(ACCNUM);
		Mockito.when(this.prize.genPrize(ACCOUNT)).thenReturn(PRIZE);
		ResponseEntity<Account> testResponse = ResponseEntity.ok(ACCOUNT);
		assertEquals(testResponse, this.service.createAccount(ACCOUNT));
		Mockito.verify(this.repo).save(ACCOUNT);
	}
	
	@InjectMocks
	private AccountService service;
	
	@Mock
	private AccountRepo repo;
	
	@Mock
	private PrizeGenService prize;
	
	@Mock
	private AccountNumGenService accountNum;
}
