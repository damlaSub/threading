package co.simplon.threading;

import java.util.concurrent.ThreadLocalRandom;

public class Application {
	
public static void main(String[] args) throws InterruptedException {
//	Thread current = Thread.currentThread();
//	Thread.sleep(3000);
//	Runnable task = createTask();
//	Thread one = new Thread(task);
//	Thread two = new Thread(task);
	Runnable task = createTask();
	for(int i= 0; i< 10; i++) {
		Thread thread = createThread(task);
		thread.start();
	}
	

	
}

private static Thread createThread(Runnable task) {
	
	return new Thread(task);
}

 private static Runnable createTask() {
	 
	 
	 
	 return new Runnable() {	
		private static final  ThreadLocalRandom RANDOM = ThreadLocalRandom.current();
		
					@Override
					public void run() {
						
						long duration =RANDOM.nextLong(1, 4) * 1000;
						try {
							Thread.sleep(duration);
							
						} catch (InterruptedException e) {
							//
						}
				//System.out.println(Thread.currentThread().getName() + "run()");
						log();
				
	 }
	 };
 }

private static void log() {
	Thread thread = Thread.currentThread();
	String msg = String.format("[%s] daemon=%s", thread.getName(), thread.isDaemon());
	
	System.out.println(msg);
	}
}
