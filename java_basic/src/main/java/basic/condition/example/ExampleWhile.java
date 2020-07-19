package basic.condition.example;

import java.util.Scanner;

public class ExampleWhile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean run = true;
		int balance = 0;
		Scanner scanner = new Scanner(System.in);
		while(run) {
			System.out.println("---------------------------");
			System.out.println("1.예금 |2.출금 | 3.잔고 | 4.종료");
			System.out.println("---------------------------");
			System.out.print("선택>");
			
			String menuNum = scanner.nextLine();
			
			switch(menuNum) {
			case "1":
				System.out.print("예금액>");
			    int input = scanner.nextInt();
			    balance += input;
			    break;
			case "2":
				System.out.print("출금액>");
			    int output = scanner.nextInt();
			    balance -= output;
			    break;
			case "3":
			    System.out.println("잔고>" + balance);
			    break;
			case "4":
			    run = false;
			    break;
			}
		}
		scanner.close();
		System.out.println("프로그램 종료");
	}

}
