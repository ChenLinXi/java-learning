package com.jason.methodInvoke.service.impl;

import com.jason.methodInvoke.service.MainService;

/**
 * 主功能实现
 *
 * 主功能调用子功能
 */
public class MainServiceImpl implements MainService {

    private GreetingServiceImpl greetingService = new GreetingServiceImpl();

    public String hello(String name) {
        return greetingService.hello(name);
    }
}
