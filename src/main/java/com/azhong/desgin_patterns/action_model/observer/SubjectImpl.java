package com.azhong.desgin_patterns.action_model.observer;
/**
 * 具体目标
 *
 */
public class SubjectImpl extends ISubject{

	@Override
	public void notifyObserver() {
		System.out.println("具体目标发生变化....");
		System.out.println("=================");
		for(IObserver obs:observers)
		{
			obs.response();
		}
	}

}
