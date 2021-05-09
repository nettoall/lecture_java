package com.nettoall.codetest.ex02;


import java.util.Scanner;

public class MonthDay {

	public static void main(String[] args) {
		int month;
		int repeat;
		
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("달을 입력하세요");
//		month = scanner.nextInt();
//		
//		Calendar cal = new Calendar();
//		
//		System.out.printf("%d월은 최대 %d일까지 있습니다. \n", month,cal.maxDaysOfMonth(month) );
//		scanner.close();
		
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("반복횟수를 입력하세요.");
//		repeat = scanner.nextInt();
//		int[] months = new int[repeat];
//
//		System.out.println("월을 입력하세요");
//		
//		for(int i = 0; i  < repeat; i++) {
//				months[i] = scanner.nextInt();
//		}
//		
//		Calendar cal = new Calendar();
//		for(int j = 0; j < months.length; j++) {
//			System.out.printf("%d월은 %d일까지 있습니다. \n", months[j], cal.maxDaysOfMonth(months[j]));
//		}
		
		Scanner scanner = new Scanner(System.in);
		Calendar cal = new Calendar();
		while(true) {
			System.out.println("월을 입력하세요");
			System.out.print("> ");
			month = scanner.nextInt();
			if(month == -1) {
				
				break;
			}
			System.out.printf("%d월은 %d일까지 있습니다. \n", month, cal.maxDaysOfMonth(month) );
		}
		System.out.println("Have a nice day!");
		scanner.close();

	}

}
