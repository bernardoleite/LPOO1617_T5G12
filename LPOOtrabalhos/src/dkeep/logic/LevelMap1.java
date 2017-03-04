package dkeep.logic;

import java.util.Random;

public class LevelMap1 {
	
	public int Klever = 0;
	public int reachS = 0;
	
	public int HeroMoves(char map[][] , String input, Hero hero, Lever lever, Guard guard )
	{
		 if ( input.equals("W") || input.equals("w") )
		   {
			   if (map[hero.x-1][hero.y] == 'X' || map[hero.x-1][hero.y] == 'I')  ;
			   
			   else if (map[hero.x-1][hero.y] == 'S') {reachS =1; hero.x--;}
			   
			   else if (map[hero.x-1][hero.y] == 'K') {Klever = 1;  hero.x--;}
			   
			   else if (map[hero.x-1][hero.y] == ' ') {hero.x--;}
		   }
		   
		   else  if ( input.equals("A") || input.equals("a") )
		   {
			   if (map[hero.x][hero.y-1] == 'X' || map[hero.x][hero.y-1] == 'I')  ;
			   
			   else  if (map[hero.x][hero.y-1] == 'S') {reachS =1; hero.y--;}
			   
			   else  if (map[hero.x][hero.y-1] == 'K') {Klever = 1; hero.y--;}
			   
			   else if (map[hero.x][hero.y-1] == ' ') {hero.y--;}
		   }
		   
		   else if ( input.equals("S") || input.equals("s") )
		   {
			   
			   if (map[hero.x+1][hero.y] == 'X' || map[hero.x+1][hero.y] == 'I')  ;
			   
			   else if (map[hero.x+1][hero.y] == 'S') {reachS =1; hero.x++;}
			   
			   else if (map[hero.x+1][hero.y] == 'K') {Klever = 1; hero.x++;}
			   
			   else if (map[hero.x+1][hero.y] == ' ') {hero.x++;}
			   
			   
		   }
		
		   else  if ( input.equals("D") || input.equals("d") )
		   {
			   if (map[hero.x][hero.y+1] == 'X' || map[hero.x][hero.y+1] == 'I')  ;
			   
			   else if (map[hero.x][hero.y+1] == 'S')  {reachS =1; hero.y++;}
			   
			   else if (map[hero.x][hero.y+1] == 'K')  {Klever = 1; hero.y++;}
			  		  
			   else if (map[hero.x][hero.y+1] == ' ')  {hero.y++;}
			   
		   }
		 
		if (Crossing(hero, lever, guard) == 1) return 1;	//import
		 
		GuardMovement(hero,lever,guard);
		
		if (Crossing(hero, lever, guard) == 1) return 1;		
		
		else if (reachS == 1) return 2;
		
		else if (Klever == 1) { Klever = 0; return 3;}

		else return 0;

	}
	
	
	 public int GuardMovement(Hero hero, Lever lever, Guard guard)
	 {
		 
	if (guard.typeguard.equals("Rookie"))
		
	{
		 guard.steps++;
		 
		  if (guard.steps > 24) guard.steps = 1;
	    	
    	  else if (guard.steps <= 0) guard.steps = 24;
		 
		 Movement(hero, lever, guard);
		 
	}
	
	else if (guard.typeguard.equals("Drunken"))	
	{
			int number = 1, number2 = 1 ;
		   
		   Random num = new Random();

	       number = num.nextInt(2)+1;
	       
	       if (number == 1) //Acordado
	    	   {
	    	   guard.dress = "G";
	    	   
			   Random num2 = new Random();

		       number2 = num2.nextInt(2)+1;
		       
	    	    if(number2 == 1) //Segue em frente
	    	    {
	    			guard.steps++;
	    			 
		    	    if (guard.steps > 24) guard.steps = 1;
		    	    	
		    	    else if (guard.steps <= 0) guard.steps = 24;
		    	    	
	    			Movement(hero, lever, guard);
	    			 
	    			 
	    	    }
	    	    
	    	    else if(number2 == 2) //Anda para trás
	    	    {
	    	    	guard.steps--; //analisar caso negativo
	    	    	
	    	    	if (guard.steps > 24) guard.steps = 1;
	    	    	
	    	    	else if (guard.steps <= 0) guard.steps = 24;
	    			 
	    			 Movement(hero, lever, guard); 
	    			 
	    	    }
	    	    
	    	   
	    	   }
	       
	       else if (number == 2) //Adormecido
	    	   {
	    	   guard.dress = "g";
	    	   }
		 
	 }
	
	else if (guard.typeguard.equals("Suspicious"))
	{
			int number3 = 1;
		
		   Random num3 = new Random();

	       number3 = num3.nextInt(2)+1;
	       
    	    if(number3 == 1) //Segue em frente
    	    {
    			 guard.steps++;
    			 
    			 if (guard.steps > 24) guard.steps = 1;
    			 
    			 else if (guard.steps <= 0) guard.steps = 24;

    			 Movement(hero, lever, guard);
    			 
    	    }
    	    
    	    else if(number3 == 2) //Anda para trás
    	    {
    	    	guard.steps--; //analisar caso negativo
    	    	
    	    	if (guard.steps > 24) guard.steps = 1;
    	    	
    	    	else if (guard.steps <= 0) guard.steps = 24;
    			 
    			 Movement(hero, lever, guard);
    			 
    			 
    	    }
		 
	 }
	
	return 1;
	 }
	 public int Crossing(Hero hero, Lever lever, Guard guard)
	 {
		 
		 if (hero.x == guard.x && hero.y == guard.y) return 1;
		 
		 else if (hero.x == guard.x && Math.abs(hero.y - guard.y) == 1 && guard.dress.equals("g")) return 0;
		 
		 else if (Math.abs(hero.x - guard.x) == 1 && hero.y == guard.y && guard.dress.equals("g")) return 0;
		 
		 else if (hero.x == guard.x && Math.abs(hero.y - guard.y) == 1) return 1;
		 
		 else if (Math.abs(hero.x - guard.x) == 1 && hero.y == guard.y) return 1;
		 
		 else return 0;
 
	 }
	 
	 
	 
