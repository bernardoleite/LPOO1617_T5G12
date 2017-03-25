package dkeep.cli;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

import dkeep.logic.Enemy;
import dkeep.logic.Hero;
import dkeep.logic.StateOfGame;
import dkeep.logic.Ork;


public class Cli {
	

	
    public static void main(String[] args) {
    	
    	StateOfGame novojogo = new StateOfGame(1, 0, 2); //Novo Jogo

    	int flag1 = 1;
    	
    	while (flag1 == 1)
    		
		{
		
		System.out.printf("Movimento? (W,A,S,D) ");
		
		Scanner reader = new Scanner (System.in);
		
		String movement = reader.next();  
		
		novojogo.Input(movement); //Ler Teclado

		
		for (int i = 0; i < 10; i++)
		{
			for (int j = 0; j < 10 ; j++)
			{
				System.out.print(novojogo.getMap()[i][j]);
				System.out.printf(" ");
			}
			
			System.out.printf("\n");
		}
		
		if ( novojogo.GameState() == 1 ) {System.out.printf("!!!Game Over!!!\n"); flag1 = 0;}
		
		if ( novojogo.GameState() == 2 ) {System.out.printf("!!!You Win this Level!!!\n"); flag1 = 0;}
		
		}
    	
    	novojogo = new StateOfGame(2, 0, 2); //Novo Jogo
    	
    	flag1 = 1;
    	
    	while (flag1 == 1)
    		
		{
		
		System.out.printf("Movimento? (W,A,S,D) ");
		
		Scanner reader = new Scanner (System.in);
		
		String movement = reader.next(); 
		
		novojogo.Input(movement); //Ler Teclado

		
		for (int i = 0; i < 10; i++)
		{
			for (int j = 0; j < 10 ; j++)
			{
				System.out.print(novojogo.getMap()[i][j]);
				System.out.printf(" ");
			}
			
			System.out.printf("\n");
		}
		
		if ( novojogo.GameState() == 1 ) {System.out.printf("!!!Game Over!!!\n"); flag1 = 0;}
		
		if ( novojogo.GameState() == 2 ) {System.out.printf("!!!You Win the Game!!!\n"); flag1 = 0;}
		
		}
 
}
}