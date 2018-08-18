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


public class Login_Screen {

	JFrame frame;

	/**
	 * Launch the credit screen.
	 */
	public static void main(String[] args) {
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
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		//Login Screen setup
		JLabel login = new JLabel("");
		login.setBounds(0, 0, 450, 278);
		Image l = new ImageIcon(this.getClass().getResource("/login_screen.png")).getImage();
		Image l1 = l.getScaledInstance(login.getWidth(), login.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon l2 = new ImageIcon(l1);
		login.setIcon(l2);
		
		JTextField textField = new JTextField();
		textField.setOpaque(false);
		textField.setBounds(269, 91, 130, 29);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
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
		btnConfirm.setBounds(308, 137, 117, 29);
		
		frame.getContentPane().add(btnConfirm);
		frame.getContentPane().add(login);
	
		
	}
	

}
