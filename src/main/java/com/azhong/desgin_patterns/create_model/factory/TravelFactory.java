package com.azhong.desgin_patterns.create_model.factory;

public class TravelFactory implements AbstractFactory {
    @Override
    public Service getService(){
        System.out.println("具体出行服务工厂生成->具体出行服务...");
        return new TravelServices();
    }
}
