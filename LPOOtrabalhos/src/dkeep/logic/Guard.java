package dkeep.logic;

import java.io.Serializable;
import java.util.Random;

public class Guard extends Enemy implements Serializable{
	
	public int x, y;
	public int steps = 0;
	public String typeguard = " ";
	public char dress = 'G';
	public int timestopped = 0;
	public int number = 1;
	private int freeze = 0;
	
	public Guard(int Cordx, int Cordy)
	{
		
		this.x = Cordx;
		this.y = Cordy;
 
	}
	
	public void ChooseGuardRandom()
	{
		   
		   
		   Random num = new Random();

	       number = num.nextInt(3)+1;
	       
	       if (number == 1)
	       {
	    	   typeguard = "Rookie";
	       }
	       
	       else if (number == 2)
	       {
	    	   typeguard = "Drunken";
	       }
	       
	       else if (number == 3)
	       {
	    	   typeguard = "Suspicious";
	       }

	}
	
	/**  
	    * Retrieve Guard Positions  
	    * @return Array (Integer)  
	    */ 
	
	public int[] getGuardPos()
	{
		int vec[] = {this.x,this.y};
		
		return vec;
	}
	
	
	
	public void setGuardPositions(int CordX, int CordY)
	{
		this.x = CordX;
		this.y = CordY;
			
	}
	
	public void setGuardPersonality(int GuardPersonality)
	{
		if (GuardPersonality == 1) this.typeguard = "Rookie";
		else if (GuardPersonality == 2) this.typeguard = "Drunken";
		else if (GuardPersonality == 3) this.typeguard = "Suspicious";
			
	}
	
	public void StopMovement()
	{
		this.freeze = 1;
	}
	
	
	/**  
	    * Retrieve a Value that says if Guard is Frozen or Not 
	    * @return An Integer
	    */ 
	
	public int getMovement()
	{
		return this.freeze;
	}

}
