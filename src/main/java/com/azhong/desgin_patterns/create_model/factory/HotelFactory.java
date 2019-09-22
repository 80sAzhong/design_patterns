package com.azhong.desgin_patterns.create_model.factory;

public class HotelFactory implements AbstractFactory{
    @Override
    public Service getService() {
        System.out.println("具体住宿服务工厂生成->具体住宿服务...");
        return new HotelService();
    }
}
