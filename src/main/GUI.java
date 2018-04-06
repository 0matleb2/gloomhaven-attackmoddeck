package main;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import java.awt.Font;
import java.awt.Point;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.border.BevelBorder;

import cards.AttackModifierDeck;
import contracts.IAttackModifierCard;
import contracts.IAttackModifierDeck;

import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class GUI {

	private JFrame frmSnowblindsGloomhavenAttack;
	private ArrayList<JLabel> drawnCardLabels;
	private JLabel lblShuffle;
	private JLabel lblMask;
	private IAttackModifierDeck deck;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frmSnowblindsGloomhavenAttack.setVisible(true);
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
		deck = new AttackModifierDeck();
		drawnCardLabels = new ArrayList<JLabel>();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSnowblindsGloomhavenAttack = new JFrame();
		frmSnowblindsGloomhavenAttack.setTitle("Snowblind's GLOOMHAVEN Attack Modifier Deck Simulator");
		frmSnowblindsGloomhavenAttack.setFont(new Font("Pirata One", Font.PLAIN, 18));
		frmSnowblindsGloomhavenAttack.setIconImage(Toolkit.getDefaultToolkit().getImage(GUI.class.getResource("/icons/Reshuffle.png")));
		frmSnowblindsGloomhavenAttack.setResizable(false);
		frmSnowblindsGloomhavenAttack.setSize(1024, 751);
		frmSnowblindsGloomhavenAttack.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ImageIcon imageIcon = new ImageIcon(GUI.class.getResource("/boxArt/boxFrontLarge.jpg"));
		BackgroundPanel panel = new BackgroundPanel(imageIcon.getImage());
		frmSnowblindsGloomhavenAttack.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel maskPanel = new JPanel();
		maskPanel.setBounds(297, 295, 437, 296);
		maskPanel.setLayout(new BorderLayout());
		maskPanel.setOpaque(true);
		maskPanel.setVisible(true);
		panel.add(maskPanel);
		
		lblMask = new JLabel("");
		lblMask.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 245, 238), new Color(245, 222, 179), null, null));
		lblMask.setBackground(new Color(10, 10, 10, 20));
		lblMask.setOpaque(true);
		lblMask.setHorizontalAlignment(SwingConstants.CENTER);
		lblMask.setVisible(false);
		maskPanel.add(lblMask, BorderLayout.CENTER);
		
		lblShuffle = new JLabel("");
		lblShuffle.setIcon(new ImageIcon(GUI.class.getResource("/icons/Reshuffle.png")));
		lblShuffle.setBounds(484, 603, 47, 46);
		panel.add(lblShuffle);
		
		JLabel lblTitle = new JLabel("Attack Modifier Deck Simulator");
		lblTitle.setForeground(new Color(255, 245, 238));
		lblTitle.setFont(new Font("Pirata One", Font.PLAIN, 36));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(126, 227, 767, 39);
		panel.add(lblTitle);
		
		JLabel lblSnowblind = new JLabel("Snowblind's");
		lblSnowblind.setHorizontalAlignment(SwingConstants.CENTER);
		lblSnowblind.setForeground(new Color(255, 245, 238));
		lblSnowblind.setFont(new Font("Pirata One", Font.PLAIN, 36));
		lblSnowblind.setBounds(126, 73, 767, 39);
		panel.add(lblSnowblind);
		
		JLabel lblBless = new JLabel("");
		lblBless.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 245, 238), new Color(245, 222, 179), null, null));
		lblBless.setHorizontalAlignment(SwingConstants.CENTER);
		lblBless.setIcon(new ImageIcon(GUI.class.getResource("/attackModifers/Double Damage - Bless.png")));
		lblBless.setBounds(297, 294, 437, 296);
		drawnCardLabels.add(lblBless);
		lblBless.setVisible(false);
		panel.add(lblBless);
		
		JLabel lblDoubleDamage = new JLabel("");
		lblDoubleDamage.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 245, 238), new Color(245, 222, 179), null, null));
		lblDoubleDamage.setHorizontalAlignment(SwingConstants.CENTER);
		lblDoubleDamage.setIcon(new ImageIcon(GUI.class.getResource("/attackModifers/Double Damage.png")));
		lblDoubleDamage.setBounds(297, 294, 437, 296);
		lblDoubleDamage.setVisible(false);
		drawnCardLabels.add(lblDoubleDamage);
		panel.add(lblDoubleDamage);
		
		JLabel lblPlusTwo = new JLabel("");
		lblPlusTwo.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 245, 238), new Color(245, 222, 179), null, null));
		lblPlusTwo.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlusTwo.setIcon(new ImageIcon(GUI.class.getResource("/attackModifers/Plus 2.png")));
		lblPlusTwo.setBounds(297, 294, 437, 296);
		lblPlusTwo.setVisible(false);
		drawnCardLabels.add(lblPlusTwo);
		panel.add(lblPlusTwo);
		
		JLabel lblPlusOne = new JLabel("");
		lblPlusOne.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 245, 238), new Color(245, 222, 179), null, null));
		lblPlusOne.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlusOne.setIcon(new ImageIcon(GUI.class.getResource("/attackModifers/Plus 1.png")));
		lblPlusOne.setBounds(297, 294, 437, 296);
		lblPlusOne.setVisible(false);
		drawnCardLabels.add(lblPlusOne);
		panel.add(lblPlusOne);
		
		JLabel lblNetural = new JLabel("");
		lblNetural.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 245, 238), new Color(245, 222, 179), null, null));
		lblNetural.setHorizontalAlignment(SwingConstants.CENTER);
		lblNetural.setIcon(new ImageIcon(GUI.class.getResource("/attackModifers/Neutral.png")));
		lblNetural.setBounds(297, 294, 437, 296);
		lblNetural.setVisible(false);
		drawnCardLabels.add(lblNetural);
		panel.add(lblNetural);
		
		JLabel lblMinusOne = new JLabel("");
		lblMinusOne.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 245, 238), new Color(245, 222, 179), null, null));
		lblMinusOne.setHorizontalAlignment(SwingConstants.CENTER);
		lblMinusOne.setIcon(new ImageIcon(GUI.class.getResource("/attackModifers/Minus 1.png")));
		lblMinusOne.setBounds(297, 294, 437, 296);
		lblMinusOne.setVisible(false);
		drawnCardLabels.add(lblMinusOne);
		panel.add(lblMinusOne);
		
		JLabel lblMinusTwo = new JLabel("");
		lblMinusTwo.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 245, 238), new Color(245, 222, 179), null, null));
		lblMinusTwo.setHorizontalAlignment(SwingConstants.CENTER);
		lblMinusTwo.setIcon(new ImageIcon(GUI.class.getResource("/attackModifers/Minus 2.png")));
		lblMinusTwo.setBounds(297, 294, 437, 296);
		lblMinusTwo.setVisible(false);
		drawnCardLabels.add(lblMinusTwo);
		panel.add(lblMinusTwo);
		
		JLabel lblMiss = new JLabel("");
		lblMiss.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 245, 238), new Color(245, 222, 179), null, null));
		lblMiss.setHorizontalAlignment(SwingConstants.CENTER);
		lblMiss.setIcon(new ImageIcon(GUI.class.getResource("/attackModifers/No Damage.png")));
		lblMiss.setBounds(297, 294, 437, 296);
		lblMiss.setVisible(false);
		drawnCardLabels.add(lblMiss);
		panel.add(lblMiss);
		
		JLabel lblCurse = new JLabel("");
		lblCurse.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 245, 238), new Color(245, 222, 179), null, null));
		lblCurse.setHorizontalAlignment(SwingConstants.CENTER);
		lblCurse.setIcon(new ImageIcon(GUI.class.getResource("/attackModifers/No Damage - Curse.png")));
		lblCurse.setBounds(297, 294, 437, 296);
		lblCurse.setVisible(false);
		drawnCardLabels.add(lblCurse);
		panel.add(lblCurse);
		
		JLabel lblCardBlank = new JLabel("");
		lblCardBlank.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 245, 238), new Color(245, 222, 179), null, null));
		lblCardBlank.setHorizontalAlignment(SwingConstants.CENTER);
		lblCardBlank.setIcon(new ImageIcon(GUI.class.getResource("/attackModifers/Attack Modifier - Blank.jpg")));
		lblCardBlank.setBounds(297, 294, 437, 296);
		lblCardBlank.setVisible(false);
		drawnCardLabels.add(lblCardBlank);
		panel.add(lblCardBlank);
		
		JLabel lblCardBlankReshuffle = new JLabel("");
		lblCardBlankReshuffle.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 245, 238), new Color(245, 222, 179), null, null));
		lblCardBlankReshuffle.setHorizontalAlignment(SwingConstants.CENTER);
		lblCardBlankReshuffle.setIcon(new ImageIcon(GUI.class.getResource("/attackModifers/Attack Modifier - Blank - Reshuffle.jpg")));
		lblCardBlankReshuffle.setBounds(297, 294, 437, 296);
		lblCardBlankReshuffle.setVisible(false);
		drawnCardLabels.add(lblCardBlankReshuffle);
		panel.add(lblCardBlankReshuffle);
		
		JLabel lblCardBack = new JLabel("");
		lblCardBack.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 245, 238), new Color(245, 222, 179), null, null));
		lblCardBack.setHorizontalAlignment(SwingConstants.CENTER);
		lblCardBack.setIcon(new ImageIcon(GUI.class.getResource("/attackModifers/Attack Modifier - Back.jpg")));
		lblCardBack.setBounds(297, 294, 437, 296);
		drawnCardLabels.add(lblCardBack);
		panel.add(lblCardBack);
		
		JButton btnDraw = new JButton("");
		btnDraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IAttackModifierCard drawnCard = deck.draw();
				
				lblCurse.setVisible(false);
				lblMiss.setVisible(false);
				lblMinusTwo.setVisible(false);
				lblMinusOne.setVisible(false);
				lblNetural.setVisible(false);
				lblPlusOne.setVisible(false);
				lblPlusTwo.setVisible(false);
				lblDoubleDamage.setVisible(false);
				lblBless.setVisible(false);
				
				lblCardBack.setVisible(false);
				lblCardBlank.setVisible(false);
				lblCardBlankReshuffle.setVisible(false);
				
				switch (drawnCard.getType()) {
				case CURSE:
					lblCurse.setVisible(true);
					lblCardBlankReshuffle.setVisible(true);
					btnDraw.setEnabled(false);
					break;
				case MISS:
					lblMiss.setVisible(true);
					lblCardBlankReshuffle.setVisible(true);
					btnDraw.setEnabled(false);
					break;
				case MINUSONE:
					lblMinusOne.setVisible(true);
					lblCardBlank.setVisible(true);
					break;
				case MINUSTWO:
					lblMinusTwo.setVisible(true);
					lblCardBlank.setVisible(true);
					break;
				case NEUTRAL:
					lblNetural.setVisible(true);
					lblCardBlank.setVisible(true);
					break;
				case PLUSONE:
					lblPlusOne.setVisible(true);
					lblCardBlank.setVisible(true);
					break;
				case PLUSTWO:
					lblPlusTwo.setVisible(true);
					lblCardBlank.setVisible(true);
					break;
				case DOUBLEDAMAGE:
					lblDoubleDamage.setVisible(true);
					lblCardBlankReshuffle.setVisible(true);
					btnDraw.setEnabled(false);
					break;
				case BLESS:
					lblBless.setVisible(true);
					lblCardBlankReshuffle.setVisible(true);
					btnDraw.setEnabled(false);
					break;
				default:
					break;
				
				}
			}
		});
		
		btnDraw.addMouseListener(new MouseListener() {
			private Point location = drawnCardLabels.get(0).getLocation();

			@Override
			public void mousePressed(MouseEvent e) {
				for (JComponent drawnCardLabel : drawnCardLabels) {
					moveJComponent(new Point(location.x, location.y + 1), drawnCardLabel);
					lblMask.setVisible(true);
				}		
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				for (JComponent drawnCardLabel : drawnCardLabels) {
					moveJComponent(location, drawnCardLabel);	
					lblMask.setVisible(false);
				}				
			}

			@Override
			public void mouseEntered(MouseEvent e) { }

			@Override
			public void mouseExited(MouseEvent e) { }

			@Override
			public void mouseClicked(MouseEvent e) { }
		});
		
		btnDraw.setFont(new Font("Pirata One", Font.PLAIN, 36));
		btnDraw.setForeground(new Color(255, 245, 238));
		btnDraw.setOpaque(false);
		btnDraw.setContentAreaFilled(false);
		btnDraw.setBorderPainted(false);
		btnDraw.setFocusPainted(false);
		btnDraw.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 245, 238), new Color(245, 222, 179), null, null));
		btnDraw.setBounds(297, 294, 437, 296);
		panel.add(btnDraw);
		
		CircleButton btnShuffle = new CircleButton("");
		btnShuffle.addMouseListener(new MouseListener() {
			private Point location = lblShuffle.getLocation();

			@Override
			public void mousePressed(MouseEvent e) {
				moveJComponent(new Point(location.x, location.y + 1), lblShuffle);			
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				moveJComponent(location, lblShuffle);				
			}

			@Override
			public void mouseEntered(MouseEvent e) { }

			@Override
			public void mouseExited(MouseEvent e) { }

			@Override
			public void mouseClicked(MouseEvent e) { }
		});
		
		btnShuffle.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				deck.shuffle();
				
				lblCurse.setVisible(false);
				lblMiss.setVisible(false);
				lblMinusTwo.setVisible(false);
				lblMinusOne.setVisible(false);
				lblNetural.setVisible(false);
				lblPlusOne.setVisible(false);
				lblPlusTwo.setVisible(false);
				lblDoubleDamage.setVisible(false);
				lblBless.setVisible(false);
				
				lblCardBlank.setVisible(false);
				lblCardBlankReshuffle.setVisible(false);
				lblCardBack.setVisible(true);
				
				btnDraw.setEnabled(true);
				
			}
		});
		

		btnShuffle.setOpaque(false);
		btnShuffle.setContentAreaFilled(false);
		btnShuffle.setBorderPainted(false);
		btnShuffle.setFocusPainted(false);
		btnShuffle.setBounds(475, 602, 64, 46);
		panel.add(btnShuffle);
		
	}
	
	private void moveJComponent(final Point p, JComponent component) {
	    SwingUtilities.invokeLater(new Runnable() {
	      @Override
	      public void run() {
	    	  component.setLocation(p);
	      }
	    });
	  }
}
