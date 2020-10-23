package com.springcloud.configserver.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author judy
 */
@RestController
public class DisController {

    @ApiOperation(value = "查询客服组列表", notes = "【王雪芬】")
    @GetMapping("List")
    private String getDisString() {
        return "str";
    }
}
