package basic.condition.example;

public class ExampleFor05 {
	public static void main(String[] args) {
		int loop = 5;
		
		for(int i = 0; i < loop; i++) {
			for(int j = 0; j < i; j++) {
				System.out.print(" ");
			}
			for(int k = 0; k <= ((5-i-1)*2); k++) {
				System.out.print("*");
			}
			System.out.println("");
			
		}
	}

}
