package boardGame;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Win_Screen {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Win_Screen window = new Win_Screen();
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
	public Win_Screen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(300, 0, 750, 625);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Game End Screen setup
		JLabel win = new JLabel("");
		win.setBounds(0, 0, 750, 603);
		Image w = new ImageIcon(this.getClass().getResource("/win_screen.png")).getImage();
		Image w1 = w.getScaledInstance(win.getWidth(), win.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon w2 = new ImageIcon(w1);
		frame.getContentPane().setLayout(null);
		
		JButton btnPlayAgain = new JButton("");
		btnPlayAgain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Checkers_Screen cs = new Checkers_Screen();
				cs.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnPlayAgain.setBorderPainted(false);
		btnPlayAgain.setBounds(284, 338, 178, 47);
		frame.getContentPane().add(btnPlayAgain);
		
		JButton btnMainMenu = new JButton("");
		btnMainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main_Screen ms = new Main_Screen();
				ms.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnMainMenu.setBorderPainted(false);
		btnMainMenu.setBounds(281, 407, 183, 48);
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
		btnQuitGame.setBounds(289, 476, 171, 46);
		frame.getContentPane().add(btnQuitGame);
		win.setIcon(w2);
		
		frame.getContentPane().add(win);
	}

}
