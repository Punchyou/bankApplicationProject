package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.persistence.repo.AccountService;

@SpringBootApplication
public class bankingAppApplication {

	public static void main(String[] args) {
		
		ApplicationContext ac = SpringApplication.run(bankingAppApplication.class, args);
		AccountService service = ac.getBean(AccountService.class);
		service.createAccount(new Account(""))
	
	}

}
