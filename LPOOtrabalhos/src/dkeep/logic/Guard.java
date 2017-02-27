package dkeep.logic;

import java.util.Random;

public class Guard extends Enemy {
	
	public int x, y;
	public int steps = 0;
	public String typeguard = " ";
	public String dress = "G";
	public int timestopped = 0;
	
	public Guard(int Cordx, int Cordy)
	{
		
		this.x = Cordx;
		this.y = Cordy;
		ChooseGuard();
	}
	
	public void ChooseGuard()
	{
		   int number = 1 ;
		   
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

}
