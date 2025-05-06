package com.ems.ems_eureka_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EmsEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmsEurekaServerApplication.class, args);
	}

}
