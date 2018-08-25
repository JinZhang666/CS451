package boardGame;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Game_End_Screen {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Game_End_Screen window = new Game_End_Screen();
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
	public Game_End_Screen() {
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
		JLabel end = new JLabel("");
		end.setBounds(0, 0, 750, 603);
		Image e = new ImageIcon(this.getClass().getResource("/game_end_screen.png")).getImage();
		Image e1 = e.getScaledInstance(end.getWidth(), end.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon e2 = new ImageIcon(e1);
		end.setIcon(e2);
		
		frame.getContentPane().add(end);
	}

}
