package cas;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

import org.junit.Test;

public class Test1 {
	/**
	 * 理应得到10000，但是每次都不确定，因为num++是非原子性的
	 */
	ExecutorService es = Executors.newFixedThreadPool(10);
	private static volatile int num =0;
	public static void increase() {
		num++;
	}
	@Test
	public void test1() {
		CountDownLatch latch = new CountDownLatch(10);
		for(int i=0;i<10;i++) {
			es.execute(new Runnable() {
				@Override
				public void run() {
					for(int k =0 ;k<1000;k++) {
						increase();
					}
					latch.countDown();
				}
			});
		}
		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(num);
	}
	/**
	 * atom提供原子性操作，结果是10000
	 */
	private AtomicInteger number=new AtomicInteger(0);
	private void atomIncrease() {
		number.incrementAndGet();
	}
	@Test
	public void test2() {
		CountDownLatch latch = new CountDownLatch(10);
		for(int i=0;i<10;i++) {
			es.execute(new Runnable() {
				@Override
				public void run() {
					for(int k =0 ;k<1000;k++) {
						atomIncrease();
					}
					latch.countDown();
				}
			});
		}
		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(number);
	}
	
	
}
