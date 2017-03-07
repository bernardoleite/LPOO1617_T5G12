package dkeep.test;

import static org.junit.Assert.*;

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

public class TestDungeonGameLogic {
	
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
		StateOfGame novo = new StateOfGame(1);
		novo.NewGame(1);
		assertEquals (vet[0], novo.hero.getHeroPos()[0]);
		assertEquals (vet[1], novo.hero.getHeroPos()[1]);
		novo.HeroMovement("s", map);
	 //hero moves down (free cell, should go and update position)
		assertEquals(vet2[0], novo.hero.getHeroPos()[0]);
		assertEquals(vet2[1], novo.hero.getHeroPos()[1]);
		
	}
	
	@Test
	public void testMoveHeroMoveIntoWall() {
		
		int vet[] = {1,1};
		int vet2[] = {1,1};
		StateOfGame novo = new StateOfGame(1);
		novo.NewGame(1);
		assertEquals (vet[0], novo.hero.getHeroPos()[0]);
		assertEquals (vet[1], novo.hero.getHeroPos()[1]);
		novo.HeroMovement("a", map);
		//hero moves left (there is a wall, must not update position)
		assertEquals(vet2[0], novo.hero.getHeroPos()[0]);
		assertEquals(vet2[1], novo.hero.getHeroPos()[1]);
		
	}
	
	
	@Test
	public void testHeroIsCapturedByGuard() {
		
		StateOfGame novo = new StateOfGame(1);
		novo.NewGame(1);
		novo.GetGuard().setGuardPositions(1, 3);
		assertEquals (0, novo.GameState());
		novo.HeroMovement("d", map);
		assertEquals(1, novo.GameState());
		
	}
	
	@Test
	public void testHeroFailsToLeave() {
		
		int current ;
		StateOfGame novo = new StateOfGame(1);
		novo.NewGame(1);
		novo.HeroMovement("s", map);
		assertEquals (0, novo.GameState()); 
		novo.HeroMovement("a", map);
		assertEquals (0, novo.GameState());
	}
	
	@Test
	public void testDoorsOpenWhenLeverIsReached() {
		
		StateOfGame novo = new StateOfGame(1);
		novo.NewGame(1);
		novo.GetLever().SetLeverPos(3, 1);
		novo.HeroMovement("s", map);
		novo.HeroMovement("s", map);
		assertEquals (3, novo.GameState());
	
	}
	
	@Test
	public void testProgresstoKeep() {
		
		StateOfGame novo = new StateOfGame(1);
		novo.NewGame(1);
		novo.GetLever().SetLeverPos(3, 1);
		novo.HeroMovement("s", map);
		novo.HeroMovement("s", map);
		assertEquals (3, novo.GameState());
		novo.HeroMovement("a", map);
		assertEquals (2, novo.GameState());
	
	}

}
