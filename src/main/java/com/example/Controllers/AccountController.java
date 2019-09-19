package com.example.Controllers;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.persistence.domain.Account;
import com.example.persistence.repo.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {
	private AccountService service;

	public AccountController(AccountService service) {
		this.service = service;
	}

	@PostMapping("/create")
	public ResponseEntity<Account> createAccount(@RequestBody Account account){
		return this.service.createAccount(account);
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<List<Account>> findAll() {
		return this.service.findAll();
	}
	
	@PutMapping("/update")
	public ResponseEntity<Account> updateAccount(@RequestBody Account account, @PathParam("id") Long id) {
		return this.service.updateAccount(account, id);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> deleteAccount(@PathVariable("id") Long id) {
		return this.service.deleteAccount(id);
	}
}
