package javapuzzle;
/**
 * 两个线程并发修改hashmap
 */
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map.Entry;

public class HashMapConcurrentTest {

	public static void main(String[] args) {
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(1, 0);
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for (int i = 0; i < 100; i++) {
					System.out.println("开始获取");
					System.out.println(map.get(1));
					System.out.println("结束获取");
				}
			}
		});
		
		Thread t11 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(Entry<Integer, Integer> e : map.entrySet()) {
					System.out.println(e.getValue());
					map.remove(e.getKey());
				}
				
				
			}
		});
		
		t11.start();
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("开始删除");
				map.remove(1);
				System.out.println("结束删除");
			}
		});
		
		Thread t3 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for (int i = 0; i < 100; i++) {
					System.out.println("开始插入");
					map.put(1, i);
					System.out.println("结束插入");
				}
			}
		});
		
		
//		t1.start();
////		t2.start();
//		t3.start();
		map.entrySet().iterator();
		Hashtable<Integer,Integer> h = new Hashtable<>();
	}

}
