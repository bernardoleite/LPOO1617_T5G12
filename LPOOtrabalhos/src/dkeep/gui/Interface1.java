package dkeep.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Font;
import javax.swing.SwingConstants;

import dkeep.logic.Guard;
import dkeep.logic.Ork;
import dkeep.logic.StateOfGame;


import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class Interface1 {

	private JFrame frame;
	private JTextField numogres;
	private JButton btnUp;
	private JButton btnDown;
	private JButton btnLeft;
	private JButton btnRight;
	private int ogres;
	private JButton btnNewGame;
	private StateOfGame novojogo;
	String [] guarda = {"Rookie","Drunken", "Suspicious"};
	private JComboBox comboBox;
	private JLabel lblStatus;
	private int NumberOgres = 0;
	private int MyLevel = 1;
	private JPanel panel;
	private char[][] Map = null;
	public char Map1[][]= {{'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'}, /*Tabuleiro do 1º nível*/
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
 
	
	static Interface1 window;
	private JButton btnEditKeepLevel;
	private JButton btnLoadGame;
	private JButton btnSaveGame;
	
	private int[] OrksPos = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21};
	private int NumOrk = 0;
	private int[] KeyPos = {1,2,3,4,5,6,7,8,9,10};
	private int[] HeroPos = {1,2,3,4,5,6,7,8,9,10};
	private int m = 0;
	
	private int lin = 10, col = 10;
	private String fileName = "data.bin";
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args)  {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new Interface1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void MapToSend (char[][] MapToSend, int lin, int col)
	{
		this.Map = MapToSend;
		this.lin = lin;
		this.col = col;
		
		
	}

	public void MapTreatment ()
	{
		int aux = 0;
		
		for(int i = 0;  i < lin; i++){
	  		
			for (int j = 0 ; j < col; j++){
				
				if (Map[i][j] == 'K')
				{
					KeyPos[0] = i; KeyPos[1] = j;
					Map[i][j] = ' ';
				}
				
				else if (Map[i][j] == 'H')
				{
					HeroPos[0] = i; HeroPos[1] = j;
					Map[i][j] = ' ';
				}
	
				else if (Map[i][j] == 'O')
				{
					OrksPos[aux] = i; OrksPos[aux+1] = j;
					aux = aux + 2;
					NumOrk = NumOrk + 1;
					Map[i][j] = ' ';
				}
			
			}
			
		}
	}
	
	public String getCurrentMap()
	{
		String aux;
		String fim;
		fim = "";
		for (int i = 0; i < lin; i++)
		{
			
			aux = String.valueOf(novojogo.getMap()[i]);
			fim = fim + " " + aux + "\n";

		}
		

		
		return fim;
	}
	
	public void turnOffMovementButtoms()
	{
		btnUp.setEnabled(false);
		btnDown.setEnabled(false);
		btnLeft.setEnabled(false);
		btnRight.setEnabled(false);
		
	}
	
	public void GameStatus()
	{
		if ( novojogo.GameState() == 1 ) {
			
			lblStatus.setText("Game Over!");
			turnOffMovementButtoms();
			panel.removeKeyListener((KeyListener) panel);
			btnNewGame.setEnabled(true);
			
			}
		
		else if ( novojogo.GameState() == 2 ) {
			
			lblStatus.setText("Win!");
			
			MyLevel++;
			
			if (MyLevel == 2){
				
				if(Map != null) 
					
				{
					MapTreatment();
					novojogo = new StateOfGame(2, 0, NumOrk);
					novojogo.SetLevel2Map(Map);
					novojogo.SetLinAndCol(lin, col);
					novojogo.GetHero().setHeroPos(HeroPos[0], HeroPos[1]);
					novojogo.GetKey().setKeypos(KeyPos[0], KeyPos[1]);
					for (int k = 0; k < novojogo.GetOrk().size(); k++)
					{
						novojogo.GetOrk().get(k).setOrkPositicions(OrksPos[m], OrksPos[m+1]);
						m=m+2;
					}
					m = 0;
					
				}
				
				else {novojogo = new StateOfGame(2, 0, NumberOgres); }
				
				
				
				panel = new GraphicsLevel1And2(window, novojogo,lin,col);
				panel.setBounds(61, 163, 593, 435);
				frame.getContentPane().add(panel);
				
				
				}
			
			else if (MyLevel == 3){
				turnOffMovementButtoms();
				panel.removeKeyListener((KeyListener) panel);
				btnNewGame.setEnabled(true);}
			}
		
		else lblStatus.setText("You Can Play Now");
	}

	/**
	 * Create the application.
	 */
	public Interface1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()  {
		frame = new JFrame();
		frame.setBounds(100, 100, 952, 728);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(472, 5, 0, 0);
		frame.getContentPane().add(label);
		
		JLabel lblNewLabel = new JLabel("Number of Ogres (If edited, don't need):");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(84, 30, 270, 53);
		frame.getContentPane().add(lblNewLabel);
		
		numogres = new JTextField();
		numogres.setBounds(415, 47, 116, 20);
		frame.getContentPane().add(numogres);
		numogres.setColumns(10);
		
		JLabel lblGuardPersonality = new JLabel("Guard Personality:");
		lblGuardPersonality.setHorizontalAlignment(SwingConstants.CENTER);
		lblGuardPersonality.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGuardPersonality.setBounds(94, 71, 124, 32);
		frame.getContentPane().add(lblGuardPersonality);
		
		comboBox = new JComboBox(guarda);
		comboBox.setToolTipText("Choose the Guard's Personality");
		comboBox.setBounds(412, 79, 124, 20);
		frame.getContentPane().add(comboBox);
		
		btnNewGame = new JButton("New Game");
		btnNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				btnUp.setEnabled(true); btnDown.setEnabled(true); btnLeft.setEnabled(true); btnRight.setEnabled(true); btnNewGame.setEnabled(true);
				MyLevel = 1;
				
				
				if (numogres.getText().length()== 0){
					ogres =1;
				}else{
					String texto = numogres.getText();
					ogres = Integer.parseInt(texto);
				}
				int tipoguarda = comboBox.getSelectedIndex();
				tipoguarda++;
				
				
				novojogo = new StateOfGame(1, tipoguarda, 4);
				panel = new GraphicsLevel1And2(window,novojogo,10,10);	
				panel.setBounds(61, 163, 593, 435);
				frame.getContentPane().add(panel);
				panel.repaint();
				NumberOgres = ogres;	
				GameStatus();
				panel.requestFocusInWindow();
		
		
			}
		});	
			
			
		btnNewGame.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewGame.setBounds(764, 227, 146, 23);
		frame.getContentPane().add(btnNewGame);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
				
			}
		});
		btnExit.setBounds(764, 367, 146, 23);
		frame.getContentPane().add(btnExit);
		
		btnUp = new JButton("Up");
		btnUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				updateGame("w");				
	
			}
		});
		btnUp.setEnabled(false);
		btnUp.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnUp.setBounds(774, 422, 110, 23);
		frame.getContentPane().add(btnUp);
		
		btnDown = new JButton("Down");
		btnDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				updateGame("s");
			
				
			}

		});
		btnDown.setEnabled(false);
		btnDown.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDown.setBounds(774, 492, 110, 23);
		frame.getContentPane().add(btnDown);
		
		btnLeft = new JButton("Left");
		btnLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				updateGame("a");		
				
				
			}
		});
		btnLeft.setEnabled(false);
		btnLeft.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLeft.setBounds(720, 457, 110, 23);
		frame.getContentPane().add(btnLeft);
		
		btnRight = new JButton("Right");
		btnRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				updateGame("d");			
				
				
			}
		});
		btnRight.setEnabled(false);
		btnRight.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRight.setBounds(825, 457, 110, 23);
		frame.getContentPane().add(btnRight);
		
		lblStatus = new JLabel("Status");
		lblStatus.setBounds(34, 686, 206, 14);
		frame.getContentPane().add(lblStatus);
		
		btnEditKeepLevel = new JButton("Edit Keep Level");
		btnEditKeepLevel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				EditKeepLevelInterface editkeep = new EditKeepLevelInterface(window);
				editkeep.NewWindow();
				
		
			}
		});
		btnEditKeepLevel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEditKeepLevel.setBounds(764, 262, 146, 23);
		frame.getContentPane().add(btnEditKeepLevel);
		
		btnLoadGame = new JButton("Load Game");
		btnLoadGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					ObjectInputStream is = new ObjectInputStream(new FileInputStream(fileName));
					novojogo = (StateOfGame) is.readObject();
					lblStatus.setText("The Last Game Was Loaded");
					panel = new GraphicsLevel1And2(window,novojogo,10,10);	
					panel.setBounds(61, 163, 593, 435);
					frame.getContentPane().add(panel);
					panel.repaint();
				
					panel.requestFocusInWindow();
					is.close();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				catch (ClassNotFoundException e1) {
					
					e1.printStackTrace();
				}
				
				
			}
		});
		btnLoadGame.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLoadGame.setBounds(764, 297, 146, 23);
		frame.getContentPane().add(btnLoadGame);
		
		btnSaveGame = new JButton("Save & Exit");
		btnSaveGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					ObjectOutputStream os = new ObjectOutputStream( new FileOutputStream(fileName));
					os.writeObject(novojogo);
					os.close();
				} catch (FileNotFoundException e1) {
				
					e1.printStackTrace();
				} catch (IOException e1) {
					
					e1.printStackTrace();
				}
				lblStatus.setText("You have Saved Current Game!");
				System.exit(0);
			}
		});
		btnSaveGame.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSaveGame.setBounds(764, 332, 146, 23);
		frame.getContentPane().add(btnSaveGame);


	}

	public void updateGame(String dir) {
		novojogo.Input(dir);
		panel.setBounds(61, 163, 593, 435);
		frame.getContentPane().add(panel);
		panel.repaint();
		GameStatus();
		panel.requestFocusInWindow();
	
	}

}
