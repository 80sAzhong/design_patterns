package com.azhong.desgin_patterns.create_model.abstract_factory;

public class WxIMFactory implements AbstractIMFactory{
    @Override
    public ChatService getChat() {
        System.out.println("微信IM工程类生成->具体微信聊天服务...");
        return new WxChatServiceImpl();
    }

    @Override
    public PaymentService getPayment() {
        System.out.println("微信IM工程类生成->具体微信支付服务...");
        return new WxPaymentServiceImpl();
    }
}
