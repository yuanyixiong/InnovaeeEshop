/********************************************
 * Copyright (c) 2017, www.qingshixun.com
 *
 * All rights reserved
 *
 *********************************************/
package online.shixun.demo.eshop.eshopservicehome.config.thymeleaf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ThymeleafConfig {

    /**
     * spring-boot-starter-thymeleaf,springboot 自动addDialect方言
     *
     * @return
     */
    @Bean
    @ConditionalOnMissingBean(ThymeleafDialect.class)
    @Autowired
    public ThymeleafDialect thymeleafDialect(Image image, Math math) {
        return new ThymeleafDialect(image, math);
    }
}
