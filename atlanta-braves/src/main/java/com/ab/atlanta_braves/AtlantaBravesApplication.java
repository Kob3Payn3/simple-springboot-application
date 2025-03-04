package com.ab.atlanta_braves;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;

@SpringBootApplication
public class AtlantaBravesApplication extends WebMvcAutoConfiguration {

	public static void main(String[] args) {
		SpringApplication.run(AtlantaBravesApplication.class, args);
	}

}
