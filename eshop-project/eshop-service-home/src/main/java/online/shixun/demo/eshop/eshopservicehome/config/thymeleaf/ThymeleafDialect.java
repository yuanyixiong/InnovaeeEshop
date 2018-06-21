/********************************************
 * Copyright (c) 2017, www.qingshixun.com
 *
 * All rights reserved
 *
 *********************************************/
package online.shixun.demo.eshop.eshopservicehome.config.thymeleaf;

import org.thymeleaf.dialect.AbstractDialect;
import org.thymeleaf.dialect.IExpressionObjectDialect;
import org.thymeleaf.expression.IExpressionObjectFactory;

/**
 * 自定义的Thymeleaf方言，用于扩展Thymeleaf页面对象
 */
public class ThymeleafDialect extends AbstractDialect implements IExpressionObjectDialect {

    private Image image;

    private Math math;

    public ThymeleafDialect(Image image, Math math) {
        super("Math Dialect");
        this.image = image;
        this.math = math;
    }

    @Override
    public IExpressionObjectFactory getExpressionObjectFactory() {
        return new ThymeleafObjectFactory(image, math);
    }
}
