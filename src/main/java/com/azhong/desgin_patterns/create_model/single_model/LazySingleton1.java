package com.azhong.desgin_patterns.create_model.single_model;

/**
 * 懒汉模式(安全模式)
 */
public class LazySingleton1 {
    private static LazySingleton1 instance=null;
    private LazySingleton1(){};//避免类在外部实例化
    //方法上加同步
    public static synchronized LazySingleton1 getInstance() {
        if (instance == null) {
        	try {
				Thread.sleep(3000);
	            instance = new LazySingleton1();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
        }
        return instance;
    }
}
