package boardGame;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.FileReader;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Help_Screen {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Help_Screen window = new Help_Screen();
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
	public Help_Screen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 750, 625);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//Game End Screen setup
		JLabel help = new JLabel("");
		help.setBounds(0, 0, 750, 603);
		Image h = new ImageIcon(this.getClass().getResource("/help_screen.png")).getImage();
		Image h1 = h.getScaledInstance(help.getWidth(), help.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon h2 = new ImageIcon(h1);
		help.setIcon(h2);
		
		JTextArea instructions_text = new JTextArea(5, 200);
		instructions_text.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(instructions_text);
		scrollPane.setBounds(170, 153, 404, 373);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setPreferredSize(new Dimension(243, 174));
		try {
			FileReader in = new FileReader("data/instructions.txt");
			BufferedReader br = new BufferedReader(in);
			instructions_text.read(br, null);
			br.close();
			instructions_text.requestFocus();
		}
			catch(Exception e) {
				JOptionPane.showMessageDialog(null, "Instructions not available");
			}
		instructions_text.setLineWrap(true);
		instructions_text.setWrapStyleWord(true);
		
		frame.getContentPane().add(scrollPane);
		frame.getContentPane().add(help);
		
		
	}

}
