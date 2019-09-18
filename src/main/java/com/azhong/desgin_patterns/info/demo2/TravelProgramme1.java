package com.azhong.desgin_patterns.info.demo2;
/**
 * @Desc 出行方案一
 * 采用继承父类方式实现复用：从父类中继承transport方法，通过对应的方法实现出行。
 * 但会有一个问题:继承了哪个父类就只能拥有1种出行方式，不能
 * 在运行时发生改变，不够灵活。
 * 总结:无论是从父类中继承的方法，还是子类重写的父类方法，
 * 实现的都是一种静态的复用。不能在运行时发生改变，灵活性比较差。
 * @author Administrator
 *
 */
public class TravelProgramme1 extends Train {
	/*
	 * 出行
	 */
	public void goOut() {
		this.transport();
	}
}
