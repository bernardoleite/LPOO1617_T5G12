package dkeep.cli;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

import dkeep.logic.Matrix1;
import dkeep.logic.Matrix2;



public class jogo {
	
	public static void clearScreen() {  
	    System.out.print("\033[H\033[2J");  
	    System.out.flush();  
	   }  
	
	
    public static void main(String[] args) {
  
		char aux[][] = {{'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'}, /*Tabuleiro do 1º nível*/
    			{'X', 'H', ' ', ' ', 'I', ' ', 'X', ' ', 'G', 'X'},
    			{'X', 'X', 'X', ' ', 'X', 'X', 'X', ' ', ' ', 'X'},
    			{'X', ' ', 'I', ' ', 'I', ' ', 'X', ' ', ' ', 'X'},
    			{'X', 'X', 'X', ' ', 'X', 'X', 'X', ' ', ' ', 'X'},
    			{'I', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X'},
    			{'I', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X'},
    			{'X', 'X', 'X', ' ', 'X', 'X', 'X', 'X', ' ', 'X'},
    			{'X', ' ', 'I', ' ', 'I', ' ', 'X', 'K', ' ', 'X'},
    			{'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'}
    			
    		};
		
		char aux2[][] = {{'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'}, /*Tabuleiro do 2º nível*/
    			{'I', ' ', ' ', ' ', 'O', ' ', ' ', ' ', 'K', 'X'},
    			{'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X'},
    			{'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X'},
    			{'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X'},
    			{'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X'},
    			{'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X'},
    			{'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X'},
    			{'X', 'H', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X'},
    			{'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'}
    			
    		};
		
		 int pos[] = {1,1};	 	/*Posicao inicial do Hero*/
		 int posOg[] = {1,4};	 	/*Posicao inicial do Ogre*/
		 int GuardSteps = 0; 	/*Passos do Guarda*/
		 int flag1 = 0; 		/*Flag que faz o controlo do nivel 1*/
		 int flag2 = 0;			/*Flag que faz o controlo do nivel 2*/
		
    	Matrix1 obj = new Matrix1 (aux);
    	obj.PrintMatrix1();
    	
   
    	while (flag1 == 0)
    	{
	
    	System.out.printf("Movimento? (W,A,S,D) ");
    	
    	Scanner leitura = new Scanner (System.in);
        
        String mov = leitura.next();

        
        obj.MoverEmNivel1(mov, pos[0], pos[1]);
        
        pos = obj.AtualizarCoord();
        
        GuardSteps++;
        
        obj.MoveGuarda(GuardSteps);
        
        if (GuardSteps == 24) GuardSteps = 0;
    
        if (obj.VerificaGuarda() == 1) {obj.PrintMatrix1(); System.out.println("!!!!GAME OVER!!!!"); flag1 = 1;}
        
        obj.VerificaK() ;
        
        if ( obj.VerificaSeGanhou() == 1) {obj.PrintMatrix1();  flag1 = 1;}
        
        obj.PrintMatrix1();
        
    	}
    	
    	
		 pos[0] = 8;
		 pos[1] = 1;


		
	   	Matrix2 obj2 = new Matrix2 (aux2);
	   	obj2.PrintMatrix2();
	   	char carater = 'H'; //O carater vai mudar para K quando o Hero apanhar a chave
    	
    
    	while (flag2 == 0)
    	{
    		
        	System.out.printf("Movimento? (W,A,S,D) ");
        	
        	Scanner leitura = new Scanner (System.in);
            
            String mov = leitura.next();

            
            obj2.MoverEmNivel2(mov, pos[0], pos[1], carater);
            
           // obj2.VerificaK() ;
           
            obj2.MoveOgre(posOg[0], posOg[1]);
            
            obj2.PrintMatrix2();
            
            if (obj2.Perdeu() == 1) {System.out.println("!!!!GAME OVER!!!!"); flag2 = 1;}
            
            carater = obj2.VerificaCarater();
            
            pos = obj2.AtualizarCoord();
                     
            posOg = obj2.AtualizarCoordOgre();
            
            if (obj2.VerificaOgre() == 1) {obj2.PrintMatrix2(); System.out.println("!!!!GAME OVER!!!!"); flag2 = 1;}
            
            obj2.VerificaOgre() ;
            
            if ( obj2.VerificaSeGanhou() == 1) {obj2.PrintMatrix2();  System.out.println("!!!!YOU WIN THE GAME!!!!"); flag2 = 1;}
            
            //obj2.PrintMatrix2();
            
            obj2.CleanExplosives();
            
            
            
    		
    	}
    	
    	
}
    







}