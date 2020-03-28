package com.example.pidservice;

import com.example.pidservice.redis.SecondKill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class SpringBootRunner implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRunner.class, args);
	}


	@Autowired
	SecondKill secondKill;

	public void run(String... args) {
		secondKill.run();
	}


}
