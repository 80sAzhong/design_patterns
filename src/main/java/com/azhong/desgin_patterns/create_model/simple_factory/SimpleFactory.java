package com.azhong.desgin_patterns.create_model.simple_factory;

import com.azhong.desgin_patterns.info.demo2.Bus;
import com.azhong.desgin_patterns.info.demo2.Metro;
import com.azhong.desgin_patterns.info.demo2.Train;
import com.azhong.desgin_patterns.info.demo2.Vehicle;
/**
 * @Desc 简单工程模式
 * 
 * @author Administrator
 *
 */
public class SimpleFactory {
	public Vehicle getVehicle(int type) {
		switch (type) {
		case 0:
			return new Train();
		case 1:
			return new Metro();
		case 2:
			return new Bus();
		default:
			return null;
		}
	}
}
