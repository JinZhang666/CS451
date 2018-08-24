package boardGame;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;


public class Splash_Screen {

	JFrame frame;

	/**
	 * Launch the splash screen.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Splash_Screen window = new Splash_Screen();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the window.
	 */
	public Splash_Screen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 750, 625);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Splash Screen setup
		JLabel splash = new JLabel("");
		splash.setBounds(0, 0, 750, 603);
		Image s = new ImageIcon(this.getClass().getResource("/splash_screen.png")).getImage();
		Image s1 = s.getScaledInstance(splash.getWidth(), splash.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon s2 = new ImageIcon(s1);
		splash.setIcon(s2);
		
		JButton btnEnterGame = new JButton("");
		btnEnterGame.setOpaque(false);
		btnEnterGame.setContentAreaFilled(false);
		btnEnterGame.setBorderPainted(false);
		btnEnterGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login_Screen ls = new Login_Screen();
				ls.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnEnterGame.setBounds(458, 235, 200, 49);
		
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(btnEnterGame);
		frame.getContentPane().add(splash);
	}

}
