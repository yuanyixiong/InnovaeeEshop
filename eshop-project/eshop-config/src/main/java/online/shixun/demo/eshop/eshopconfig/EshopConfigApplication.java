package online.shixun.demo.eshop.eshopconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableConfigServer
@SpringBootApplication
public class EshopConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(EshopConfigApplication.class, args);
	}
}
