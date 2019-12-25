package com.azhong.desgin_patterns.action_model.observer.observer_demo;

/**
 * 抽象的操作，所有的观察者都实现该接口
 * 当被观察者有变化需要通知时，有了一个共同的接口
 */
public interface Observer {
    void updateCode(String exchange);
}
