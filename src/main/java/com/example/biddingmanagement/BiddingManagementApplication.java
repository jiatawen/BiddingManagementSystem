package com.example.biddingmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.example.biddingmanagement","com.example.service"})
public class BiddingManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(BiddingManagementApplication.class, args);
    }

}