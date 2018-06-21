/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 *
 *********************************************/
package online.shixun.demo.eshop.eshopservicetype.core.service;

/**
 * Bean的通用枚举
 */
public enum BeanEnum {
    DEL("已删", 1), UNDEL("未删", 2);//移除

    // 成员变量
    protected String name;
    protected int index;

    BeanEnum(String name, int index) {
        this.name = name;
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public int getIndex() {
        return index;
    }
}
