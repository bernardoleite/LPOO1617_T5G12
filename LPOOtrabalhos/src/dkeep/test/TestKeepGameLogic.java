package dkeep.test;

import static org.junit.Assert.*;

import org.junit.Test;

import dkeep.logic.StateOfGame;

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

public class TestKeepGameLogic {
	
	
	char [][] map = {
					{'X','X','X','X','X'},
					{'X','H',' ',' ','X'},
					{'I',' ',' ',' ','X'},
					{'I',' ',' ',' ','X'},
					{'X','X','X','X','X'}
};
	
	@Test
	public void HeroGoesNextOgre() {
		
		
		int vet[] = {1,1};
		int vet2[] = {1,3};
		
		StateOfGame novo = new StateOfGame(2);
		
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
		
		

		StateOfGame novo = new StateOfGame(2);

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
		
		StateOfGame novo = new StateOfGame(2);

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

		
		StateOfGame novo = new StateOfGame(2);
		
		
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

		
		StateOfGame novo = new StateOfGame(2);

		
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

}
