 package dkeep.gui;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import dkeep.logic.StateOfGame;



public class SimpleGraphicsPanel extends JPanel implements MouseListener, MouseMotionListener, KeyListener {
	
  // Coordinates of the elipse “bounding rectangle”

	public char map[][]= {{'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'}, /*Tabuleiro do 1º nível*/
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
	
	private StateOfGame thegame;
	private BufferedImage doorclose, dooropen, guard, hero, ork, spiek, wall, stuned, heroarmed, key, armer, sleeping, lever;
	
	Interface1 window;
  
  // Constructor, adding mouse and keyboard listeneres
  
  
  public SimpleGraphicsPanel(Interface1 window, StateOfGame novojogo) {
	  this.window = window;
       addMouseListener(this);
       addMouseMotionListener(this);
       this.addKeyListener(this);
       this.thegame = novojogo;
       
       try {                
    	   hero = ImageIO.read(getClass().getResourceAsStream("hero.png"));
    	   doorclose = ImageIO.read(getClass().getResourceAsStream("doorclose.png"));
    	   dooropen = ImageIO.read(getClass().getResourceAsStream("dooropen.png"));
    	   guard = ImageIO.read(getClass().getResourceAsStream("guard.png"));
    	   ork = ImageIO.read(getClass().getResourceAsStream("ork.png"));
    	   spiek = ImageIO.read(getClass().getResourceAsStream("spiek.png"));
    	   wall = ImageIO.read(getClass().getResourceAsStream("wall.png"));
    	   stuned = ImageIO.read(getClass().getResourceAsStream("stuned.png"));
    	   heroarmed = ImageIO.read(getClass().getResourceAsStream("heroarmed.png"));
    	   key = ImageIO.read(getClass().getResourceAsStream("key.png"));
    	   armer = ImageIO.read(getClass().getResourceAsStream("armer.png"));
    	   sleeping = ImageIO.read(getClass().getResourceAsStream("sleeping.png"));
    	   lever = ImageIO.read(getClass().getResourceAsStream("lever.png"));
        } catch (IOException ex) {
             // handle exception...
        }
       
       
       
}
  // Redraws the panel, only when requested by SWING
  public void paintComponent(Graphics g) {
       super.paintComponent(g); // limpa fundo ...
       
       map = thegame.getMap();
    
       int i, j;
       int m = 0, n = 0;
       
       g.setColor(Color.BLUE);
       
     
       for (i = 0; i < map.length; i++)
       {
    	   for (j = 0; j < map.length; j++)
    	   {	
    		  if(map[i][j] == 'X') 		{g.drawImage(wall, m, n, 35, 35, null, null);}
    		  else if(map[i][j] == 'H') {g.drawImage(hero, m, n, 35, 35, null, null);}
    		  else if(map[i][j] == 'O') {g.drawImage(ork, m, n, 35, 35, null, null);}
    		  else if(map[i][j] == '*') {g.drawImage(spiek, m, n, 25, 25, null, null);}
    		  else if(map[i][j] == 'G') {g.drawImage(guard, m, n, 35, 35, null, null);}
    		  else if(map[i][j] == 'I') {g.drawImage(doorclose, m, n, 35, 35, null, null);}
    		  else if(map[i][j] == 'S') {g.drawImage(dooropen, m, n, 35, 35, null, null);}
    		  else if(map[i][j] == '$') {g.drawImage(stuned, m, n, 35, 35, null, null);}
    		  else if(map[i][j] == 'A' && thegame.GetHero().getHeroDress() == 'A') {g.drawImage(heroarmed, m, n, 35, 35, null, null);}
    		  else if(map[i][j] == 'A') {g.drawImage(armer, m, n, 35, 35, null, null);}
    		  else if(map[i][j] == 'K' && thegame.GetMyLevel() == 1) {g.drawImage(lever, m, n, 35, 35, null, null);}
    		  else if(map[i][j] == 'K' && thegame.GetMyLevel() == 2 && thegame.GetKey().StatusKey() == 0 ) {g.drawImage(key, m, n, 35, 35, null, null);}
    		  else if(map[i][j] == 'K' && thegame.GetKey().StatusKey() == 1) {g.drawImage(heroarmed, m, n, 35, 35, null, null);}
    		  else if(map[i][j] == 'g') {g.drawImage(sleeping, m, n, 35, 35, null, null);}
    		  m = m + 30;
    	   }
    	   m = 0;
    	   n = n + 35;

       }
       
    
       
      // g.drawImage(image, 0, 0, 50, 50, null, null);
       
       
       
       
}



@Override
public void mouseDragged(MouseEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void mouseMoved(MouseEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void mouseClicked(MouseEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void mousePressed(MouseEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void mouseReleased(MouseEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void mouseEntered(MouseEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void mouseExited(MouseEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void keyTyped(KeyEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void keyPressed(KeyEvent e) {
	
	if (e.getKeyCode() == KeyEvent.VK_UP)
	{

		window.updateGame("w");
		
	}
	
	if (e.getKeyCode() == KeyEvent.VK_LEFT)
	{

		window.updateGame("a");
		
	}
	
	if (e.getKeyCode() == KeyEvent.VK_DOWN)
	{

		window.updateGame("s");
		
	}
	
	if (e.getKeyCode() == KeyEvent.VK_RIGHT)
	{
		window.updateGame("d");
		
	}
	
	repaint();
	
}
@Override
public void keyReleased(KeyEvent e) {
	// TODO Auto-generated method stub
	
}
  
}

