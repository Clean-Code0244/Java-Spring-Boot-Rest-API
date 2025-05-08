package com.omertursun.gallerist.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.omertursun"})
@EntityScan(basePackages = {"com.omertursun"})
@EnableJpaRepositories(basePackages = {"com.omertursun"})

public class GalleristApplicationStarter {

	public static void main(String[] args) {
		SpringApplication.run(GalleristApplicationStarter.class, args);
	}

}
