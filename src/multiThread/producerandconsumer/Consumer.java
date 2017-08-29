package multiThread.producerandconsumer;

import java.util.Random;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class Consumer implements Runnable{
	private BlockingQueue<String> queue ; 
	public static final int DEFAULT_RANGE_FOR_SLEEP=1000;
	@Override
	public void run() {
		 System.out.println("�����������̣߳�");
	        Random r = new Random();
	        boolean isRunning = true;
	        try {
	            while (isRunning) {
	                System.out.println(Thread.currentThread().getName()+"���Ӷ��л�ȡ����...");
	                String data = queue.poll(2, TimeUnit.SECONDS);
	                if (null != data) {
	                    System.out.println("�õ����ݣ�" + data);
	                    System.out.println("�����������ݣ�" + data);
	                    Thread.sleep(r.nextInt(DEFAULT_RANGE_FOR_SLEEP));
	                } else {
	                    // ����2s��û���ݣ���Ϊ���������̶߳��Ѿ��˳����Զ��˳������̡߳�
	                    isRunning = false;
	                }
	            }
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	            Thread.currentThread().interrupt();
	        } finally {
	            System.out.println("�˳��������̣߳�");
	        }
	}
	public Consumer(BlockingQueue<String> q) {
		super();
		this.queue = q;
	}

}
