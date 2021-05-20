package threads;

import model.StripeProgress;
import ui.ProgressUI;

public class StripeProgressThread extends Thread{
	
	private ProgressUI pui;
	private StripeProgress sp;
	private int time;
	
	public StripeProgressThread(ProgressUI pui, StripeProgress sp,int time) {
		this.pui = pui;
		this.sp = sp;
		this.time = time;
	}
	
	public void run() {
		while(!sp.finished()) {
			sp.advance();
			pui.refresh();
			
			try {
				Thread.sleep(time);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
