/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package switch2variables;

/**
 *
 * @author BMXDDT007327
 */
public class Switch2variables {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int v=3,b=7;
        System.out.println("el valor inicial de V es: "+ v);
        System.out.println("el Valor inicial de B es: "+ b);
        v = v+b;
        b=v-b;
        v = v-b;
        System.out.println("el valor de V es: "+ v);
        System.out.println("el Valor de B es: "+ b);
    }
    
}
