package dkeep.logic;

import java.io.Serializable;

public class Enemy implements Serializable{
	
	int posisaox;
	int posisaoy;
	
	public Enemy(){}
	
	public Enemy(int CoordenadaX, int CoordenadaY)
	{
		this.posisaox = CoordenadaX;
		this.posisaoy = CoordenadaY;
	}
	
	
	
}