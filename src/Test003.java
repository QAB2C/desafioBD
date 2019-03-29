
public class Test003 {

	public static void main(String[] args) {

		int a = 7;
		int b = 3;
		
		System.out.println("Valor inicial de A: " + a);
		System.out.println("Valor inicial de B: " + b);
		
		a = b + a;
		b = a - b;
		a = a - b;
		
		System.out.println("Valor final de A: " + a);
		System.out.println("Valor final de B: " + b);
	}

}
