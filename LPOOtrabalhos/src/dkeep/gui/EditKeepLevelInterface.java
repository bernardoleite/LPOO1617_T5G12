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

public class EditKeepLevelInterface extends JFrame {

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
	
	private int lin, col;
	private boolean  fbtnAddHero = false, fbtnAddOrks = false, fbtnAddWalls = false, fbtnAddKey = false, fbtnAddExitDoor = false;
	
	
	public String getNameToAdd()
	{

		 if (fbtnAddHero) return "fbtnAddHero";
		else if (fbtnAddOrks) return "fbtnAddOrks";
		else if (fbtnAddWalls) return "fbtnAddWalls";
		else if (fbtnAddKey) return "fbtnAddKey";
		else if (fbtnAddExitDoor) return "fbtnAddExitDoor";
		
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
		frame.setBounds(100, 100, 772, 516);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnAddHero = new JButton("Add Hero");
		btnAddHero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				fbtnAddHero = true;
				fbtnAddOrks = false;
				fbtnAddWalls = false;
				fbtnAddKey = false;
				fbtnAddExitDoor = false;
				setVisible(false);
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
		btnSaveReturn.setBounds(621, 330, 117, 42);
		btnSaveReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				windowOriginal.MapToSend(Map, lin, col);
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		btnAddExitDoor.setBounds(621, 289, 117, 29);
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
				
				
				String linhas = lines.getText();
				String colunas = columns.getText();
				
				lin = Integer.parseInt(linhas);
				col = Integer.parseInt(colunas);
				
				mypanel = new GraphicsEditKeep(window, lin, col);
				//mypanel.setBounds(22, 23, (lin*320)/10, (col*350)/10);
				mypanel.setBounds(22, 23, 500, 500);
				frame.getContentPane().add(mypanel);
				mypanel.repaint();
				mypanel.requestFocusInWindow();
				
				
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
		
		JLabel info = new JLabel("Status");
		info.setBounds(434, 6, 332, 16);
		frame.getContentPane().add(info);
		
		
	
	}
}
