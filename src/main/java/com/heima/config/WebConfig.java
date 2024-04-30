package com.heima.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//package com.heima.config;
//import com.heima.interceptor.LoginInterceptor;
//import org.dom4j.io.SAXReader;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Scope;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//
//@Configuration //配置類
//public class WebConfig implements WebMvcConfigurer {
//
//    @Autowired
//    private LoginInterceptor loginInterceptor;
//    public void addInterceptors(InterceptorRegistry registry){
//        registry.addInterceptor(loginInterceptor).addPathPatterns("/*");
//    }
//    @Scope("prototype")
//    @Bean //將方法返回直接給IOC容器管理,成為IOC容器的bean對象
//    public SAXReader reader(){
//        return new SAXReader();
//    }
//}
@Configuration
public class WebConfig implements WebMvcConfigurer {


    /**
     * 接受跨來源請求（CORS）來自不同 IP 的請求
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:5173") // 允許來源
                .allowedMethods("GET", "POST", "PUT", "DELETE") // 允許的請求方法
                .allowedHeaders("*") // 允許的標頭
                .allowCredentials(true) // 允許携帶認證信息（例如Cookie）
                .maxAge(3600); // 預檢請求的有效期，以秒為單位
    }
}