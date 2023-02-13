package com.cards.cardsmicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@SpringBootApplication
@RefreshScope
public class CardsMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CardsMicroserviceApplication.class, args);
	}

}
