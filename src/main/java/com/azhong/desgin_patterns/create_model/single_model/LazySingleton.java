package com.azhong.desgin_patterns.create_model.single_model;

/**
 * 懒汉模式(安全模式)
 */
public class LazySingleton {
    private static volatile LazySingleton instance=null;//保证 instance在所有线程中同步(可见性）
    private LazySingleton(){};//避免类在外部实例化
    //方法上加同步
    public static synchronized LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();

        }
        return instance;
    }
}
