
public class Test001 {

	public static void main(String []args) {
		
		int valor = 1;
		for(int i=0; i<50; i++) {
			if((valor % 3) == 0 && (valor % 5) == 0) {
				System.out.println("BestDay");
			}else if((valor % 3) == 0) {
				System.out.println("Best");
			}else if((valor % 5) == 0) {
				System.out.println("Day");
			}else {
				System.out.println(valor);
			}
			valor++;
		}
	}

}
