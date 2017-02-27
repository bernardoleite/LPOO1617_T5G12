package dkeep.logic;

public class Key {
	
	public char dress = 'K';
	public int locked = 0; //if unlocked , locked = 0; else if locked = 1;
	public int x,y;
	int catched = 0; 
	
	public Key(int CoordenadaX, int CoordenadaY)
	{
		x  = CoordenadaX;
		y = CoordenadaY;
	}

}
