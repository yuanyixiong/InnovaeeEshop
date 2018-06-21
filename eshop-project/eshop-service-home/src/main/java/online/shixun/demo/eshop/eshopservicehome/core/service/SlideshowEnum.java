/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 *
 *********************************************/
package online.shixun.demo.eshop.eshopservicehome.core.service;

/**
 * @ClassName SlideshowEnum
 * @Description TODO
 * @Date 2018/05/21 14:52
 * @Author shixun.online
 * @Version 1.0
 **/
public enum SlideshowEnum {

    INDEX_MAIN("首页-轮播图", "index-main"),
    INDEX_CAMERA("首页-数码-轮播图", "index-camera"),
    INDEX_JEWELRY("首页-珠宝-轮播图", "index-jewelry"),
    INDEX_SPORT("首页-运动器材-轮播图", "index-sport"),
    CATEGORY_MAIN("商品检索页-轮播图", "category-main");

    SlideshowEnum(String name, String keyword) {
        this.name = name;
        this.keyword = keyword;
    }

    private String name;//轮播图名称
    private String keyword;//轮播图关键字

    public String getKeyword() {
        return keyword;
    }
}
