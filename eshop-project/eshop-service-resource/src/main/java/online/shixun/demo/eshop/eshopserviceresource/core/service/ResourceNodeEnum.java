/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 *
 *********************************************/
package online.shixun.demo.eshop.eshopserviceresource.core.service;

/**
 * 资源节点的的枚举
 */
public enum ResourceNodeEnum {

    ROOT("root"),//整个系统的根节点
    EHSOP_ADMIN("ehsop_admin"),//服务器根节点
    EHSOP_CLIENT("ehsop_client"),//客户端根节点
    EHSOP_CLIENT_LEVEL_NAVIGATION("ehsop_client_level_navigation"),//客户端水平导航栏
    EHSOP_CLIENT_VERTICAL_NAVIGATION("ehsop_client_vertical_navigation");//客户端垂直导航栏

    // 成员变量
    protected String name;

    ResourceNodeEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
