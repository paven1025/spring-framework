package com.paven.controller;

import com.paven.service.TestService1;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * @author cpw
 * @date 2021/7/25 12:56 上午
 */
@Controller
public class TestController {

    @Resource
    private TestService1 testService;

    public void handleController() {
        System.out.println("TestController...");
    }
}
