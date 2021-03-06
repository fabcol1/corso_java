package es.thread;

public class ThreadExample extends Thread {
	public ThreadExample(String str) {
		super(str);
	}
	
	public void run() {
		System.out.println("State: " + getState());
		for(int i = 0; i < 10; i++) {
			System.out.println(i + " " + getName());
			try {
				sleep((int) (Math.random()*1000));
			} catch(InterruptedException e) { }
		}
		System.out.println(getName() + " end his job...");
	}
}
