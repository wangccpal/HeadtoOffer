import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.locks.Lock;
//测试得出static final变量必须在声明时初始化，final可以在块儿里初始化
public class wmsj3 {
	 final int a;
	{
		a=3;
	}
	public static void main(String[] args) {
		System.out.println(f());
		String s ;
		System.out.println("1"+2);
		LinkedList<Integer> list;
		Object o ;
		final int a ;
	}

	private static int f() {
		// TODO Auto-generated method stub
		int a=1;
		try {
			return a++;
		}
		finally {
			++a;
		}
	}
}
