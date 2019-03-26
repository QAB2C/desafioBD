/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bestday;

/**
 *
 * @author BMXDDT011330
 */
public class Fibonacci {

    public static void main(String args[]) {

        int a = 0, b = 1, c = 0;

        for (int i = 0; i < 11; i++) {
            if (i < 10) {

                System.out.println(a);
                c = a + b;
                a = b;
                b = c;

            }

        }

    }

}
