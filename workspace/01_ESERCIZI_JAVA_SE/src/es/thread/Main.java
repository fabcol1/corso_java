package es.thread;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		runWithThreadClass();
	}

	private static void runWithThreadClass() throws InterruptedException {
//		ThreadExample th = new ThreadExample("yeeee");
//		System.out.println("State: " + th.getState());
//		th.start();
//		Thread.sleep(11000);
//		System.out.println("State: " + th.getState());
//		
		new ThreadExample("Pippo").start();
		new ThreadExample("Pluto").start();
	}
	
	private static void runWithRunnableInterface() throws InterruptedException {
		RunnableExample runnable = new RunnableExample();
		Thread t = new Thread(runnable);
		t.start();
	}
	
}
