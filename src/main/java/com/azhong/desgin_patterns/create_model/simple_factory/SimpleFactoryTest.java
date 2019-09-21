package com.azhong.desgin_patterns.create_model.simple_factory;

import com.azhong.desgin_patterns.info.demo2.Vehicle;

public class SimpleFactoryTest {
	public static void main(String[] args) {
		SimpleFactory sf = new SimpleFactory();
		Vehicle v1=sf.getVehicle(0);
		v1.transport();
		Vehicle v2=sf.getVehicle(1);
		v2.transport();
		Vehicle v3=sf.getVehicle(2);
		v3.transport();
	}
}
