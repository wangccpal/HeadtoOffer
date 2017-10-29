package javapuzzle;
/**
 * 学JAVA的时候看到过，是通过引用类型来调用响应的方法，真的是这样吗？覆盖与覆写呢？
 * 
 * 结论是，父类的引用可以得到父类的变量，但是使用的是子类的方法。
 * 如果覆盖的话方法的覆盖不能给可见性降级.
 * private 不能被继承
 * @author CC
 *
 */
public class ExtendsTest {

	String name = "CC";
	
	private int age = 20;
	
	public String getName() {
		System.out.println("fa");
		return name;
	}
	public int getAge() {
		return age;
	}
	
	public static void main(String[] args) {
		ExtendsTest e = new E1();
		System.out.println(e.name);
		System.out.println(e.age);
		System.out.println(e.getName());
		System.out.println(e.getAge());
		System.out.println("____________________________");
		E1 e1 = new E1();
		System.out.println(e1.name);
		System.out.println(e1.age);
		System.out.println(e1.getName());
		System.out.println(e1.getAge());
	}

}

class E1 extends ExtendsTest{
	String name = "LL";
	
	int age = 18;
	
	public String getName() {
		System.out.println("son");
		return name;
	}
	public int getAge() {
		return age;
	}
}
