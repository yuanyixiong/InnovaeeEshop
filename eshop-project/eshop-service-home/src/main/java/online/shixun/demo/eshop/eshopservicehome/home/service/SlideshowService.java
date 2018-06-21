/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 *
 *********************************************/
package online.shixun.demo.eshop.eshopservicehome.home.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @ClassName SlideshowService
 * @Description TODO
 * @Date 2018/06/14 13:41
 * @Author shixun.online
 * @Version 1.0
 **/
@FeignClient(value = "service-slideshow", fallback = SlideshowServiceHystric.class)
public interface SlideshowService {

    @GetMapping("slideshow/getSlideshows")
    Object getSlideshows(@RequestParam(value = "keyword") String keyword);

}

@Component
class SlideshowServiceHystric implements SlideshowService {

    @Override
    public Object getSlideshows(String keyword) {
        System.out.println("熔断机制");
        return null;
    }
}
