package dkeep.test;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

import dkeep.logic.StateOfGame;

/*
 Testing the Ogre's random behaviour (movement, club swinging) requires a more complex testing procedure. 
 Therefore, create an additional test class that verifies (at each game turn, that is, Hero's movement), 
 the expected "random" behaviour of the Ogre by checking if the next state is one of the expected, failing otherwise. 
 Below is just a suggestion how to organize your test code:
 */

public class TesteOgreRandomBehaviour {
	
	char [][] map = {
			{'X','X','X','X','X'},
			{'X','H',' ',' ','X'},
			{'I',' ',' ',' ','X'},
			{'I',' ',' ',' ','X'},
			{'X','X','X','X','X'}
};

	@Test(timeout=1000)
	public void TestOgreRandomBehavior() {
		
		/*
		 * Outcome1 is an exit in case of The Ogre's Movement and his club aren't Random
		 * 
		 * Outcome2 is an exit when Ogre catches the Hero.
		 * 
		 * Outcom3 is an exit if (it is difficult to happen) Hero catch the key and reach the doors
		 */
		
		int move;
		char ogreMov;
		char clubMov;
		Random mov = new Random();
		boolean outcome1 = false, outcome2 = false, outcome3 = false;
		
		StateOfGame novo = new StateOfGame(2);
		novo.NewGame(2);
		
		for (int i = 0; i < novo.getOrks().size(); i++){
			novo.getOrks().get(i).setOrkPositicions(1, 3);}
		
		novo.GetHero().setHeroPos(1, 1);
		novo.GetKey().setKeypos(3, 2);
	
		
		while ( outcome1 == false && outcome2 == false && outcome3 == false)
		{
			move = mov.nextInt(3)+1; //hero's movement
			
			ogreMov = novo.getOrks().get(0).getOgreMovement();
			clubMov = novo.getOrks().get(0).getClubMovement();
			
			if (ogreMov != 'W' || ogreMov != 'A' || ogreMov != 'S' || ogreMov != 'D')
				outcome1 = true;
			
			if (clubMov != 'W' || ogreMov != 'A' || ogreMov != 'S' || ogreMov != 'D')
				outcome1 = true;
			
			if(novo.GameState() == 1) // hero fails
				outcome3 = true;
			
			if(novo.GameState() == 2) // hero wins
				outcome3 = true;
			
	
		}
		
	}

}
