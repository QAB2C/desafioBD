import java.util.Scanner;

public class Tarea {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Longitud del Cuadrado: ");
        int lineas = sc.nextInt();

        for (int i = 1; i <= lineas; i++) {

            for (int j = 1; j <= lineas; j++) {
                if (i == 1 || i == lineas || j == 1 || j == lineas || (i == j) || (lineas - i) == (j - 1)) {
                    System.out.print("X");
                } else
                    System.out.print(" ");
            }
            System.out.print("\n");
        }
        sc.close();
    }

}
