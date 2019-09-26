package com.azhong.desgin_patterns.create_model.single_model;

/**
 * 懒汉模式(非安全模式)
 */
public class LazySingleton0 {
    private static LazySingleton0 instance=null;
    private LazySingleton0(){};//避免类在外部实例化
    //方法上加同步
    public static LazySingleton0 getInstance() {
        if (instance == null) {
        	try {
				Thread.sleep(3000);
	            instance = new LazySingleton0();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
        }
        return instance;
    }
}
