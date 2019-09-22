package com.azhong.desgin_patterns.create_model.factory;

public class TravelServices implements Service {
    @Override
    public void showService(){
        System.out.println("提供具体出行服务列表...");
    }
}
