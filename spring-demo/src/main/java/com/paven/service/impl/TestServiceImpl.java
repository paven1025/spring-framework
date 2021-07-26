package com.paven.service.impl;

import com.paven.service.TestService;
import org.springframework.stereotype.Service;

/**
 * @author cpw
 * @date 2021/7/22 12:25 上午
 */
@Service("testService")
public class TestServiceImpl implements TestService {

    @Override
    public String sayHello(String name) {
        System.out.println("hello:" + name);
        return "success";
    }
}
