package basic.thread.pool;

public class ThreadCaller implements Runnable{
    private String name;

    public ThreadCaller(String name){
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("Thread name : " + this.name + " : " + Thread.currentThread().getName());
        int value = Integer.parseInt("삼");

    }
}
