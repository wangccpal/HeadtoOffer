package multiThread;

public class Producter implements Runnable {

	@Override
	public void run() {
		while (true) {
			
			synchronized (ConsumerProduct.lock) {
//				try {
//					Thread.sleep(1000);
//				} catch (InterruptedException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
				if (ConsumerProduct.count .get()>= 100) {
					try {
						System.out.println("�����߿�ʼwait");
						ConsumerProduct.lock.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
//					System.out.println(Thread.currentThread().getName() + "�����˵�" + ++ConsumerProduct.count + "����Ʒ");
//					ConsumerProduct.lock.notifyAll();
				}
				else{
				System.out.println(Thread.currentThread().getName() + "�����˵�" + ConsumerProduct.count.incrementAndGet() + "����Ʒ");
				ConsumerProduct.lock.notifyAll();
				}
			}
		}
	}

}