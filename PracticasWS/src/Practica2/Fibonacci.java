package Practica2;

public class Fibonacci {

	public int seriefibonacci(int tamaño) {
		int serie = 0, numero1 = 0, numero2 = 1;

		for (int i = 0; i < tamaño; i++) {
			serie = numero1;
			numero1 = numero2;
			numero2 = serie + numero2;
			System.out.println(serie);
		}
		return serie;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Fibonacci f = new Fibonacci();
		f.seriefibonacci(10);
	}

}
