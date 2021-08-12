package com.paven.service.impl;

import com.paven.service.TestService;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {

    public String test() {
        return "test";
    }
}
