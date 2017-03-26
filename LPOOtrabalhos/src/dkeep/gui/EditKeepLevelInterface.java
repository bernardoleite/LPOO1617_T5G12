package dkeep.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import dkeep.logic.StateOfGame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class EditKeepLevelInterface {

	private JFrame frame;
	private JPanel mypanel;
	private JButton btnAddHero;
	private JButton btnAddOrks;
	private JButton btnAddWalls;
	private JButton btnAddKey;
	private JButton btnAddExitDoor;
	private JButton btnStartEditing;
	static Interface1 windowOriginal;
	static EditKeepLevelInterface window;
	private JTextField lines;
	private JTextField columns;
	private char[][] Map;
	public JLabel info;
	
	private int lin = 0, col = 0;
	private boolean  fbtnAddHero = false, fbtnAddOrks = false, fbtnAddWalls = false, fbtnAddKey = false, fbtnAddExitDoor = false, fbtnRemove = false;
	private int fAcceptDim = 0;

	
	public String getNameToAdd()
	{

		 if (fbtnAddHero) return "fbtnAddHero";
		else if (fbtnAddOrks) return "fbtnAddOrks";
		else if (fbtnAddWalls) return "fbtnAddWalls";
		else if (fbtnAddKey) return "fbtnAddKey";
		else if (fbtnAddExitDoor) return "fbtnAddExitDoor";
		else if (fbtnRemove) return "fbtnRemove";
		
		return null;
		
	}
	
	public void MapRefresh(char[][] mapToSend)
	{
		
		this.Map = mapToSend;
	}

	/**
	 * Launch the application.
	 */
	public static void NewWindow() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new EditKeepLevelInterface(windowOriginal);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EditKeepLevelInterface(Interface1 windowOriginal) {
		this.windowOriginal = windowOriginal;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 774, 618);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		JButton btnAddHero = new JButton("Add Hero");
		btnAddHero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				fbtnAddHero = true;
				fbtnAddOrks = false;
				fbtnAddWalls = false;
				fbtnAddKey = false;
				fbtnAddExitDoor = false;
	
			}
		});
		btnAddHero.setBounds(621, 159, 117, 29);
		
		
		JButton btnAddOrks = new JButton("Add Orks");
		btnAddOrks.setBounds(621, 200, 117, 29);
		btnAddOrks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				fbtnAddHero = false;
				fbtnAddOrks = true;
				fbtnAddWalls = false;
				fbtnAddKey = false;
				fbtnAddExitDoor = false;
			}
		});
		
		JButton btnAddWalls = new JButton("Add Walls");
		btnAddWalls.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				fbtnAddHero = false;
				fbtnAddOrks = false;
				fbtnAddWalls = true;
				fbtnAddKey = false;
				fbtnAddExitDoor = false;
			}
		});
		btnAddWalls.setBounds(621, 118, 117, 29);
		
		JButton btnSaveReturn = new JButton("Save & Return");
		btnSaveReturn.setBounds(621, 365, 117, 42);
		btnSaveReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if( fAcceptDim == 1 ){
				windowOriginal.MapToSend(Map, lin, col);
				frame.setVisible(false);}
				
				if(fAcceptDim == 0){
					info.setText("You must Creat A Map");
				}
				
				
				
				fAcceptDim = 0;
			}
		});
		
		JButton btnAddKey = new JButton("Add Key");
		btnAddKey.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				fbtnAddHero = false;
				fbtnAddOrks = false;
				fbtnAddWalls = false;
				fbtnAddKey = true;
				fbtnAddExitDoor = false;

			}
		});
		btnAddKey.setBounds(621, 241, 117, 29);
		
		JButton btnAddExitDoor = new JButton("Add Exit Door");
		btnAddExitDoor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				fbtnAddHero = false;
				fbtnAddOrks = false;
				fbtnAddWalls = false;
				fbtnAddKey = false;
				fbtnAddExitDoor = true;
				
			}
		});
		btnAddExitDoor.setBounds(621, 282, 117, 29);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(btnAddHero);
		frame.getContentPane().add(btnAddOrks);
		frame.getContentPane().add(btnAddWalls);
		frame.getContentPane().add(btnSaveReturn);
		frame.getContentPane().add(btnAddKey);
		frame.getContentPane().add(btnAddExitDoor);
		
		JButton btnStartEditing = new JButton("Start Editing");
		btnStartEditing.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				btnAddHero.setVisible(true);
				btnAddOrks.setVisible(true);
				btnAddWalls.setVisible(true);
				btnAddKey.setVisible(true);
				btnAddExitDoor.setVisible(true);
				btnAddKey.setEnabled(true);
				btnAddHero.setEnabled(true);
				
				String linhas = " ";
				String colunas = " " ;
				
				if (lines.getText().length()== 0 || columns.getText().length() ==0){
					info.setText("You must insert valid height and weight!");
				}else{
					info.setText("You can Start Creating Your Map.");
					linhas = lines.getText();
					colunas = columns.getText();
					lin = Integer.parseInt(linhas);
					col = Integer.parseInt(colunas);
					fAcceptDim = 1;
				}
	
				if(fAcceptDim == 1)
				{
				mypanel = new GraphicsEditKeep(window, lin, col);
				mypanel.setBounds(22, 23, 500, 500);
				frame.getContentPane().add(mypanel);
				mypanel.repaint();
				mypanel.requestFocusInWindow();
				}

			}
		});
		btnStartEditing.setBounds(621, 64, 117, 42);
		frame.getContentPane().add(btnStartEditing);
		
		lines = new JTextField();
		lines.setBounds(526, 159, 90, 26);
		frame.getContentPane().add(lines);
		lines.setColumns(10);
		
		columns = new JTextField();
		columns.setColumns(10);
		columns.setBounds(526, 241, 90, 26);
		frame.getContentPane().add(columns);
		
		JLabel Lines = new JLabel("Height");
		Lines.setBounds(550, 141, 61, 16);
		frame.getContentPane().add(Lines);
		
		JLabel lblColumns = new JLabel("Width");
		lblColumns.setBounds(548, 223, 61, 16);
		frame.getContentPane().add(lblColumns);
		
		info = new JLabel("Status");
		info.setBounds(434, 6, 332, 16);
		frame.getContentPane().add(info);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				fbtnAddHero = false;
				fbtnAddOrks = false;
				fbtnAddWalls = false;
				fbtnAddKey = false;
				fbtnAddExitDoor = false;
				fbtnRemove = true;
				
			}
		});
		btnRemove.setBounds(621, 323, 117, 29);
		frame.getContentPane().add(btnRemove);
		
		JLabel lblNewLabel = new JLabel("You are Able to Insert 1 Hero and 1 Key.");
		lblNewLabel.setBounds(266, 574, 434, 16);
		frame.getContentPane().add(lblNewLabel);
		
		
	
	}
}
