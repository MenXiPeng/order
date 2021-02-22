package com.mxp.order.service;

import com.mxp.cloudapicommon.entity.CommonResult;
import com.mxp.order.service.Impl.OrderFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * 描述：
 *
 * @author menxipeng by 2021/2/8
 *
 * HystrixCommandProperties 断路器配置
 */
@Component
@FeignClient(value = "PAYMENT",fallbackFactory = OrderFallback.class)
public interface OrderService {

    @RequestMapping("/payment/getPort")
    CommonResult<Map<String,Object>> payment();

}
