package dkeep.logic;

import java.util.ArrayList;
import java.util.Random;

public class LevelMap2 {
	

	public int keycatched = 0;
	public int needchange = 0;
	public int reachS = 0;
	private int imortality = 0;
	
	
	   public int HeroMoves(char[][] map ,String input ,Hero hero ,Key key , ArrayList<Ork> orks){ //CHANGE ORKS
		   
			  
		   if ( input.equals("W") || input.equals("w") )
		   {
			   if (map[hero.x-1][hero.y] == 'X' )  ;
			   
			   else if (hero.x-1 == 8 && hero.y == 2 && hero.armed == 0) {hero.armed = 1; hero.dress = 'A'; hero.x--;}
			   
			   else if (map[hero.x-1][hero.y] == 'S') {reachS = 1; hero.x--;}
			   
			   else if (map[hero.x-1][hero.y] == ' ') {hero.x--;}
			   
			   //if (hero.x-1 == key.x && hero.y == key.y && key.locked  == 0) {keycatched = 1; key.dress = ' ';  hero.dress = 'K';}
			   
			   else  if (map[hero.x-1][hero.y] == 'I' && keycatched == 1) {needchange = 1;}
			   
		   }
		   
		   else  if ( input.equals("A") || input.equals("a") )
			   
		   {
			   if (map[hero.x][hero.y-1] == 'X' )  ;
			   
			   else  if (hero.x == 8 && hero.y-1 == 2 && hero.armed == 0) {hero.armed = 1; hero.dress = 'A'; hero.y--;}
			   
			   else  if (map[hero.x][hero.y-1] == 'S' ) {reachS = 1; hero.y--;}
			   
			   else if (map[hero.x][hero.y-1] == ' ') {hero.y--;}
			   
			  // if (hero.x == key.x && hero.y-1 == key.y && key.locked  == 0) {keycatched = 1; key.dress = ' '; hero.dress = 'K';}
			   
			   else  if (map[hero.x][hero.y-1] == 'I' && keycatched == 1) {needchange = 1;}					   	

		   }
		   
		   else if ( input.equals("S") || input.equals("s") )
		   {
			   
			   if (map[hero.x+1][hero.y] == 'X')  ;
			   
			   else if (hero.x+1 == 8 && hero.y == 2 && hero.armed == 0) {hero.armed = 1; hero.dress = 'A'; hero.x++;}
			   
			   else if (map[hero.x+1][hero.y] == 'S' ) {reachS = 1; hero.x++;}
			   
			   else if (map[hero.x+1][hero.y] == ' ') {hero.x++;}
			   
			   //if (hero.x+1 == key.x && hero.y == key.y && key.locked  == 0) {keycatched = 1; key.dress = ' '; hero.dress = 'K';}
			   
			   else if (map[hero.x+1][hero.y] == 'I' && keycatched == 1) {needchange = 1;}
		   }
		
		   else  if ( input.equals("D") || input.equals("d") )
		   {
			   if (map[hero.x][hero.y+1] == 'X')  ;
			   
			   else if (hero.x == 8 && hero.y+1 == 2 && hero.armed == 0)  {hero.armed = 1; hero.dress = 'A'; hero.y++;}
			  
			   else if (map[hero.x][hero.y+1] == 'S')  {reachS = 1; hero.y++;}
			   
			   else if (map[hero.x][hero.y+1] == ' ')  	{hero.y++;}
			   
			   // if ( hero.x == key.x && hero.y+1 == key.y && key.locked  == 0)	{keycatched = 1; key.dress = ' '; hero.dress = 'K'; hero.y++;}
			   
			   else if (map[hero.x][hero.y+1] == 'I' && keycatched == 1) {needchange = 1;}

		   }
		   
		   
		     
			OrksMovement(map, hero ,key , orks); //OrksMovement(map, hero, key, orks);
			
			 for (int i = 0 ; i < orks.size(); i++)
			 {
			 if (Crossing(map, hero, key, orks.get(i) ) == 1) return 1;
			 }

			if (reachS == 1) return 2;
			
			if (needchange == 1) { needchange = 0; return 3;}

			return 0;

	   }
	   
	   
	   public void OrksMovement(char[][] map, Hero hero ,Key key ,ArrayList<Ork> orks) //CHANGE ORKS
	   {
		   
		   int aleaMov1 = 1;
		   int aleaClub1 = 1;

		   for (int i = 0 ; i < orks.size(); i++)
		   {
			   Random mov = new Random();
			   Random club = new Random();
			   aleaMov1 = mov.nextInt(4)+1;
			   aleaClub1 = club.nextInt(4)+1;	
			   EffectiveMovement(map, hero ,key , orks.get(i) , aleaMov1, aleaClub1);
		   }
		   
		/*  
		   Random mov = new Random();
		   Random mov2 = new Random();
		   Random mov3 = new Random();
		   Random mov4 = new Random();
		   
		   Random club = new Random();
		   Random club2 = new Random();
		   Random club3 = new Random();
		   Random club4 = new Random();	  

	       aleaMov1 = mov.nextInt(4)+1;
	       aleaMov2 = mov2.nextInt(4)+1;
	       aleaMov3 = mov3.nextInt(4)+1;
	       aleaMov4 = mov4.nextInt(4)+1;
	       
	       aleaClub1 = club.nextInt(4)+1;	  
	       aleaClub2 = club2.nextInt(4)+1;
	       aleaClub3 = club3.nextInt(4)+1;
	      aleaClub4 = club4.nextInt(4)+1;
	           
	       EffectiveMovement(map, hero ,key ,ork, aleaMov1, aleaClub1);
	       EffectiveMovement(map, hero ,key ,ork2, aleaMov2, aleaClub2);
	       EffectiveMovement(map, hero ,key ,ork3, aleaMov3, aleaClub3);
	       EffectiveMovement(map, hero ,key ,ork4, aleaMov4, aleaClub4);*/
		   
	   }
	   
