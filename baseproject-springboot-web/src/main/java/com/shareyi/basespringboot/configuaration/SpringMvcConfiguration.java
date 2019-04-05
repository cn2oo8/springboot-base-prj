package com.shareyi.basespringboot.configuaration;

import com.shareyi.basespringboot.interceptor.LogInterceptor;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.annotation.Resource;

/**
 * spring拦截器相关配置
 *
 * @author david
 * @date 2018/11/4
 */
@SpringBootConfiguration
public class SpringMvcConfiguration extends WebMvcConfigurerAdapter {

    @Resource
    LogInterceptor logInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(logInterceptor).addPathPatterns("/**");
    }
}
