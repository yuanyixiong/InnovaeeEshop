/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 *
 *********************************************/
package online.shixun.demo.eshop.eshopservicehome.home.controller;

import online.shixun.demo.eshop.eshopservicehome.core.service.SlideshowEnum;
import online.shixun.demo.eshop.eshopservicehome.home.service.ProductService;
import online.shixun.demo.eshop.eshopservicehome.home.service.ResourceService;
import online.shixun.demo.eshop.eshopservicehome.home.service.SlideshowService;
import online.shixun.demo.eshop.eshopservicehome.home.service.TypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @ClassName HomeController
 * @Description TODO
 * @Date 2018/06/14 10:32
 * @Author shixun.online
 * @Version 1.0
 **/
@RestController
public class HomeController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ProductService productService;
    @Autowired
    private ResourceService resourceService;
    @Autowired
    private TypeService typeService;
    @Autowired
    private SlideshowService slideshowService;

    /**
     * 首页 tab 页的商品加载
     *
     * @param mav
     * @param types
     * @param pageSize
     * @return
     */
    @GetMapping("/home/getProducts")
    public Object getProducts(ModelAndView mav, @RequestParam(defaultValue = "") String types, @RequestParam(defaultValue = "1") Integer pageSize) {
        mav.addObject("pageInfo", productService.getProducts(types, pageSize));
        mav.setViewName("/fragment/index/products");
        return mav;
    }

    /**
     * 首页菜单加载
     *
     * @param mav
     * @return
     */
    @RequestMapping(value = {"/", "/index", "/home"}, method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView home(ModelAndView mav) {

        //加载水平导航栏菜单
        mav.addObject("levelNavigationMenu", resourceService.getLevelNavigation());
        //加载垂直导航栏菜单
        mav.addObject("verticalNavigationMenu", resourceService.getVerticalNavigation());
        //加载商品类型
        mav.addObject("productTypeMenu", typeService.getProductTypeMenu());

        //首页-轮播图
        mav.addObject("main_slideshows", slideshowService.getSlideshows(SlideshowEnum.INDEX_MAIN.getKeyword()));
        //首页-数码-轮播图
        mav.addObject("camera_slideshows", slideshowService.getSlideshows(SlideshowEnum.INDEX_CAMERA.getKeyword()));
        //首页-珠宝-轮播图
        mav.addObject("jewelry_slideshows", slideshowService.getSlideshows(SlideshowEnum.INDEX_JEWELRY.getKeyword()));
        //首页-运动-轮播图
        mav.addObject("sport_slideshows", slideshowService.getSlideshows(SlideshowEnum.INDEX_SPORT.getKeyword()));

        //设置转发的页面
        mav.setViewName("/index");

        return mav;
    }
}
