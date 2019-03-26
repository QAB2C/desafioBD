
public class Desafion6 {
	  public static void main(String[] args) {
	    	
		    int a=5;
	    	int i, j;
	    	int aux;
	    	for( i=1; i<=a; i++){
	    		System.out.print("\n");
	    		for(j=1; j <=a; j++) {
	    		 
	    			aux=a-i+1;
	    			
	    		if( i==1 || j==1 ||j==a || i==a || i==j || j==aux)
	    		{
	    	    	 System.out.print("X ");
	    	     } else
	    	     {
	    	    	 System.out.print("O ");
	    	     }
	    		}
	    	     
	    		}
	    	}
	   
	 

}

