package com.nets.springSecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@EnableJpaRepositories(basePackages="com.bytestree.restful.repository")
@SpringBootApplication(scanBasePackages={"com.nets.springSecurity"})
public class SecureAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecureAppApplication.class, args);
		//test
		//$2a$10$UXMNVLzQm3fRYf6oNvhaEO8L6se0SHmyT3ypwSlsAtvFwp1JdJMlK
	}

}
