package dkeep.logic;
public class Hero {
	
	public int x = 1;
	public int y = 1;
	public char dress = 'H';
	public int armed = 0; //1 for yes and 0 for no
	
	public Hero(int CordX, int CordY)
	{
		this.x = CordX;
		this.y = CordY;
	}
	
	public int[] getHeroPos()
	{
		int vec[] = {this.x,this.y};
		
		return vec;
	}
	
	
	public void setHeroPos(int CordX, int CordY)
	{
		this.x = CordX;
		this.y = CordY;
			
	}
	
	public char getHeroDress()
	{
		return this.dress;
	}
	
}