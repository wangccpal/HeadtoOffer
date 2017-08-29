package multiThread;

import multiThread.ConsumerProduct;

public class Consumer implements Runnable {

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
				if (ConsumerProduct.count.get()<= 0) {
					try {
						System.out.println("消费者开始wait");
						ConsumerProduct.lock.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
//					System.out.println(Thread.currentThread().getName() + "消费了第" + ConsumerProduct.count-- + "个产品");
//					ConsumerProduct.lock.notifyAll();
				}
				else {
				System.out.println(Thread.currentThread().getName() + "消费了第" + ConsumerProduct.count.getAndDecrement() + "个产品");
				ConsumerProduct.lock.notifyAll();
				}
			}
		}
	}

}
