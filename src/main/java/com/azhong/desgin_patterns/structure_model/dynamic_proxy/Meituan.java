package com.azhong.desgin_patterns.structure_model.dynamic_proxy;

public class Meituan implements IBuyTickets {

	@Override
	public void buyTickets() {
		System.out.println("美团上购买电影票...");
	}

}
