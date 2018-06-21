/********************************************
 * Copyright (c) 2017, www.qingshixun.com
 *
 * All rights reserved
 *
 *********************************************/
package online.shixun.demo.eshop.eshopservicehome.config.thymeleaf;

import org.thymeleaf.context.IExpressionContext;
import org.thymeleaf.expression.IExpressionObjectFactory;

import java.util.*;

/**
 * Thymeleaf工具对象的扩展工厂
 */
public class ThymeleafObjectFactory implements IExpressionObjectFactory {


    //key Thymeleaf页面中自定义对象的名称
    //value Thymeleaf页面中的自定义的对象
    private Map<String, Object> thymeleaf = new HashMap<>();

    // Thymeleaf页面中自定义对象的名称
    private Set<String> allExpressionObjectNames;


    public ThymeleafObjectFactory(Image image, Math math) {
        thymeleaf.put("image", image);
        thymeleaf.put("math", math);
        this.allExpressionObjectNames = Collections.unmodifiableSet(this.thymeleaf.keySet());
    }

    /**
     * 返回该工厂类能创建的工具类对象的集合
     *
     * @return
     */
    @Override
    public Set<String> getAllExpressionObjectNames() {
        return this.allExpressionObjectNames;
    }

    /**
     * 根据表达式的名称,创建工具类对象
     *
     * @param iExpressionContext
     * @param expressionObjectName
     * @return
     */
    @Override
    public Object buildObject(IExpressionContext iExpressionContext, String expressionObjectName) {
        return this.thymeleaf.get(expressionObjectName);
    }

    /**
     * 返回该工具对象是否可缓存
     *
     * @param expressionObjectName
     * @return
     */
    @Override
    public boolean isCacheable(String expressionObjectName) {
        return Objects.nonNull(this.thymeleaf.get(expressionObjectName));
    }
}
