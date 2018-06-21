/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 *
 *********************************************/
package online.shixun.demo.eshop.eshopservicehome.home.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @ClassName ResourceService ribbon restTemplate
 * @Description TODO
 * @Date 2018/06/14 10:33
 * @Author shixun.online
 * @Version 1.0
 **/
@Service
public class ResourceService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "hiError")
    public Object getLevelNavigation() {
        return restTemplate.getForObject("http://service-resource/resource/getLevelNavigation", List.class);
    }

    @HystrixCommand(fallbackMethod = "hiError")
    public Object getVerticalNavigation() {
        return restTemplate.getForObject("http://service-resource/resource/getVerticalNavigation", List.class);
    }

    //熔断方法
    public String hiError() {
        return "ResourceService hiError";
    }

}
