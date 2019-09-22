package com.azhong.desgin_patterns.create_model.abstract_factory;

public class ZfbPaymentServiceImpl implements PaymentService {
    @Override
    public void showService() {
        System.out.println("支付宝支付服务...");
    }
}
