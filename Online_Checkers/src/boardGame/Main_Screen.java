package boardGame;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main_Screen {

	JFrame frame;

	/**
	 * Launch the Window.
	 */
	public static void main(String args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main_Screen window = new Main_Screen();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	/**
	 * Create the Window.
	 */
	public Main_Screen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Main Screen setup
		JLabel main = new JLabel("");
		main.setBounds(0, 0, 450, 278);
		Image m = new ImageIcon(this.getClass().getResource("/main_screen.png")).getImage();
		Image m1 = m.getScaledInstance(main.getWidth(), main.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon m2 = new ImageIcon(m1);
		main.setIcon(m2);
		
		JButton btnStartGame = new JButton("");
		btnStartGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Checkers_Screen cs = new Checkers_Screen();
				cs.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnStartGame.setOpaque(false);
		btnStartGame.setContentAreaFilled(false);
		btnStartGame.setBorderPainted(false);
		btnStartGame.setBounds(277, 94, 117, 29);
		
		JButton btnExitGame = new JButton("");
		btnExitGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Credit_Screen cs = new Credit_Screen();
				cs.frame.setVisible(true);
				frame.dispose();
				/*
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frame.setVisible(false);
				*/
			}
		});
		btnExitGame.setOpaque(false);
		btnExitGame.setContentAreaFilled(false);
		btnExitGame.setBorderPainted(false);
		btnExitGame.setBounds(277, 135, 117, 29);
		
		JButton btnInstructions = new JButton("");
		btnInstructions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Instructions_Screen is = new Instructions_Screen();
				is.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnInstructions.setOpaque(false);
		btnInstructions.setContentAreaFilled(false);
		btnInstructions.setBorderPainted(false);
		btnInstructions.setBounds(277, 176, 117, 29);
		
		JButton btnAbout = new JButton("");
		btnAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				About_Screen as = new About_Screen();
				as.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnAbout.setOpaque(false);
		btnAbout.setContentAreaFilled(false);
		btnAbout.setBorderPainted(false);
		btnAbout.setBounds(277, 212, 117, 29);
		
		frame.getContentPane().add(btnStartGame);
		frame.getContentPane().add(btnExitGame);
		frame.getContentPane().add(btnInstructions);
		frame.getContentPane().add(btnAbout);
		frame.getContentPane().add(main);
	}

}
