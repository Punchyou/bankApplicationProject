package com.example.persistence.repo;

import java.util.Random;

import org.springframework.stereotype.Service;

import com.example.persistence.domain.Account;
@Service
public class AccountNumGenService {
	
	public void genNumber(Account account) {
		Random rand = new Random();
		int num = rand.nextInt(3);
		if(num == 0) account.setAccountNumber(Math.round(Math.random()*1000000));
        else if (num == 1)  account.setAccountNumber(Math.round(Math.random()*100000000));
        else {
            int m = (int) Math.pow(10, 10 - 1);
            account.setAccountNumber( (long) (m + new Random().nextInt(9 * m)));
        }

	}

}
