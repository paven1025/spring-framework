package com.paven.service.impl;

import com.paven.service.TestService1;
import com.paven.service.TestService2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author cpw
 * @date 2021/7/22 12:25 上午
 */
//@Service("testService1")
public class TestService1Impl implements TestService1 {

    @Transactional
    @Override
    public String sayHello(String name) {
        System.out.println("hello:" + name);
        return "success";
    }

    public TestService2 testService;

    public TestService1Impl() {
    }

    public TestService1Impl(TestService2Impl testService2) {
    }

    public TestService2 getTestService() {
        return testService;
    }

    public void setTestService(TestService2 testService) {
        this.testService = testService;
    }
}
