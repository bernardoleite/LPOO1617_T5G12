package dkeep.logic;

import java.util.Random;

public class LevelMap2 {
	

	public int keycatched = 0;
	public int needchange = 0;
	public int reachS = 0;
	
	   public void HeroMoves(char[][] map ,String input ,Hero hero ,Key key ,Ork ork){
		   
			  
		   if ( input.equals("W") || input.equals("w") )
		   {
			   if (map[hero.x-1][hero.y] == 'X' )  ;
			   
			   else if (map[hero.x-1][hero.y] == 'S') {reachS = 1; hero.x--;}
			   
			   else if (map[hero.x-1][hero.y] == ' ') {hero.x--;}
			   
			   else if (map[hero.x-1][hero.y] == 'K') {keycatched = 1; hero.dress = 'K';}
			   
			   else  if (map[hero.x-1][hero.y] == 'I' && keycatched == 1) {needchange =1;}
			   
		   }
		   
		   else  if ( input.equals("A") || input.equals("a") )
			   
		   {
			   if (map[hero.x][hero.y-1] == 'X' )  ;
			   
			   else  if (map[hero.x][hero.y-1] == 'S' ) {}
			   
			   else if (map[hero.x][hero.y-1] == ' ') {}
			   
			   else  if (map[hero.x][hero.y-1] == 'K') {}
			   
			   else  if (map[hero.x][hero.y-1] == 'I' && keycatched == 1) {}					   	
			   
			   
			   
		   }
		   
		   else if ( input.equals("S") || input.equals("s") )
		   {
			   
			   if (map[hero.x+1][hero.y] == 'X')  ;
			   
			   else if (map[hero.x+1][hero.y] == 'S' ) {}
			   
			   else if (map[hero.x+1][hero.y] == ' ') {}
			   
			   else if (map[hero.x+1][hero.y] == 'K') {}
			   
			   else if (map[hero.x+1][hero.y] == 'I' && keycatched == 1) {}
			   
			   
			   
		   }
		
		   else  if ( input.equals("D") || input.equals("d") )
		   {
			   if (map[hero.x][hero.y+1] == 'X')  ;
			  
			   else if (map[hero.x][hero.y+1] == 'S')  { }
			   
			   else if (map[hero.x][hero.y+1] == ' ')  	{ }
			   
			   else if (map[hero.x][hero.y+1] == 'K')	 { }
			   
			   else if (map[hero.x][hero.y+1] == 'I' && keycatched == 1) {  }
			   
			 
		   }
		   
		   /*
		    * 
			OrkMovement(map , hero ,key , ork);
							
			if (Crossing(map, hero, key, ork) == 1) return 1;		
			
			else if (reachS == 1) return 2;
			
			else if (needchange == 1) { needchange = 0; return 3;}

			else return 0;
			
			*/
		   
	   }
	   
	   
	   public void OrkMovement(char[][] map, Hero hero ,Key key ,Ork ork)
	   {

		   int number = 1 , number2= 1;
		   
		   Random num = new Random();
		   Random num2 = new Random();

	       number = num.nextInt(4)+1;
	       number2 = num.nextInt(4)+1;
	           
	       
	       /*
	       if (number == 1) //W
	    	{
	    	    if (vec[linhaOg-1][colunaOg] == 'K' ) {}
	    	    
	    	    else if (vec[linhaOg-1][colunaOg] == ' ') {}
    
	    	}
	       
	        if (number == 2) //A
	       {
	    	  if (vec[linhaOg][colunaOg-1] == 'K' && porta == 0) {vec[linhaOg][colunaOg] = ' '; vec[linhaOg][colunaOg-1] = '$'; trancar =1; colunaOg--;}
	    	  
	    	  else if (vec[linhaOg][colunaOg-1] == ' ' && trancar == 0) { vec[linhaOg][colunaOg] = ' '; vec[linhaOg][colunaOg-1] = 'O'; colunaOg--;}
	       }
	       
	       else if (number == 3) //S
	       {
	    	  if (vec[linhaOg+1][colunaOg] == 'K' && porta == 0) {vec[linhaOg][colunaOg] = ' '; vec[linhaOg+1][colunaOg] = '$'; trancar =1; linhaOg++;}
	    	  
	    	  else if (vec[linhaOg+1][colunaOg] == ' '  && trancar == 0 ) { vec[linhaOg][colunaOg] = ' '; vec[linhaOg+1][colunaOg] = 'O'; linhaOg++;}
	       }
	       
	        else if (number == 4) //D
	       {
	    	   
	    	  if (vec[linhaOg][colunaOg+1] == 'K' && porta == 0) {System.out.print("ola"); vec[linhaOg][colunaOg] = ' '; vec[linhaOg][colunaOg+1] = '$'; trancar = 1; colunaOg++;}
	    	  
	    	  else if (vec[linhaOg][colunaOg+1] == ' ' && trancar == 0 ) { vec[linhaOg][colunaOg] = ' '; vec[linhaOg][colunaOg+1] = 'O'; colunaOg++;}
	       }
	       
	       //Club
	       
	       if (porta == 0 && trancar == 0) {vec[1][8] = 'K';}
	    	   
	       if (number2 == 1) {
	       
	    	  if (vec[linhaOg-1][colunaOg] == ' ') {vec[linhaOg-1][colunaOg] = '*';  }   
	    	  else if (vec[linhaOg-1][colunaOg] == 'K' && porta == 0) {vec[linhaOg-1][colunaOg] = '$';  }
	    	  
	       }
	       
	       else if (number2 == 2) {
	    	   
		    	  if (vec[linhaOg][colunaOg-1] == ' ') {vec[linhaOg][colunaOg-1] = '*';  }
		    	  else if (vec[linhaOg][colunaOg-1] == 'K' && porta == 0) {vec[linhaOg][colunaOg-1] = '$';  }
		    	  
		       }
	       
	       else if (number2 == 3) {
	    	   
		    	  if (vec[linhaOg+1][colunaOg] == ' ') {vec[linhaOg+1][colunaOg] = '*';  }   
		    	  else if (vec[linhaOg+1][colunaOg] == 'K' && porta == 0) {vec[linhaOg+1][colunaOg] = '$';  }  
		    	  
		       }
	       
	       else if (number2 == 4) {
	    	   
		    	  if (vec[linhaOg][colunaOg+1] == ' ') {vec[linhaOg][colunaOg+1] = '*';  } 
		    	  else  if (vec[linhaOg][colunaOg+1] == 'K'&& porta == 0) {vec[linhaOg][colunaOg+1] = '$';  }  
		    	  
		       }
*/
		   
	   }
	   
	   public int Crossing (char[][] map, Hero hero ,Key key ,Ork ork)
	   {
		   return 1;
	   }

}
