package com.azhong.desgin_patterns.create_model.factory;

public class FactoryTest {
    public static void main(String[] args) {
        AbstractFactory factory = new FoodFactory();
        factory.getService().showService();
        factory=new HotelFactory();
        factory.getService().showService();
        factory=new TravelFactory();
        factory.getService().showService();
    }
}
