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
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class In_Game_About_Screen {

	JFrame frame;

	/**
	 * Launch the about screen.
	 */
	public static void main(String args) {
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
	public In_Game_About_Screen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(450, 0, 400, 450);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		//About Screen setup
		JLabel about = new JLabel("");
		about.setFont(new Font("American Typewriter", Font.PLAIN, 16));
		about.setBounds(0, 0, 400, 428);
		Image a = new ImageIcon(this.getClass().getResource("/in_game_about_screen.png")).getImage();
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
		btnAboutToMain.setBounds(274, 166, 48, 42);
		
		JTextArea txtrClientVersion = new JTextArea();
		txtrClientVersion.setFont(new Font("American Typewriter", Font.PLAIN, 16));
		txtrClientVersion.setOpaque(false);
		txtrClientVersion.setEditable(false);
		txtrClientVersion.setText("Client Version:");
		txtrClientVersion.setBounds(147, 109, 112, 26);
		
		JTextPane txtVersion = new JTextPane();
		txtVersion.setOpaque(false);
		txtVersion.setEditable(false);
		txtVersion.setBounds(147, 147, 112, 26);
		try {
			FileReader in = new FileReader("data/version.txt");
			BufferedReader br = new BufferedReader(in);
			txtVersion.read(br, null);
			br.close();
			txtVersion.requestFocus();
		}
			catch(Exception e) {
				JOptionPane.showMessageDialog(null, "Instructions not available");
			}
        SimpleAttributeSet attrs=new SimpleAttributeSet();
        StyleConstants.setAlignment(attrs,StyleConstants.ALIGN_CENTER);
        StyledDocument version = (StyledDocument)txtVersion.getDocument();
        version.setParagraphAttributes(0,version.getLength()-1,attrs,false);
		
		JTextArea txtrPatchLog = new JTextArea();
		txtrPatchLog.setFont(new Font("American Typewriter", Font.PLAIN, 16));
		txtrPatchLog.setOpaque(false);
		txtrPatchLog.setText("Patch Log: ");
		txtrPatchLog.setBounds(162, 198, 83, 27);
		
		JTextPane txtLog = new JTextPane();
		txtLog.setOpaque(false);
		txtLog.setEditable(false);
		txtLog.setBounds(109, 237, 190, 118);
		try {
			FileReader in = new FileReader("data/log.txt");
			BufferedReader br = new BufferedReader(in);
			txtLog.read(br, null);
			br.close();
			txtLog.requestFocus();
		}
			catch(Exception e) {
				JOptionPane.showMessageDialog(null, "Instructions not available");
			}
        SimpleAttributeSet attrs2 = new SimpleAttributeSet();
        StyleConstants.setAlignment(attrs2,StyleConstants.ALIGN_CENTER);
        StyledDocument log=(StyledDocument)txtLog.getDocument();
        log.setParagraphAttributes(0,log.getLength()-1,attrs2,false);
        
        frame.getContentPane().setLayout(null);
        frame.getContentPane().add(btnAboutToMain);
        frame.getContentPane().add(txtrClientVersion);
        frame.getContentPane().add(txtVersion);
        frame.getContentPane().add(txtrPatchLog);
		frame.getContentPane().add(txtLog);
		frame.getContentPane().add(about);
	}
}
