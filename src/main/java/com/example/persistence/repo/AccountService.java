package com.example.persistence.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.persistence.domain.Account;


@Service
public class AccountService {
	
	@Autowired
	private AccountRepo repo;
	
	
	public Account createAccount(Account account) {
		return this.repo.save(account);
	}
	
	// read method
	public List<Account> findAll(){
		return this.repo.findAll();
	}
	
	public Account updateAccount(Account account, Long id) {
		Account toUpdate = this.repo.findById(id).get();
		toUpdate.setFirstname(account.getFirstname());
		toUpdate.setLastname(account.getLastname());
		toUpdate.setAccountNumber(account.getAccountNumber());
		return this.repo.save(toUpdate);
	}
	
	public boolean deleteAccount(Long id) {
		this.repo.deleteById(id);
		return this.repo.existsById(id);
	}
		
		
	}