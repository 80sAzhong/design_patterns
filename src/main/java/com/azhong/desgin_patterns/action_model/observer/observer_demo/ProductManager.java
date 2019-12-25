package com.azhong.desgin_patterns.action_model.observer.observer_demo;

public class ProductManager extends Subject {
    private static class ProductManagerSingletonHolder{
        private static final ProductManager INSTANCE = new ProductManager();
    }

    public static final ProductManager getInstance(){
        return ProductManagerSingletonHolder.INSTANCE;
    }
    //需求便跟，通知观察者
    public void demandChanged(String exchange){
        notifyObservers(exchange);
    }
}
