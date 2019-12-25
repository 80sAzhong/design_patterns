package com.azhong.desgin_patterns.action_model.observer.observer_demo;

import java.util.ArrayList;
import java.util.List;

/**
 * 被观察者父类
 */
public class Subject {
    //观察者对象列表
    private List<Observer> observers = new ArrayList<Observer>();

    /**
     * 注册观察者对象
     * @param observer
     */
    public void registerObserver(Observer observer){
        if(!observers.contains(observers))
        {
            observers.add(observer);
        }
    }

    /**
     * 解绑观察者
     * @param observer
     */
    public void unRegisterObserver(Observer observer)
    {
        if(observers.contains(observer))
        {
            observers.remove(observer);
        }
    }

    //通知所有注册的观察者执行相应的操作
    public void notifyObservers(String exchange){
        for(Observer observer:observers)
        {
            observer.updateCode(exchange);
        }
    }
}
