package com.mxp.order.service;

import com.mxp.cloudapicommon.entity.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * 描述：
 *
 * @author menxipeng by 2021/2/8
 */
@Component
@FeignClient("PAYMENT")
public interface OrderService {

    @RequestMapping("/payment/getPort")
    CommonResult<Map<String,Object>> payment();

}
