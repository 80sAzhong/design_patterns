package com.azhong.desgin_patterns.action_model.observer;

import java.util.ArrayList;
import java.util.List;
/**
 * 抽象目标
 *
 */
public abstract class ISubject {
	protected List<IObserver> observers=new ArrayList<>();
	public void add(IObserver observer)
	{
		observers.add(observer);
	}
	
	public void remove(IObserver observer)
	{
		observers.remove(observer);
	}
	//通知观察者
	public abstract void notifyObserver();
}