	   public void EffectiveMovement(char[][] map, Hero hero ,Key key ,Ork ork, int aleaMov, int aleaClub)
	   {
		   //if (ork.freeze > 0) ork.freeze--;
		     
	       if (aleaMov == 1) //W
	    	{
	    	   	ork.setOgreMovement('W');
	    	   	
	    	   	if (map[ork.x-1][ork.y] == 'X');
	    	   
	    	   	else if (ork.x-1 == key.x && ork.y == key.y && ork.freeze == 0 && key.catched == 0 ) { ork.dress = '$'; ork.x--;}
	    	    
	    	   // else if (ork.x-1 == hero.x && ork.y == hero.y  && hero.armed == 1) { ork.dress = '8';  ork.freeze = 2; ork.x--; }
	    	    
	    	    else if (map[ork.x-1][ork.y] == ' ' && ork.freeze == 0 ) {ork.dress = 'O'; ork.x--;}
    
	    	}
	       
	        if (aleaMov == 2) //A
	       {
	        ork.setOgreMovement('A');
	        	
	        if (map[ork.x][ork.y-1] == 'X');
	        
	        else if (ork.x == key.x && ork.y-1 == key.y && ork.freeze == 0 && key.catched == 0 ) {ork.dress = '$';  ork.y--;}
	    	  
	    	 // else if (ork.x == hero.x && ork.y-1 == hero.y  && hero.armed == 1) { ork.dress = '8';  ork.freeze = 2; ork.y--; }
	    	  
	    	  else if (map[ork.x][ork.y-1] == ' ' && ork.freeze == 0 ) {ork.dress = 'O'; ork.y--;}
	       }
	       
	       else if (aleaMov == 3) //S
	       {
	    	   ork.setOgreMovement('S');
	    	   
	    	   if (map[ork.x+1][ork.y] == 'X');
	    	   
	    	   else if (ork.x+1 == key.x && ork.y == key.y && ork.freeze == 0 && key.catched == 0 ) {ork.dress = '$'; ork.x++;}
	    	  
	    	 // else if (ork.x+1 == hero.x && ork.y == hero.y  && hero.armed == 1) { ork.dress = '8';  ork.freeze = 2; ork.x++; }
	    	  
	    	  else if (map[ork.x+1][ork.y] == ' ' && ork.freeze == 0  ) {ork.dress = 'O'; ork.x++;}
	       }
	       
	        else if (aleaMov == 4) //D
	       {
	        	ork.setOgreMovement('D');
	        	
	        	if (map[ork.x][ork.y+1] == 'X');

	        	else if (ork.x == key.x && ork.y+1 == key.y && ork.freeze == 0  && key.catched == 0) {ork.dress = '$'; ork.y++;}
	    	  
	    	  //else if (ork.x == hero.x && ork.y+1 == hero.y  && hero.armed == 1) { ork.dress = '8';  ork.freeze = 2; ork.y++; }
	    	  
	    	  else if (map[ork.x][ork.y+1] == ' ' && ork.freeze == 0  ) {ork.dress = 'O';  ork.y++;}
	       }
	       
	       //Club
   if (ork.freezeclub == 0){
	       if (aleaClub == 1) 
	       {
	    	  ork.setClubMovement('W');
	    	   
	    	  if (map[ork.x-1][ork.y] == 'X');
	    	  
	    	  if (ork.x-1 == key.x && ork.y == key.y ) {ork.dressclub = '$'; ork.clubx = ork.x - 1; ork.cluby = ork.y; }
	    	   
	    	  else if (map[ork.x-1][ork.y] == ' ') {ork.dressclub = '*'; ork.clubx = ork.x - 1; ork.cluby = ork.y; }   
	    	   
	    	  
	       }
	       
	       else if (aleaClub == 2) 
	       {
	    	   	ork.setClubMovement('A');
	    	   	if (map[ork.x][ork.y-1] == 'X');
	    	   	if (ork.x == key.x && ork.y-1 == key.y ) {ork.dressclub = '$'; ork.clubx = ork.x ; ork.cluby = ork.y - 1; } 
	    	   	else if (map[ork.x][ork.y-1] == ' ') {ork.dressclub = '*'; ork.clubx = ork.x ; ork.cluby = ork.y - 1; }
		    	 
		   }
	       
	       else if (aleaClub == 3) 
	       {
	    	   ork.setClubMovement('S');
	    	   if (map[ork.x+1][ork.y] == 'X');
	    	   if (ork.x+1 == key.x && ork.y == key.y ) {ork.dressclub = '$'; ork.clubx = ork.x + 1; ork.cluby = ork.y; }  
	    	   else if (map[ork.x+1][ork.y] == ' ') {ork.dressclub = '*'; ork.clubx = ork.x + 1; ork.cluby = ork.y; }   
	    	     
		      }
	       
	       else if (aleaClub == 4) 
	       {
	    	   ork.setClubMovement('D');
	    	   if (map[ork.x][ork.y+1] == 'X');
	    	   if (ork.x == key.x && ork.y+1 == key.y ) {ork.dressclub = '$'; ork.clubx = ork.x; ork.cluby = ork.y + 1; }  
	    	   else if (map[ork.x][ork.y+1] == ' ') {ork.dressclub = '*'; ork.clubx = ork.x; ork.cluby = ork.y + 1; } 
	    	   	  
		   }}
	   }
	   
