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



public class GraphicsLevel1And2 extends JPanel implements MouseListener, MouseMotionListener, KeyListener {
	


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
	private BufferedImage doorclose, dooropen, guard, hero, ork, spiek, wall, stuned, heroarmed, key, armer, sleeping, lever, keylocked, doors;
	private int lin = 10, col = 10;
	
	Interface1 window;
  

  
  
  public GraphicsLevel1And2(Interface1 window, StateOfGame novojogo, int lin, int col) { 
	  this.window = window;
       addMouseListener(this);
       addMouseMotionListener(this);
       this.addKeyListener(this);
       this.thegame = novojogo;
       this.lin = lin;
       this.col = col;
       
       try {                
    	   hero = ImageIO.read(getClass().getResourceAsStream("hero.png"));doorclose = ImageIO.read(getClass().getResourceAsStream("doorclose.png")); dooropen = ImageIO.read(getClass().getResourceAsStream("dooropen.png")); guard = ImageIO.read(getClass().getResourceAsStream("guard.png")); ork = ImageIO.read(getClass().getResourceAsStream("ork.png"));
    	   spiek = ImageIO.read(getClass().getResourceAsStream("spiek.png"));
    	   wall = ImageIO.read(getClass().getResourceAsStream("wall.png"));
    	   stuned = ImageIO.read(getClass().getResourceAsStream("stuned.png"));
    	   heroarmed = ImageIO.read(getClass().getResourceAsStream("heroarmed.png"));
    	   key = ImageIO.read(getClass().getResourceAsStream("key.png"));
    	   armer = ImageIO.read(getClass().getResourceAsStream("armer.png"));
    	   sleeping = ImageIO.read(getClass().getResourceAsStream("sleeping.png"));
    	   lever = ImageIO.read(getClass().getResourceAsStream("lever.png"));
    	   keylocked = ImageIO.read(getClass().getResourceAsStream("keylocked.png"));
    	   doors = ImageIO.read(getClass().getResourceAsStream("doors.png"));
        } catch (IOException ex) {
            
        }
       
       
       
}

  public void paintComponent(Graphics g) {
       super.paintComponent(g); // limpa fundo ...
       
       map = thegame.getMap();
    
       int i, j;
       int m = 0, n = 0;
       
       g.setColor(Color.BLUE);
       
     
       for (i = 0; i < lin; i++)
       {
    	   for (j = 0; j < col; j++)
    	   {	
    		  if(map[i][j] == 'X') 		{g.drawImage(wall, m, n, 35, 35, null, null);}
    		  else if(map[i][j] == 'H' ) {g.drawImage(hero, m, n, 35, 35, null, null);}
    		  else if(map[i][j] == 'O') {g.drawImage(ork, m, n, 35, 35, null, null);}
    		  else if(map[i][j] == '8') {g.drawImage(stuned, m, n, 35, 35, null, null);}
    		  else if(map[i][j] == '*') {g.drawImage(spiek, m, n, 25, 25, null, null);}
    		  else if(map[i][j] == 'G') {g.drawImage(guard, m, n, 35, 35, null, null);}
    		  else if(map[i][j] == 'I' && j != 0 && thegame.MyLevel == 1) {g.drawImage(doors, m, n, 35, 35, null, null);}
    		  else if(map[i][j] == 'I' && j != 0 && thegame.MyLevel == 2) {g.drawImage(doorclose, m, n, 35, 35, null, null);}
    		  else if(map[i][j] == 'I' && j == 0) {g.drawImage(doorclose, m, n, 35, 35, null, null);}
    		  else if(map[i][j] == 'I' && thegame.GetMyLevel() > 1) {g.drawImage(doorclose, m, n, 35, 35, null, null);}
    		  else if(map[i][j] == 'S' && j == 0) {g.drawImage(dooropen, m, n, 35, 35, null, null);}
    		  else if(map[i][j] == 'S' && j != 0) {g.drawImage(doors, m, n, 35, 35, null, null);}
    		  else if(map[i][j] == 'S' && thegame.GetMyLevel() > 1) {g.drawImage(dooropen, m, n, 35, 35, null, null);}
    		  else if(map[i][j] == '$') {g.drawImage(keylocked, m, n, 35, 35, null, null);}
    		  else if(map[i][j] == 'A' && thegame.GetHero().getHeroDress() == 'A') {g.drawImage(heroarmed, m, n, 35, 35, null, null);}
    		  else if(map[i][j] == 'A') {g.drawImage(armer, m, n, 35, 35, null, null);}
    		  else if(map[i][j] == 'K' && thegame.GetMyLevel() == 1) {g.drawImage(lever, m, n, 35, 35, null, null);}
    		  else if(map[i][j] == 'K' && thegame.GetMyLevel() == 2 && thegame.GetKey().StatusKey() == 0 ) {g.drawImage(key, m, n, 35, 35, null, null);}
    		  else if(map[i][j] == 'K' && thegame.GetKey().StatusKey() == 1) {g.drawImage(key, m, n, 35, 35, null, null);}
    		  else if(map[i][j] == 'g') {g.drawImage(sleeping, m, n, 35, 35, null, null);}
    		  m = m + 30;
    	   }
    	   m = 0;
    	   n = n + 35;

       }
       
    
       
    
       
       
       
       
}


@Override
public void mouseDragged(MouseEvent e) {

	
}
@Override
public void mouseMoved(MouseEvent e) {

	
}
@Override
public void mouseClicked(MouseEvent e) {

	
}
@Override
public void mousePressed(MouseEvent e) {

	
}
@Override
public void mouseReleased(MouseEvent e) {

	
}
@Override
public void mouseEntered(MouseEvent e) {

	
}
@Override
public void mouseExited(MouseEvent e) {

	
}
@Override
public void keyTyped(KeyEvent e) {

	
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
	
	
}
  
}

