/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 *
 *********************************************/
package online.shixun.demo.eshop.eshopserviceresource.module.resource.service;

import online.shixun.demo.eshop.eshopserviceresource.core.service.Node;
import online.shixun.demo.eshop.eshopserviceresource.core.service.RecursionService;
import online.shixun.demo.eshop.eshopserviceresource.core.service.ResourceNodeEnum;
import online.shixun.demo.eshop.eshopserviceresource.dto.EshopResource;
import online.shixun.demo.eshop.eshopserviceresource.module.resource.mapper.EshopResourceMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class EshopResourceService implements RecursionService<EshopResource, String> {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private EshopResourceMapper resourceMapper;

    /**
     * 初始化首页水平导航栏菜单
     *
     * @return
     */
    public List<Node<EshopResource>> initLevelNavigation() {
        logger.info("init level navigation:");
        return initNode(ResourceNodeEnum.EHSOP_CLIENT_LEVEL_NAVIGATION.getName());
    }

    /**
     * 初始化首页垂直平导航栏菜单
     *
     * @return
     */
    public List<Node<EshopResource>> initVerticalNavigation() {
        logger.info("init vertical navigation:");
        return initNode(ResourceNodeEnum.EHSOP_CLIENT_VERTICAL_NAVIGATION.getName());
    }

    @Override
    public void initNode(Node<EshopResource> node) {
        //查询主菜单的子菜单
        resourceMapper.findChildren(node.getData().getId()).forEach(tempNode -> {
            //包装子菜单类型
            Node next_node = new Node(tempNode.getId(), tempNode.getResourceName(), tempNode.getResourceIndex(), tempNode);
            //将子菜单添加到主菜单中
            node.getNodes().add(next_node);
            //递归初始化
            initNode(next_node);
            //排序刚初始化完成的菜单
            Collections.sort(node.getNodes());
        });
    }

    @Override
    public List<Node<EshopResource>> initNode(String rootNodeId) {
        EshopResource node = resourceMapper.selectByPrimaryKey(rootNodeId);
        Node menu = new Node(node.getId(), node.getResourceName(), node.getResourceIndex(), node);
        initNode(menu);
        return menu.getNodes();
    }

}
