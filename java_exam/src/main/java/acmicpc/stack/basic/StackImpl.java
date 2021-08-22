package acmicpc.stack.basic;

/**
 * stack LIFO 구조
 *
 */
public class StackImpl {
    int[] intStack = new int[100000];
    int size = 0;

    public void pop() {
        intStack[size -1] = 0;
        size--;
    }

    public void push(int a){
        intStack[size] = a;
        size++;
    }

    public int top() {
        return intStack[size - 1];
    }

    public boolean empty(){
        if(size == 0){
            return true;
        }
        return false;
    }

    public int size(){
        return size;

    }

    public static void main(String[] args) {
        StackImpl stack = new StackImpl();

        System.out.println("before push size : " + stack.size());

        stack.push(5);
        stack.push(10);
        stack.push(3);
        System.out.println("after push(3) top : " + stack.top());
        System.out.println("after push(3) size : " + stack.size());
        stack.pop();
        stack.pop();
        System.out.println("after pop(2) top : " + stack.top());
        System.out.println("after pop(2) size : " + stack.size());
        stack.push(2);
        stack.push(7);
        stack.push(1);
        System.out.println("after push(3) top  : " + stack.top());
        System.out.println("after push(3) empty  : " + stack.empty());
        System.out.println("after push(3) size : " + stack.size());
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        System.out.println("after pop(4) empty  : " + stack.empty());
        System.out.println("after pop(4) size : " + stack.size());
    }
}
