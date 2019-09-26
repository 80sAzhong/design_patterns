package com.azhong.desgin_patterns.structure_model.simple_proxy;

public enum Office12306 implements IBuyTrainTickets {
	INSTANCE;
	public void buyTrainTickets() {
		System.out.println("12306官方出票...");
	}

}
