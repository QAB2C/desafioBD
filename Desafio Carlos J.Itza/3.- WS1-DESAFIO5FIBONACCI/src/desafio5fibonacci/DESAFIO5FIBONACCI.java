/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desafio5fibonacci;

import javax.swing.JOptionPane;

/**
 *
 * @author BMXDDT050154
 */
public class DESAFIO5FIBONACCI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
   
        int n1 = 0;
        int n2 = 1;
        int aux;
        int TAM;
TAM =Integer.parseInt(JOptionPane.showInputDialog(null,"Limite del Fibonacci"));
        System.out.println(n1);
        System.out.println(n2);

        while (n2 + n1 <= TAM) {
            aux = n1;
            n1 = n2;
            n2 = aux + n1;

            System.out.println(n2);
        }
    }
}
      

