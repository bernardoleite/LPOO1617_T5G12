package dkeep.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class Interface {

	private JFrame frame;
	private JTextField numogres;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface window = new Interface();
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
	public Interface() {
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
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(228, 120, 135, 20);
		frame.getContentPane().add(comboBox);
		
		JButton btnNewGame = new JButton("New Game");
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
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Courier New", Font.PLAIN, 13));
		textArea.setBounds(51, 175, 589, 443);
		frame.getContentPane().add(textArea);
		
		JButton btnUp = new JButton("Up");
		btnUp.setEnabled(false);
		btnUp.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnUp.setBounds(750, 244, 110, 23);
		frame.getContentPane().add(btnUp);
		
		JButton btnDown = new JButton("Down");
		btnDown.setEnabled(false);
		btnDown.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDown.setBounds(750, 366, 110, 23);
		frame.getContentPane().add(btnDown);
		
		JButton btnLeft = new JButton("Left");
		btnLeft.setEnabled(false);
		btnLeft.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLeft.setBounds(676, 302, 110, 23);
		frame.getContentPane().add(btnLeft);
		
		JButton btnRight = new JButton("Right");
		btnRight.setEnabled(false);
		btnRight.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRight.setBounds(825, 302, 110, 23);
		frame.getContentPane().add(btnRight);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setBounds(61, 629, 46, 14);
		frame.getContentPane().add(lblStatus);
	}
}
