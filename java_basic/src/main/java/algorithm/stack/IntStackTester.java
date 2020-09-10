package algorithm.stack;

import java.util.Scanner;

public class IntStackTester {
    public static void main(String[] args){
        Scanner stdIn = new Scanner(System.in);
        IntStack s = new IntStack(64);

        while(true){
            System.out.println("현재 데이터 수 : " + s.size() + "/" + s.capacity());
            System.out.print("(1)푸시  (2)팝  (3)피크  (4)덤프  (5)비어있음  (6)가득참  (7)크기  (8)찾기  (9)클리어 (0)종료  : ");

            int menu = stdIn.nextByte();
            if(menu == 0) break;

            int x;
            switch (menu){
                case 1:
                    System.out.print("데이터: ");
                    x = stdIn.nextInt();
                    try{
                        s.push(x);
                    }catch(IntStack.OverflowIntStackException e){
                        System.out.println("스택이 가득 찼습니다.");
                    }
                    break;

                case 2:
                    try{
                        x = s.pop();
                        System.out.println("팝한 데이터는 " + x + "입니다.");
                    }catch(IntStack.EmptyIntstackException e){
                        System.out.println("스택이 비어 있습니다. ");
                    }
                    break;
                case 3:
                    try{
                        x = s.peek();
                        System.out.println("피크한 데이터틑 " + x + "입니다.");
                    }catch(IntStack.EmptyIntstackException e){
                        System.out.println("스택이 비어 있습니다.");
                    }
                    break;

                case 4:
                    s.dump();
                    break;

                case 5:
                    System.out.println("스택은 "+ (s.isEmpty() ? "비었습니다.":"비지 않았습니다."));
                    break;

                case 6:
                    System.out.println("스택은 "+ (s.isFUll() ? "가득 찼습니다" : "가득 차지 않았습니다.") );
                    break;
                case 7:
                    System.out.println("스택의 크기는 " + s.size() +" 입니다.");
                    break;

                case 8:
                    System.out.print("찾을 숫자는 : ");
                    int index = stdIn.nextInt();
                    System.out.println("찾는 숫자는 : " + s.indexOf(index) + "에 있습니다.");
                    break;
                case 9:
                    System.out.println("스택을 클리어합니다.");
                    s.clear();
                    System.out.println("스택의 크기는 " + s.size() + " 입니다.");
                    break;
            }
        }
    }
}
