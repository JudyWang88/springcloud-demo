package com.springcloud.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author judy
 * 采用 LoadBalancerClient 实现远程调用
 */
@RestController
public class LoadBalancerClientController {


    @Autowired
    LoadBalancerClient loadBalancerClient;

    @RequestMapping("/test")
    public String test() {
        // 通过spring cloud common中的负载均衡接口选取服务提供节点实现接口调用
        ServiceInstance serviceInstance = loadBalancerClient.choose("springcloud.learninig.properties");
        String url = serviceInstance.getUri() + "/get";
        RestTemplate restTemplate = new RestTemplate();
        Boolean result = restTemplate.getForObject(url, Boolean.class);
        return "Invoke : " + url + ", return : " + result;
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
