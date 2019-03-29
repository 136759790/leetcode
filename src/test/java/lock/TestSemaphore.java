package lock;

import java.util.concurrent.Semaphore;

import org.junit.Test;

public class TestSemaphore {
	
	
	
	@Test
	public void test() {
		Semaphore sa = new Semaphore(1);
		Semaphore sb = new Semaphore(0);
		Semaphore sc = new Semaphore(0);
		Thread ta = new Thread(new PrintThread(sa, sb),"A");
		Thread tb = new Thread(new PrintThread(sb, sc),"B");
		Thread tc = new Thread(new PrintThread(sc, sa),"C");
		ta.start();
		tb.start();
		tc.start();
	}
	
	class PrintThread implements Runnable{
		private Semaphore cur;
		private Semaphore after;
		@Override
		public void run() {
			try {
				for(int i=0;i<10; i++) {
					cur.acquire(1);
					System.out.println(Thread.currentThread().getName());
					after.release(1);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		public PrintThread(Semaphore cur, Semaphore after) {
			super();
			this.cur = cur;
			this.after = after;
		}
		
		
	}
}
