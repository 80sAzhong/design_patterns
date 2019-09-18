package com.azhong.desgin_patterns.info.demo2;
/**
 * @Desc 客户2
 * 客户2采用出行方案2：可以根据用户需要动态的变更出行方式，出行方式可以多样化
 * 总结:
 *  1.用聚合/组合复用，去代替继承复用。把一些特征和行为抽取出来，形成工具类。
 *  然后通过聚合/组合成为当前类的属性。再调用其中的属性和行为达到代码重用的目的。
 *  2.另外，我们可以选择一个类中是否应该具有某种行为，从而决定应该聚合那些类，不应该聚合那些类。
 *  这样，通过聚合/组合关系，也可以避免继承所带的方法污染问题。
 *  3.聚合/组合复用也可以在运行时动态进行。新对象可以使用聚合/组合关系，将新的责任委派到合适的对象。
 *  所以，使用聚合/组合，具有很强的代码重用性和灵活性
 * @author Administrator
 *
 */
public class Customer2 {
	private TravelProgramme2 p2 = new TravelProgramme2();	

	public static void main(String[] args) {
		Customer2 c2 = new Customer2();
		//更换交通工具出行
		c2.p2.changeVehicle(new Train());
		c2.p2.goOut();
		c2.p2.changeVehicle(new Bus());
		c2.p2.goOut();
		c2.p2.changeVehicle(new Metro());
		c2.p2.goOut();
	}
}
