/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 *
 *********************************************/
package online.shixun.demo.eshop.eshopservicehome.config.thymeleaf;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Image {

    @Value("${system.file.images.service.nginxVisitURL}")
    private String nginxVisitURL;//nginx 图片服务器地址

    public String getImage(String imgUrl) {
        return String.format("%s%s", nginxVisitURL, imgUrl);
    }

    public String getImage(String imgUrl, int index) {
        String url = "";
        if (index <= 2 && index >= 0) {
            url = String.format("%s%s", nginxVisitURL, imgUrl.split(",")[index]);
        }
        return url;
    }
}
