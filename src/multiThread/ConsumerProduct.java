package multiThread;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ConsumerProduct {
	public volatile static  AtomicInteger count=new AtomicInteger(0);
	public static Object lock = new Object();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread t1 = new Thread(new Consumer());
		Thread t2 = new Thread(new Producter());
		Thread t3 = new Thread(new Consumer());
		t3.start();
		t2.start();
		t1.start();
	}

}
