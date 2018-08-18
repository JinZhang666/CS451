package boardGame;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class About_Screen {

	JFrame frame;

	/**
	 * Launch the about screen.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					About_Screen window = new About_Screen();
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
	public About_Screen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//About Screen setup
		JLabel about = new JLabel("");
		about.setBounds(0, 0, 450, 278);
		Image a = new ImageIcon(this.getClass().getResource("/about_screen.png")).getImage();
		Image a1 = a.getScaledInstance(about.getWidth(), about.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon a2 = new ImageIcon(a1);
		about.setIcon(a2);
		
		JButton btnAboutToMain = new JButton("");
		btnAboutToMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main_Screen ms = new Main_Screen();
				ms.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnAboutToMain.setOpaque(false);
		btnAboutToMain.setContentAreaFilled(false);
		btnAboutToMain.setBorderPainted(false);
		btnAboutToMain.setBounds(167, 73, 27, 29);

		frame.getContentPane().add(btnAboutToMain);
		frame.getContentPane().add(about);
	}

}
