package dkeep.logic;
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
	{}
	
	//create new function to crate random positions when ork borns
	
}