package com.azhong.desgin_patterns.create_model.single_model;

import java.lang.reflect.Constructor;
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

	public static void beComplicatedByExecutor2() throws InterruptedException, ExecutionException {
		ExecutorService executors = Executors.newFixedThreadPool(10);
		List<Future<LazySingleton2>> flist=new ArrayList<Future<LazySingleton2>>();
		for(int i=0;i<10;i++) {
			Callable<LazySingleton2> task = new Callable() {
				@Override
				public LazySingleton2 call() throws Exception {
					return LazySingleton2.getInstance();
				}
			};
			flist.add(executors.submit(task));
		}
		for (Future<LazySingleton2> f : flist) {
			System.out.println(f.get());
		}
	}


	public static void reflectAttack() throws Exception{
		LazySingleton3 lz0= LazySingleton3.getInstance();
		System.out.println("lz0:"+lz0);
		LazySingleton3 lz1= LazySingleton3.getInstance();
		System.out.println("lz1:"+lz1);
		System.out.println("正常情况下，实例化2个实例是否相同:"+(lz0==lz1));
		Constructor<LazySingleton3> constructor =LazySingleton3.class.getDeclaredConstructor();
		constructor.setAccessible(true);
		LazySingleton3 lz2 = constructor.newInstance();
		System.out.println("lz2:"+lz2);
		System.out.println("通过反射攻击下，实例化2个实例是否相同:"+(lz1==lz2));
	}

	public static void reflectAttack2() throws Exception{
		LazySingleton4 lz0= LazySingleton4.INSTANCE.getInstance();
		System.out.println("lz0:"+lz0);
		LazySingleton4 lz1= LazySingleton4.INSTANCE.getInstance();
		System.out.println("lz1:"+lz1);
		System.out.println("正常情况下，实例化2个实例是否相同:"+(lz0==lz1));
		Constructor<LazySingleton4> constructor =LazySingleton4.class.getDeclaredConstructor();
		constructor.setAccessible(true);
		LazySingleton4 lz2 = constructor.newInstance();//会报异常：java.lang.NoSuchMethodException
		//原因:反射在通过newInstance创建对象时，会检查该类是否ENUM修饰，如果是则抛出异常，反射失败
		System.out.println("lz2:"+lz2);
		System.out.println("通过反射攻击下，实例化2个实例是否相同:"+(lz1==lz2));
	}
	
	public static void main(String[] args) throws Exception {

//		SingletonTest.beComplicatedByExecutor0();
//		SingletonTest.beComplicatedByExecutor1();
//		SingletonTest.beComplicatedByExecutor2();
//		SingletonTest.reflectAttack();
		SingletonTest.reflectAttack2();
//		SingletonTest.beComplicatedByExecutor();
//		LazySingleton lz=LazySingleton.getInstance();
//		LazySingleton lz2=LazySingleton.getInstance();
//		System.out.println("lz==lz2?"+(lz==lz2));
		
	}
}
