package online.shixun.demo.eshop.eshopserviceproduct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;

@EnableEurekaClient
@SpringBootApplication
public class EshopServiceProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(EshopServiceProductApplication.class, args);
	}

	@Bean
	public AlwaysSampler defaultSampler(){
		return new AlwaysSampler();
	}
}
