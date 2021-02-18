package com.mxp.order.configuration;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 描述：
 *
 * @author menxipeng by 2021/2/3
 */
@Configuration
public class RestTemplateConfig {

    //@LoadBalanced
    @Bean
    public RestTemplate requestTemplate(){
        return new RestTemplate();
    }

}
