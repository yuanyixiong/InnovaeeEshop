package online.shixun.demo.eshop.eshopserviceresource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;

@EnableEurekaClient
@SpringBootApplication
public class EshopServiceResourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EshopServiceResourceApplication.class, args);
    }

    @Bean
    public AlwaysSampler defaultSampler(){
        return new AlwaysSampler();
    }
}
