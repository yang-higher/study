package com.ry.springcloud.controller;

import com.ry.springcloud.entities.CommonResult;
import com.ry.springcloud.entities.Payment;
import com.ry.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

/**
 * @Description:
 * @Author: ruyi yang
 * @date 2021/6/19 20:31
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private EurekaDiscoveryClient discoveryClient;
    @Resource
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("*****插入结果 " + result);
        if (result > 0) {
            return new CommonResult(200, "插入数据成功,serverPort:" + serverPort, result);
        }
        return new CommonResult(444, "插入失败");
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPamentById(@PathVariable Long id) {
        Payment paymentById = paymentService.getPaymentById(id);
        log.info("*****插入结果 " + paymentById);
        if (Objects.nonNull(paymentById)) {
            return new CommonResult(200, "success,serverPort:" + serverPort, paymentById);
        }
        return new CommonResult(444, "failed");
    }

   @GetMapping(value = "/payment/discovery")
   public Object discovery() {
       List<String> services = discoveryClient.getServices();
       for (String element : services) {
           log.info("*****element: " + element);
       }
       List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
       for (ServiceInstance instance : instances) {

           log.info(instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri());
       }

       return this.discoveryClient;
   }
}
