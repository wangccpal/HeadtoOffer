package multiThread.singleton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Singleton2 {
	public static Singleton2 getIntance() {
		return InstanceHolder.instance;
	}
	
	private Singleton2() {
	}
	
	static class InstanceHolder{
		static Singleton2 instance = new Singleton2();
	}
	public static void main(String[] args) {
		ExecutorService es = Executors.newFixedThreadPool(10);
		for (int i = 0; i < 20; i++) {
			es.execute(new Runnable() {
				
				@Override
				public void run() {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(getIntance());
				}
			});
		}
		System.out.println("end");
	}

}
