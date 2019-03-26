
package ciclos2;

public class Ciclos2 {

    public static void main(String[] args) {
        //int i;
        for (int i = 1; i <= 50; i++) {
             if (i % 3 == 0 && i % 5 == 0 ) {
                System.out.println("BestDay");
            } 
            else if (i % 3 == 0) {
                System.out.println("Best");
            } 
            else if (i % 5 == 0) {
                System.out.println("Day");
            }
            else {
                System.out.println(i);
            }
        }

    }
}
