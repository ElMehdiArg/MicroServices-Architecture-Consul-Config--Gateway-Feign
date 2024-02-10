package org.sid.invetoryservice;

import org.sid.invetoryservice.entities.Product;
import org.sid.invetoryservice.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Random;

@SpringBootApplication
public class InvetoryServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(InvetoryServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(ProductRepository productRepository) {
		return args -> {
			Random random = new Random();
			for (int i = 0; i < 10; i++) {
				productRepository.saveAll(List.of(
						Product.builder()
								.name("computer" + i)
								.price(1200 + Math.random() * 1000)
								.quantity(1 + random.nextInt(200)).build()
				));
			}
			;
		};
	}

}
