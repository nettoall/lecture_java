package basic.condition.example;

public class ExampleWhile03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] array = {"one","two","three","four"};
		boolean stop = false;
		int index = 0;
		
		while(!stop) {
			String item = array[index];
			if(item.equals("three")) {
				stop = true;
			}else {
				System.out.println(item);
			}
			index++;
		}
	}

}
