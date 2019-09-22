package com.azhong.desgin_patterns.create_model.factory;

public class HotelService implements Service{
    @Override
    public void showService() {
        System.out.println("提供具体住宿服务列表...");
    }
}
