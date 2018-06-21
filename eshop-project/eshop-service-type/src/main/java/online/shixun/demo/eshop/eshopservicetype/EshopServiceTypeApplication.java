package online.shixun.demo.eshop.eshopservicetype;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class EshopServiceTypeApplication {

	public static void main(String[] args) {
		SpringApplication.run(EshopServiceTypeApplication.class, args);
	}
}
