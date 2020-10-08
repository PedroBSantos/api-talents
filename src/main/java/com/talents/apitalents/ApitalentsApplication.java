package com.talents.apitalents;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApitalentsApplication implements CommandLineRunner {

	@Autowired
	private StartH2Env startH2Env;

	public static void main(String[] args) {
		SpringApplication.run(ApitalentsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		startH2Env.start();
	}
}
