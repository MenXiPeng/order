package com.mxp.order.service.Impl;

import com.mxp.cloudapicommon.entity.CommonResult;
import com.mxp.order.service.OrderService;
import feign.hystrix.FallbackFactory;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 描述：
 *
 * @author menxipeng by 2021/2/18
 */
@Log4j2
@Component
public class OrderFallback implements FallbackFactory<OrderService> {

    @Override
    public OrderService create(Throwable throwable) {
        return () -> {
            log.error(throwable);
            return new CommonResult(9999,"fallback");
        };
    }
}
