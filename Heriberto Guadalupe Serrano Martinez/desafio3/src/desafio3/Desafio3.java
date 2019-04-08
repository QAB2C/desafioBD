/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desafio3;

/**
 *
 * @author BMXDDT007327
 */
public class Desafio3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        for(int x=1;x<=50;x++){
        if(x%5==0 && x%3==0 ){
            System.out.println("BestDay");
        }
        else if(x%3==0){
            System.out.println("Best");
        }else if(x%5==0){
            System.out.println("Day");
        }
        
        
        else{
            System.out.println(x);
        }
        }
    }
    
}
