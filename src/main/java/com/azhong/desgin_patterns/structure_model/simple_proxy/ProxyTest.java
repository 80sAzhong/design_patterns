package com.azhong.desgin_patterns.structure_model.simple_proxy;

public class ProxyTest {
	public static void main(String[] args) throws Exception {
		IBuyTrainTickets buyTickets=new ZhiXing();
		buyTickets.buyTrainTickets();	
	}
}
