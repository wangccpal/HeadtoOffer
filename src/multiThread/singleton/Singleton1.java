package multiThread.singleton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Singleton1 {
	private static volatile Singleton1 instance;
	public static Singleton1 getInstance() {
		if(instance == null) {
			synchronized(Singleton1.class) {
				if(instance ==null) {
					instance = new Singleton1();
				}
			}
		}
		return instance;
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
					System.out.println(getInstance());
				}
			});
		}
		System.out.println("end");
	}
}
