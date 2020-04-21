package com.nettoall.codetest.ex01;

import java.util.Scanner;

public class Gugudan {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[] result = new int[9];
		int input = 0;
		if(scanner.hasNext()) {
			input = scanner.nextInt();
			
//			for(int i = 1; i < 10; i++) {
//				System.out.println(input + "단은 : " + input + " * " + i + " = " + (input * i));
//			}
			
//			for(int i = 1; i < 10; i++) {
//				result[i-1]  = input * i;
//			}
//			
//			for(int i : result) {
//				System.out.println(i);
//			}
			
			Gugudan gugudan = new Gugudan();
			int[] result2 = gugudan.multiply(input);
			gugudan.print(result2);
			
		}else {
			for(int i = 1; i <10; i++) {
				for(int j = 1; j < 10; j++) {
					System.out.println(i + " * " + j +" = " + (i*j));
				}
			}
		}
		// TODO Auto-generated method stub
		

	}
	
	public int[] multiply(int input) {
		int[] result = new int[9];
		for(int i = 1; i < 10; i++) {
			result[i-1]  = input * i;
		}
		return result;
	}
	
	public void print(int[] result) {
		for(int i : result) {
			System.out.println(i);
		}
	}

}
