
package fibonacci;
public class Fibonacci {

    public static void main(String[] args) {
        
        int valor1=0;
        int valor2=1;
        int res;
        int tam=10;
        
        for(int i=0; i<=tam; i++ ){   
            res=valor1;
            valor1=valor2+valor1;
            valor2=res;
            System.out.println(valor2);
        }
        
        }
    }
    

