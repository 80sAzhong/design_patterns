package com.azhong.desgin_patterns.action_model.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 抽象者父类(观察者集合类)
 */
public class Subject {
    protected List<IObserver> observers = new ArrayList<>();

    //注册观察者
    public void add(IObserver observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    //移除观察者
    public void remove(IObserver observer) {
        if (observers.contains(observer)) {
            observers.remove(observer);
        }
    }

    //通知观察者
    public void notifyObserver(){
        System.out.println("具体目标发生变化....");
        System.out.println("=================");
        for(IObserver obs:observers)
        {
            obs.response();
        }
    };
}
