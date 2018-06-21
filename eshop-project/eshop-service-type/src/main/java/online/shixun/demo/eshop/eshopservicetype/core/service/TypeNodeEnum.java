/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 *
 *********************************************/
package online.shixun.demo.eshop.eshopservicetype.core.service;

/**
 * 类型节点的的枚举
 */
public enum TypeNodeEnum {

    ROOT("root");//整个系统的根节点

    // 成员变量
    protected String name;

    TypeNodeEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
