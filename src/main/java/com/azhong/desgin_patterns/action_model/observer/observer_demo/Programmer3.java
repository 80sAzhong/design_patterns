package com.azhong.desgin_patterns.action_model.observer.observer_demo;

public class Programmer3 implements Observer {
    public Programmer3(){
        ProductManager.getInstance().registerObserver(this);
    }
    @Override
    public void updateCode(String exchange) {
        System.out.println("3.苦逼的完成需求:"+exchange);
    }
}
