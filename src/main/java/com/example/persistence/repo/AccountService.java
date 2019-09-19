package com.example.persistence.repo;

import java.math.*;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.persistence.domain.Account;


@Service
public class AccountService {
	
	@Autowired
	private AccountRepo repo;
	
	@Autowired
	private AccountNumGenService numGen;
	
	@Autowired
	private PrizeGenService prizeGen;
	
	
	public ResponseEntity<Account> createAccount(Account account) {
		numGen.genNumber(account);
		account.setPrizeNumber(prizeGen.genPrize(account));
		
		return ResponseEntity.ok(this.repo.save(account));
	}
	
	// read method
	public ResponseEntity<List<Account>> findAll(){
		return ResponseEntity.ok(this.repo.findAll());
	}
	
	public ResponseEntity<Account> updateAccount(Account account, Long id) {
		Account toUpdate = this.repo.findById(id).get();
		toUpdate.setFirstname(account.getFirstname());
		toUpdate.setLastname(account.getLastname());
//		toUpdate.setAccountNumber(account.getAccountNumber());
		return ResponseEntity.ok(this.repo.save(toUpdate));
	}
	
	public ResponseEntity<Boolean> deleteAccount(Long id) {
		this.repo.deleteById(id);
		return ResponseEntity.ok(this.repo.existsById(id));
	}
		
}