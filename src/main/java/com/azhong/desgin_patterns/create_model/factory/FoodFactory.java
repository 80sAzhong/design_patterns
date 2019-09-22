package com.azhong.desgin_patterns.create_model.factory;

public class FoodFactory implements AbstractFactory{
    @Override
    public Service getService() {
        System.out.println("具体美食服务工厂生成->具体美食服务...");
        return new FoodService();
    }
}
