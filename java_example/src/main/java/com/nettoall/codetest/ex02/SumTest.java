package com.nettoall.codetest.ex02;

import java.util.Scanner;

public class SumTest {

//	public static void main(String[] args) {
//		
//		System.out.println("두 수를 입력하세요");
//		Scanner scanner = new Scanner(System.in);
//		
//		String input = scanner.nextLine();
//		
//		String[] a = input.split(" ");
//		
//		int sum = Integer.parseInt(a[0]) + Integer.parseInt(a[1]);
//		System.out.println(" 두 수의 합은 " + sum + "입니다.");
//	}
	
	public static void main(String[] args) {
		int a,b;
		Scanner scanner = new Scanner(System.in);
				String s1, s2;
				System.out.println("두 수를 입력해 주세요");
				s1 = scanner.next();
				s2 = scanner.next();
				a = Integer.parseInt(s1);
				b = Integer.parseInt(s2);
				
				System.out.printf("%d와 %d의 합은 %d입니다. ", a,b,a+b);
	}

}
