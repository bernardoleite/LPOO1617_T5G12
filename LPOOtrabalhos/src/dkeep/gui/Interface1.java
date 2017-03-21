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
import dkeep.logic.StateOfGame;


import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
	private JTextArea txtArea;
	private JButton btnNewGame;
	private StateOfGame novojogo;
	String [] guarda = {"Rookie","Drunken", "Suspicious"};
	private JComboBox comboBox;
	private JLabel lblStatus;
	private int NumberOgres = 0;
	private int MyLevel = 1;
	private JPanel panel;

	static Interface1 window;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
	
	public String getCurrentMap()
	{
		String aux;
		String fim;
		fim = "";
		for (int i = 0; i < 10; i++)
		{
			
			aux = String.valueOf(novojogo.getMap()[i]);
			fim = fim + " " + aux + "\n";

		}
		

		
		return fim;
	}
	
	public char[][] olaola()
	{
		return novojogo.getMap();
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
			btnNewGame.setEnabled(true);
			
			}
		
		else if ( novojogo.GameState() == 2 ) {
			
			lblStatus.setText("Win!");
			MyLevel++;
			
			if (MyLevel > 1){
				novojogo = new StateOfGame(2, 0, NumberOgres);
				panel = new SimpleGraphicsPanel(window, novojogo);
				panel.setBounds(61, 163, 593, 435);
				frame.getContentPane().add(panel);
				
				}
			
			else if (MyLevel == 3)
				turnOffMovementButtoms();
				btnNewGame.setEnabled(true);
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
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 961, 697);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(472, 5, 0, 0);
		frame.getContentPane().add(label);
		
		JLabel lblNewLabel = new JLabel("Number of Ogres:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(100, 69, 124, 32);
		frame.getContentPane().add(lblNewLabel);
		
		numogres = new JTextField();
		numogres.setBounds(228, 77, 92, 20);
		frame.getContentPane().add(numogres);
		numogres.setColumns(10);
		
		JLabel lblGuardPersonality = new JLabel("Guard Personality:");
		lblGuardPersonality.setHorizontalAlignment(SwingConstants.CENTER);
		lblGuardPersonality.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGuardPersonality.setBounds(100, 112, 124, 32);
		frame.getContentPane().add(lblGuardPersonality);
		
		comboBox = new JComboBox(guarda);
		comboBox.setToolTipText("Choose the Guard's Personality");
		comboBox.setBounds(228, 120, 135, 20);
		frame.getContentPane().add(comboBox);
		
		btnNewGame = new JButton("New Game");
		btnNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				btnUp.setEnabled(true);
				btnDown.setEnabled(true);
				btnLeft.setEnabled(true);
				btnRight.setEnabled(true);
				btnNewGame.setEnabled(false);
				String texto = numogres.getText();
				ogres = Integer.parseInt(texto);
				int tipoguarda = comboBox.getSelectedIndex();
				tipoguarda++;
				
				novojogo = new StateOfGame(1, tipoguarda, 4);
				panel = new SimpleGraphicsPanel(window,novojogo);	
				panel.setBounds(61, 163, 593, 435);
				frame.getContentPane().add(panel);
				panel.repaint();
				panel.requestFocusInWindow();
				
				
				NumberOgres = ogres;
				
				txtArea.setText(getCurrentMap());
				
				GameStatus();
				panel.requestFocusInWindow();
			
				
				
				
				
				
				
			}
		});	
			
			
		btnNewGame.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewGame.setBounds(750, 112, 110, 23);
		frame.getContentPane().add(btnNewGame);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnExit.setBounds(750, 543, 110, 23);
		frame.getContentPane().add(btnExit);
		
		txtArea = new JTextArea();
		txtArea.setText("Welcome to Ogre Dungeon!");
		txtArea.setFont(new Font("Courier New", Font.PLAIN, 23));
		txtArea.setBounds(453, 29, 223, 108);
		frame.getContentPane().add(txtArea);
		
		frame.getContentPane().add(txtArea);
		
		btnUp = new JButton("Up");
		btnUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				updateGame("w");				
				
				
				
			}
		});
		btnUp.setEnabled(false);
		btnUp.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnUp.setBounds(750, 244, 110, 23);
		frame.getContentPane().add(btnUp);
		
		btnDown = new JButton("Down");
		btnDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				updateGame("s");
			
				
			}

		});
		btnDown.setEnabled(false);
		btnDown.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDown.setBounds(750, 366, 110, 23);
		frame.getContentPane().add(btnDown);
		
		btnLeft = new JButton("Left");
		btnLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				updateGame("a");		
				
				
			}
		});
		btnLeft.setEnabled(false);
		btnLeft.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLeft.setBounds(676, 302, 110, 23);
		frame.getContentPane().add(btnLeft);
		
		btnRight = new JButton("Right");
		btnRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				updateGame("d");			
				
				
			}
		});
		btnRight.setEnabled(false);
		btnRight.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRight.setBounds(825, 302, 110, 23);
		frame.getContentPane().add(btnRight);
		
		lblStatus = new JLabel("Status");
		lblStatus.setBounds(61, 629, 206, 14);
		frame.getContentPane().add(lblStatus);
	

	}

	public void updateGame(String dir) {
		novojogo.Input(dir);
		
		txtArea.setText(getCurrentMap());
		panel.setBounds(61, 163, 593, 435);
		frame.getContentPane().add(panel);
		panel.repaint();
		panel.requestFocusInWindow();
		GameStatus();
	}

}
