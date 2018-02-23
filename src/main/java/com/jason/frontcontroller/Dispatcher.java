package com.jason.frontcontroller;

/**
 * 前端控制器可能使用一个调度器对象来调度请求到相应的具体处理程序
 */
public class Dispatcher {

    private HomeView homeView;
    private StudentView studentView;

    public Dispatcher() {
        homeView = new HomeView();
        studentView = new StudentView();
    }

    public void dispatch(String request) {
        if ("STUDENT".equals(request)) {
            studentView.show();
        } else {
            homeView.show();
        }
    }
}
