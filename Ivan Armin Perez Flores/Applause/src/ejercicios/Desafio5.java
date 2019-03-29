package ejercicios;

import java.util.Scanner;

public class Desafio5 {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);

		int x, a = 0, b = 1, y;
		System.out.println("Cuantos numeros deseas generar");
		x = scan.nextInt();

		for (int i = 1; i <= x; i++) {

			y = a;
			a = a + b;
			b = y;

			System.out.println(b);

		}

	}

}
