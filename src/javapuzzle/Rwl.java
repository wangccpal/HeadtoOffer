package javapuzzle;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Rwl {

	public static void main(String[] args) {
		ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
		rwl.readLock().unlock();
		System.out.println("rn1");
		rwl.readLock().lock();
		System.out.println("rl1");
		rwl.readLock().lock();
		System.out.println("rl1");
		rwl.readLock().unlock();
		System.out.println("rn1");
		rwl.writeLock().lock();
		System.out.println("rl1");
		rwl.writeLock().unlock();
		System.out.println("rn1");
	}

}
