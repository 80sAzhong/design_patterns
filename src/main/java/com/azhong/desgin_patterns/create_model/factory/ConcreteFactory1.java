package com.azhong.desgin_patterns.create_model.factory;

public class ConcreteFactory1 implements AbstractFactory {

	@Override
	public Service getService() {
		System.out.println("具体工厂1生产->具体产品1.。。。");
		return (Service) new ConcreteFactory1();
	}

}
