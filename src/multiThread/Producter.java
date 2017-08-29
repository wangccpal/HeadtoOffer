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
						System.out.println("生产者开始wait");
						ConsumerProduct.lock.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
//					System.out.println(Thread.currentThread().getName() + "生产了第" + ++ConsumerProduct.count + "个产品");
//					ConsumerProduct.lock.notifyAll();
				}
				else{
				System.out.println(Thread.currentThread().getName() + "生产了第" + ConsumerProduct.count.incrementAndGet() + "个产品");
				ConsumerProduct.lock.notifyAll();
				}
			}
		}
	}

}
