package dkeep.logic;

import java.util.Random;

public class Ork extends Enemy {
	
	public int x;
	public int y;
	public int clubx;
	public int cluby;
	public char dressclub = '*';
	public char dress = 'O';
	public int freeze = 0;
	public int freezeclub = 0;
	public int permanent = 0;
	
	private char OgreMovement; //this represents the char (W,A,S,D) of Random Movement Behavior (ogre)
	private char OgresClubMovement; //this represents the char (W,A,S,D) of Random Movement Behavior (club)
	
	public Ork(int CoordenadaX, int CoordenadaY)
	{
		this.x = CoordenadaX;
		this.y = CoordenadaY;
	}
	
	public Ork()
	{
		int num1 = 0, num2 = 0;
		
		 Random posx = new Random();
		 num1 = posx.nextInt(3)+1;
		 
		 Random posy = new Random();
		 num2 = posy.nextInt(3)+1;
		 
		 this.x = num1;
		 this.y = num2;
	}
	
	public void StopMovement()
	{
		this.freeze = 1;
		this.permanent = 1;
		this.freezeclub = 1;
	}
	
	public void setOrkPositicions(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	public int[] getOrkPos()
	{
		int vec[] = {this.x,this.y};
		
		return vec;
	}
	
	public void setOgreMovement(char letter)
	{
		this.OgreMovement = letter;
	}
	
	public void setClubMovement(char letter)
	{
		this.OgresClubMovement = letter;
	}
	
	public char getOgreMovement()
	{
		return this.OgreMovement;
	}
	
	public char getClubMovement()
	{
		return this.OgresClubMovement;
	}
	
	//create new function to crate random positions when ork borns
	
}