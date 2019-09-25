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
	/**
	 * 并发测试
	 * @throws InterruptedException
	 * @throws ExecutionException
	 */
	public static void beComplicatedByExecutor0() throws InterruptedException, ExecutionException {
		ExecutorService executors = Executors.newFixedThreadPool(10);
		List<Future<LazySingleton0>> flist=new ArrayList<Future<LazySingleton0>>();
			for(int i=0;i<10;i++) {
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

	public static void beComplicatedByExecutor1() throws InterruptedException, ExecutionException {
		ExecutorService executors = Executors.newFixedThreadPool(10);
		List<Future<LazySingleton1>> flist=new ArrayList<Future<LazySingleton1>>();
		for(int i=0;i<10;i++) {
			Callable<LazySingleton1> task = new Callable() {
				@Override
				public LazySingleton1 call() throws Exception {
					return LazySingleton1.getInstance();
				}
			};
			flist.add(executors.submit(task));
		}
		for (Future<LazySingleton1> f : flist) {
			System.out.println(f.get());
		}
	}

	public static void beComplicatedByExecutor() throws InterruptedException, ExecutionException {
		ExecutorService executors = Executors.newFixedThreadPool(10);
		List<Future<LazySingleton>> flist=new ArrayList<Future<LazySingleton>>();
		for(int i=0;i<10;i++) {
			Callable<LazySingleton> task = new Callable() {
				@Override
				public LazySingleton call() throws Exception {
					return LazySingleton.getInstance();
				}
			};
			flist.add(executors.submit(task));
		}
		for (Future<LazySingleton> f : flist) {
			System.out.println(f.get());
		}
	}


	public static void main(String[] args) throws Exception {

//		SingletonTest.beComplicatedByExecutor0();
		SingletonTest.beComplicatedByExecutor1();
//		SingletonTest.beComplicatedByExecutor();
//		LazySingleton lz=LazySingleton.getInstance();
//		LazySingleton lz2=LazySingleton.getInstance();
//		System.out.println("lz==lz2?"+(lz==lz2));
		
	}
}
