package com.azhong.desgin_patterns.create_model.abstract_factory;

public class WxChatServiceImpl implements ChatService{
    @Override
    public void showService() {
        System.out.println("微信聊天服务...");
    }
}
