/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fibonacci;

/**
 *
 * @author BMXDDT007327
 */
public class Fibonacci {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int n1=0,n2=1,aux;
        for(int x=0;x<=20;x++){
            System.out.println(n1+n2);
            aux = n1+n2;
            n1 = n2;
            n2 = aux;
            
        }
    }
    
}
