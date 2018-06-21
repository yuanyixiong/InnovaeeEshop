package online.shixun.demo.eshop.eshopturbine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@EnableTurbine
@EnableHystrixDashboard
@SpringBootApplication
public class EshopTurbineApplication {

    //fegin
    //http://localhost:10021/hystrix.stream

    //ribbon

    //http://localhost:11006/hystrix
    //http://localhost:11006/turbine.stream
    public static void main(String[] args) {
        SpringApplication.run(EshopTurbineApplication.class, args);
    }
}
