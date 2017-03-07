package dkeep.logic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class StateOfGame {
	

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
	
	public LevelMap1 GetLevelMap1()
	{
		return level1;
	}
	
	public LevelMap2 GetLevelMap2()
	{
		return level2;
	}
	
	public Hero GetHero()
	{
		return hero;
	}
	
	public Lever GetLever()
	{
		return lever;
	}
	
	public Key GetKey()
	{
		return key;
	}
	
	public ArrayList<Ork> GetOrk()
	{
		return orks;
	}
	
	public Guard GetGuard()
	{
		return guard;
	}
	
	public int GetMyLevel()
	{
		return MyLevel;
	}
	
	public ArrayList<Ork> getOrks()
	{
		return this.orks;
	}
	
	
	public StateOfGame(int Level)	//Precisa de mudança aquando acrescento de nivel
	{
		this.MyLevel = Level;
		if (Level == 1) NewGame(1);
		if (Level == 2) NewGame(2);
		
	}
	
	public int NewGame(int Level) //Precisa de mudança aquando acrescento de nivel
	{
		int num = 0;
		
		if (Level == 1)
		{
			hero = new Hero (1,1);
			guard = new Guard (1,8);
			lever = new Lever (8,7);
			level1 = new LevelMap1();
		}
		
		else if (Level == 2)
		{
			hero = new Hero (8,1);
			key = new Key(1,8);
			level2 = new LevelMap2();
			
			//New
			 Random NumOrks = new Random();
			 num = NumOrks.nextInt(3)+1;
			 orks = new ArrayList<Ork> ();
			 
		 for (int i = 0; i < num; i++)
			 { 		 
				 orks.add(new Ork());
			 }
			//New
			 
		}
		
		return 1;
	}
	
	public int Input (String input)	
	{
		if (MyLevel == 1 )HeroMovement(input, Map1);
		else if (MyLevel == 2 )HeroMovement(input, Map2);

		return 1;
	}
	
	public int HeroMovement(String input, char map[][])	//Precisa de mudança aquando acrescento de nivel
	{
		int current;
		
		if (MyLevel == 1 ) { 
			
			current = level1.HeroMoves(map ,input ,hero ,lever ,guard );
			
			if(current == 1) 	//Se receber 1 Guarda e Hero cruzaram-se
				status = 1;
				
			else if(current == 2) //Se receber 2 Vitória
				status = 2;
			
			else if(current == 3) // Necessario Mudar Mapa
			{
				status = 3;
				MapChange(map);
			}
			
			}
		
		else if (MyLevel == 2){
			
			current = level2.HeroMoves(map ,input ,hero ,key , orks );
			
			if(current == 1) 	//Se receber 1 Guarda e Ork cruzaram-se
				status = 1;
				
			else if(current == 2) //Se receber 2 Vitória
				status = 2;
			
			else if(current == 3) // Necessario Mudar Mapa
				{
				status = 3;
				MapChange(map);
				}
		}
		
		
		return 1;
	}
	
	public int GameState()
	{
		if (status == 1) return 1;
		
		else if (status == 2) return 2;
		
		else if (status == 3) return 3;
		
		else return 0;
		
	}
	
	public int MapChange(char map[][])
	{
		if(MyLevel == 1)
		{
		 	for(int i = 0; i < map.length; i++){
	    		for (int j = 0 ; j < map.length; j++){
	    			if (map[i][j] == 'I') map[i][j] = 'S';
	    			//else if (map[i][j] == 'K') map[i][j] = ' ';
	    		}

	    	}
			  	
			 return 1;
		}
		
		 if (MyLevel == 2)
		{
		 	for(int i = 0; i < 10; i++){
	    		for (int j = 0 ; j < 10; j++){
	    			if (map[i][j] == 'I') map[i][j] = 'S';
	    			//else if (map[i][j] == 'K') map[i][j] = ' ';
	    		}

	    	}

		}
		
		return 1;
	}
	
	public char[][] getMap() //Precisa de mudança aquando acrescento de nivel
	{
		int next = 1; //Variaveis para nao desconfigurar impressao
		int ver = 0; //Variaveis para nao desconfigurar impressao
		int cont = 0;
		char  clonemap[][] = new char[10][10];
		
		for (int c = 0; c < 10; c++ ){
			for (int v = 0; v < 10; v++){
				clonemap[c][v] = Map2[c][v];
			}
		}
		
	if (MyLevel == 1)
	{	  
		
		for(int i = 0;  i < 10; i++){
  		
			for (int j = 0 ; j < 10; j++){
			
			if ( (hero.x == i && hero.y == j) && (guard.x == i && guard.y == j) )
			{
				System.out.print (hero.dress); 
				System.out.print (guard.dress);
				next = 0;
				ver = 1;
			}
			
			else if (hero.x == i && hero.y == j)
			{
			System.out.print (hero.dress); next = 0;
			}
			
			else if (guard.x == i && guard.y == j)
			{
			System.out.print (guard.dress); next = 0;
			}
			
			else if (lever.x == i && lever.y == j)
			{
			System.out.print ('K'); next = 0;
			}	
			
			if(next == 1){
			System.out.print (Map1[i][j]);
			}
			
			next = 1;
			if (ver == 0) System.out.print(" ");		
			ver = 0;
			
		}
		System.out.print("\n");
	}
		return clonemap;
		}
	
	
	else if (MyLevel == 2) //change orks prints
		
	{

		
	for(int i = 0;  i < 10; i++){
  		
		for (int j = 0 ; j < 10; j++){
			
			if (key.x == i && key.y == j && key.locked == 0)
			{
				clonemap[i][j] = key.dress;
			}
			
			if (hero.x == i && hero.y == j)
			{
				clonemap[i][j] = hero.dress;
			}
			
			if (i == 8 && j == 2 && hero.armed == 0)
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
	
	
	