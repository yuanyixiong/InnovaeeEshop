package online.shixun.demo.eshop.eshopzipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin.server.EnableZipkinServer;


@EnableZipkinServer
@SpringBootApplication
public class EshopZipkinApplication {

	//http://localhost:11001/zipkin

	public static void main(String[] args) {
		SpringApplication.run(EshopZipkinApplication.class, args);
	}
}
