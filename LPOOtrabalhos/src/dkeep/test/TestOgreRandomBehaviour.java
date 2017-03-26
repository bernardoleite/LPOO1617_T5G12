package dkeep.test;

import java.util.Random;

import org.junit.Test;

import dkeep.logic.StateOfGame;

public class TestOgreRandomBehaviour {
	
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
