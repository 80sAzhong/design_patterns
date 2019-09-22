package com.azhong.desgin_patterns.create_model.abstract_factory;

public class AbstractFactoryTest {
    public static void main(String[] args) {
        AbstractIMFactory imFactory = new WxIMFactory();
        imFactory.getChat().showService();
        imFactory.getPayment().showService();
        imFactory = new ZfbIMFactory();
        imFactory.getChat().showService();
        imFactory.getPayment().showService();
    }
}
