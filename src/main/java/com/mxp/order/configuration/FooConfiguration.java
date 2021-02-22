package com.mxp.order.configuration;

import feign.Feign;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * 描述：
 *
 * @author menxipeng by 2021/2/19
 */
@Configuration
public class FooConfiguration {
    @Bean
    @Scope("prototype")
    public Feign.Builder feignBuilder() {

        return Feign.builder();
    }
}
