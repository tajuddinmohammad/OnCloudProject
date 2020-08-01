package com.oncould.ServiceRegisterServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ServiceRegisterServerApplication {

	public static void main(String[] args) {
		//System.setProperty("spring.config.name", "registration-server");
		SpringApplication.run(ServiceRegisterServerApplication.class, args);
	}

}
