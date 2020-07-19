package basic.thread.create;

import java.awt.Toolkit;

public class BeepPrintExample2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//how 1
//		Runnable task = new BeepTask();
//		Thread thread = new Thread(task);
		
		// how 2
		/*Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				Toolkit toolkit = Toolkit.getDefaultToolkit();
				for( int i =0; i < 5; i++) {
					toolkit.beep();
					try {Thread.sleep(500);}catch(Exception e) {}
				}
			}
		});
		*/
		
//		how 3
		Thread thread = new Thread( () -> {
			Toolkit toolkit = Toolkit.getDefaultToolkit();
			for( int i =0; i < 5; i++) {
				toolkit.beep();
				try {Thread.sleep(500);}catch(Exception e) {}
			}
		});
		
		thread.start();
		
		for(int j =0; j < 5; j++) {
			System.out.println("띵");
		}
	}

}
