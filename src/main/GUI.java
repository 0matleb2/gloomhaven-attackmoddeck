package main;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import javax.swing.JMenuBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenu;

public class GUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
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
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setSize(1024, 751);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ImageIcon imageIcon = new ImageIcon(GUI.class.getResource("/boxArt/boxFrontLarge.jpg"));
		BackgroundPanel panel = new BackgroundPanel(imageIcon.getImage());
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblAttackModifierDeck = new JLabel("Attack Modifier Deck Simulator");
		lblAttackModifierDeck.setForeground(new Color(255, 245, 238));
		lblAttackModifierDeck.setFont(new Font("Pirata One", Font.PLAIN, 36));
		lblAttackModifierDeck.setHorizontalAlignment(SwingConstants.CENTER);
		lblAttackModifierDeck.setBounds(126, 224, 767, 39);
		panel.add(lblAttackModifierDeck);
		
		JLabel lblSnowblinds = new JLabel("Snowblind's");
		lblSnowblinds.setHorizontalAlignment(SwingConstants.CENTER);
		lblSnowblinds.setForeground(new Color(255, 245, 238));
		lblSnowblinds.setFont(new Font("Pirata One", Font.PLAIN, 36));
		lblSnowblinds.setBounds(126, 73, 767, 39);
		panel.add(lblSnowblinds);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 245, 238), new Color(245, 222, 179), null, null));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(GUI.class.getResource("/attackModifers/Attack Modifier - Back.jpg")));
		lblNewLabel.setBounds(297, 294, 437, 296);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Draw");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setFont(new Font("Pirata One", Font.PLAIN, 36));
		btnNewButton.setForeground(new Color(255, 245, 238));
		btnNewButton.setOpaque(false);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorderPainted(true);
		btnNewButton.setFocusPainted(false);
		btnNewButton.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 245, 238), new Color(245, 222, 179), null, null));
		btnNewButton.setBounds(100, 393, 134, 68);
		panel.add(btnNewButton);
		
		JMenuBar menuBar = new JMenuBar();
		frame.getContentPane().add(menuBar, BorderLayout.NORTH);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
	}
}
