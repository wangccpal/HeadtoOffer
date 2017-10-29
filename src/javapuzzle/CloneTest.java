
package javapuzzle;
/**
 * 测试一下克隆接口。浅克隆就是对象里面的对象只复制引用，指向的还是同一个对象。
 * 然后如果克隆里面形成了死循环就会爆栈。当然如果对象过大的话也可能是oom
 * @author CC
 *
 */
public class CloneTest {

	public static void main(String[] args) throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		A a = new A();
		A cloneA = a.clone();
		System.out.println(a);
		System.out.println(cloneA);
//		System.out.println(a.b);
//		System.out.println(cloneA.b);
		
		
		B b = new B();
		B cloneB = b.clone();
		System.out.println(b);
		System.out.println(cloneB);
	}

}

class A {
	int a;
//	B b= new B();
	@Override
	protected A clone() throws CloneNotSupportedException {
		A clone = (A)super.clone();
//		clone.b = new B();
		return  clone;
	}
}
class B implements Cloneable{
	int b;
//	A a = new A();
	@Override
	protected B clone() throws CloneNotSupportedException {
		B clone = (B)super.clone();
//		clone.a = new A();
		return  clone;
	}
}