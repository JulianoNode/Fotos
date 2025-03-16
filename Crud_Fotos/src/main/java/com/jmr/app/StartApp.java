package com.jmr.app;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StartApp {

	public static void main(String[] args) {
		Tabelas recursos = new Tabelas();
		
		SpringApplication app = new SpringApplication(StartApp.class);
		app.setDefaultProperties(Collections.singletonMap("server.port", "8082"));
		app.run(args);
		System.out.println(recursos.runProgeto());
		
		
	}

}
