/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 *
 *********************************************/
package online.shixun.demo.eshop.eshopserviceproduct.module.product.service;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import online.shixun.demo.eshop.eshopserviceproduct.dto.EshopProductWithBLOBs;
import online.shixun.demo.eshop.eshopserviceproduct.module.product.mapper.EshopProductMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;


@Service
public class EshopProductService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private EshopProductMapper productMapper;

    /**
     * 分页查询商品
     *
     * @param productName [条件]商品名称
     * @param type        [条件]父类型id
     * @param types_set   [条件]子类型id集合
     * @param prices_set  [条件]价格集合(最低-最高)示例：0-50,200-300,800-1500
     * @param colors_set  [条件]颜色id集合
     * @param brands_set  [条件]品牌id集合
     * @param sizes_set   [条件]尺码id集合
     * @param pageNum     页码
     * @param pageSize    显示数据条数
     * @return 分页数据
     */
    public PageInfo getProducts(String productName, String type, Set<String> types_set, Set<String> prices_set, Set<String> colors_set, Set<String> brands_set, Set<String> sizes_set, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<EshopProductWithBLOBs> list = productMapper.getProducts(productName, type, types_set, prices_set, colors_set, brands_set, sizes_set);
        PageInfo<EshopProductWithBLOBs> pageInfo = new PageInfo<EshopProductWithBLOBs>(list);//获取分页信息
        System.out.println(pageInfo);
        return pageInfo;
    }

}
