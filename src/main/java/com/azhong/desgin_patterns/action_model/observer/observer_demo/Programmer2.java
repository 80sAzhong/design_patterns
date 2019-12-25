package com.azhong.desgin_patterns.action_model.observer.observer_demo;

public class Programmer2 implements Observer {
    public Programmer2(){
        ProductManager.getInstance().registerObserver(this);
    }
    @Override
    public void updateCode(String exchange) {
        System.out.println("2.苦逼的完成需求:"+exchange);
    }
}
