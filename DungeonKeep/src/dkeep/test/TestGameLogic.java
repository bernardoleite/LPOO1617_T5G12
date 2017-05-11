package dkeep.test;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

import dkeep.logic.StateOfGame;

/*
Hero moves successfully into a free cell.
Hero tries to, unsuccessfully, move into a wall.
Hero moves into an adjacent position to the Guard and the game ends with defeat.
Hero moves towards the closed exit doors and fails to leave.
Hero moves into the lever cell and the Dungeon exit doors open.
Hero moves into the open Dungeon exit doors and progresses into the Keep.
 */

public class TestGameLogic {
	
	char [][] map = {{'X','X','X','X','X'},
					{'X','H',' ',' ','X'},
					{'I',' ',' ',' ','X'},
					{'I',' ',' ',' ','X'},
					{'X','X','X','X','X'}
	};


	
	public char map2[][]= {{'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'}, /*Tabuleiro do 1º nível*/
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
	
	
	public char map3[][] = {{'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'}, /*Tabuleiro do 2º nível*/
			{'I', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X'},
			{'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X'},
			{'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X'},
			{'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X'},
			{'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X'},
			{'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X'},
			{'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X'},
			{'X', ' ', 'A', ' ', ' ', ' ', ' ', ' ', ' ', 'X'},
			{'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'}
			
		};
	
	
	char [][] map4 = {
			{'X','X','X','X','X','X'},
			{'X',' ',' ',' ',' ','X'},
			{'X',' ',' ',' ',' ','X'},
			{'X',' ','I',' ',' ','X'},
			{'X',' ',' ',' ',' ','X'},
			{'X','X','X','X','X','X'}
};
	
	
	public char map5[][]= {
			{'X', 'I', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'}, /*Tabuleiro do 1º nível*/
			{'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X'},
			{'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X'},
			{'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X'},
			{'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X'},
			{'I', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X'},
			{'I', ' ', ' ', 'I', ' ', ' ', ' ', ' ', ' ', 'X'},
			{'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X'},
			{'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'I'},
			{'X', 'X', 'I', 'X', 'X', 'X', 'X', 'X', 'X', 'X'}
			
		};
	
	
	char [][] map7 = {
			{'X','X','X','X','X','X'},
			{'X',' ',' ',' ',' ','X'},
			{'X',' ',' ',' ',' ','X'},
			{'X',' ',' ','I',' ','X'},
			{'X',' ',' ',' ',' ','X'},
			{'X','X','X','X','X','X'}
};
 
 
	@Test
	public void testMoveHeroIntoFreeCell() {
		
		int vet[] = {1,1};
		int vet2[] = {2,1};
		StateOfGame novo = new StateOfGame(1, 0, 2);

		assertEquals (vet[0], novo.hero.getHeroPos()[0]);
		assertEquals (vet[1], novo.hero.getHeroPos()[1]);
		novo.HeroMovement("s", map); //hero moves down (free cell, should go and update position)
		assertEquals(vet2[0], novo.hero.getHeroPos()[0]);
		assertEquals(vet2[1], novo.hero.getHeroPos()[1]);
		
	}
	
	@Test
	public void testMoveHeroMoveIntoWall() {
		
		int vet[] = {1,1};
		int vet2[] = {1,1};
		StateOfGame novo = new StateOfGame(1, 0, 2);

		assertEquals (vet[0], novo.hero.getHeroPos()[0]);
		assertEquals (vet[1], novo.hero.getHeroPos()[1]);
		novo.HeroMovement("a", map); //hero moves left (there is a wall, must not update position)
		assertEquals(vet2[0], novo.hero.getHeroPos()[0]);
		assertEquals(vet2[1], novo.hero.getHeroPos()[1]);
		
	}

	@Test
	public void testHeroIsCapturedByGuard() {
		
		StateOfGame novo = new StateOfGame(1, 0, 2);
		novo.GetGuard().setGuardPositions(1, 3);
		novo.GetGuard().StopMovement();
		assertEquals (0, novo.GameState());
		novo.HeroMovement("d", map); //move next to the guard
		assertEquals(1, novo.GameState());
	}
	
	@Test
	public void testHeroFailsToLeave() {
		
		int current ;
		StateOfGame novo = new StateOfGame(1, 0, 2);
		novo.HeroMovement("s", map);
		assertEquals (0, novo.GameState()); 
		novo.HeroMovement("a", map);
		assertEquals (0, novo.GameState());
	}
	
	@Test
	public void testDoorsOpenWhenLeverIsReached() {
		
		StateOfGame novo = new StateOfGame(1, 0, 2);
		novo.SetLinAndCol(5, 5);
		novo.GetLever().SetLeverPos(3, 1);
		novo.HeroMovement("s", map);
		novo.HeroMovement("s", map);
		assertEquals (3, novo.GameState());
	
	}
	
	@Test
	public void testProgresstoKeep() {
		
		StateOfGame novo = new StateOfGame(1, 0, 2);
		novo.SetLinAndCol(5, 5);
		novo.GetLever().SetLeverPos(3, 1);
		novo.HeroMovement("s", map);
		novo.HeroMovement("s", map);
		assertEquals (3, novo.GameState());
		novo.HeroMovement("a", map);
		assertEquals (2, novo.GameState());
	
	}
	
	
	/*
	 * 
	 * As similar to the previous task, now create a test class to verify the game logic for the Keep level, with the Ogre not moving or swinging his club. It should test the following situations:
	 * 
	Hero moves into an adjacent position to the Ogre and the game ends with defeat.
	Hero moves into the Keep's exit door key cell and changes its representation to "K".
	Hero moves into the closed Keep's exit door, without the key, and fails to open it.
	Hero moves into the closed Keep's exit door, with the key, and the door opens.
	Hero moves into the open Keep's exit door and the game ends with victory.
	*/
	
	@Test
	public void HeroGoesNextOgre() {
		
		
		int vet[] = {1,1};
		int vet2[] = {1,3};
		
		StateOfGame novo = new StateOfGame(2,0,1);
		
		for (int i = 0; i < novo.getOrks().size(); i++){
			novo.getOrks().get(i).setOrkPositicions(1, 3);}
		
		novo.GetHero().setHeroPos(1, 1);
		novo.GetKey().setKeypos(3, 2);
		
		novo.StopOrksMovement(); //In this case... 
		
		assertEquals (vet[0], novo.hero.getHeroPos()[0]);
		assertEquals (vet[1], novo.hero.getHeroPos()[1]);
		
		assertEquals (vet2[0], novo.getOrks().get(0).getOrkPos()[0]);
		assertEquals (vet2[1], novo.getOrks().get(0).getOrkPos()[1]);
		
		assertEquals (0, novo.GameState());
		
		novo.HeroMovement("d", map);
		
		assertEquals (1, novo.GameState());

	}
	
	@Test
	public void HeroChangesWhenReachKeyCell() {
		
		

		StateOfGame novo = new StateOfGame(2,0,1);

		for (int i = 0; i < novo.getOrks().size(); i++){
			novo.getOrks().get(i).setOrkPositicions(1, 3);}
		
		novo.GetHero().setHeroPos(1, 1);
		novo.GetKey().setKeypos(3, 2);
		
		novo.StopOrksMovement();
		
		novo.HeroMovement("s", map);
		novo.HeroMovement("s", map);
		novo.HeroMovement("d", map);
		
	
		
		assertEquals ('K', novo.GetHero().getHeroDress());

	}
	
	@Test
	public void HeroFailstoExit() {
		
		StateOfGame novo = new StateOfGame(2,0,1);

		for (int i = 0; i < novo.getOrks().size(); i++){
			novo.getOrks().get(i).setOrkPositicions(1, 3);}
		
		novo.GetHero().setHeroPos(1, 1);
		novo.GetKey().setKeypos(3, 2);
		
		novo.StopOrksMovement();
		
		novo.HeroMovement("s", map);
		novo.HeroMovement("a", map);
		
		assertEquals (0, novo.GameState());
		

	}
	
	
	@Test
	public void HeroOpenDoors() {
		
		int vet[] = {3,1};

		
		StateOfGame novo = new StateOfGame(2,0,1);
		novo.SetLinAndCol(5, 5);
		
		for (int i = 0; i < novo.getOrks().size(); i++){
			novo.getOrks().get(i).setOrkPositicions(1, 3);}
		
		novo.GetHero().setHeroPos(1, 1);
		novo.GetKey().setKeypos(3, 2);
		
		novo.StopOrksMovement();
		
		novo.HeroMovement("s", map);
		novo.HeroMovement("s", map);
		novo.HeroMovement("d", map); 
		
		
		assertEquals ('K', novo.GetHero().getHeroDress()); //has key
		
		novo.HeroMovement("a", map);	
		novo.HeroMovement("a", map); //opens only

		
		assertEquals (3, novo.GameState()); //door opens
		

	}
	
	@Test
	public void HeroExitAndVictory() {
		
		int vet[] = {3,1};

		
		StateOfGame novo = new StateOfGame(2,0,1);
		novo.SetLinAndCol(5, 5);
		
		novo.getMap();
		
		
		for (int i = 0; i < novo.getOrks().size(); i++){
			novo.getOrks().get(i).setOrkPositicions(1, 3);}
		
		novo.GetHero().setHeroPos(1, 1);
		novo.GetKey().setKeypos(3, 2);
		
		novo.StopOrksMovement();
		
		novo.HeroMovement("s", map);
		novo.HeroMovement("s", map);
		novo.HeroMovement("d", map); 
		
		
		assertEquals ('K', novo.GetHero().getHeroDress()); //has key
		
		novo.HeroMovement("a", map);	
		novo.HeroMovement("a", map);
		novo.HeroMovement("a", map); //plus this movement to exit

		assertEquals (2, novo.GameState()); //win 
		

	}
	/*
	 Testing the Ogre's random behaviour (movement, club swinging) requires a more complex testing procedure. 
	 Therefore, create an additional test class that verifies (at each game turn, that is, Hero's movement), 
	 the expected "random" behaviour of the Ogre by checking if the next state is one of the expected, failing otherwise. 
	 Below is just a suggestion how to organize your test code:
	 */
	
	

}
