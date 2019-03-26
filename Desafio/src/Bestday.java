
public class Bestday {
	
	public static void main(String[] args) {
		
		for (int num= 1 ; num<=50;num++) {
			
			
			if(num % 3 == 0 && num% 5==0) {
				
				System.out.println("BESTDAY!!!!!");
				
			}
			else
				
				if (num%3==0) {
					
					System.out.println("BEST!!");
					
				}else
				
				
				if (num % 5==0){
					
					System.out.println("DAY!!!");
					
				
				}
			System.out.println(num);
			
			
		}
	}

		
}
