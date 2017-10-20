package javapuzzle;
/**
 * 测试一下双重return，结果表示以finally的为准；
 * 测试testexception，finally，catched顺序
 * @author CC
 *
 */
public class Try_Finally {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getValue());
		try {
			test();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Exception");
//			e.printStackTrace();
		}
		System.out.println("end");
	}

	public static int getValue() {
		int i=1;
		try {
			i=4;
			return i;//加不加这一行都无所谓
		}
		finally {
			i++;
			return i;
		}
	}
	
	public static void test() throws Exception {
		try {
			throw new Exception();
		}
		finally {
			System.out.println("finally");
		}
	}
}
