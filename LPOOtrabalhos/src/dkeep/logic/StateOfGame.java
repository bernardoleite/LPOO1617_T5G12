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
			{'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X'},
			{'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'}
			
		};
	
	public LevelMap1 level1;
	public LevelMap2 level2;
	public Hero hero;
	public Lever lever;
	public Key key;
	public Ork ork;
	public Ork ork2;
	public Ork ork3;
	public Ork ork4;
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
	
	public Ork GetOrk(int orkNumber)
	{
		if (orkNumber == 1) return ork;
		else if (orkNumber == 2) return ork2;
		else if (orkNumber == 3) return ork3;
		else return ork4;
	}
	
	public Guard GetGuard()
	{
		return guard;
	}
	
	public int GetMyLevel()
	{
		return MyLevel;
	}
	
	
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
			hero = new Hero (8,1);
			ork =  new  Ork(2,7);
			ork2 = new Ork(3,5);
			ork3 = new Ork(5,6);
			ork4 = new Ork(6,8);
			key = new Key(1,8);
			level2 = new LevelMap2();
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
			
			current = level2.HeroMoves(map ,input ,hero ,key ,ork, ork2, ork3, ork4 );
			
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
		 	for(int i = 0; i < 10; i++){
	    		for (int j = 0 ; j < 10; j++){
	    			if (map[i][j] == 'I') map[i][j] = 'S';
	    			else if (map[i][j] == 'K') map[i][j] = ' ';
	    		}

	    	}
			  	
			 return 1;
		}
		
		else if (MyLevel == 2)
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
	
	public void getMap() //Precisa de mudança aquando acrescento de nivel
	{
		int next = 1; //Variaveis para nao desconfigurar impressao
		int ver = 0; //Variaveis para nao desconfigurar impressao
		int cont = 0;
		
	if (MyLevel == 1)
	{	  	for(int i = 0;  i < 10; i++){
  		
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
			
			if(next == 1){
			System.out.print (Map1[i][j]);
			}
			
			next = 1;
			if (ver == 0) System.out.print(" ");		
			ver = 0;
			
		}
		System.out.print("\n");
	}}
	
	
	else if (MyLevel == 2)
		
	{	  	
		
	for(int i = 0;  i < 10; i++){
  		
		for (int j = 0 ; j < 10; j++){
			
			if (hero.x == i && hero.y == j)
			{
				System.out.print(hero.dress); 
			}
			
			else if (i == 8 && j == 2 && hero.armed == 0)
			{
				System.out.print('A');
			}
			
			else if (ork.x == i && ork.y == j)
			{
				System.out.print(ork.dress);
			}
				
			else if (ork.clubx == i && ork.y == j)
			{
				System.out.print(ork.dressclub);
			}
			
			else if (ork2.x == i && ork2.y == j)
			{
				System.out.print(ork2.dress);
			}
			
			else if (ork2.clubx == i && ork2.cluby == j)
			{
				System.out.print(ork2.dressclub);
			}
		/*	
			if (ork3.x == i && ork3.y == j)
			{
				System.out.print(ork3.dress);
			}
			
			if (ork3.clubx == i && ork3.cluby == j)
			{
				System.out.print(ork3.dressclub);
			}
			
			if (ork4.x == i && ork4.y == j)
			{
				System.out.print(ork4.dress);
			}
			
			if (ork4.clubx == i && ork4.cluby == j)
			{
				System.out.print(ork4.dressclub); 
			}*/
			
			else if (key.x == i && key.y == j && key.locked == 0)
			{
				System.out.print(key.dress);
			}
			
			
			else System.out.print(Map2[i][j]);
			
			


			System.out.print(" ");		
			
		}
		System.out.print("\n");
	}
	}

	}
	
	
	
}
	
	
	