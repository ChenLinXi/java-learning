package com.jason.methodInvoke.service.impl;

import com.jason.methodInvoke.service.AbstractService;
import com.jason.methodInvoke.service.GreetingService;

/**
 * 子功能实现
 *
 * 继承抽象服务protected方法, 封装并实现hello功能
 */
public class GreetingServiceImpl extends AbstractService implements GreetingService {

    public String hello(String name) {
        return super.hello() + " " + name;
    }
}
