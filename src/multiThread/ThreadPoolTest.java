package multiThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ThreadPoolTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//方法一，Executors 下的工厂方法
		ExecutorService es = Executors.newCachedThreadPool();
		//方法二，直接调用构造函数
		ExecutorService ea = new ThreadPoolExecutor(0, 0, 0, null, null);
		ReentrantLock lc = new ReentrantLock();
		ReadWriteLock;
	}

}
