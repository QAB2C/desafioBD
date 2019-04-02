
public class Lista50 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i=1; i<=50; i++) {
			if (i%3==0 && i%5==0) {
				System.out.println("BestDay");
			}
			if (i%3==0) {
				System.out.println("Best");
			}
			if (i%5==0) {
				System.out.println("Day");
			}
			
			System.out.println(i);
			
		}
	}

}
