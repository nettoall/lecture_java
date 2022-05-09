//package algorithm.stack;
//
//public class Gstack<E> {
//    private int max;
//    private int ptr;
//    private E[] stk;
//
//    public static class EmptyGstackException extends RuntimeException{
//        public EmptyGstackException(){}
//    }
//
//    public static class OverflowGStackException extends RuntimeException{
//        public OverflowGStackException(){}
//    }
//
//    public Gstack(int capacity){
//        max = capacity;
//        ptr = 0;
//        try{
//            stk = (E[])new Object[max];
//        }catch(OutOfMemoryError e){
//            max = 0;
//        }
//    }
//
//    public void push(E x){
//        if(ptr >= max)
//            throw new OverflowGStackException();
//        stk[ptr++] = x;
//    }
//
//    public E pop(){
//        if(ptr <= 0)
//            throw new EmptyGstackException();
//        return stk[--ptr];
//    }
//
//    public E peek(){
//        if(ptr <= 0)
//            throw new EmptyGstackException();
//        return stk[ptr -1];
//    }
//
//    public int indexOf(E e){
//        for(int i = ptr -1; i >= 0;ptr--){
//            if(stk[i] == e || stk[i].equals(e))
//                return i;
//        }
//        return -1;
//    }
//
//    public void clear(){
//        ptr = 0;
//    }
//
//    public boolean isEmpty(){
//        return ptr <= 0;
//    }
//
//    public boolean isFull(){
//        return ptr >= max;
//    }
//
//    public int capacity(){
//        return max;
//    }
//
//    public int size(){
//        return ptr;
//    }
//
//    public void dump(){
//        if(ptr <= 0)
//            System.out.println("스택이 비었습니다.");
//
//        for(int i = 0; i < ptr -1; i++){
//            System.out.print(stk[i] + " ");
//        }
//        System.out.println();
//    }
//
//}
