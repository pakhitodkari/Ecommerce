package com.pv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"pv.com.service.OrderService"})
@ComponentScan(value = {"pv.com.service.OrderService"})
@EnableCaching
public class EcommerceOrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceOrderApplication.class, args);
	}

    @Bean
    RestTemplate getRestTemplate()
	{
		return new RestTemplate();
	}

}
