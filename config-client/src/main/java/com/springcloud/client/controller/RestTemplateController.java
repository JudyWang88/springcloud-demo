package com.springcloud.client.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author judy
 */
@Slf4j
@RestController
public class RestTemplateController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/rest")
    public String test() {
        String forObject = restTemplate.getForObject("http://springcloud.learninig.properties/get", String.class);
        return "Return:" + forObject;
    }


    /**
     * 给RestTemplate添加复杂均衡
     * @return
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }


}
