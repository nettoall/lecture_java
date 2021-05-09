package com.nettoall.codetest.ex01;

import java.util.Scanner;

public class Gugudan3Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Gugudan3Class gugudan3 = new Gugudan3Class();
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		
		String[] array = input.split(",");
		
		int[] result = gugudan3.calculate(Integer.parseInt(array[0]), Integer.parseInt(array[1]));
		gugudan3.print(result);

	}
	
	

}

class Gugudan3Class{
	
	
	public int[] calculate(int input1, int input2) {
		
		
		int[] result = new int[(input1-1) * input2];
		int k = 0;
		for(int i = 2; i <= input1; i++) {
			for(int j = 1; j <= input2; j++) {
				result[k] = i * j ;
				k++;
			}
			
		}
		
		return result;
	}
	
	public void print(int[] input) {
		for(int i: input) {
			System.out.println(i);
		}
		
	}
}
