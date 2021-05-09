package com.nettoall.codetest.ex01;

import java.util.Scanner;

public class Gugudan2Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Gugudan2Class gugudan2 = new Gugudan2Class();
		Scanner scanner = new Scanner(System.in);
		int input = scanner.nextInt();
		
		int[] result = gugudan2.calculate(input);
		gugudan2.print(result);

	}
	
	

}

class Gugudan2Class{
	
	
	public int[] calculate(int input) {
		int[] result = new int[input-1];
		for(int i = 2; i <= input; i++) {
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
