/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises;

/**
 *
 * @author BMXDDT007525
 */

//Test.invertirvalor();
//Test.cuadrado();
//Test.fibonacci();

public class Test {
    public static void invertirvalor(){
        int a = 3;
        int b = 7;
        
        b = a - b + b + b;
        a = b - a;
        b = b - a;
        
        System.out.println("valor a: " +a);
        System.out.println("valor b: " +b);
    }
    
    public static void cuadrado(){
        int fi = 9;
        int co = 9;
        
        for (int col = 1; col <= co; col++) {
            int a = fi - col + 1;
            for (int fila = 1; fila <= fi; fila++) {
              //lateral izq //lateral der//superior   //  inferior  //diagonal inver//diagonal
                if(col == 1 || col == co || fila == 1 || fila == fi || col == fila || a == fila){
                    System.out.print("X");
                }else{
                    System.out.print("O");
                }
            }
            System.out.println("");
        }
    }
    
    public static void fibonacci(){//No lo hice yo
        int a = 0;
        int b = 1;

        for (int i = 0; i < 10; i++) {
            a = a + b;
            b = a - b;
            
            System.out.println(b);
        }
    }
    public static void Ciclo() {
		for (int i = 1; i <= 50; i++) {
			if (i % 3 == 0 && i % 5 == 0) {
				System.out.println("Best Day");
			} else if (i % 3 == 0) {
				System.out.println("Best");
			} else if (i % 5 == 0) {
				System.out.println("Day");
			} else {
				System.out.println(i);
			}
		}
	}
}
