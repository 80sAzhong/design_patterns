package com.azhong.desgin_patterns.create_model.factory;

public class FoodService implements Service{
    @Override
    public void showService() {
        System.out.println("提供美食服务列表...");
    }
}
