package com.azhong.desgin_patterns.action_model.observer;
/**
 * 演示
 */
public class ObserverTest {
	public static void main(String[] args) {
		ISubject sub = new SubjectImpl();
		IObserver obs1 = new ObserverImpl1();
		IObserver obs2 = new ObserverImpl2();
		sub.add(obs1);
		sub.add(obs2);
		sub.notifyObserver();
	}
}
