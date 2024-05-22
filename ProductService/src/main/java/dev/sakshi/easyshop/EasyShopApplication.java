package dev.sakshi.easyshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EasyShopApplication {

    public static void main(String[] args) {
        SpringApplication.run(EasyShopApplication.class, args);
    }

}
