
public class Square {
	
	
	public static void main (String[] args) {
	int lado=9;
	
	
	for (int x = 0; x < lado; x++) {
	    for (int y = 0; y < lado; y++) {
	    	
	    	
	    	
	 	    if ((x>0&& x<lado-1) && (y>0&&y<lado-1)) {
	 	    	
	 	    	System.out.print("O");
	 	    }
	 	    else {
	 	    	
	 	    	
	 	    	
	 	    	System.out.print("X");
	 	    }
	    		    	
	    }
	    System.out.println(""); //Short for new line.
	}
	
}
}
