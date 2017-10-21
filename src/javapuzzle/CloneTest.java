package javapuzzle;

public class CloneTest {

	public static void main(String[] args) throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		A a = new A();
		a.init();
		B b = new B();
		b.init();
		Object aa =   a.clone();
		Object bb =  b.clone();
		System.out.println(a);
		System.out.println(aa);
		System.out.println(b);
		System.out.println(bb);
	}


}
class A implements Cloneable{
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	int name;
	int age;
//	B b = null;
	void init(){
//		b = new B();
	}
}

class B implements Cloneable{
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	int name ;
	int age;
//	A a = null;
	void init() {
//		a= new A();
	}
}