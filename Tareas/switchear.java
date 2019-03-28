/**
 *
 * @author BMXDDT005858
 * Se crea un metodo llamado imprimir en la que por posicion intercambia las variables que se muestran
 */
public class switchear {

    public static void main(String[] args) {

        int a = 3;
        int b = 7;

        imprimir(a, b); //original
        System.out.println("-----------------------------");
        imprimir(b, a); //switch
    }

    public static void imprimir(int a, int b) {
        System.out.println("El valor de A es " + a);
        System.out.println("El valor de B es " + b);

    }

}
