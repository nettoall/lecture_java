package algorithm.sort.merge;

import java.util.Arrays;

public class ArraysSortTester {

	public static void main(String[] args) {
		int[] x = {22,5,11,32,120,68,70};
		
		Arrays.sort(x);
		
		System.out.println("오름차순으로 정럴했습니다.");
		for(int i = 0; i < x.length;i++) {
			System.out.println("x[" + i + "] = " + x[i]);
		}

	}

}
