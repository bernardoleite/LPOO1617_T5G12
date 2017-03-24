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
		novo.GetLever().SetLeverPos(3, 1);
		novo.HeroMovement("s", map);
		novo.HeroMovement("s", map);
		assertEquals (3, novo.GameState());
	
	}
	
	@Test
	public void testProgresstoKeep() {
		
		StateOfGame novo = new StateOfGame(1, 0, 2);
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
	
	@Test(timeout=1000)
	public void TestOgreRandomBehavior() {

		int move;
		char ogreMov;
		char clubMov;
		String step ="";

		boolean outcome1 = false, outcome2 = false, outcome3 = false, outcome4 = false, outcome5 = false, outcome6 = false, outcome7 = false, outcome8 = false, 
		outcome9 = false, outcome10 = false, outcome11 = false, outcome12 = false, outcome13 = false, outcome14 = false, outcome15 = false, outcome16 = false ;
		
		boolean outcome = false;

		
		StateOfGame novo = new StateOfGame(2,0,1);
		novo.NothingHappens();
		
		for (int i = 0; i < novo.getOrks().size(); i++){
			novo.getOrks().get(i).setOrkPositicions(1, 3);}
		
		novo.GetHero().setHeroPos(1, 1);
		novo.GetKey().setKeypos(3, 2);
	
		
		while ( outcome != true)
		{
			Random mov = new Random();
			move = mov.nextInt(3)+1; //hero's movement
			
			if(move == 1) step = "W";
			else if(move == 2) step = "A";
			else if(move == 3) step = "S";
			else if(move == 4) step = "D";
			
			novo.Input(step);
			
			ogreMov = novo.getOrks().get(0).getOgreMovement();
			clubMov = novo.getOrks().get(0).getClubMovement();
			
			if (ogreMov == 'W' && clubMov == 'W')
				outcome1 = true;
			
			if (ogreMov == 'W' && clubMov == 'A')
				outcome2 = true;
			
			if (ogreMov == 'W' && clubMov == 'S')
				outcome3 = true;
			
			if (ogreMov == 'W' && clubMov == 'D')
				outcome4 = true;
			
			if (ogreMov == 'A' && clubMov == 'W')
				outcome5 = true;
			
			if (ogreMov == 'A' && clubMov == 'A')
				outcome6 = true;
			
			if (ogreMov == 'A' && clubMov == 'S')
				outcome7 = true;
			
			if (ogreMov == 'A' && clubMov == 'D')
				outcome8 = true;
			
			if (ogreMov == 'S' && clubMov == 'W')
				outcome9 = true;
			
			if (ogreMov == 'S' && clubMov == 'A')
				outcome10 = true;
			
			if (ogreMov == 'S' && clubMov == 'S')
				outcome11 = true;
			
			if (ogreMov == 'S' && clubMov == 'D')
				outcome12 = true;
			
			if (ogreMov == 'D' && clubMov == 'W')
				outcome13 = true;
			
			if (ogreMov == 'D' && clubMov == 'A')
				outcome14 = true;
			
			if (ogreMov == 'D' && clubMov == 'S')
				outcome15 = true;
			
			if (ogreMov == 'D' && clubMov == 'D')
				outcome16 = true;

			outcome = outcome1 && outcome2 && outcome3 && outcome4 && outcome5 && outcome6 && outcome7 && outcome8 
			&& outcome9 && outcome10 && outcome11 && outcome12 && outcome13 && outcome14 && outcome15 && outcome16 ;
			
		}
		
	}

}
