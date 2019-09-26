package com.azhong.desgin_patterns.structure_model.dynamic_proxy;

public class DynamicProxyClient {
	public static void main(String[] args) {
		// 1. 创建调用处理器类对象
		DynamicProxy dProxy = new DynamicProxy();
		// 2. 创建目标对象对象
		TaoPP tpp=new TaoPP();
		Meituan mt=new Meituan();
		//3. 创建动态代理类 & 对象：通过调用处理器类对象newProxyInstance（）传入上述目标对象对象
		IBuyTickets ibcTickts=(IBuyTickets) dProxy.newProxyInstance(tpp);
		// 4. 通过调用动态代理对象方法从而调用目标对象方法
        // 实际上是调用了invoke（），再通过invoke（）里的反射机制调用目标对象的方法
		ibcTickts.buyTickets();
		System.out.println("===============================================");
		ibcTickts=(IBuyTickets)dProxy.newProxyInstance(mt);		
		ibcTickts.buyTickets();
	}
}
