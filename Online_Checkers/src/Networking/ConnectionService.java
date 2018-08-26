package Networking;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import appwarp.WarpController;
import appwarp.WarpListener;

public class ConnectionService implements WarpListener{
	private final String tryingToConnect = "Connecting to AppWarp";
	private final String errorInConnection = "Error in Connection, Go Back";
	private final String waitForOtherUser = "Waiting for other user";
	
	private String msg = tryingToConnect;
 
	public ConnectionService() {
		WarpController.getInstance().setListener(this);
	}
	
	//JIN
	public void showConnectStatusWindow(String msg) {
		ImageIcon icon = new ImageIcon("data/connection_duck.png");
		JOptionPane.showMessageDialog(null, msg, "Connecting...", JOptionPane.INFORMATION_MESSAGE, icon);
	}
	
	@Override
	public void onError (String message) {
		this.msg = errorInConnection;
        this.showConnectStatusWindow(this.msg);
	}
	
	@Override
	public void onGameStarted (String message) {
		this.msg = "Game Start";
	    this.showConnectStatusWindow(this.msg);
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
	    this.showConnectStatusWindow(this.msg);
	    
	}

}
