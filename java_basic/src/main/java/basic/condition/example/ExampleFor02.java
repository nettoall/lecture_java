package basic.condition.example;

public class ExampleFor02 {
//	public static void main(String[] args) {
//		int loop = 5;
//		
//		for(int i = 1; i <= loop; i++) {
//			for(int j = 5; j >= 1; j--) {
//				if(j <= i) {
//					System.out.print("*");
//				}else {
//					System.out.print(" ");
//				}
//			}
//			System.out.println("");
//		}
//	}
	public static void main(String[] args) {
		int loop = 5;
		
		for(int i = 0; i < loop; i++) {
			for(int j = i; j < loop; j++) {
				System.out.print(" ");
			}
			for(int k =0; k <=i; k++) {
				System.out.print("*");
			}
			System.out.println("");
			
		}
	}

}
