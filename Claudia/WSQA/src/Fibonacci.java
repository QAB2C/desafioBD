
public class Fibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
int  k = 0;
int l=1;
int l2;
int v=10;
		for (int i=1; i<=v; i++) {
			
	l2=k;
	k=l+k;
	l=l2;
	
	System.out.println(l2);
	
		}
	}

}
