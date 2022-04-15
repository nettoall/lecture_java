package algorithm.maxmin;

public class MaxExample {

	public static void main(String[] args) {
		System.out.println(max4(3,2,9,1));
		System.out.println(min3(2,7,1));
		System.out.println(min4(2,7,1,8));
	}
	
	static int max4(int a, int b, int c, int d) {
		int max = 0;
		
		if(a > max) max = a;
		if(b > max) max = b;
		if(c > max) max = c;
		if(d > max) max = d;
		
		return max;
	}
	
	static int min3(int a, int b, int c) {
		int min = 0;
		
		if(min > a) min = a;
		if(min > b) min = b;
		if(min>c) min = c;
		
		return min;
	}
	
	static int min4(int a, int b, int c, int d) {
		int min = 0;
		
		if(min > a) min = a;
		if(min > b) min = b;
		if(min>c) min = c;
		if(min>d) min = d;
		
		return min;
	}

}
