package boardGame;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;


public class Login_Screen {

	JFrame frame;
	private JTextField txtHghs;

	/**
	 * Launch the login screen.
	 */
	public static void main(String args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_Screen window = new Login_Screen();
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
	public Login_Screen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(300, 0, 750, 625);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		//Login Screen setup
		JLabel login = new JLabel("");
		login.setBounds(0, 0, 750, 603);
		Image l = new ImageIcon(this.getClass().getResource("/login_screen.png")).getImage();
		Image l1 = l.getScaledInstance(login.getWidth(), login.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon l2 = new ImageIcon(l1);
		login.setIcon(l2);
		
		JTextField txtName = new JTextField();
		txtName.setFont(new Font("American Typewriter", Font.PLAIN, 28));
		txtName.setBounds(452, 196, 221, 66);
		
		JButton btnConfirm = new JButton("");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main_Screen ms = new Main_Screen();
				ms.frame.setVisible(true);
				frame.dispose();
			}
		});
		
		btnConfirm.setOpaque(false);
		btnConfirm.setContentAreaFilled(false);
		btnConfirm.setBorderPainted(false);
		btnConfirm.setBounds(548, 309, 117, 37);
		
		frame.getContentPane().add(txtName);
		frame.getContentPane().add(btnConfirm);
		frame.getContentPane().add(login);
	
		
	}
}
