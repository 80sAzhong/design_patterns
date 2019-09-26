package com.azhong.desgin_patterns.structure_model.simple_proxy;

public class ZhiXing implements IBuyTrainTickets {
	private Office12306 office;
	public void buyTrainTickets() {
		preMethod();
		office=Office12306.INSTANCE;
		office.buyTrainTickets();
		afterMethod();
	}
	
	public void preMethod() {
		System.out.println("出行查找地图....");
	}
	
	public void afterMethod() {
		System.out.println("当地旅行推荐...");
	}
}
