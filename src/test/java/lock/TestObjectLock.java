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

public class TestObjectLock {
	@Test
	public void test() {
		Object a = new Object();
		Object b = new Object();
		Object c = new Object();
		PrintThread ta = new PrintThread(c, a);
		PrintThread tb = new PrintThread(a, b);
		PrintThread tc = new PrintThread(b, c);
		new Thread(ta, "A").start();
		new Thread(tb, "B").start();
		new Thread(tc, "C").start();
	}
	class PrintThread implements Runnable{
		private Object pre;
		private Object cur;
		@Override
		public void run() {
			for(int i=0;i<10;i++) {
				synchronized (cur) {
					synchronized (pre) {
						try {
							System.out.println(Thread.currentThread().getName());
							pre.notify();
							System.out.println("-----");
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					try {
						cur.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
		public PrintThread(Object pre, Object cur) {
			super();
			this.cur = cur;
			this.pre = pre;
		}
		
		
	}
}
