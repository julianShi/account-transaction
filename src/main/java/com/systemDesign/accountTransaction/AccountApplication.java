package com.systemDesign.accountTransaction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
curl -X POST 'http://localhost:8080/account?balance=100'
curl -X GET 'http://localhost:8080/account/{id}
curl -X GET 'http://localhost:8080/account/
curl -X POST 'http://localhost:8080/account/22/transfer?to=23&amount=10'
 */
@SpringBootApplication
public class AccountApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountApplication.class, args);
	}

}
