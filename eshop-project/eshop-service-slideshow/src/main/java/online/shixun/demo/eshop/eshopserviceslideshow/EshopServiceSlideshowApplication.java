package online.shixun.demo.eshop.eshopserviceslideshow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class EshopServiceSlideshowApplication {

    public static void main(String[] args) {
        SpringApplication.run(EshopServiceSlideshowApplication.class, args);
    }
}
