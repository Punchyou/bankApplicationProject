package com.example.persistence.repo;

import java.util.Random;

import org.springframework.stereotype.Service;

import com.example.persistence.domain.Account;
@Service
public class PrizeGenService {
	
	public void genPrize(Account account) {
		account.getAccountNumber();

	}

}
