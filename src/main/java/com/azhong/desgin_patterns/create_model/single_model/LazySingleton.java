package com.azhong.desgin_patterns.create_model.single_model;

/**
 * 懒汉模式(安全模式)
 */
public class LazySingleton {
    /*
     *  uniqueInstance = new Signleton();实际上是有三个步骤：
     *  为 uniqueInstance 分配内存空间
     *  初始化 uniqueInstance
     *  将 uniqueInstance 指向分配的内存地址
     *  在JVM优化中有一项指令重排，为了保证提高处理器效率，实际执行的顺序有可能与代码书写的顺序不同。
     * 在这三个步骤中，执行顺序有可能编程1->3->2，也就是说线程可能获得一个没有初始化的对象。
     *  声明对象为volatile，该关键字防止指令重排序，保证了多线程下正常运行
     */
    private static volatile LazySingleton instance=null;//保证 instance在所有线程中同步
    private LazySingleton(){};//避免类在外部实例化
    //方法上加同步
    public static  LazySingleton getInstance() {
        if (instance == null) {
            try {
                Thread.sleep(3000);
                instance = new LazySingleton();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return instance;
    }
}
