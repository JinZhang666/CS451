package boardGame;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import java.awt.Font;

public class Game_End_Screen {

	JFrame frame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Game_End_Screen window = new Game_End_Screen("");
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
	public Game_End_Screen(String p) {
		initialize(p);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String p) {
		frame = new JFrame();
		frame.setBounds(300, 0, 750, 625);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Tie Screen setup
		JLabel tie = new JLabel("");
		tie.setBounds(0, 0, 750, 603);
		Image t = new ImageIcon(this.getClass().getResource("/game_end_screen.png")).getImage();
		Image t1 = t.getScaledInstance(tie.getWidth(), tie.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon t2 = new ImageIcon(t1);
		frame.getContentPane().setLayout(null);
		
		JTextArea txtrCon = new JTextArea();
		txtrCon.setFont(new Font("American Typewriter", Font.PLAIN, 35));
		txtrCon.setOpaque(false);
		txtrCon.setEditable(false);
		txtrCon.setLineWrap(true);
		txtrCon.setWrapStyleWord(true);
		txtrCon.setText("Congratulations!");
		txtrCon.setBounds(231, 238, 285, 46);
		frame.getContentPane().add(txtrCon);
		
		JTextArea txtrName = new JTextArea();
		txtrName.setText(p);
		txtrName.setWrapStyleWord(true);
		txtrName.setOpaque(false);
		txtrName.setLineWrap(true);
		txtrName.setEditable(false);
		txtrName.setFont(new Font("American Typewriter", Font.PLAIN, 31));
		txtrName.setBounds(241, 296, 277, 47);
		frame.getContentPane().add(txtrName);
		
		JButton btnMainMenu = new JButton("");
		btnMainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main_Screen ms = new Main_Screen();
				ms.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnMainMenu.setBorderPainted(false);
		btnMainMenu.setBounds(281, 365, 183, 48);
		frame.getContentPane().add(btnMainMenu);
		
		JButton btnQuitGame = new JButton("");
		btnQuitGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Credit_Screen cs = new Credit_Screen();
				cs.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnQuitGame.setBorderPainted(false);
		btnQuitGame.setBounds(292, 448, 171, 46);
		frame.getContentPane().add(btnQuitGame);
		tie.setIcon(t2);
		
		frame.getContentPane().add(tie);
	}

}
