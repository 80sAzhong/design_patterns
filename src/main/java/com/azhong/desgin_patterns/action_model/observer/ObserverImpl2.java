package com.azhong.desgin_patterns.action_model.observer;

public class ObserverImpl2 implements IObserver {
	public ObserverImpl2(){
		SubjectImpl.getInstance().add(this);
	}
	@Override
	public void response() {
		System.out.println("具体观察者2做出反应...");
	}
}
