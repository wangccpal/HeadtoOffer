package javapuzzle;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 测试sychronized标记方法，类，代码块的区别；
 * 同步静态方法
 * @author CC
 *
 */
public class SychronizedTest2 {
	/**
	 * m1 m2 是不可以同步执行的，虽然是两个不同的方法，但是占用了同一个对象的minotor对象
	 * 除非调用不同对象的两个方法
	 * @throws InterruptedException
	 */
	public static synchronized void method1() throws InterruptedException {
		System.out.println(" m1 start");
		Thread.sleep(500);
		System.out.println("m1 execute");
		Thread.sleep(500);
		System.out.println("m1 end");
	}
	
	public static synchronized void method2() throws InterruptedException {
		System.out.println(" m2 start");
		Thread.sleep(500);
		System.out.println("m2 execute");
		Thread.sleep(500);
		System.out.println("m2 end");
	}
	
	public static void main(String[] args) {
		SychronizedTest2 st = new SychronizedTest2();
//		new Thread(new Runnable() {
//			
//			@Override
//			public void run() {
//				// TODO Auto-generated method stub
//				try {
//					st.method1();
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		}).start();
		
//		new Thread(new Runnable() {
//			
//			@Override
//			public void run() {
//				// TODO Auto-generated method stub
//				try {
//					st.method2();
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		}).start();
		ExecutorService es = Executors.newCachedThreadPool();
		es.submit(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					st.method1();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		});
		es.submit(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					st.method2();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
	}
	
	
}
