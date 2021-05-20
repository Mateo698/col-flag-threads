package ui;

import java.util.Random;

import model.StripeProgress;
import threads.StripeProgressThread;

public class ProgressUI {
	
	private StripeProgress[] stripes;
	private StripeProgressThread[] threads;
	
	public ProgressUI() {
		Random r = new Random();
		stripes = new StripeProgress[3];
		stripes[0] = new StripeProgress(15,"\033[43m ");
		stripes[1] = new StripeProgress(10,"\033[44m ");
		stripes[2] = new StripeProgress(5,"\033[41m ");
		
		threads = new StripeProgressThread[3];
		threads[0] = new StripeProgressThread(this, stripes[0], (int) (r.nextInt(10)+1)*100);
		threads[1] = new StripeProgressThread(this, stripes[1], (int) (r.nextInt(10)+1)*100);
		threads[2] = new StripeProgressThread(this, stripes[2], (int) (r.nextInt(10)+1)*100);
	}
	
	
	public void start() {
		for (int i = 0; i < threads.length; i++) {
			threads[i].start();
		}
		
	}
	
	public synchronized void refresh() {
		String x = "";
		for (int i = 0; i < stripes.length; i++) {
			x += stripes[i].getStatus();
		}
		System.out.print("\033" + "[2J");
		System.out.println(x);
	}

}
