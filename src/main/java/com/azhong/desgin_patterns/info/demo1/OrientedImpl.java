package com.azhong.desgin_patterns.info.demo1;
/**
 * @desc 面向实现编程
 * @author Administrator
 *
 */
public class OrientedImpl {
	public static void hearVoice(Cat cat) {
		cat.voice();
	}
	public static void hearVoice(Dog dog) {
		dog.voice();
	}
	public static void main(String[] args) {
		OrientedImpl.hearVoice(new Cat());
		OrientedImpl.hearVoice(new Dog());
	}
}
