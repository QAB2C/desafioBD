import javax.swing.JOptionPane;

public class Ejercicio6 {
	public static void main(String[] args) {
		int tamaño=Integer.parseInt(JOptionPane.showInputDialog(null,"Tamaño del Cuadrado"));
		for(int x=0; x<tamaño; x++) {
			for(int y=0; y<tamaño; y++) {
				if(x==0 || y==0 || x==tamaño-1 || y==tamaño-1 || x==y || y==(tamaño-x)-1) {
					System.out.print("X");
				}else{
					System.out.print("O");
				}
			}
			System.out.print("\n");
		}
	}
}
