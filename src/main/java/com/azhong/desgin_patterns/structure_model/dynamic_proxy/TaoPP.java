package com.azhong.desgin_patterns.structure_model.dynamic_proxy;

public class TaoPP implements IBuyTickets {

	@Override
	public void buyTickets() {
		System.out.println("在淘票票上代购电影票...");
	}

}
