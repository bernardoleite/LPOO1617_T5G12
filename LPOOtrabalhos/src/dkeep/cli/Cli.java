package dkeep.cli;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

import dkeep.logic.Enemy;
import dkeep.logic.Hero;
import dkeep.logic.StateOfGame;
import dkeep.logic.Ork;


public class Cli {
	

	
    public static void main(String[] args) {
    	
    	StateOfGame novojogo = new StateOfGame(1); //Novo Jogo
    	int flag1 = 1;
    	
    	
    	while (flag1 == 1)
    		
		{
		
		System.out.printf("Movimento? (W,A,S,D) ");
		
		Scanner reader = new Scanner (System.in);
		
		String movement = reader.next(); 
		
		novojogo.Input(movement); //Ler Teclado
		
		novojogo.getMap();	//Mapa Resultante da Jogada
		
		if ( novojogo.GameState() == 1 ) {System.out.printf("!!!Game Over!!!\n"); flag1 = 0;}
		
		if ( novojogo.GameState() == 2 ) {System.out.printf("!!!You Win!!!\n"); flag1 = 0;}
		
		}
    
    
    
}
}