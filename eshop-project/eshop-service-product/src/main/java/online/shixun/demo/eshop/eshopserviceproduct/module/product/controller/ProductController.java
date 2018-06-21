/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 *
 *********************************************/
package online.shixun.demo.eshop.eshopserviceproduct.module.product.controller;

import com.github.pagehelper.PageInfo;
import online.shixun.demo.eshop.eshopserviceproduct.dto.EshopProductWithBLOBs;
import online.shixun.demo.eshop.eshopserviceproduct.module.product.service.EshopProductService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @ClassName ProductController
 * @Description TODO
 * @Date 2018/06/11 17:01
 * @Author shixun.online
 * @Version 1.0
 **/
@RestController
@RequestMapping(value = "/product")
public class ProductController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private EshopProductService productService;

    /**
     * 加载商品列表
     *
     * @param types 子类型id数组字符串","分割 示例：1，2，4
     * @return
     */
    @GetMapping("/getProducts")
    public PageInfo<EshopProductWithBLOBs> getProducts(@RequestParam(defaultValue = "") String types, @RequestParam(defaultValue = "1") Integer pageSize) {
        logger.info("types:" + types);
        //拆分数组成集合
        Set<String> types_set = Arrays.stream(types.split(",")).filter(StringUtils::isNotBlank).collect(Collectors.toSet());
        //查询商品
        return productService.getProducts(null, null, types_set, null, null, null, null, 1, pageSize);
    }
}
