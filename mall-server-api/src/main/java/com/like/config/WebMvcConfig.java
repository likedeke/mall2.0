package com.like.config;

import com.like.interceptor.UserTokenInterceptor;
import com.like.resource.FileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author like
 * @email 980650920@qq.com
 * @since 2021-02-21 15:09
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    FileUpload fileUpload;

    @Value("${spring.profiles.active}")
    String proProfiles;

    /**
     * 添加拦截器
     * @param registry 注册表
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(userTokenInterceptor()) // 添加拦截检测用户token的拦截器
                .addPathPatterns("/myorders/**")
                .addPathPatterns("/address/**")
                .addPathPatterns("/myComment/**")
                .addPathPatterns("/userInfo/**")
                .addPathPatterns("/orders/**")
                .excludePathPatterns("/orders/notifyMerchantOrderPaid/**")
                .excludePathPatterns("/myorders/deliver/**");
        WebMvcConfigurer.super.addInterceptors(registry);
    }

    /**
     * 实现静态资源的映射
     * @param registry 注册表
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("doc.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
        // 映射图片访问路径
        if (proProfiles.equals("local")) {
            registry.addResourceHandler("/**").addResourceLocations(
                    "file:" + "D:\\Java\\project\\stduyproject\\mall2.0\\api\\src\\main\\resources\\static\\image");
        } else if (proProfiles.equals("dev")) {
            registry.addResourceHandler("/**")
                    .addResourceLocations("file:" + "/root/app/mall2/image/userFace");
        }
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    /**
     * 用户令牌拦截器
     * @return {@link UserTokenInterceptor}
     */
    @Bean
    public UserTokenInterceptor userTokenInterceptor() {
        return new UserTokenInterceptor();
    }
}
