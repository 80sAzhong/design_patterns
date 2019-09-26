package com.azhong.desgin_patterns.create_model.single_model;

/**
 * 懒汉模式(枚举方式)
 */
public enum LazySingleton4 {
	INSTANCE;
    //方法上加同步
    public LazySingleton4 getInstance() {
        return INSTANCE;
    }
}
