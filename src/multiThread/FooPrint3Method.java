package multiThread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class FooPrint3Method {
    CountDownLatch cdl = new CountDownLatch(1);
    CountDownLatch cdl1 = new CountDownLatch(1);
    CountDownLatch cdl2 = new CountDownLatch(1);
    CountDownLatch cdl3 = new CountDownLatch(1);
    Semaphore s1 = new Semaphore(0);

    private FooPrint3Method() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        cdl.await();
        cdl1.await();
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        cdl.await();
        cdl2.await();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        cdl1.countDown();
        s1.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        cdl.await();
        cdl3.await();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
        cdl2.countDown();
    }

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> System.out.println("m1");
        Runnable runnable2 = () -> System.out.println("m2");
        Runnable runnable3 = () -> System.out.println("m3");
        FooPrint3Method fooPrint3Method = new FooPrint3Method();
        new Thread(() -> {
            try {
                fooPrint3Method.first(runnable);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                fooPrint3Method.second(runnable2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                fooPrint3Method.third(runnable3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        fooPrint3Method.cdl.countDown();
        fooPrint3Method.cdl3.countDown();
    }

}
