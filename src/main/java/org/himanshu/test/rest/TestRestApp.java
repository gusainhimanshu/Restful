package org.himanshu.test.rest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestRestApp {

	public static void main(String[] args) {
		SpringApplication.run(TestRestApp.class, args);
	}

}