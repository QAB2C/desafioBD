
public class Fibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a=1;
		int b=1;
		int temp;
		int limit = 40;
		
			
			System.out.println(a);
			System.out.println(b);
			
			while (b+a <= limit) {
				
				temp = a;
		       a=b;
				b=temp + a;
				
				System.out.println(b);
				
				
				
				
			}
	}

}
