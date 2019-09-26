package com.azhong.desgin_patterns.create_model.single_model;

/**
 * 懒汉模式(静态内部类式)
 */
public class LazySingleton3 {
    private LazySingleton3(){
    	System.out.println("外部类无参构造器...");
    };//避免类在外部实例化
    static {
        System.out.println("外部类静态代码块...");
    }
    /*
     * 静态内部类实现单例模式，这种方式优于上面两种方式，
     * 他即实现了线程安全，又省去了null的判断，性能优于上面两种
     */
    private static class LazyHolder{
    	private static final LazySingleton3 INSTANCE=new LazySingleton3();
    	static {
            System.out.println("内部类静态代码块...");
        }
    } 
    
    //方法上加同步
    public static final LazySingleton3 getInstance() {
    	System.out.println("获取实例...");
        return LazyHolder.INSTANCE;
    }
}
