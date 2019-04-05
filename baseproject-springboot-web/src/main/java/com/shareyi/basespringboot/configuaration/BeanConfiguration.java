package com.shareyi.basespringboot.configuaration;

import com.shareyi.basespringboot.common.chain.HandlerChainFactory;
import com.shareyi.basespringboot.common.utils.Profiles;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 自定义bean 构建器
 *
 * @author david
 * @date 2018/10/3
 */
@Configuration
public class BeanConfiguration {


    @Bean
    public HandlerChainFactory chainFactory() {
        return HandlerChainFactory.getInstance();
    }

    @Bean
    public Profiles createProfiles() {
        return Profiles.getInstance();
    }

}
