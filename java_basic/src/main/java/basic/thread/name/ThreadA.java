package basic.thread.name;

public class ThreadA extends Thread {
	
	public ThreadA() {
		setName("ThreadA");
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i =0; i < 2; i++) {
			System.out.println(getName() +"가 출력 ");
		}
	}

}
