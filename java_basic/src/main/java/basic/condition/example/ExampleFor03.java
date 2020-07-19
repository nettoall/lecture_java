package basic.condition.example;

public class ExampleFor03 {
	public static void main(String[] args) {
		int loop = 5;
		
		for(int i = 0; i < loop; i++) {
			for(int j = i; j < loop-1; j++) {
				System.out.print(" ");
			}
			for(int k =0; k <= (2*i); k++) {
				System.out.print("*");
			}
			System.out.println("");
			
		}
	}

}
