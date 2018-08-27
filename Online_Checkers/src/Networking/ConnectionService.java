package Networking;

import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import appwarp.WarpController;
import appwarp.WarpListener;


public class ConnectionService implements WarpListener{
	private final String tryingToConnect = "Connecting to AppWarp";
	private final String errorInConnection = "Error in Connection, Go Back";
	private final String waitForOtherUser = "Creating a new room for you, then you can wait for other user";
	
	private String state = "connecting";
	
	private String msg = tryingToConnect;
 
	public ConnectionService() {
		WarpController.getInstance().setListener(this);
        showConnectStatusWindow(msg);				

	}
	
	//JIN
	static public void showConnectStatusWindow(String msg) {
		/*ImageIcon icon = new ImageIcon("data/connection_duck.png");
		SwingUtilities.invokeLater(new Runnable() {
		public void run() {
			JOptionPane.showMessageDialog(null, msg, "Connecting...", JOptionPane.INFORMATION_MESSAGE, icon);
		}
		});
		*/
        
		/*
				JFrame fr = new JFrame();
				JDialog jd = new JDialog(fr, "test", true);
				JOptionPane pane = new JOptionPane(msg);
				jd.setContentPane(pane);
				jd.pack();
				jd.setVisible(true);
			    System.out.println("Going to dispose");
			    jd.setVisible(false);
				jd.dispose();		
*/
		ImageIcon icon = new ImageIcon("data/connection_duck.png");
		JOptionPane m = new JOptionPane(msg,  JOptionPane.INFORMATION_MESSAGE);
		m.setIcon(icon);
		JDialog dlg = m.createDialog("Connecting...");
		dlg.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		new Thread(new Runnable() {
			public void run() {
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				dlg.setVisible(false);
			}}).start();
     	dlg.setVisible(true);	

		}
	
	@Override
	public void onError (String message) {
		this.msg = errorInConnection;
	}
	
	@Override
	public void onGameStarted (String message) {
		this.msg = "Game Start";
		System.out.println("Going to show the game start status");
		showConnectStatusWindow(msg);	
	}

	@Override
	public void onGameFinished (int code, boolean isRemote) {

	}
	
	@Override
	public void onGameUpdateReceived (String message) {
		
	}

	@Override
	public void onWaitingStarted(String message) {
		this.msg = waitForOtherUser;
		System.out.println("Going to show the waiing status");
		showConnectStatusWindow(msg);				
		
	}

}
