package com.khouloud.cms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class CustomerManagementsApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerManagementsApplication.class, args);
    }

}
