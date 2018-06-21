/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 *
 *********************************************/
package online.shixun.demo.eshop.eshopservicehome.home.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @ClassName TypeService
 * @Description TODO
 * @Date 2018/06/14 11:03
 * @Author shixun.online
 * @Version 1.0
 **/
@FeignClient(value = "service-type", fallback = TypeServiceHystric.class)
public interface TypeService {
    //负载均衡
    @GetMapping("/type/getProductTypeMenu")
    Object getProductTypeMenu();
}

@Component
class TypeServiceHystric implements TypeService {
    @Override
    public Object getProductTypeMenu() {
        System.out.println("熔断机制");
        return null;
    }
}