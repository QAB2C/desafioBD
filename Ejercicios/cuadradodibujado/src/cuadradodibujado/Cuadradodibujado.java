/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cuadradodibujado;
/**
 *
 * @author BMXDDT007327
 */
public class Cuadradodibujado {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String cad ="";
        int longitud = 6;
        for(int x=0;x<longitud;x++){
            
            for(int y=0;y<longitud;y++){
                
                if(x==0 || y==0 || x==longitud-1 || y == longitud-1){
                cad = cad + "X";
                }else if(x==y || (x+y)==longitud-1){
                    cad=cad+"X";
                }
                else{
                cad = cad+"O";
                }
            }
            cad = cad + "\n";
        }
        System.out.println(cad);
    }
    
}
