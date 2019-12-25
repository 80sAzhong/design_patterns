package com.azhong.desgin_patterns.action_model.observer;

/**
 * 具体的被观察者（发生变化的目标类）
 */
public class ConcreteSubject extends Subject {
	private static class SubjectImplSingleHolder {
		private static final ConcreteSubject INSTANCE = new ConcreteSubject();
	}
	private ConcreteSubject() {
	}
	public static final ConcreteSubject getInstance() {
		return SubjectImplSingleHolder.INSTANCE;
	}
	public void demandChanged() {
		notifyObserver();
	}
}
