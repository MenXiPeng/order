package com.mxp.order.controller;

import com.mxp.cloudapicommon.entity.CommonResult;
import com.mxp.cloudapicommon.entity.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;

/**
 * 描述：
 *
 * @author menxipeng by 2021/2/3
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    private static final String URL = "http://PAYMENT";
    //private static final String URL = "http://localhost:8011";

    @RequestMapping("/getOrder")
    public CommonResult getOrder(HttpServletRequest request){
        //restTemplate.postForObject(URL + "/payment/getPort", request, CommonResult.class);
        return restTemplate.getForObject(URL + "/payment/getPort", CommonResult.class);
    }

    @RequestMapping("/payment/{id}")
    public CommonResult getPayment(@PathVariable("id") Integer id){
        Payment payment = new Payment();
        payment.setId(id);
        return restTemplate.postForObject(URL + "/payment/info", payment, CommonResult.class);
    }

}
