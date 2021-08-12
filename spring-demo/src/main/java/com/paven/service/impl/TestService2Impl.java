package com.paven.service.impl;

import com.paven.service.TestService1;
import com.paven.service.TestService2;
import org.springframework.stereotype.Service;

/**
 * @author cpw
 * @date 2021/7/22 12:25 上午
 */
//@Service("testService2")
public class TestService2Impl implements TestService2 {

    @Override
    public String sayHello(String name) {
        System.out.println("hello:" + name);
        return "success";
    }

    public TestService1 testService;

    public TestService1 getTestService() {
        return testService;
    }

    public void setTestService(TestService1 testService) {
        this.testService = testService;
    }

    public TestService2Impl() {
    }

    public TestService2Impl(TestService1Impl testService) {
        this.testService = testService;
    }
}
