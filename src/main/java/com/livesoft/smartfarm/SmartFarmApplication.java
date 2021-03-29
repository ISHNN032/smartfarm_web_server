package com.livesoft.smartfarm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class SmartFarmApplication extends SpringBootServletInitializer {

	static {
		System.setProperty("spring.config.location", "classpath:/application.yml,classpath:/smartfarm.yml");
	}

	public static void main(String[] args) {
		SpringApplication.run(SmartFarmApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(SmartFarmApplication.class);
	}
}
