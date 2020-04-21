package com.nettoall.codetest.ex01;

import java.util.Scanner;

public class GugudanMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GugudanClass gugudan = new GugudanClass();
		Scanner scanner = new Scanner(System.in);
		int input = scanner.nextInt();
		
		int[] result = gugudan.calculate(input);
		gugudan.print(result);

	}
	
	

}

class GugudanClass{
	
	
	public int[] calculate(int input) {
		int[] result = new int[9];
		for(int i = 1; i < 10; i++) {
			result[i-1] = input * i;
		}
		
		return result;
	}
	
	public void print(int[] input) {
		for(int i: input) {
			System.out.println(i);
		}
		
	}
}
