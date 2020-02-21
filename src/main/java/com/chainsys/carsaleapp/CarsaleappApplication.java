package com.chainsys.carsaleapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@ServletComponentScan("com.chainsys.carsale.servlet")
public class CarsaleappApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarsaleappApplication.class, args);
	}

}
