package com.tcs.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableDiscoveryClient
@RefreshScope
@ComponentScan(basePackages = { "com.tcs.controller", "com.tcs.server" })
@EntityScan("com.tcs.dao")
@EnableJpaRepositories("com.tcs.dao")
public class EmployeeManagementServerWIthExceptionHandlingApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagementServerWIthExceptionHandlingApplication.class, args);
	}

}
