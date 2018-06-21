package online.shixun.demo.eshop.eshopservicetype.module.type.service;


import online.shixun.demo.eshop.eshopservicetype.core.service.BeanEnum;
import online.shixun.demo.eshop.eshopservicetype.core.service.Node;
import online.shixun.demo.eshop.eshopservicetype.core.service.RecursionService;
import online.shixun.demo.eshop.eshopservicetype.core.service.TypeNodeEnum;
import online.shixun.demo.eshop.eshopservicetype.dto.EshopType;
import online.shixun.demo.eshop.eshopservicetype.dto.EshopTypeCriteria;
import online.shixun.demo.eshop.eshopservicetype.module.type.mapper.EshopTypeMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 *
 *********************************************/
@Service
public class EshopTypeService implements RecursionService<EshopType, String> {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private EshopTypeMapper eshopTypeMapper;

    /**
     * 初始化商品类型
     *
     * @return
     */
    public List<Node<EshopType>> initProductTypeMenu() {
        logger.info("init product type ");
        return initNode(TypeNodeEnum.ROOT.getName());
    }

    @Override
    public void initNode(Node<EshopType> node) {
        //查询节点的子节点
        eshopTypeMapper.findChildren(node.getData().getId()).forEach(tempNode -> {
            //包装子节点类型
            Node next_node = new Node(tempNode.getId(), tempNode.getTypeName(), tempNode.getTypeIndex(), tempNode);
            //将子节点添加到主节点中
            node.getNodes().add(next_node);
            //递归初始化
            initNode(next_node);
            //排序刚初始化完成的节点
            Collections.sort(node.getNodes());
        });
    }

    @Override
    public List<Node<EshopType>> initNode(String rootNodeId) {
        EshopType node = eshopTypeMapper.selectByPrimaryKey(rootNodeId);
        Node menu = new Node(node.getId(), node.getTypeName(), node.getTypeIndex(), node);
        initNode(menu);
        return menu.getNodes();
    }


    /**
     * 递归加载当前类型的所有父类型
     *
     * @param nodeId
     * @return
     */
    public List<EshopType> initParentNode(String nodeId) {
        List<EshopType> parents = new ArrayList<>();
        EshopType node = eshopTypeMapper.selectByPrimaryKey(nodeId);
        initParentNode(node, parents);
        return parents;
    }

    /**
     * 递归加载当前类型的所有父类型
     *
     * @param node
     * @param parents
     * @return
     */
    private List<EshopType> initParentNode(EshopType node, List<EshopType> parents) {
        if (Objects.isNull(node) || Objects.isNull(node.getTypeParentId())) {
            return parents;
        }
        EshopType eshopType = eshopTypeMapper.selectByPrimaryKey(node.getTypeParentId());
        parents.add(eshopType);
        initParentNode(eshopType, parents);
        return parents;
    }


    public List<EshopType> getTypes(EshopType type) {
        EshopTypeCriteria eshopTypeCriteria = new EshopTypeCriteria();
        EshopTypeCriteria.Criteria criteria = eshopTypeCriteria.createCriteria();
        criteria.andIsDelEqualTo(BeanEnum.UNDEL.getIndex());//未删
        if (Objects.nonNull(type)) {
            //其他条件
            if (Objects.nonNull(type.getTypeParentId())) {
                criteria.andTypeParentIdEqualTo(type.getTypeParentId());
            }
        }
        return eshopTypeMapper.selectByExample(eshopTypeCriteria);
    }
}
