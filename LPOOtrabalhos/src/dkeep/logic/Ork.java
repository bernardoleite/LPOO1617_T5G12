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
	
	public Ork(int CoordenadaX, int CoordenadaY)
	{
		this.x = CoordenadaX;
		this.y = CoordenadaY;
	}
	
	public Ork()
	{
		int num1 = 0, num2 = 0;
		
		 Random posx = new Random();
		 num1 = posx.nextInt(8)+1;
		 
		 Random posy = new Random();
		 num2 = posy.nextInt(8)+1;
		 
		 this.x = num1;
		 this.y = num2;
	}
	
	//create new function to crate random positions when ork borns
	
}