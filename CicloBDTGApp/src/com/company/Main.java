
package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("\nEjercicios Applause");
        menu();
	}

    private static void menu(){
        int opcion;
        Scanner sc = new Scanner(System.in); //Se crea el lector

        do {
            System.out.println("\n\nElige una opción\n");
            System.out.println("    1.- Desafio_n3_Bestday\n    2.- Desafio_n4_2Variables\n    3.- Desafio_n5_Fibonacci\n    4.- desafio_n6_Square\n    5.- Salir...");//Se pide un dato al usuario
            opcion = sc.nextInt();
                switch (opcion) {
                    case 1:
                        desafio_n3_Bestday();
                        break;
                    case 2:
                        System.out.println("Ingrese 1er número entero positivo:\n");//Se pide numero A
                        int n1 = sc.nextInt(); //Se guarda número
                        System.out.println("Ingrese 2do número entero positivo:\n");//Se pide número B
                        int n2 = sc.nextInt(); //Se guarda número
                        desafio_n4_2Variables(n1, n2);
                        break;
                    case 3:
                        System.out.println("Ingrese Numero entero positivo para imprimir Fibonnaci:\n");//Se pide numero A
                        int tamanoF = sc.nextInt(); //Se guarda número
                        desafio_n5_Fibonacci(tamanoF);
                        break;
                    case 4:
                        System.out.println("Ingrese Tamaño del cuadrado, numero entero positivo:\n");//Se pide numero A
                        int tamanoS = sc.nextInt(); //Se guarda número
                        desafio_n6_Square(tamanoS);
                        break;
                    case 5:
                        System.out.println("saliendo...");
                        break;
                    default:
                        System.out.println("error");
                        break;
            }
        }while (opcion != 5 || opcion < 5 );
    }

    private static void desafio_n3_Bestday() {
        int i;
        for (i=1;i <= 10;i++){
            if ( (i % 3 ==  0 ) &  (i % 5 == 0)){
                System.out.println("Bestday");
            }
            else if (i % 3 == 0){
                System.out.println("Best");
            }
            else if (i % 5 == 0){
                System.out.println("Day");
            }
            else {
                System.out.println(""+ i);
            }
        }
    }

    private static void desafio_n4_2Variables(int A, int B) {
        System.out.println("El valor inicial de A: " + A + "\nEl valor inicial de B: " + B);
        A= A+B; B= A-B;A= A-B;
        System.out.println("El valor actual de A : "+A+"\nEl valor actual de B: "+B);
    }

    private static void desafio_n5_Fibonacci(int TAM) {
        int a=0,b=1;
        int sum;
        for (int i=0;i <= TAM;i++){
            if (i>1){
                sum=a+b;
                System.out.print(sum+", ");
                a=b;
                b=sum;
            }
            else
                System.out.print(i+", ");
        }
    }

    private static void desafio_n6_Square(int TAM) {
        int i,j;
        for ( i = 1; i <= TAM ; i ++ ){
            for ( j = 1; j <= TAM; j++){
                if (j == TAM ) //Salto de línea límite del lado del cuadrado
                {System.out.print("X\n");
                }
                if ( (j== 1 || i == 1 || i== TAM) & j < TAM ) //Imprime Contorno de Cuadrado.
                {System.out.print("X ");
                }
                else if ( (i == j) || ( (j == (TAM-i+1) ) ) ) // Valida la posición de las Diagonales
                { System.out.print("X ");
                }
                else
                {System.out.print("o ");
                }
            }
        }
    }

}
