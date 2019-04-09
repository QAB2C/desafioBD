
public class Test004 {

	public static void main(String[] args) {

		int tamanio = 16;

		String matrix = "";

		for (int i = 0; i < tamanio; i++) {
			for (int x = 0; x < tamanio; x++) {
				int z = i + 1;
				if ((i == x) || (x == (tamanio - z)) || ((x == 0) || (x == tamanio - 1))
						|| ((i == 0) || (i == tamanio - 1))) {
					matrix = "X";
					System.out.print(String.format("%s ", matrix));
				} else {
					matrix = "O";
					System.out.print(String.format("%s ", matrix));
				}
			}
			System.out.println();
		}

	}

}
