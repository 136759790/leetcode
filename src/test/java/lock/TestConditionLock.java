package lock;
/**
 * 三个线程循环打印ABC10次
 * @author zhaoxiaoteng
 *
 */

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.junit.Test;

public class TestConditionLock {
	Lock lock = new ReentrantLock();
	@Test
	public void test() {
		Condition a = lock.newCondition();
		Condition b = lock.newCondition();
		Condition c = lock.newCondition();
		PrintThread ta = new PrintThread(a, b);
		PrintThread tb = new PrintThread(b, c);
		PrintThread tc = new PrintThread(c, a);
		new Thread(tb, "B").start();
		new Thread(ta, "A").start();
		new Thread(tc, "C").start();
	}
	class PrintThread implements Runnable{
		private Condition cur;
		private Condition after;
		@Override
		public void run() {
			try {
				lock.lock();
				for (int i = 0; i < 10; i++) {
					try {
						System.out.println(Thread.currentThread().getName());
						after.signal();
						cur.await();
						System.out.println(123456);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}finally{
				lock.unlock();
			}
		}
		public PrintThread(Condition cur, Condition after) {
			super();
			this.cur = cur;
			this.after = after;
		}
		
		
	}
}
