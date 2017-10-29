package javapuzzle;

public class WaitTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("1");
		synchronized (args) {
			System.out.println(2);
			try {
				args.wait();
			} catch (InterruptedException e) {
				
			}
		}
		System.out.println("3");
	}

}
