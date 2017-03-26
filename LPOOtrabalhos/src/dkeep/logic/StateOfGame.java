package dkeep.logic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class StateOfGame implements Serializable{
	

	public char Map1[][]= {{'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'}, /*Tabuleiro do 1º nível*/
			{'X', ' ', ' ', ' ', 'I', ' ', 'X', ' ', ' ', 'X'},
			{'X', 'X', 'X', ' ', 'X', 'X', 'X', ' ', ' ', 'X'},
			{'X', ' ', 'I', ' ', 'I', ' ', 'X', ' ', ' ', 'X'},
			{'X', 'X', 'X', ' ', 'X', 'X', 'X', ' ', ' ', 'X'},
			{'I', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X'},
			{'I', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X'},
			{'X', 'X', 'X', ' ', 'X', 'X', 'X', 'X', ' ', 'X'},
			{'X', ' ', 'I', ' ', 'I', ' ', 'X', ' ', ' ', 'X'},
			{'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'}
			
		};
	
	public char Map2[][] = {{'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'}, /*Tabuleiro do 2º nível*/
			{'I', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X'},
			{'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X'},
			{'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X'},
			{'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X'},
			{'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X'},
			{'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X'},
			{'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X'},
			{'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X'},
			{'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'} 
			
		};
	 
	public LevelMap1 level1;
	public LevelMap2 level2;
	public Hero hero;
	public Lever lever;
	public Key key;
	public ArrayList<Ork> orks; //novo
	public Guard guard;
	public int MyLevel;
	public int status = 0;
	private int lin = 10, col = 10;
	
	/**  
	    * Set the Level2 Map 
	    * @param map is the Map to be used.
	    */  
	
	public void SetLevel2Map(char map[][])
	{
		this.Map2 = map;
		
	}
	
	/**  
	    * Set the Level1 Map
	    * @param map is the Map to be used.
	    */  
	
	public void SetLevel1Map(char map[][])
	{
		this.Map1 = map;
		
	}
	/**  
	    * Set Lines And Cols of Game
	    * @param lin is the number of lines
	    * @param col is the number of columns
	    */  
	
	public void SetLinAndCol(int lin, int col)
	{
		this.lin = lin;
		this.col = col;
	}
	
	/**  
	    * Get LevelMap1
	    * @return the object corresponding to the LevelMap1
	    */  
	
	public LevelMap1 GetLevelMap1()
	{
		return level1;
	}
	
	/**  
	    * Get LevelMap2
	    * @return the object corresponding to the LevelMap2
	    */ 
	
	public LevelMap2 GetLevelMap2()
	{
		return level2;
	}
	
	/**  
	    * Get Hero Object
	    * @return Hero's object
	    */  
	
	public Hero GetHero()
	{
		return hero;
	}
	
	/**  
	    * Get Lever Object
	    * @return Lever's Object
	    */  
	
	public Lever GetLever()
	{
		return lever;
	}
	
	/**  
	    * Get Key Object
	    * @return ke's object.
	    */  
	
	public Key GetKey()
	{
		return key;
	}
	
	/**  
	    * Get an ArrayList of Ogres
	    * @return ork's array.
	    */  
	
	public ArrayList<Ork> GetOrk()
	{
		return orks;
	}
	/**  
	    * Get the Guard Object
	    * @return guard's object.
	    */  
	
	public Guard GetGuard()
	{
		return guard;
	}
	
	/**  
	    * Get Current Level
	    * @return current level.
	    */  
	
	public int GetMyLevel()
	{
		return MyLevel;
	}
	
	/**  
	    * Get the Orks Array
	    * @return ork's array.
	    */  
	
	public ArrayList<Ork> getOrks()
	{
		return this.orks;
	}
	
	/**  
	    * Create StateOfGame
	    */  
	
	
	public StateOfGame(int Level, int GuardPersonality, int numberOrks) 	
	{
		this.MyLevel = Level;
		if (Level == 1) NewGame(1,GuardPersonality, numberOrks);
		if (Level == 2) NewGame(2, GuardPersonality, numberOrks);
		
	}
	/**  
	    * Create New Game
	    * @param Level is the lever's object
	    * @param GuardPersonality is the Guard Personality
	    * @param numberOrks is the number of Ogres
	    * @return an integer that represents success.
	    */  
	public int NewGame(int Level, int GuardPersonality, int numberOrks) 
	{
		int num = 0;
		
		if (Level == 1)
		{
			hero = new Hero (1,1);
			guard = new Guard (1,8);
			
			if (GuardPersonality == 0) guard.ChooseGuardRandom();
			else guard.setGuardPersonality(GuardPersonality);
			
			lever = new Lever (8,7);
			level1 = new LevelMap1();
		}
	
		
		else if (Level == 2)
		{
			Random NumOrks = new Random();
			num = NumOrks.nextInt(3)+1;
			 
			hero = new Hero (8,1);
			key = new Key(1,8);
			level2 = new LevelMap2();
			
			 this.orks = new ArrayList<Ork> ();
		
			 
			
		 for (int i = 0; i < numberOrks; i++)
			 { 		 
				 orks.add(new Ork());
			 }
			
			 
		}
		
		return 1;
	}
	
	/**  
	    * Input from Keyboard
	    * @param input is the String that represents movement.
	    * @return an integer that represents success.
	    */  
	
	public int Input (String input)	
	{
		if (MyLevel == 1 )HeroMovement(input, Map1);
		else if (MyLevel == 2 )HeroMovement(input, Map2);

		return 1;
	}
	
	/**  
	    * Stops Orks Movement (Onty for Unit Tests)
	    */  
	
	public void StopOrksMovement()
	{
		for (int i = 0; i < orks.size(); i++)
		{
			orks.get(i).StopMovement();
		}
	}
	
	/**  
	    * Hero Movement
	    * @param input is the String that represents movement.
	    * @param Map is the Map used 
	    * @return an integer that represents success.
	    */  
	
	
	public int HeroMovement(String input, char map[][])	
	{
		int current;
		
		if (MyLevel == 1 ) { 
			
			current = level1.HeroMoves(map ,input ,hero ,lever ,guard );
			
			if(current == 1) 	
				status = 1;
				
			else if(current == 2)
				status = 2;
			
			else if(current == 3) 
			{
				status = 3;
				MapChange(map);
			}
			
			}
		
		else if (MyLevel == 2){
			
			current = level2.HeroMoves(map ,input ,hero ,key , orks );
			
			if(current == 1) 	
				status = 1;
				
			else if(current == 2) 
				status = 2;
			
			else if(current == 3)
				{
				status = 3;
				MapChange(map);
				}
		}
		
		
		return 1;
	}
	
	/**  
	    * Game State to Know Anytime what is the State of Game.
	    * @return an integer that represents success.
	    */ 
	
	public int GameState()
	{
		if (status == 1) return 1;
		
		else if (status == 2) return 2;
		
		else if (status == 3) return 3;
		
		else return 0;
		
	}
	
	/**  
	    * Set Imortality to the Hero (Only For Unit Tests)
	    */ 
	
	public void NothingHappens()
	{
		level2.setImortality();
		
	}
	
	/**  
	    * Changing the map
	    * @param map is the Map received to make a refresh.
	    * @return an integer that represents success.
	    */ 
	
	public int MapChange(char map[][])
	{
		if(MyLevel == 1)
		{
		 	for(int i = 0; i < lin; i++){
	    		for (int j = 0 ; j < col; j++){
	    			if (map[i][j] == 'I') map[i][j] = 'S';

	    		}

	    	} 
			  	
			 return 1;
		}
		
		 if (MyLevel == 2)
		{
		 	for(int i = 0; i < lin; i++){
	    		for (int j = 0 ; j < col; j++){
	    			if (map[i][j] == 'I') map[i][j] = 'S';

	    		}

	    	}

		}
		
		return 1;
	}
	
	/**  
	    * Get the  Current Map
	    * @return present Map.
	    */ 
	
	public char[][] getMap()
	{
		int next = 1; 
		int ver = 0; 
		int cont = 0;
		char  clonemap[][] = new char[lin][col];
		
		
	if (MyLevel == 1)
	{	  
		
		for (int c = 0; c < 10; c++ ){
			for (int v = 0; v < 10; v++){
				clonemap[c][v] = Map1[c][v];
			}
		}
		
		for(int i = 0;  i < 10; i++){
  		
			for (int j = 0 ; j < 10; j++){
			
			if ( (hero.x == i && hero.y == j) && (guard.x == i && guard.y == j) )
			{
				clonemap[i][j] = guard.dress;

			}
			
			else if (hero.x == i && hero.y == j)
			{
				clonemap[i][j] = hero.dress; next = 0;
			}
			
			else if (guard.x == i && guard.y == j)
			{
				clonemap[i][j] = guard.dress; next = 0;
			}
			
			else if (lever.x == i && lever.y == j)
			{
				clonemap[i][j] = 'K'; next = 0;
			}	
			
			else{
				clonemap[i][j] = Map1[i][j];
			}
			
			
		}

	}
		return clonemap;
		}
	
	
	else if (MyLevel == 2) 
		
	{
		for (int c = 0; c < lin; c++ ){
			for (int v = 0; v < col; v++){
				clonemap[c][v] = Map2[c][v];
			}
		}

		
	for(int i = 0;  i < lin; i++){
  		
		for (int j = 0 ; j < col; j++){
			
			if (key.x == i && key.y == j && key.locked == 0)
			{
				clonemap[i][j] = key.dress;
			}
			
			if (hero.x == i && hero.y == j)
			{
				clonemap[i][j] = hero.dress;
			}
			
			if (i == 2 && j == 2 && hero.armed == 0)
			{
				clonemap[i][j] = 'A';
			}
			
			for (int k = 0; k < orks.size(); k++)
			{
				if (orks.get(k).x == i && orks.get(k).y == j ) clonemap[i][j] = orks.get(k).dress;
			}
			
			for (int m = 0; m < orks.size(); m++)
			{
				if (orks.get(m).clubx == i && orks.get(m).cluby == j ) clonemap[i][j] = orks.get(m).dressclub;;
			}
		
			
		}
		
	}
	
	return clonemap;
	}
	return clonemap;
	}
	
	
	
}
	
	
	