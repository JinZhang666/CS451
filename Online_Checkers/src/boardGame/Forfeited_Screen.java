package boardGame;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.Font;

public class Forfeited_Screen {

	JFrame frame;
	/**
	 * Launch the application.
	 */
	public static void main(String args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Forfeited_Screen window = new Forfeited_Screen("");
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
	public Forfeited_Screen(String p) {
		initialize(p);
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String p) {
		frame = new JFrame();
		frame.setBounds(300, 0, 750, 625);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Forfeited Screen setup
		JLabel forfeit = new JLabel("");
		forfeit.setBounds(0, 0, 750, 603);
		Image f = new ImageIcon(this.getClass().getResource("/forfeit_screen.png")).getImage();
		Image f1 = f.getScaledInstance(forfeit.getWidth(), forfeit.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon f2 = new ImageIcon(f1);
		forfeit.setIcon(f2);
		frame.getContentPane().setLayout(null);
		
		JButton btnMainMenu = new JButton("");
		btnMainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main_Screen ms = new Main_Screen();
				ms.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnMainMenu.setBorderPainted(false);
		btnMainMenu.setBounds(277, 362, 193, 46);
		
		JButton btnQuitGame = new JButton("");
		btnQuitGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Credit_Screen cs = new Credit_Screen();
				cs.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnQuitGame.setBorderPainted(false);
		btnQuitGame.setBounds(277, 446, 193, 51);
		
		JTextArea txtrPlayer = new JTextArea();
		txtrPlayer.setText(p);
		txtrPlayer.setFont(new Font("American Typewriter", Font.PLAIN, 32));
		txtrPlayer.setOpaque(false);
		txtrPlayer.setLineWrap(true);
		txtrPlayer.setWrapStyleWord(true);
		txtrPlayer.setEditable(false);
		txtrPlayer.setBounds(288, 249, 182, 43);
		frame.getContentPane().add(txtrPlayer);
		
		JTextArea txtrForfeited = new JTextArea();
		txtrForfeited.setText("Forfeited.");
		txtrForfeited.setOpaque(false);
		txtrForfeited.setWrapStyleWord(true);
		txtrForfeited.setFont(new Font("American Typewriter", Font.PLAIN, 32));
		txtrForfeited.setLineWrap(true);
		txtrForfeited.setBounds(294, 304, 159, 46);
		frame.getContentPane().add(txtrForfeited);
		
		frame.getContentPane().add(btnMainMenu);
		frame.getContentPane().add(btnQuitGame);
		frame.getContentPane().add(forfeit);
	}
}
