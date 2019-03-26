
import java.util.*;
	public class valores {
    public static void main(String[] args) {
    	
        Scanner sc = new Scanner(System.in);
        int A, B;
        System.out.print("Tecleé el valor de A: ");
        A = sc.nextInt();
        System.out.print("Tecleé el valor de B: ");
        B = sc.nextInt();
       // System.out.println("Valores iniciales: A = " + A + "   B = " + B);
        //instrucciones para hacer el intercambio
        A = A + B;
        B = A - B;
        A = A - B;
        
        
        System.out.println("Valores Switcheados son: A = " + A + "   B = " + B);
    }
}
    
