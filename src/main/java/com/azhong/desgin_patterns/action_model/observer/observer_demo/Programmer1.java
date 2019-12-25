package com.azhong.desgin_patterns.action_model.observer.observer_demo;

public class Programmer1 implements Observer {
    public Programmer1(){
        ProductManager.getInstance().registerObserver(this);
    }
    @Override
    public void updateCode(String exchange) {
        System.out.println("1.苦逼的完成需求："+exchange);
    }
}
