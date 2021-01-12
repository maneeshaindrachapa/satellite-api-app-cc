package com.cloud.satelliteapi;

import com.cloud.satelliteapi.exception.handler.RestTemplateResponseErrorHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@SpringBootApplication
@EntityScan(basePackages = "com.cloud.satelliteapi")
@EnableJpaRepositories(basePackages = "com.cloud.satelliteapi")
@ComponentScan(basePackages = "com.cloud.satelliteapi")
public class SatelliteApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SatelliteApiApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplateBuilder()
				.errorHandler(new RestTemplateResponseErrorHandler())
				.build();
	}

	@PostConstruct
	public void init() {
		TimeZone.setDefault(TimeZone.getDefault());
	}
}
