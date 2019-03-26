
public class Ejercicio5 {
	public static void main(String[] args) {
        int a=0;
        int b=1;
        int aux;
        
        for(int i=0; i<10; i++) {
        	aux=a+b;
        	a=b;
        	b=aux;
        	System.out.print(aux+"\n");
        }
	}
}
