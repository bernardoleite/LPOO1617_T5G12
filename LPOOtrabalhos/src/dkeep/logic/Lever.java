package dkeep.logic;

import java.io.Serializable;

public class Lever implements Serializable {
	
	public int x;
	public int y;
	public int catched = 0;
	
	public Lever(int CordX, int CordY)
	{
		this.x = CordX;
		this.y = CordY;
	}
	
	public int GetCatched(){
		
		return catched;
	}
	
	/**  
	    * Set the Lever Positions
	    * @param CordX is the x
	    * @param CordY is the y
	    */  
	
	public void SetLeverPos(int CordX, int CordY){
		
		this.x = CordX;
		this.y = CordY;
		
	}

}
