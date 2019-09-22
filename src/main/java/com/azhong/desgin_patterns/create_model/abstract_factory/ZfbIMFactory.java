package com.azhong.desgin_patterns.create_model.abstract_factory;

public class ZfbIMFactory implements AbstractIMFactory {
    @Override
    public ChatService getChat() {
        System.out.println("支付宝IM工程类生成->具体支付宝聊天服务...");
        return new ZfbChatServiceImpl();
    }

    @Override
    public PaymentService getPayment() {
        System.out.println("支付宝IM工程类生成->具体支付宝聊天服务...");
        return new ZfbPaymentServiceImpl();
    }
}
