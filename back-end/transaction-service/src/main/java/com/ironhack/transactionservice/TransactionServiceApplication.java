package com.ironhack.transactionservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
/**
 * Transaction Service Application
 */
@SpringBootApplication
@EnableDiscoveryClient
public class TransactionServiceApplication {
	/**
	 * Main
	 * @param args String array args
	 */
	public static void main(String[] args) {
		SpringApplication.run(TransactionServiceApplication.class, args);
	}

}
