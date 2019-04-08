/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cuadrado2;

import javax.swing.JOptionPane;

/**
 *
 * @author BMXDDT050154
 */
public class Cuadrado2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        int x;
        int y;
        int TAM=Integer.parseInt(JOptionPane.showInputDialog(null,"Tamaño del Cuadrado"));

    for(x=0; x<TAM; x++) 
    {
    for(y=0; y<TAM; y++) 
    {
    if(x== 0 | y== 0 | x == TAM-1 | y==TAM-1 | x==y | y == (TAM-x) -1)
        {
        System.out.print(" X");
        }
    else
        {
        System.out.print(" O");
        }
    }
    System.out.print("\n");
    }
    }
}
    
            
        

