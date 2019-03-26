public class Fibonacci {

    public static void main(String[] args) {
        int x = 0, suma = 1, y;

        for (int i = 1; i <= 10; i++) {
            y = x;
            x = suma + x;
            suma = y;
            System.out.println("Suma " + suma);
        }

    }

}


