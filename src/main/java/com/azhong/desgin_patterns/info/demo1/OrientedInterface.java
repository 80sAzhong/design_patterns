package com.azhong.desgin_patterns.info.demo1;
/**
 * 面向接口编程
 * @author Administrator
 *
 */
public class OrientedInterface {
	public static void hearVoice(Animal animal)
	{
		animal.voice();
	}
	public static void main(String[] args) {
		OrientedInterface.hearVoice(new Cat());
		OrientedInterface.hearVoice(new Dog());
	}
}
