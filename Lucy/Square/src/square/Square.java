package square;

public class Square {

    public static void main(String[] args) {
        int i;
        int j;
        int n = 5;
        for (i = 1; i <= n; i++) {
            for (j = 1; j <= n; j++) {
                if (i == j) {

                    System.out.print("O");
                } else if (i - 1 == j - 1) {
                    System.out.print("O");
                } else {
                    System.out.print("X");
                }
            }
            System.out.print("\n");
        }
    }
}
