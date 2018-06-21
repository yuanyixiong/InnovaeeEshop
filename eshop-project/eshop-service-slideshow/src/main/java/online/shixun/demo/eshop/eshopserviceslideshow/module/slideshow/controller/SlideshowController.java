/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 *
 *********************************************/
package online.shixun.demo.eshop.eshopserviceslideshow.module.slideshow.controller;

import online.shixun.demo.eshop.eshopserviceslideshow.core.service.SlideshowEnum;
import online.shixun.demo.eshop.eshopserviceslideshow.dto.EshopSlideshow;
import online.shixun.demo.eshop.eshopserviceslideshow.module.slideshow.service.EshopSlideshowService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @ClassName SlideshowController
 * @Description TODO
 * @Date 2018/06/14 11:18
 * @Author shixun.online
 * @Version 1.0
 **/
@RestController
@RequestMapping("/slideshow")
public class SlideshowController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private EshopSlideshowService slideshowService;


    /**
     * 根据轮播图关键字获得对应德轮播图可选值范围如下
     * index-main、index-jewelry、index-sport、category-main
     *
     * @param keyword
     * @return
     */
    @GetMapping("/getSlideshows")
    public List<EshopSlideshow> getSlideshows(String keyword) {
        return slideshowService.getSlideshows(Arrays.stream(SlideshowEnum.values()).filter(tempEnum -> Objects.equals(tempEnum.getKeyword(), keyword)).findFirst().get());
    }
}
