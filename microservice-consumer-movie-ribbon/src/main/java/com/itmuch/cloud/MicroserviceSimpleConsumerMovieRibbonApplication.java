package com.itmuch.cloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class MicroserviceSimpleConsumerMovieRibbonApplication {
	@Autowired
	private RestTemplateBuilder restTemplateBuilder;


	@Bean
	@LoadBalanced
	public RestTemplate restTemplate(){
		return restTemplateBuilder.build();
	}

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceSimpleConsumerMovieRibbonApplication.class, args);
	}
}
