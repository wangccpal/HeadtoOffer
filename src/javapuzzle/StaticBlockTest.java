package javapuzzle;
/**
 * 静态变量~静态块儿
 * @author CC
 *
 */
public class StaticBlockTest {
	static int cnt =6;
	static {
		cnt+=9;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(cnt);
	}
	static {
		cnt/=3;
	}
}
