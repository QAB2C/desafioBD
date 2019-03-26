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
public class Bestday {

    public static void main(String args[]) {
        //int b = 50;
        for (int i = 1; i <= 50; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println(i + " Bestday");

            } else if (i % 3 == 0) {
                System.out.println(i + " Best");
            } else if (i % 5 == 0) {
                System.out.println(i + " Day");
            } else if (i % 3 != 0 && i % 5 != 0) {
                System.out.println(i);
            }
        }

    }
}
