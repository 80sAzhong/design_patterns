package com.azhong.desgin_patterns.create_model.single_model;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 访问测试类
 */
public class SingletonTest {
	public static <T> void beComplicatedByExecutor(T t) throws InterruptedException, ExecutionException {
		ExecutorService executors = Executors.newFixedThreadPool(1000);
		List<Future<LazySingleton0>> flist=new ArrayList<Future<LazySingleton0>>();
			for(int i=0;i<10000;i++) {
				Callable<LazySingleton0> task = new Callable() {
					@Override
					public LazySingleton0 call() throws Exception {
						return LazySingleton0.getInstance();
					}
				};
				flist.add(executors.submit(task));
			}
			for (Future<LazySingleton0> f : flist) {
				System.out.println(f.get());
			}
	}
	public static void main(String[] args) throws Exception {
		LazySingleton lz=LazySingleton.getInstance();
		LazySingleton lz2=LazySingleton.getInstance();
		System.out.println("lz==lz2?"+(lz==lz2));
		SingletonTest.beComplicatedByExecutor<LazySingleton0>();
		
		
	}
}
