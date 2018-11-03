package com.example.SpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication(scanBasePackages = {"com.example.SpringBoot", "org.github.andythsu.GCP.Services"})
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}