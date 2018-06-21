/********************************************
 * Copyright (c) 2017, www.qingshixun.com
 *
 * All rights reserved
 *
 *********************************************/
package online.shixun.demo.eshop.eshopservicehome.config.thymeleaf;

import org.springframework.stereotype.Component;

@Component
public class Math {

    /**
     * 生成1-number之间的随机数
     *
     * @param number
     * @return
     */
    public long random(int number) {
        return java.lang.Math.round(java.lang.Math.random() * (number - 1) + 1);
    }
}