	 public int Movement(Hero hero, Lever lever, Guard guard)
	 {
		 if (guard.steps == 1) {
			   guard.x = 1;
			   guard.y = 7;
		   }
		   
		   else if (guard.steps == 2) {
			   guard.x = 2;
			   guard.y = 7;
		   }
		   
		   else  if (guard.steps == 3) {
			   guard.x = 3;
			   guard.y = 7;
		   }
		   
		   else if (guard.steps == 4) {
			   guard.x = 4;
			   guard.y = 7;
		   }
		   
		   else if (guard.steps == 5) {
			   guard.x = 5;
			   guard.y = 7;
		   }
		   
		   else if (guard.steps == 6) {
			   guard.x = 5;
			   guard.y = 6;
		   }
		   
		   else if (guard.steps == 7) {
			   guard.x = 5;
			   guard.y = 5;
		   }
		   
		   else if (guard.steps == 8) {
			   guard.x = 5;
			   guard.y = 4;
		   }
		   
		   else if (guard.steps == 9) {
			   guard.x = 5;
			   guard.y = 3;
		   }
		   
		   else if (guard.steps == 10) {
			   guard.x = 5;
			   guard.y = 2;
		   }
		   
		   else if (guard.steps == 11) {
			   guard.x = 5;
			   guard.y = 1;
		   }
		   
		   else if (guard.steps == 12) {
			   guard.x = 6;
			   guard.y = 1;
		   }
		   
		   else if (guard.steps == 13) {
			   guard.x = 6;
			   guard.y = 2;
		   }
		   
		   else if (guard.steps == 14) {
			   guard.x = 6;
			   guard.y = 3;
		   }
		   
		   else if (guard.steps == 15) {
			   guard.x = 6;
			   guard.y = 4;
		   }
		   
		   else if (guard.steps == 16) {
			   guard.x = 6;
			   guard.y = 5;
		   }
		   
		   else if (guard.steps == 17) {
			   guard.x = 6;
			   guard.y = 6;
		   }
		   
		   else if (guard.steps == 18) {
			   guard.x = 6;
			   guard.y = 7;
		   }
		   
		   else if (guard.steps == 19) {
			   guard.x = 6;
			   guard.y = 8;
		   }
		   
		   else if (guard.steps == 20) {
			   guard.x = 5;
			   guard.y = 8;
		   }
		   
		   else if (guard.steps == 21) {
			   guard.x = 4;
			   guard.y = 8;
		   }
		   
		   else if (guard.steps == 22) {
			   guard.x = 3;
			   guard.y = 8;
		   }
		   
		   else if (guard.steps == 23) {
			   guard.x = 2;
			   guard.y = 8;
		   }
		   
		   else if (guard.steps == 24) {
			   guard.x = 1;
			   guard.y = 8;
		   }
		 
		 return 1;
	 }
	 


	 
	 
	

}

