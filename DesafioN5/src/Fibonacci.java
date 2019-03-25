
public class Fibonacci {

	public static void main(String[] args) {
		int a = 0;
		int b = 1;
		int aux;	
		for (int i= 1; i <= 10 ; i ++){	
			aux =a;
			a = b + a;
			b = aux;
			System.out.println(b);	

	
		}
	}

}
