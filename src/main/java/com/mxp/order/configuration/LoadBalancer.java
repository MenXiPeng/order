package com.mxp.order.configuration;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * 描述：
 *
 * @author menxipeng by 2021/2/8
 */
public interface LoadBalancer {
    ServiceInstance instance(List<ServiceInstance> list);
}
