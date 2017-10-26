package javapuzzle;

public class SetnullTest {
	
	Object o = new Object();
	
	public static void main(String[] args) {
		SetnullTest t = new SetnullTest();
		setNull(t);
		System.out.println(t);
	}

	private static void setNull(Object o2) {
		o2 = null;
	}

}
