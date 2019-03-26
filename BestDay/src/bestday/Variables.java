/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bestday;

import java.util.Scanner;

/**
 *
 * @author BMXDDT011330
 */
public class Variables {

    public static void main(String args[]) {

        int valora, valorb, AUX;

        Scanner entrada = new Scanner(System.in);

        System.out.println("¿Cuál es el valor actual de A?");
        valora = entrada.nextInt();

        System.out.println("¿Cuál es el valor actual de B?");
        valorb = entrada.nextInt();

        System.out.println("Valores Actuales: A = " + valora + "   B = " + valorb);

        AUX = valora;
        valora = valorb;
        valorb = AUX;
        System.out.println("Valores Esperados: A = " + valora + "   B = " + valorb);

    }
}
