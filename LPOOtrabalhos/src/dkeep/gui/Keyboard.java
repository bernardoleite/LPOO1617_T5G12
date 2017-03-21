package dkeep.gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

import dkeep.logic.StateOfGame;

public class Keyboard implements KeyListener {

	private StateOfGame thegame;

	 public Keyboard (StateOfGame novojogo) {

	       this.thegame = novojogo;
	       
	  }
	 
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		if (e.getKeyCode() == KeyEvent.VK_UP)
		{
			
			
		}
		
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			
			
		}
		
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
		{
		
			
		}
		
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			
			
		}
		
		
			
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
