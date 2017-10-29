package javapuzzle;
/**
 * 静态变量~静态块儿
 * @author CC
 *考了无数次。。这次记清楚了，先都加载进来，然后再new；
 *注意，不是加载类的时候会执行static方法，而是初始化类的时候，什么时候初始化呢？new，使用静态变量等。
 *http://www.cnblogs.com/ivanfu/archive/2012/02/12/2347817.html
 */
public class StaticBlockTest {
	{
		System.out.println("Hello A");
	}
	
	static {
		System.out.println("Load A ");
	}
	public StaticBlockTest() {
		System.out.println("New A");
	}
	
	public static void main(String[] args) {
		System.out.println("CC");
		new BB();
	}
}

class BB extends StaticBlockTest{
	{
		System.out.println("Hello B");
	}
	
	static {
		System.out.println("Load B ");
	}
	public BB() {
		System.out.println("New B");
	}
}
