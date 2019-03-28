package Practica3;
import java.util.Scanner;

public class DibujarCuadrado {

	private Scanner leer;

	public void Dibujar() {

		leer = new Scanner(System.in);
		System.out.println("¿De que tamaño será tu cuadrado?");
		int tamaño = leer.nextInt();
		System.out.println("Su cuadrado es el siguiente: ");

		for (int fila = 0; fila < tamaño; fila++) {
			for (int col = 0; col < tamaño; col++) {
				if (fila == 0 | col == 0 | col == tamaño - 1 | fila == tamaño - 1 | fila == col
						| col == (tamaño - fila) - 1) {
					System.out.print(" X");
				} else {
					System.out.print(" O");
				}
			}
			System.out.print("\n");
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DibujarCuadrado c = new DibujarCuadrado();
		c.Dibujar();
	}

}
