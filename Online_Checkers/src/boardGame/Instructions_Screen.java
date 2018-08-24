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

public class Instructions_Screen {

	JFrame frame;

	/**
	 * Launch the instructions screen.
	 */
	public static void main(String args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Instructions_Screen window = new Instructions_Screen();
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
	public Instructions_Screen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 750, 625);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//Instructions Screen setup
		JLabel instructions = new JLabel("");
		instructions.setBounds(0, 0, 750, 603);
		Image i = new ImageIcon(this.getClass().getResource("/instructions_screen.png")).getImage();
		Image i1 = i.getScaledInstance(instructions.getWidth(), instructions.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon i2 = new ImageIcon(i1);
		instructions.setIcon(i2);
		
		JButton btnInstrucToMain = new JButton("");
		btnInstrucToMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main_Screen ms = new Main_Screen();
				ms.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnInstrucToMain.setOpaque(false);
		btnInstrucToMain.setContentAreaFilled(false);
		btnInstrucToMain.setBorderPainted(false);
		btnInstrucToMain.setBounds(232, 165, 39, 37);
		
		JTextArea instructions_text = new JTextArea(5, 200);
		instructions_text.setOpaque(false);
		instructions_text.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(instructions_text);
		scrollPane.setOpaque(false);
		scrollPane.setBounds(181, 232, 378, 348);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setPreferredSize(new Dimension(222, 160));
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
		frame.getContentPane().add(btnInstrucToMain);
		frame.getContentPane().add(instructions);
	}

}
