package com.example.persistence.repo;

import java.util.Random;

import org.springframework.stereotype.Service;

import com.example.persistence.domain.Account;
@Service
public class PrizeGenService {
	
	public String genPrize(Account account) {
		Random rand = new Random();
		int num = rand.nextInt(3);
		String prize;
		if(account.getAccountNumber() % 3 == 0) {
			prize = "Sorry, next time!";
		} else if (account.getAccountNumber() % 3 == 1) {
			prize = "$100";
		} else {
			prize = "$500";
		}
		return prize;

	}

}
