
public class Test002 {

	public static void main(String[] args) {
		
		int dato1=1;
		int dato2=0;
		int result=0;
		
		for(int x=0; x<10; x++) {
			
			result = dato1+dato2;
			System.out.println(result);
			dato2 = dato1;
			dato1 = result;
		}
	}

}
