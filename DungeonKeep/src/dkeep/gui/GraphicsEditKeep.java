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



public class GraphicsEditKeep extends JPanel implements MouseListener, MouseMotionListener, KeyListener {
	


	private char map[][] ;
	
	private StateOfGame thegame;
	private BufferedImage doorclose, dooropen, guard, hero, ork, spiek, wall, stuned, heroarmed, key, armer, sleeping, lever;
	EditKeepLevelInterface window;
	private int lin, col;
	private int countHero = 0, countKey = 0, countOrks = 0;
	
	

  
  
  public GraphicsEditKeep(EditKeepLevelInterface window, int lin, int col) { 
	  	this.window = window;
       addMouseListener(this);
       addMouseMotionListener(this);
       this.addKeyListener(this);
       this.lin = lin;
       this.col = col;
       
       int i = 0; 
       
       map = new char[lin][col];
       
       while(i < col){
    	   map[0][i] = 'X';
    	   map[lin-1][i] = 'X';
    	   i++;
       }
       
       i = 0;
       
       while(i < lin){
    	   map[i][0] = 'X';
    	   map[i][col-1] = 'X';
    	   i++;
       }
       
       for (i = 1; i < lin -1; i++)
    	   for (int j = 1;  j < col -1; j++)
    	   {
    		   map[i][j] = ' ';
    	   }
       
       
       try {                
    	   hero = ImageIO.read(getClass().getResourceAsStream("hero.png"));doorclose = ImageIO.read(getClass().getResourceAsStream("doorclose.png"));dooropen = ImageIO.read(getClass().getResourceAsStream("dooropen.png"));guard = ImageIO.read(getClass().getResourceAsStream("guard.png"));
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
             
        }
      
       
       
       
}

  public void paintComponent(Graphics g) {
       super.paintComponent(g); 
      
       int i, j;
       int m = 0, n = 0;
 
   
       for (i = 0; i < lin; i++)
       {
    	   for (j = 0; j < col; j++)
    	   {	
    		  if(map[i][j] == 'X') 		{g.drawImage(wall, m, n, 35, 35, null, null);}
    		  else if(map[i][j] == 'H' ) {g.drawImage(hero, m, n, 50, 50, null, null); countHero++;}
    		  else if(map[i][j] == 'O') {g.drawImage(ork, m, n, 35, 35, null, null);}
    		  else if(map[i][j] == '*') {g.drawImage(spiek, m, n, 25, 25, null, null);}
    		  else if(map[i][j] == 'G') {g.drawImage(guard, m, n, 35, 35, null, null);}
    		  else if(map[i][j] == 'I') {g.drawImage(doorclose, m, n, 35, 35, null, null);}
    		  else if(map[i][j] == 'S') {g.drawImage(dooropen, m, n, 35, 35, null, null);}
    		  else if(map[i][j] == 'K'  ) {g.drawImage(key, m, n, 35, 35, null, null); countKey++;}

    		  else if(map[i][j] == 'g') {g.drawImage(sleeping, m, n, 35, 35, null, null);}
    		  m = m + 30;
    	   }
    	   m = 0;
    	   n = n + 35; 
    	   

       }
       
}

public char[][] getMap()
{
	return map;
	}

public void MapEditor(MouseEvent e)
{
	if (window.getNameToAdd() == "fbtnAddHero" )
	{
		if (((e.getY()*col) / ((col*335)/10)) < lin-1 && ((e.getY()*col) / ((col*335)/10)) > 0 && ((e.getX()*lin) / ((lin*290)/10)) < col-1 && ((e.getX()*lin) / ((lin*290)/10)) > 0 && countHero == 0)
			map[(e.getY()*col) / ((col*335)/10)][(e.getX()*lin) / ((lin*290)/10)] = 'H'; countHero++;
	}
	else if (window.getNameToAdd() == "fbtnAddOrks" ){
		
		
		if (((e.getY()*col) / ((col*335)/10)) < lin-1 && ((e.getY()*col) / ((col*335)/10)) > 0 && ((e.getX()*lin) / ((lin*290)/10)) < col-1 && ((e.getX()*lin) / ((lin*290)/10)) > 0 )
			map[(e.getY()*col) / ((col*335)/10)][(e.getX()*lin) / ((lin*290)/10)] = 'O'; }
		
	else if (window.getNameToAdd() == "fbtnAddWalls" ){
		if (((e.getY()*col) / ((col*335)/10)) < lin-1 && ((e.getY()*col) / ((col*335)/10)) > 0 && ((e.getX()*lin) / ((lin*290)/10)) < col-1 && ((e.getX()*lin) / ((lin*290)/10)) > 0)
			map[(e.getY()*col) / ((col*335)/10)][(e.getX()*lin) / ((lin*290)/10)] = 'X';}
		
	else if (window.getNameToAdd() == "fbtnAddKey" ){
		if (((e.getY()*col) / ((col*335)/10)) < lin-1 && ((e.getY()*col) / ((col*335)/10)) > 0 && ((e.getX()*lin) / ((lin*290)/10)) < col-1 && ((e.getX()*lin) / ((lin*290)/10)) > 0 && countKey == 0)
			map[(e.getY()*col) / ((col*335)/10)][(e.getX()*lin) / ((lin*290)/10)] = 'K'; countKey++;}
		
	else if (window.getNameToAdd() == "fbtnAddExitDoor" ){
		if (((e.getY()*col) / ((col*335)/10)) < lin-1 && ((e.getY()*col) / ((col*335)/10)) > 0 && ((e.getX()*lin) / ((lin*290)/10)) < col-1 && ((e.getX()*lin) / ((lin*290)/10)) > 0)
			map[(e.getY()*col) / ((col*335)/10)][(e.getX()*lin) / ((lin*290)/10)] = 'I';}
	
	else if (window.getNameToAdd() == "fbtnRemove" ){
		if (((e.getY()*col) / ((col*335)/10)) < lin-1 && ((e.getY()*col) / ((col*335)/10)) > 0 && ((e.getX()*lin) / ((lin*290)/10)) < col-1 && ((e.getX()*lin) / ((lin*290)/10)) > 0)
			map[(e.getY()*col) / ((col*335)/10)][(e.getX()*lin) / ((lin*290)/10)] = ' ';}
	

    repaint();
    
    window.MapRefresh(map);}

@Override
public void mouseDragged(MouseEvent e) {

	
}
@Override
public void mouseMoved(MouseEvent e) {

	
}
@Override
public void mouseClicked(MouseEvent e) {
	
MapEditor(e);
    
    
}

@Override
public void mousePressed(MouseEvent e) {
	MapEditor(e);
	
}
@Override
public void mouseReleased(MouseEvent e) {
	MapEditor(e);
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
	

	
}
@Override
public void keyReleased(KeyEvent e) {

	
}
  
}

