package boardGame;

import java.awt.EventQueue;
import java.awt.Image;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Credit_Screen {
	
	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Credit_Screen window = new Credit_Screen();
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
	public Credit_Screen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//close window after 2 seconds
		Timer time = new Timer();
		time.schedule(new TimerTask(){
			@Override
			public void run() {
				frame.setVisible(false);
				frame.dispose();
			}
		}, 2000);
		
		
		frame = new JFrame();
		frame.setBounds(300, 0, 750, 625);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Credit Screen setup
		JLabel credit = new JLabel("");
		credit.setBounds(300, 0, 750, 603);
		Image c = new ImageIcon(this.getClass().getResource("/credits_screen.png")).getImage();
		Image c1 = c.getScaledInstance(credit.getWidth(), credit.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon c2 = new ImageIcon(c1);
		credit.setIcon(c2);
		
		frame.getContentPane().add(credit);
	}


}
