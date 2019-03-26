import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Intercambiar_valores {
	
	private static BufferedReader stdin = new BufferedReader (new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

			int a= 3;
			int b=7;
			String cadena;
			int entero;
			
			 // se lee un entero y se muestra el valor leído
	        System.out.print("Teclee el valor de a : ");
	        System.out.println("\na=3 || b=7");
	        cadena= stdin.readLine(); 	   // lee como un string
	        //entero = Integer.parseInt(cadena); // convierte a entero
	        System.out.println("\nEl entero leido es: "+ b);

	        // se lee un real y se muestra el valor leído
	        System.out.print("\nTeclee el valor de b : ");
	       cadena= stdin.readLine();
	        System.out.println("\nEl real leido es: "+ a);
	}

}
