package algorithm.stack;

public class TwoStack {
    private int max;
    private int ptr1;
    private int ptr2;
    private int[] stk;

    public class EmptyIntstackException extends RuntimeException{
        public EmptyIntstackException(){}
    }

    public class OverflowIntStackException extends RuntimeException{
        public OverflowIntStackException(){}
    }

    public TwoStack(int capacity){
        ptr1 = 0;
        max = capacity;
        ptr2 = capacity -1 ;
        try{
            stk = new int[max];
        }catch(OutOfMemoryError error){
            max = 0;
        }
    }

    public int push1(int x) throws TwoStack.OverflowIntStackException {
        if(ptr1 >= ptr2 + 1)
            throw new TwoStack.OverflowIntStackException();
        return stk[ptr1++] = x;
    }

    public int push2(int x) throws TwoStack.OverflowIntStackException {
        if(ptr1 >= ptr2 + 1)
            throw new TwoStack.OverflowIntStackException();
        return stk[ptr1--] = x;
    }

    public int pop1() throws TwoStack.EmptyIntstackException {
        if(ptr1 <= 0)
            throw new TwoStack.EmptyIntstackException();
        return stk[--ptr1];
    }

    public int pop2() throws TwoStack.EmptyIntstackException {
        if(ptr2 >= max -1 )
            throw new TwoStack.EmptyIntstackException();
        return stk[++ptr2];
    }

    public int peek1() throws TwoStack.EmptyIntstackException {
        if(ptr1 <= 0)
            throw new TwoStack.EmptyIntstackException();
        return stk[ptr1 - 1];
    }

    public int peek2() throws TwoStack.EmptyIntstackException {
        if(ptr2 >= max -1)
            throw new TwoStack.EmptyIntstackException();
        return stk[ptr2 + 1];
    }

    public int indexOf1(int x){
        for(int i = ptr1 -1; i >= 0; i--){
            if(stk[i] == x)
                return i;
        }
        return -1;
    }

    public int indexOf2(int x){
        for(int i = ptr2 + 1; i <= max; i++){
            if(stk[i] == x)
                return i;
        }
        return -1;
    }

    public void clear1(){
        ptr1 = 0;
    }

    public void clear2(){
        ptr2 = max -1;
    }

    public int capacity(){
        return max;
    }

    public int size1(){
        return ptr1;
    }

    public int size2(){
        return max - ptr2;
    }

    public boolean isEmpty1(){
        return ptr1 <= 0;
    }

    public boolean isEmpty2(){
        return ptr2 >= max -1;
    }

    public boolean isFUll(){
        return ptr1 >= ptr2 + 1;
    }

    public void dump1(){
        if(ptr1 <= 0)
            System.out.println("스택이 비어 있습니다.");
        else{
            for(int i = 0; i < ptr1; i++)
                System.out.print(stk[i] + " ");
            System.out.println();
        }
    }

    public void dump2(){
        if(ptr2 >= max -1 )
            System.out.println("스택이 비어 있습니다.");
        else{
            for(int i = max -1; i > ptr2; i--)
                System.out.print(stk[i] + " ");
            System.out.println();
        }
    }
}
