package com.azhong.desgin_patterns.action_model.observer;

/**
 * 具体的被观察者（发生变化的目标类）
 */
public class SubjectImpl extends Subject{
    private  static class SubjectImplSingleHolder{
        private static final SubjectImpl INSTANCE=new SubjectImpl();
    }
    private SubjectImpl(){}
    public static final SubjectImpl getInstance(){
        return SubjectImplSingleHolder.INSTANCE;
    }
    public void demandChanged(){
        notifyObserver();
    }
}
