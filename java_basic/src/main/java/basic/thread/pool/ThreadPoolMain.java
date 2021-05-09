package basic.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolMain {
    public static void main(String[] args){
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for(int i = 0; i < 20; i++){
            ThreadCaller caller = new ThreadCaller("Thread-"+i);
            executorService.submit(caller);
        }

        executorService.shutdown();
    }
}
