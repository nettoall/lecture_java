package basic.thread.create;

import java.awt.Toolkit;

public class BeepPrintExample3 {

	public static void main(String[] args) {
		//how 1
//		Thread thread = new BeepThread();
		
		
		// how 2
		Thread thread = new Thread() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				Toolkit toolkit = Toolkit.getDefaultToolkit();
				for( int i =0; i < 5; i++) {
					toolkit.beep();
					try {Thread.sleep(500);}catch(Exception e) {}
				}
			}
		};
		
		
//		how 3
//		Thread thread = new Thread( () -> {
//			Toolkit toolkit = Toolkit.getDefaultToolkit();
//			for( int i =0; i < 5; i++) {
//				toolkit.beep();
//				try {Thread.sleep(500);}catch(Exception e) {}
//			}
//		});
		
		thread.start();
		
		for(int j =0; j < 5; j++) {
			System.out.println("띵");
		}
	}

}
