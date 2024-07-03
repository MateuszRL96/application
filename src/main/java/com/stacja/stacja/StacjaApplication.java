package com.stacja.stacja;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class StacjaApplication {

	public static void main(String[] args) {
		SpringApplication.run(StacjaApplication.class, args);
	}

}
