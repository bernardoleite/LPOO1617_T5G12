package dkeep.logic;

import java.io.Serializable;

public class Key implements Serializable{
	
	public char dress = 'K';
	public int locked = 0; //if unlocked , locked = 0; else if locked = 1;
	public int x,y;
	public int catched = 0; 
	
	public Key(int CoordenadaX, int CoordenadaY)
	{
		x  = CoordenadaX;
		y = CoordenadaY;
	}
	
	/**  
	    * Set the Key Positions 
	    * @param x is the X
	    * @param y is the Y
	    */  
	
	public void setKeypos(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	/**  
	    * Verify is the Key has been catched 
	    * @return an integer status
	    */  
	
	public int StatusKey()
	{
		return catched;
	}

}
