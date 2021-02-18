package com.mxp.order.configuration;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 描述：
 *
 * @author menxipeng by 2021/2/5
 */
@Configuration
public class RibbonConfig {

    @Bean
    public IRule ribbon(){
        return new RandomRule();
    }

}
