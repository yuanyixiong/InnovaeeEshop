package online.shixun.demo.eshop.eshopeureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EshopEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(EshopEurekaApplication.class, args);
    }

}