package com.example.pidservice;

import com.example.pidservice.test.C1;
import com.example.pidservice.test.C2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class SpringBootRunner implements CommandLineRunner {

    @Autowired
    C1 c1;
    @Autowired
    C2 c2;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRunner.class, args);
	}

	public void run(String... args) {
        System.out.println(c1.getter1);
        System.out.println(c2.getter1);

        System.out.println(c1.getter1.equals(c2.getter1));

        Scanner scanner = new Scanner(System.in);
        List<String> list = Arrays.asList("exit", "logout", "quit");
        while(scanner.hasNextLine()){
            String s1 = scanner.nextLine();
            if(list.contains(s1.toLowerCase())){
                System.exit(0);
            }
        }
	}


}
