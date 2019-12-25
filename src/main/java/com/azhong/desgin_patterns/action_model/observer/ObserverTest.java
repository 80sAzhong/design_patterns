package com.azhong.desgin_patterns.action_model.observer;
/**
 * 演示
 */
public class ObserverTest {
	public static void main(String[] args) {
		System.out.println("=======注册观察者1，2======");
		IObserver ob1=new ObserverImpl1();
		IObserver ob2=new ObserverImpl2();
		//注册观察者
		ConcreteSubject.getInstance().add(ob1);
		ConcreteSubject.getInstance().add(ob2);
		//通知观察者
		ConcreteSubject.getInstance().demandChanged();
		System.out.println("=======解绑观察者1======");
		//解绑观察者
		ConcreteSubject.getInstance().remove(ob1);
		//通知观察者
		ConcreteSubject.getInstance().demandChanged();
	}
}
