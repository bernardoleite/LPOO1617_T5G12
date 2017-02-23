package dkeep.logic;
public class StateOfGame {
	

	public char Map1[][]= {{'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'}, /*Tabuleiro do 1º nível*/
			{'X', ' ', ' ', ' ', 'I', ' ', 'X', ' ', ' ', 'X'},
			{'X', 'X', 'X', ' ', 'X', 'X', 'X', ' ', ' ', 'X'},
			{'X', ' ', 'I', ' ', 'I', ' ', 'X', ' ', ' ', 'X'},
			{'X', 'X', 'X', ' ', 'X', 'X', 'X', ' ', ' ', 'X'},
			{'I', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X'},
			{'I', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X'},
			{'X', 'X', 'X', ' ', 'X', 'X', 'X', 'X', ' ', 'X'},
			{'X', ' ', 'I', ' ', 'I', ' ', 'X', 'K', ' ', 'X'},
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
			{'X', 'H', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X'},
			{'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'}
			
		};
	
	public LevelMap1 level1;
	public LevelMap2 level2;
	public Hero hero;
	public Lever lever;
	public Key key;
	public Ork ork;
	public Guard guard;
	public int MyLevel;
	public int status = 0;
	
	
	public StateOfGame(int Level)	//Precisa de mudança aquando acrescento de nivel
	{
		this.MyLevel = Level;
		if (Level == 1) NewGame(1);
		if (Level == 2) NewGame(2);
		
	}
	
	public int NewGame(int Level) //Precisa de mudança aquando acrescento de nivel
	{
		if (Level == 1)
		{
			hero = new Hero (1,1);
			guard = new Guard (1,8);
			level1 = new LevelMap1();
		}
		
		else if (Level == 2)
		{
			
		}
		
		return 1;
	}
	
	public int Input (String input)	
	{
		HeroMovement(input);

		return 1;
	}
	
	public int HeroMovement(String input)	//Precisa de mudança aquando acrescento de nivel
	{
		int current;
		
		if (MyLevel == 1) { 
			
			current = level1.HeroMoves(Map1 ,input ,hero ,lever ,guard );
			
			if(current == 1) 	//Se receber 1 Guarda e Hero cruzaram-se
				status = 1;
				
			else if(current == 2) //Se receber 2 Vitória
				status = 2;
			
			else if(current == 3) // Necessario Mudar Mapa
				MapChange();
			
			
			}
		
		else if (MyLevel == 2){ }
		
		
		return 1;
	}
	
	public int GameState()
	{
		if (status == 1) return 1;
		
		else if (status == 2) return 2;
		
		else return 0;
		
	}
	
	public int MapChange()
	{
		if(MyLevel == 1)
		{
		 	for(int i = 0; i < 10; i++){
	    		for (int j = 0 ; j < 10; j++){
	    			if (Map1[i][j] == 'I') Map1[i][j] = 'S';
	    			else if (Map1[i][j] == 'K') Map1[i][j] = ' ';
	    		}

	    	}
			  	
			 return 1;
		}
		
		else if (MyLevel == 2)
		{
			return 1;
		}
		
		return 1;
	}
	
	public void getMap() //Precisa de mudança aquando acrescento de nivel
	{
		int next = 1;
		
	  	for(int i = 0;  i < 10; i++){
	  		
    		for (int j = 0 ; j < 10; j++){
    			
    			if (hero.x == i && hero.y == j)
    			{
    			System.out.print ('H'); next = 0;
    			}
    			
    			if (guard.x == i && guard.y == j)
    			{
    			System.out.print ('G'); next = 0;
    			}	
    			
    			if(next == 1){
    			System.out.print (Map1[i][j]);
    			}
    			
    			next = 1;
    			System.out.print(" ");		
    			
    		}
    		System.out.print("\n");
    	}
	}
	
	
	
}
	
	
	