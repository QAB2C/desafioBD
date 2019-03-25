
public class Square {

	public static void main(String[] args) {
		
		String cad= ""; 

		for (int i= 0; i<4 ; i++)
		{
				for (int j= 0; j<4 ; j++)
				{	
					cad =cad + "x";
					//System.out.println("*");
				}
				cad = cad+"\n";	
		}
		System.out.println(cad);

	}
}
