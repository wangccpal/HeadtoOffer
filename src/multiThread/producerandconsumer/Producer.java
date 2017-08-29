package multiThread.producerandconsumer;

import java.util.Random;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Producer implements Runnable{
	private BlockingQueue<String> queue ; 
	public static final int DEFAULT_RANGE_FOR_SLEEP=1000;
    private static AtomicInteger  count                   = new AtomicInteger();
    private volatile boolean      isRunning               = true;

	public Producer(BlockingQueue<String> q) {
		// TODO Auto-generated constructor stub
		this.queue=q;
	}

	@Override
	 public void run() {
        String data = null;
        Random r = new Random();
 
        System.out.println("�����������̣߳�");
        try {
			while (isRunning) {
                System.out.println(Thread.currentThread().getName()+"������������...");
                Thread.sleep(r.nextInt(DEFAULT_RANGE_FOR_SLEEP));
 
                data = "data:" + count.incrementAndGet();
                System.out.println("�����ݣ�" + data + "�������...");
                if (!queue.offer(data, 2, TimeUnit.SECONDS)) {
                    System.out.println("��������ʧ�ܣ�" + data);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        } finally {
            System.out.println("�˳��������̣߳�");
        }
    }
    public void stop() {
        isRunning = false;
    }
}
