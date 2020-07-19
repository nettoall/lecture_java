package basic.thread.name;

public class ThreadNameExample {

	public static void main(String[] args) {
		Thread thread = Thread.currentThread();
		System.out.println("프로그램 시작 스레드 : " + thread.getName());
		
		Thread threada = new ThreadA();
		System.out.println("ThreadA를 생성한 스레드 : " + thread.currentThread().getName());
		threada.start();

		Thread threadb = new ThreadB();
		System.out.println("ThreadB'를 생성한 스레드 : " + thread.currentThread().getName());
		threadb.start();
	}

}
