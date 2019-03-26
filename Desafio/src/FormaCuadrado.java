import java.util.Scanner;

public class FormaCuadrado {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner (System.in);
		
		System.out.println("Define el tamaño del cuadrado");
		int tam=scanner.nextInt();
		
		for(int lado =1 ; lado <= tam; lado ++)
			System.out.println(" *");
		
		System.out.println("\n");
		
		for (int fila= 2 ;fila <tam ; fila ++) {
			
			System.out.print(" *");
			
			for (int lado=2;lado <tam;lado ++)
				System.out.println(" ");
				
				System.out.println("\n");
		}
		for (int lado=1 ; lado <= tam;lado++)
			System.out.println(" *");
	}

}
