package com.azhong.desgin_patterns.info.demo2;
/**
 * @Desc 出行方案二
 *  出行方案1出行的窘境给了我们提示:与其我们”是什么”，倒不如我们”用什么”
 *  出行方案2采用聚合/组合复用，去代替继承复用
 *  总结:
 *  1.用聚合/组合复用，去代替继承复用。把一些特征和行为抽取出来，形成工具类。
 *  然后通过聚合/组合成为当前类的属性。再调用其中的属性和行为达到代码重用的目的。
 *  2.另外，我们可以选择一个类中是否应该具有某种行为，从而决定应该聚合那些类，不应该聚合那些类。
 *  这样，通过聚合/组合关系，也可以避免继承所带的方法污染问题。
 *  所以，使用聚合/组合，具有很强的代码重用性和灵活性
 * @author Administrator
 *
 */
public class TravelProgramme2{
	//交通工具
	private Vehicle v;

	/*
	 * 更换交通工具
	 */
	public void changeVehicle(Vehicle v) {
		this.v=v;
	}
	
	public void goOut() {
		this.v.transport();
	}
}
