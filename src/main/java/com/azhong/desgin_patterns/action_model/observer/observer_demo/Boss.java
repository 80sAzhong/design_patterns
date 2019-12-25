package com.azhong.desgin_patterns.action_model.observer.observer_demo;

public class Boss {
    public void sendOrder(String exchange){
        ProductManager.getInstance().demandChanged(exchange);
    }

    public void fire(Observer observer){
        ProductManager.getInstance().unRegisterObserver(observer);
    }
}
