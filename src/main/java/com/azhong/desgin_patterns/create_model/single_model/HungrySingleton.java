package com.azhong.desgin_patterns.create_model.single_model;

public class HungrySingleton {
	private static final HungrySingleton instance=new HungrySingleton();
	private HungrySingleton() {}
	public static HungrySingleton getInstance() {
		return instance;
	}
}
