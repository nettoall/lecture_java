package algorithm.queue;

public class IntAryQueue {
    private int max;
    private int num;
    private int[] que;

    public IntAryQueue(int capacity){
        num = 0;
        max = capacity;
        try{
            que = new int[max];
        }catch(OutOfMemoryError e){
            max = 0;
        }
    }
    public class EmptyIntAryQueueException extends RuntimeException{
        public EmptyIntAryQueueException(){}
    }

    public class OverflowIntAryQueueException extends RuntimeException{
        public OverflowIntAryQueueException(){}
    }

    public int enQue(int x){
        if(num >= max)
            throw new OverflowIntAryQueueException();
        que[num++] = x;
        return x;
    }

    public int deQue(){
        if(num <= 0)
            throw new EmptyIntAryQueueException();
        int tmp = que[0];
        for(int i = 0; i < num -1; i++){
            que[i] = que[i+1];
        }
        num--;
        return tmp;
    }

    public int peek(){
        if(num <= 0)
            throw new EmptyIntAryQueueException();
        return que[0];
    }

    public int size(){
        return num;
    }
}
