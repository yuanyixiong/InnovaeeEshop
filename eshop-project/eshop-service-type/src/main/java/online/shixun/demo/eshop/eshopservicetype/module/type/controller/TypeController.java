/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 *
 *********************************************/
package online.shixun.demo.eshop.eshopservicetype.module.type.controller;

import online.shixun.demo.eshop.eshopservicetype.core.service.Node;
import online.shixun.demo.eshop.eshopservicetype.dto.EshopType;
import online.shixun.demo.eshop.eshopservicetype.module.type.service.EshopTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName TypeController
 * @Description TODO
 * @Date 2018/06/14 10:58
 * @Author shixun.online
 * @Version 1.0
 **/
@RestController
@RequestMapping("/type")
public class TypeController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private EshopTypeService typeService;

    /**
     * 产品类型
     * @return
     */
    @GetMapping("/getProductTypeMenu")
    public List<Node<EshopType>> getProductTypeMenu(){
        return typeService.initProductTypeMenu();
    }
}
