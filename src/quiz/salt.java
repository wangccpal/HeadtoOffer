package quiz;

public class salt implements Runnable {
	String s = "mo";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		salt sa = new salt();
		Thread thread = new Thread(sa);
		try {
			thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 0; i < 10; i++) {
			System.out.println(sa.s);
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		this.s="yes";
	}

}
