# design_patterns
# 设计模式入门
-----
[toc]
# 一、设计模式简介
   
## 1.什么是设计模式
   设计模式是一套被反复使用的、多数人知晓的、经过分类编目的、__代码设计经验的总结__。简而言之:是前辈们对代码开发经验的总结,解决特定问题的一系列 __套路__。   
## 2.有什么好处  
   使用设计模式是用来提高代码可复用性、可维护性、可读性、稳健性以及安全性。
```javasrcipt
在 1994 年，由 Erich Gamma、Richard Helm、Ralph Johnson 和 John Vlissides 四人合著出版了一本名为
Design Patterns - Elements of Reusable Object-Oriented Software（中文译名：设计模式 -可复用的面
向对象软件元素） 的书，该书首次提到了软件开发中设计模式的概念。
四位作者合称 GOF（四人帮，全拼 Gang of Four）。他们所提出的设计模式主要是基于以下的面向对象设计原则。
```
![QQ截图20190919105121.png](https://i.loli.net/2019/09/19/dTSPgR6IqyDfHt2.png)
  __a.对接口编程而不是对实现编程__ 
  编程时针对超类型（父类）进行编程，也就是说变量的声明类型（或方法的返回类型）是超类型，而不是具体的某个子类。
超类型中的各个方法的具体实现不在超类型中，而是在各个子类中。这样在程序执行时可以根据实际状况执行到真正的（
某个子类）行为。这样带来的好处是，我们在声明一个变量时无需关心以后执行时的真正的数据类型是哪种（某个子类类
型），这是种解耦合（松耦合）的思想。我们之后维护的时候可以随时将声明的变量替换为真正需要要执行的类型，具有很高的可维护性和可扩展性

 __b.优先使用对象组合而不是继承__ 
```javascript
继承的缺点：
 1.继承的其中一个缺点：无法通过继承的方式，重用多个类中的代码
 2.继承还有第二个缺点，那就是，父类的属性和方法，子类是无条件继承的
 3.使用继承很容易造成方法的污染。一旦父类的属性和方法，在子类中不能完全适用。那么，也就不应该使用继承关系了
 4.从父类继承而来的实现是静态的，不能在运行时发生改变，不够灵活
继承有自身的优点，父类的大部分功能可以通过继承关系自动进入子类；修改或扩展继承而来的实现较为容易。
组合的解决方案:
 1.通过聚合/组合关系，可以解决继承的缺点。由于一个类可以建多个属性，也就是可以聚合多个类。所以，可以通过聚合
/组合关系，重用多个类中的代码。
 2.另外，我们可以选择一个类中是否应该具有某种行为，从而决定应该聚合那些类，不应该聚合那些类。这样，通过聚合
/组合关系，也可以避免继承所带的方法污染问题。
 3.聚合/组合复用也可以在运行时动态进行。新对象可以使用聚合/组合关系，将新的责任委派到合适的对象。
```
总结：
继承和组合都能达到一个代码复用的效果，但是类的继承通常是白箱复用，对象组合通常为黑箱复用。我们在使用继承的
时候同时也就拥有了父对象中的保护成员，增加了耦合度。而对象组合就只需要在使用的时候接口稳定，耦合度低。  
Is a和has a 我们怎么来判断是用继承还是组合呢？只有在对象之间关系具有很强的is a关系的时候才使用继承。  
继承可以用，但使用继承需要谨慎。一般来说，使用继承有两个条件：  
父类中所有的属性和方法，在子类中都适用。  
子类不需要再去重用别的类中的代码。如果不能满足这两个条件，那么就应该使用聚合/组合关系去替代继承，来达到代码的复用。
## 3.设计模式的六大原则
*  __1、开闭原则（Open Close Principle ）__

开闭原则的意思是：对扩展开放，对修改关闭。在程序需要进行拓展的时候，不能去修改原有的代码，实现一个热插拔的效果。简言之，是为了使程序的扩展性好，易于维护和升级。想要达到这样的效果，我们需要使用接口和抽象类，后面的具体设计中我们会提到这点。

* __2、里氏代换原则（Liskov Substitution Principle）__

里氏代换原则是面向对象设计的基本原则之一。 里氏代换原则中说，任何基类可以出现的地方，子类一定可以出现。LSP 是继承复用的基石，只有当派生类可以替换掉基类，且软件单位的功能不受到影响时，基类才能真正被复用，而派生类也能够在基类的基础上增加新的行为。里氏代换原则是对开闭原则的补充。实现开闭原则的关键步骤就是抽象化，而基类与子类的继承关系就是抽象化的具体实现，所以里氏代换原则是对实现抽象化的具体步骤的规范。

* __3、依赖倒转原则（Dependence Inversion Principle）__

这个原则是开闭原则的基础，具体内容：针对接口编程，依赖于抽象而不依赖于具体。

* __4、接口隔离原则（Interface Segregation Principle）__

这个原则的意思是：使用多个隔离的接口，比使用单个接口要好。它还有另外一个意思是：降低类之间的耦合度。由此可见，其实设计模式就是从大型软件架构出发、便于升级和维护的软件设计思想，它强调降低依赖，降低耦合。

* __5、迪米特法则，又称最少知道原则（Demeter Principle）__

最少知道原则是指：一个实体应当尽量少地与其他实体之间发生相互作用，使得系统功能模块相对独立。

* __6、合成复用原则（Composite Reuse Principle）__

合成复用原则是指：尽量使用合成/聚合的方式，而不是使用继承。

## 4.设计模式的类型
```javascript
根据设计模式的参考书 Design Patterns - Elements of Reusable Object-Oriented Software（中文译名：设计模式 -
可复用的面向对象软件元素） 中所提到的，总共有 23 种设计模式。这些模式可以根据模式的目的来分，分为三大类：创建型模式（Creational
Patterns）、结构型模式（Structural Patterns）、行为型模式（Behavioral Patterns）；根据作用范围来分，分为类模式和对象模式两种。  
```
**根据模式的目的来分**
* 创建型模式：用于描述“怎样创建对象”，它的主要特点是“将对象的创建与使用分离”。GoF 中提供了单例、原型、工厂方法、抽象工厂、建造者等 5 种创建型模式。
* 结构型模式：用于描述如何将类或对象按某种布局组成更大的结构，GoF 中提供了代理、适配器、桥接、装饰、外观、享元、组合等 7 种结构型模式。  
* 行为型模式：用于描述类或对象之间怎样相互协作共同完成单个对象都无法单独完成的任务，以及怎样分配职责。GoF 中提供了模板方法、策略、命令、职责链、状态、观察者、中介者、迭代器、访问者、备忘录、解释器等 11 种行为型模式。

**根据作用范围来分**
* 类模式：用于处理类与子类之间的关系，这些关系通过继承来建立，是静态的，在编译时刻便确定下来了。GoF中的工厂方法、（类）适配器、模板方法、解释器属于该模式。  
* 对象模式：用于处理对象之间的关系，这些关系可以通过组合或聚合来实现，在运行时刻是可以变化的，更具动态性。GoF 中除了以上 4 种，其他的都是对象模式。    
<table border="1">
<caption>
表1GoF 的 23 种设计模式的分类表</caption>
<tbody>
<tr>
<th>
范围\目的</th>
<th>
创建型模式</th>
<th>
结构型模式</th>
<th>
行为型模式</th>
</tr>
<tr>
<td>
类模式</td>
<td>
工厂方法</td>
<td>
(类）适配器</td>
<td>
模板方法、解释器</td>
</tr>
<tr>
<td colspan="1" rowspan="9">
对象模式</td>
<td colspan="1" rowspan="9">
单例<br>
原型<br>
抽象工厂<br>
建造者</td>
<td colspan="1" rowspan="7">
代理<br>
(对象）适配器<br>
桥接<br>
装饰<br>
外观<br>
享元<br>
组合</td>
<td colspan="1" rowspan="6">
策略<br>
命令<br>
职责链<br>
状态<br>
观察者<br>
中介者<br>
迭代器<br>
访问者<br>
备忘录</td>
</tr>
</tbody>
</table>  

  前面说明了 GoF 的 23 种设计模式的分类，现在对各个模式的功能进行介绍。
1. 单例（Singleton）模式：某个类只能生成一个实例，该类提供了一个全局访问点供外部获取该实例，其拓展是有限多例模式。
1. 原型（Prototype）模式：将一个对象作为原型，通过对其进行复制而克隆出多个和原型类似的新实例。
1. 工厂方法（Factory Method）模式：定义一个用于创建产品的接口，由子类决定生产什么产品。
1. 抽象工厂（AbstractFactory）模式：提供一个创建产品族的接口，其每个子类可以生产一系列相关的产品。
1. 建造者（Builder）模式：将一个复杂对象分解成多个相对简单的部分，然后根据不同需要分别创建它们，最后构建成该复杂对象。
1. 代理（Proxy）模式：为某对象提供一种代理以控制对该对象的访问。即客户端通过代理间接地访问该对象，从而限制、增强或修改该对象的一些特性。
1. 适配器（Adapter）模式：将一个类的接口转换成客户希望的另外一个接口，使得原本由于接口不兼容而不能一起工作的那些类能一起工作。
1. 桥接（Bridge）模式：将抽象与实现分离，使它们可以独立变化。它是用组合关系代替继承关系来实现，从而降低了抽象和实现这两个可变维度的耦合度。
1. 装饰（Decorator）模式：动态的给对象增加一些职责，即增加其额外的功能。
1. 外观（Facade）模式：为多个复杂的子系统提供一个一致的接口，使这些子系统更加容易被访问。
1. 享元（Flyweight）模式：运用共享技术来有效地支持大量细粒度对象的复用。
1. 组合（Composite）模式：将对象组合成树状层次结构，使用户对单个对象和组合对象具有一致的访问性。
1. 模板方法（TemplateMethod）模式：定义一个操作中的算法骨架，而将算法的一些步骤延迟到子类中，使得子类可以不改变该算法结构的情况下重定义该算法的某些特定步骤。
1. 策略（Strategy）模式：定义了一系列算法，并将每个算法封装起来，使它们可以相互替换，且算法的改变不会影响使用算法的客户。
1. 命令（Command）模式：将一个请求封装为一个对象，使发出请求的责任和执行请求的责任分割开。
1. 职责链（Chain of Responsibility）模式：把请求从链中的一个对象传到下一个对象，直到请求被响应为止。通过这种方式去除对象之间的耦合。
1. 状态（State）模式：允许一个对象在其内部状态发生改变时改变其行为能力。
1. 观察者（Observer）模式：多个对象间存在一对多关系，当一个对象发生改变时，把这种改变通知给其他多个对象，从而影响其他对象的行为。
1. 中介者（Mediator）模式：定义一个中介对象来简化原有对象之间的交互关系，降低系统中对象间的耦合度，使原有对象之间不必相互了解。
1. 迭代器（Iterator）模式：提供一种方法来顺序访问聚合对象中的一系列数据，而不暴露聚合对象的内部表示。
1. 访问者（Visitor）模式：在不改变集合元素的前提下，为一个集合中的每个元素提供多种访问方式，即每个元素有多个访问者对象访问。
1. 备忘录（Memento）模式：在不破坏封装性的前提下，获取并保存一个对象的内部状态，以便以后恢复它。
1. 解释器（Interpreter）模式：提供如何定义语言的文法，以及对语言句子的解释方法，即解释器。  

----
# 二、创建型模式
## 1.工厂
**定义:**
定义一个创建产品对象的工厂接口，将产品对象的实际创建工作推迟到具体子工厂类当中。这满足创建型模式中所要求的“创建与使用相分离”的特点。  
**优点:**  
* 用户只需要知道具体工厂的名称就可得到所要的产品，无须知道产品的具体创建过程；
* 在系统增加新的产品时只需要添加具体产品类和对应的具体工厂类，无须对原工厂进行任何修改，满足开闭原则；

**缺点:** 
每增加一个产品就要增加一个具体产品类和一个对应的具体工厂类，这增加了系统的复杂度。  

**适用场景:**
- 客户只知道创建产品的工厂名，而不知道具体的产品名。如 TCL 电视工厂、海信电视工厂等。
- 创建对象的任务由多个具体子工厂中的某一个完成，而抽象工厂只提供创建产品的接口。
- 客户不关心创建产品的细节，只关心产品的品牌。
### 1.1 简单工厂方法模式
```javascript
我们把被创建的对象称为“产品”，把创建产品的对象称为“工厂”。如果要创建的产品不多，只要一个工厂类就
可以完成，这种模式叫“简单工厂模式”，它不属于 GoF 的 23 种经典设计模式，它的缺点是增加新产品时会违
背“开闭原则”。
```
**案例代码**  
![QQ截图20190919164931.png](https://i.loli.net/2019/09/19/kpCEWOUdxTer25V.png)

### 1.2 工厂方法模式
工厂方法模式由抽象工厂、具体工厂、抽象产品和具体产品等4个要素构成.
* **抽象工厂（Abstract Factory）**：提供了创建产品的接口，调用者通过它访问具体工厂的工厂方法 newProduct() 来创建产品。
* **具体工厂（ConcreteFactory）**：主要是实现抽象工厂中的抽象方法，完成具体产品的创建。
* **抽象产品（Product）**：定义了产品的规范，描述了产品的主要特性和功能。
* **具体产品（ConcreteProduct）**：实现了抽象产品角色所定义的接口，由具体工厂来创建，它同具体工厂之间一一对应。
![QQ截图20190919164931.png](http://c.biancheng.net/uploads/allimg/181114/3-1Q114135A2M3.gif)  

**案例代码**  
![QQ截图20190922124313.png](https://i.loli.net/2019/09/22/HATLcJ3j1iI5wXM.png)
![QQ截图20190922124503.png](https://i.loli.net/2019/09/22/Nu6H9l3pfLZrjS5.png)  


## 2.抽象工厂模式
**定义:**
一种为访问类提供一个创建一组相关或相互依赖对象的接口，且访问类无须指定所要产品的具体类就能得到同族的不同等级的产品的模式结构。  
（抽象工厂模式是工厂方法模式的升级版本，工厂方法模式只生产一个等级的产品，而抽象工厂模式可生产多个等级的产品）  
**优点:**  
* 可以在类的内部对产品族中相关联的多等级产品共同管理，而不必专门引入多个新的类来进行管理。
* 当增加一个新的产品族时不需要修改原代码，满足开闭原则(有一定的“开闭原则”倾斜性）

**缺点:** 
当产品族中需要增加一个新的产品时，所有的工厂类都需要进行修改。  

**适用场景:**
- 当需要创建的对象是一系列相互关联或相互依赖的产品族时，如电器工厂中的电视机、洗衣机、空调等。
- 系统中有多个产品族，但每次只使用其中的某一族产品。如有人只喜欢穿某一个品牌的衣服和鞋。
- 系统中提供了产品的类库，且所有产品的接口相同，客户端不依赖产品实例的创建细节和内部结构。

**抽象工厂模式的主要角色如下**
* **抽象工厂（Abstract Factory）**：提供了创建产品的接口，它包含多个创建产品的方法 newProduct()，可以创建多个不同等级的产品。
* **具体工厂（Concrete Factory）**：主要是实现抽象工厂中的多个抽象方法，完成具体产品的创建。
* **抽象产品（Product）**：定义了产品的规范，描述了产品的主要特性和功能，抽象工厂模式有多个抽象产品。
* **具体产品（ConcreteProduct）**：实现了抽象产品角色所定义的接口，由具体工厂来创建，它 同具体工厂之间是多对一的关系。

![image](http://c.biancheng.net/uploads/allimg/181114/3-1Q11416002NW.gif)

**案例代码**  
![QQ截图20190922224938.png](https://i.loli.net/2019/09/22/MfQlXHoYW8PxdKs.png)  
![QQ截图20190922225116.png](https://i.loli.net/2019/09/22/bdmShq68WwXc1uF.png)

## 3.单例模式
**定义:**
指一个类只有一个实例，且该类能自行创建这个实例的一种模式，对外提供一个访问该单例的全局访问点。   
**优点:**  
* 线程安全,保证数据内容的一致性
* 在类加载的同时已经创建好一个静态对象，调用时反应速度快,节省内存资源

**缺点:** 
- 不适用于变化的对象，如果同一类型的对象总是要在不同的用例场景发生变化，单例就会引起数据的错误，不能保存彼此的状态。 
- 由于单利模式中没有抽象层，因此单例类的扩展有很大的困难。 
- 单例类的职责过重，在一定程度上违背了“单一职责原则”。 
- 滥用单例将带来一些负面问题，如为了节省资源将数据库连接池对象设计为的单例类，可能会导致共享连接池对象的程序过多而出现连接池溢出；如果实例化的对象长时间不被利用，系统会认为是垃圾而被回收，这将导致对象状态的丢失。。  

**适用场景:**
- 在应用场景中，某类只要求生成一个对象的时候，如一个班中的班长、每个人的身份证号等。
- 当对象需要被共享的场合。由于单例模式只允许创建一个对象，共享该对象可以节省内存，并加快对象访问速度。如 Web 中的配置对象、数据库的连接池等。
- 当某类需要频繁实例化，而创建的对象又频繁被销毁的时候，如多线程的线程池、网络连接池等。

**单例模式的主要角色如下**
* **单例类**：包含一个实例且能自行创建这个实例的类 。
* **访问类**：使用单例的类。

![image](http://c.biancheng.net/uploads/allimg/181113/3-1Q1131KQ4K8.gif)

**案例代码0**  
```java
/**
 * 饿汉模式(安全模式)
 */
public class HungrySingleton {
	private static final HungrySingleton instance=new HungrySingleton();
	private HungrySingleton() {}
	public static HungrySingleton getInstance() {
		return instance;
	}
}
```  
**代码分析**   
该模式的特点是类一旦加载就创建一个单例，保证在调用 getInstance 方法之前单例已经存在了,以后都不会再改变，所以是多线程安全的。缺点当类装载的时候就会创建类实例，不管你用不用，先创建出来，然后每次调用的时候，就不需要再判断了，节省了运行时间(典型的以空间换时间)。  
**案例代码1** 
```java
/**
 * 懒汉模式(非安全模式)
 */
public class LazySingleton0 {
    private static LazySingleton0 instance=null;
    private LazySingleton0(){};//避免类在外部实例化
    //方法上加同步
    public static LazySingleton0 getInstance() {
        if (instance == null) {
	            instance = new LazySingleton0();
        }
        return instance;
    }
}
```
**代码分析**  
懒汉模式(非安全模式):类加载时没有生成单例，只有当第一次调用getInstance方法时才去创建这个单例，比较节约内存空间。但该实例是存在线程安全的。在并发的情况下是可能出现这种情况，就是a线程先进入getInstance()方法在创建实例化的时候，也就是还没创建成功，b线程也进入了getInstance()方法，这个时候a线程实例还没建成功，b线程判断single为空也开始创建实例，导致会出现创建出两个实例来。(可以在new LazySingleton0()前加上Thread.sleep(3000)放大这种效果)  
**案例代码2**  
```java
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
```  
**测试结果**  
![QQ截图20190926094711.png](https://i.loli.net/2019/09/26/7EhNZ9WRXmMidcl.png)  
**案例代码3**   
```java
/**
 * 懒汉模式(双重校验锁)
 */
public class LazySingleton2 {
	/*
     *  uniqueInstance = new Signleton();实际上是有三个步骤：
     *  为 uniqueInstance 分配内存空间
     *  初始化 uniqueInstance
     *  将 uniqueInstance 指向分配的内存地址
     *  在JVM优化中有一项指令重排，为了保证提高处理器效率，实际执行的顺序有可能与代码书写的顺序不同。
     * 在这三个步骤中，执行顺序有可能编程1->3->2，也就是说线程可能获得一个没有初始化的对象。
     *  声明对象为volatile，该关键字防止指令重排序，保证了多线程下正常运行
     */
    private static volatile LazySingleton2 instance=null;
    private LazySingleton2(){};//避免类在外部实例化
    //方法上加同步
    public static LazySingleton2 getInstance() {
        if (instance == null) {
        	try {
                synchronized(LazySingleton2.class) {
                    if(instance == null) {
                    	Thread.sleep(3000);
                        instance = new LazySingleton2();
                    }
                }
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
        }
        return instance;
    }
}


/**
 * 懒汉模式(静态内部类式)
 */
public class LazySingleton3 {
    private LazySingleton3(){};//避免类在外
    /*
     * 静态内部类实现单例模式，这种方式优于上面两种方式，
     * 他即实现了线程安全，又省去了null的判断，性能优于上面两种
     */
    private static class LazyHolder{
    	private static final LazySingleton3 INSTANCE=new LazySingleton3();
    } 
    部实例化
    //方法上加同步
    public static final LazySingleton3 getInstance() {
        return LazyHolder.INSTANCE;
    }
}
```
**代码分析**   
双重校验锁:代码中关键字volatile和synchronized能保证该段代码在多线程环境下安全，但每次访问时都要同步，会影响性能，且消耗更多的资源，这是懒汉式单例的缺点;  
静态内部类式：静态内部类实现单例模式，这种方式优于上面两种方式,他即实现了线程安全，又省去了null的判断，性能优于上面两种.(内部类LazyHolder只有在getInstance()方法第一次调用的时候才会被加载（实现了延迟加载效果），而且其加载过程是线程安全的（实现线程安全）。内部类加载的时候只实例化了一次instance)。  
 !!#ff0000但是!! ，上面所有的单例模式是在不考虑放射机制和序列化机制的情况下实现的单例模式，但是如果考虑了放射，则上面的单例就无法做到单例类只能有一个实例这种说法了。测试代码如下:  
**案例代码4**  
```java
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
```  
**测试结果**  
![QQ截图20190926101259.png](https://i.loli.net/2019/09/26/vzoupwZImQEBDyf.png)  
**代码分析**   
结果如上，尤此可得出以上的单例无法避免反射的恶意攻击。我们可以采用枚举模式来实现。  
**案例代码5**  
```java
/**
 * 懒汉模式(枚举方式)
 */
public enum LazySingleton4 {
	INSTANCE;
    //方法上加同步
    public LazySingleton4 getInstance() {
        return INSTANCE;
    }
}
//我们再使用上面的反射攻击测试枚举方式的单例模式创建的实例是否相同
```  
**测试结果**   
![QQ截图20190926102600.png](https://i.loli.net/2019/09/26/PUJ6yl9EHqKbVcR.png)  
**代码分析**    
反射在通过newInstance创建对象时，会检查该类是否ENUM修饰，如果是则抛出异常，反射失败。所以就算你反射的时候设置有参构造器也会反射失败。所以枚举是不怕反射攻击的。

---
# 三、结构模式
## 1.代理
**定义:**
由于某些原因需要给某对象提供一个代理以控制对该对象的访问。这时，访问对象不适合或者不能直接引用目标对象，代理对象作为访问对象和目标对象之间的中介。  
**优点:**  
* 代理模式在客户端与目标对象之间起到一个中介作用和保护目标对象的作用。
* 代理对象可以扩展目标对象的功能。
* 代理模式能将客户端与目标对象分离，在一定程度上降低了系统的耦合度。  

**缺点:** 
* 在客户端和目标对象之间增加一个代理对象，会造成请求处理速度变慢；
* 增加了系统的复杂度；  

**适用场景:**
- 远程代理，这种方式通常是为了隐藏目标对象存在于不同地址空间的事实，方便客户端访问。例如，用户申请某些网盘空间时，会在用户的文件系统中建立一个虚拟的硬盘，用户访问虚拟硬盘时实际访问的是网盘空间。。
- 虚拟代理，这种方式通常用于要创建的目标对象开销很大时。例如，下载一幅很大的图像需要很长时间，因某种计算比较复杂而短时间无法完成，这时可以先用小比例的虚拟代理替换真实的对象，消除用户对服务器慢的感觉。
- 安全代理，这种方式通常用于控制不同种类客户对真实对象的访问权限。
- 智能指引，主要用于调用目标对象时，代理附加一些额外的处理功能。例如，增加计算真实对象的引用次数的功能，这样当该对象没有被引用时，就可以自动释放它；
- 延迟加载，指为了提高系统的性能，延迟对目标的加载。例如，Hibernate 中就存在属性的延迟加载和关联表的延时加载

### 1.1 代理模式的结构和实现
代理模式的结构比较简单，主要是通过定义一个继承抽象主题的代理来包含真实主题，从而实现对真实主题的访问，下面来分析其基本结构和实现方法。  
* **抽象主题（Subject）类**：通过接口或抽象类声明真实主题和代理对象实现的业务方法。
* **真实主题（Real Subject）类**：实现了抽象主题中的具体业务，是代理对象所代表的真实对象，是最终要引用的对象。
* **代理（Proxy）类**：提供了与真实主题相同的接口，其内部含有对真实主题的引用，它可以访问、控制或扩展真实主题的功能。
![QQ截图20190919164931.png](http://c.biancheng.net/uploads/allimg/181115/3-1Q115093011523.gif)  
**案例代码**  
![QQ截图20190926110753.png](https://i.loli.net/2019/09/26/jO8KFW3arTIdVLA.png) 
```java
出行查找地图....
12306官方出票...
当地旅行推荐...
```

### 1.2 动态代理
在前面介绍的代理模式中，代理类中包含了对真实主题的引用，这种方式存在两个缺点。
真实主题与代理主题一一对应，增加真实主题也要增加代理。
设计代理以前真实主题必须事先存在，不太灵活。采用动态代理模式可以解决以上问题如 SpringAOP
![QQ截图20190919164931.png](http://c.biancheng.net/uploads/allimg/181115/3-1Q115093255227.gif)

**案例代码**  
```java
/**
 * 作用:
 * 1.  生成 动态代理对象
 * 2.  指定 代理对象运行目标对象方法时需要完成的 具体任务
 * 注：需实现InvocationHandler接口 = 调用处理器 接口
 * 所以称为 调用处理器类
 */
public class DynamicProxy implements InvocationHandler{
	// 声明代理对象
    // 作用：绑定关系，即关联到哪个接口（与具体的实现类绑定）的哪些方法将被调用时，执行invoke（）
	private Object proxyObj;
	public Object newProxyInstance(Object proxyObj)
	{
		this.proxyObj=proxyObj;
		return Proxy.newProxyInstance(proxyObj.getClass().getClassLoader(), proxyObj.getClass().getInterfaces(), this);
		// Proxy类 = 动态代理类的主类 
        // Proxy.newProxyInstance（）作用：根据指定的类装载器、一组接口 & 调用处理器 生成动态代理类实例，并最终返回
        // 参数说明：
        // 参数1：指定产生代理对象的类加载器，需要将其指定为和目标对象同一个类加载器
        // 参数2：指定目标对象的实现接口
        // 即要给目标对象提供一组什么接口。若提供了一组接口给它，那么该代理对象就默认实现了该接口，这样就能调用这组接口中的方法
        // 参数3：指定InvocationHandler对象。即动态代理对象在调用方法时，会关联到哪个InvocationHandler对象
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable{
		 // 参数说明：
        // 参数1：动态代理对象（即哪个动态代理对象调用了method（）
        // 参数2：目标对象被调用的方法
        // 参数3：指定被调用方法的参数
		Object result=null;
		preMethod();
		System.out.println("执行代理方法...");
		result = method.invoke(proxyObj, args);
		AfterMethod();
		return result;
	}
	
	public void preMethod() {
		System.out.println("购买前推荐...");
	}

	public void AfterMethod() {
		System.out.println("购买后推荐...");
	}
}

/**
 * 代理客户端
 */
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
```
**测试结果**  
```java
购买前推荐...
执行代理方法...
在淘票票上代购电影票...
购买后推荐...
===============================================
购买前推荐...
执行代理方法...
美团上购买电影票...
购买后推荐...
```
**代码分析**    
*  创建动态代理类 & 对象：通过调用处理器类对象newProxyInstance（）
*  通过调用动态代理对象方法从而调用目标对象方法

---
# 四、行为模式
## 1.观察者
**定义:**
指多个对象间存在一对多的依赖关系，当一个对象的状态发生改变时，所有依赖于它的对象都得到通知并被自动更新。这种模式有时又称作发布-订阅模式、模型-视图模式，它是对象行为型模式。  
**优点:**  
* 降低了目标与观察者之间的耦合关系，两者之间是抽象耦合关系。
* 目标与观察者之间建立了一套触发机制。  

**缺点:** 
* 目标与观察者之间的依赖关系并没有完全解除，而且有可能出现循环引用；
* 当观察者对象很多时，通知的发布会花费很多时间，影响程序的效率；  

**适用场景:**
- 对象间存在一对多关系，一个对象的状态发生改变会影响其他对象。
- 当一个抽象模型有两个方面，其中一个方面依赖于另一方面时，可将这二者封装在独立的对象中以使它们可以各自独立地改变和复用  

### 1.1 观察者模式的结构和实现
实现观察者模式时要注意具体目标对象和具体观察者对象之间不能直接调用，否则将使两者之间紧密耦合起来，这违反了面向对象的设计原则。  
* **抽象主题（Subject）角色**：也叫抽象目标类，它提供了一个用于保存观察者对象的聚集类和增加、删除观察者对象的方法，以及通知所有观察者的抽象方法。
* **具体主题（Concrete    Subject）角色**：也叫具体目标类，它实现抽象目标中的通知方法，当具体主题的内部状态发生改变时，通知所有注册过的观察者对象。
* **抽象观察者（Observer）角色**：它是一个抽象类或接口，它包含了一个更新自己的抽象方法，当接到具体主题的更改通知时被调用。
* **具体观察者（Concrete Observer）角色**：实现抽象观察者中定义的抽象方法，以便在得到目标的更改通知时更新自身的状态。
![QQ截图20190919164931.png](http://c.biancheng.net/uploads/allimg/181116/3-1Q1161A6221S.gif)  
**案例代码**  
```java

/**
 * 抽象者
 */
public interface IObserver {
	void response();//反应
}

/**
 * 具体观察者1
 *
 */
public class ObserverImpl1 implements IObserver {
	@Override
	public void response() {
		System.out.println("具体观察者1做出反应...");
	}
}

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


/**
 * 演示
 */
public class ObserverTest {
	public static void main(String[] args) {
		ISubject sub = new SubjectImpl();
		IObserver obs1 = new ObserverImpl1();
		IObserver obs2 = new ObserverImpl2();
		sub.add(obs1);
		sub.add(obs2);
		sub.notifyObserver();
	}
}
```

**演示效果** 
```java
具体目标发生变化....
=================
具体观察者1做出反应...
具体观察者2做出反应...
```
案例源码地址:
https://github.com/80sAzhong/design_patterns.git

