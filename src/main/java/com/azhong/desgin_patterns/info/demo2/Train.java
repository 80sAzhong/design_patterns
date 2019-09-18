package com.azhong.desgin_patterns.info.demo2;

public class Train implements Vehicle {

	@Override
	public void transport() {
		System.out.println("坐火车....");
	}
	
	public void eat() {
		System.out.println("点餐....");
	}
}
