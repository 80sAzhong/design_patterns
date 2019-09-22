package com.azhong.desgin_patterns.create_model.abstract_factory;

public interface AbstractIMFactory {
    public ChatService getChat();
    public PaymentService getPayment();
}