		 public void setImortality(){
			 this.imortality = 1;
		 }
	   
	   public int Crossing (char[][] map, Hero hero ,Key key ,Ork ork)
	   
	   {
		   
		   if (hero.x == key.x && hero.y == key.y && key.locked  == 0) {keycatched = 1; key.catched =1 ; key.dress = ' '; hero.dress = 'K';}

		   if (ork.freeze > 0 && ork.permanent == 0) ork.freeze--;
	/*	   	   
		   if (ork.x == key.x && ork.y == key.y || ork.clubx == key.x && ork.cluby == key.y  )
		   {
			   key.locked = 1;
		   }   */
		   
		   else key.locked = 0;
		   
		   	if (hero.x == ork.x && hero.y == ork.y && this.imortality == 0) return 1;	   
		   	if (hero.x == ork.clubx && hero.y == ork.cluby && ork.freezeclub == 0 && this.imortality == 0) return 1;
			 
			 else if (hero.x == ork.x && Math.abs(hero.y - ork.y) == 1 && hero.armed == 0 && this.imortality == 0 ) return 1; //Crossing Hero and an Ork
			 
			 else if (Math.abs(hero.x - ork.x) == 1 && hero.y == ork.y && hero.armed == 0 && this.imortality == 0) return 1; //Crossing Hero and an Ork's Club
		   
		   
			 else if (hero.x == ork.x && Math.abs(hero.y - ork.y) == 1 && hero.armed == 1 ) {ork.dress = '8';  ork.freeze = 2; return 0;} //Crossing Hero and an Ork with armer

			 else if (Math.abs(hero.x - ork.x) == 1 && hero.y == ork.y && hero.armed == 1) {ork.dress = '8';  ork.freeze = 2;  return 0;} //Crossing Hero and an Ork's Club with armer
		   
		   
			 else if (Math.abs(hero.x - ork.clubx) == 1 && hero.y == ork.cluby  && ork.freezeclub == 0 && this.imortality == 0) return 1; //Crossing Hero and an Ork's Club
		   
			 else if (hero.x == ork.clubx  && Math.abs(hero.y - ork.cluby) == 1  && ork.freezeclub == 0 && this.imortality == 0) return 1; //Crossing Hero and an Ork's Club
		   
			 return 0;
		   
	
	   }

}
