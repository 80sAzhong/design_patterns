package com.azhong.desgin_patterns.create_model.single_model;

/**
 * 懒汉模式(双重校验锁较安全模式)
 */
public class LazySingleton2 {
    private static LazySingleton2 instance=null;
    private LazySingleton2(){};//避免类在外部实例化
    //方法上加同步
    public static LazySingleton2 getInstance() {
        if (instance == null) {
        	try {
				Thread.sleep(3000);
                synchronized(LazySingleton2.class) {
                    if(instance == null) {
                        instance = new LazySingleton2();
                    }
                }
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
        }
        return instance;
    }
}
