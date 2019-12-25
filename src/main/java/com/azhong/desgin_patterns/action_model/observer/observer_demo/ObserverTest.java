package com.azhong.desgin_patterns.action_model.observer.observer_demo;

/**
 * 观察者模式测试(类似发布订阅模式：发布者为被观察对象；订阅者即为观察者)
 * 模拟场景:boss变更业务需求-》产品经理-》开发人员
 * Boss:发号施令，变更需求-》产品经理
 * Subject:被观察者(发布者)父类（提供:注册订阅；取消订阅；通知所有注册的观察者执行相应的操作）
 * ProductManager:被观察者实现类(具体的发布者)接受到Boss的指令，发布变更需求(即为被观察的对象)将需求变更通知给订阅者(观察者)
 * Observer:观察者抽象的操作，所有的观察者都实现该接口,当被观察者有变化需要通知时，有了一个共同的接口
 * Programmer1/2/3:观察者实现类(具体的订阅者)
 */
public class ObserverTest {
    public static void main(String[] args) {
    	System.out.println("+++++++产品经理通知开发者1，2，3变更需求++++++");
        Programmer1 p1 = new Programmer1();
        Programmer2 p2 = new Programmer2();
        Programmer3 p3 = new Programmer3();
        Boss bos = new Boss();
        bos.sendOrder("需求1业务更改。。。");
        System.out.println("+++++++boss开除p2++++++");
        bos.fire(p2);
        bos.sendOrder("需求2业务变更。。。");
    }
}
