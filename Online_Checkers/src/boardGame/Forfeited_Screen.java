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

public class Forfeited_Screen {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Forfeited_Screen window = new Forfeited_Screen();
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
	public Forfeited_Screen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(300, 0, 750, 625);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Forfeited Screen setup
		JLabel forfeit = new JLabel("");
		forfeit.setBounds(0, 0, 750, 603);
		Image f = new ImageIcon(this.getClass().getResource("/forfeited_screen.png")).getImage();
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
		btnMainMenu.setBounds(277, 330, 193, 46);
		
		JButton btnQuitGame = new JButton("");
		btnQuitGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnQuitGame.setBorderPainted(false);
		btnQuitGame.setBounds(277, 420, 193, 51);
		
		frame.getContentPane().add(btnMainMenu);
		frame.getContentPane().add(btnQuitGame);
		frame.getContentPane().add(forfeit);
	}
}
