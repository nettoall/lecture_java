package basic.condition.example;

public class ExampleFor01 {
	public static void main(String[] args) {
		int loop = 5;
		
		for(int i = 1; i <= loop; i++) {
			for(int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println("");
		}
	}

}
