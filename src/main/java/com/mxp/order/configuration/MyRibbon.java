package com.mxp.order.configuration;

import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import com.netflix.loadbalancer.Server;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 描述：
 *
 * @author menxipeng by 2021/2/8
 */
@Component
public class MyRibbon implements LoadBalancer {

    private final AtomicInteger nextServerCyclicCounter = new AtomicInteger(0);

    public final int getIncrementAndGet(){
        /// 访问次数
        int current ;
        int next = 0;
        do {
            current = nextServerCyclicCounter.get();
            next = next >= Integer.MAX_VALUE ? 0 : current + 1;
        } while (!(nextServerCyclicCounter.compareAndSet(current, next)));
        return next;
    }


    @Override
    public ServiceInstance instance(List<ServiceInstance> list) {
        var serverCount = list.size();
        int index = getIncrementAndGet() % serverCount;
        return list.get(index);
    }
}
