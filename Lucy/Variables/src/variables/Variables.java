
package variables;


public class Variables {

    public static void main(String[] args) {
        int a=3;
        int b=7;
        int c;
        
        System.out.println("Valores Originales");
        System.out.println("El valor de A es "+a);
        System.out.println("El valor de B es "+b); 
        
        c = a;
        a= b;
        b = c;
       
        System.out.println("Nuevos Valores");
        System.out.println("El valor de A es "+a);
        System.out.println("El valor de B es "+b); 
       
    }
}
