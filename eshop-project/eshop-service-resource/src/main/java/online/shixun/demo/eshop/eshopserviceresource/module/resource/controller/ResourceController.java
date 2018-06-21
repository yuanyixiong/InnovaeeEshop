/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 *
 *********************************************/
package online.shixun.demo.eshop.eshopserviceresource.module.resource.controller;

import online.shixun.demo.eshop.eshopserviceresource.core.service.Node;
import online.shixun.demo.eshop.eshopserviceresource.dto.EshopResource;
import online.shixun.demo.eshop.eshopserviceresource.module.resource.service.EshopResourceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName ResourceController
 * @Description TODO
 * @Date 2018/06/14 10:12
 * @Author shixun.online
 * @Version 1.0
 **/
@RestController
@RequestMapping("/resource")
public class ResourceController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private EshopResourceService resourceService;


    /**
     * 水平导航栏菜单
     *
     * @return
     */
    @GetMapping("/getLevelNavigation")
    public List<Node<EshopResource>> getLevelNavigation() {
        return resourceService.initLevelNavigation();
    }

    /**
     * 垂直导航栏菜单
     *
     * @return
     */
    @GetMapping("/getVerticalNavigation")
    public List<Node<EshopResource>> getVerticalNavigation() {
        return resourceService.initVerticalNavigation();
    }
}
