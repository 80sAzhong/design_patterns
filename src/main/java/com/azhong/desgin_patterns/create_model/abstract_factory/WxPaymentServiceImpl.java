package com.azhong.desgin_patterns.create_model.abstract_factory;

public class WxPaymentServiceImpl implements PaymentService {
    @Override
    public void showService() {
        System.out.println("微信支付服务...");
    }
}
