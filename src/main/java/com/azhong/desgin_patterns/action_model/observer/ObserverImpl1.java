package com.azhong.desgin_patterns.action_model.observer;
/**
 * 具体观察者1
 *
 */
public class ObserverImpl1 implements IObserver {
	@Override
	public void response() {
		System.out.println("具体观察者1做出反应...");
	}
}
