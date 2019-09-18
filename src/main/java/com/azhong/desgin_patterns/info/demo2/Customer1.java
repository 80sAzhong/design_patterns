package com.azhong.desgin_patterns.info.demo2;
/**
 * @Desc 客户1选择采用出行方案一
 * 客户1使用方案一只能拥有1种出行方式，不能
 * 在运行时发生改变，不够灵活。
 * 总结:无论是从父类中继承的方法，还是子类重写的父类方法，
 * 实现的都是一种静态的复用。不能在运行时发生改变，灵活性比较差。
 * @author Administrator
 *
 */
public class Customer1{
	private TravelProgramme1 p1 = new TravelProgramme1();	
	public static void main(String[] args) {
		new Customer1().p1.goOut();
	}
}
