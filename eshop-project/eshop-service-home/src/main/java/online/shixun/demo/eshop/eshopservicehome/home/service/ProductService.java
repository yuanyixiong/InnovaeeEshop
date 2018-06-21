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
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @ClassName ProductService fegin
 * @Description TODO
 * @Date 2018/06/11 16:54
 * @Author shixun.online
 * @Version 1.0
 **/
@FeignClient(value = "service-product", fallback = ProductServiceHystric.class)
public interface ProductService {

    @GetMapping("/product/getProducts")
    Object getProducts(@RequestParam(value = "types") String types, @RequestParam(value = "pageSize") Integer pageSize);
}

@Component
class ProductServiceHystric implements ProductService {

    @Override
    public Object getProducts(String types, Integer pageSize) {
        System.out.println("熔断机制");
        return null;
    }
}