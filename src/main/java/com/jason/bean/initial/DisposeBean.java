package com.jason.bean.initial;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DisposeBean implements DisposableBean {

    @Override
    public void destroy() throws Exception {
        System.clearProperty("hello");
    }
}
