/*
 * Author: Kimberly Ly
 * Date: 	8/17/2018
 * Updates: 8/19/2018 - Integrated this window into the overall application flow 
 * 				(splash screen -> login screen -> main screen's "Start Game" -> checkers screen)
 * Description: This window displays the Checkers game where both players are playing on.
 */
package boardGame;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import java.awt.EventQueue;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.Observable;
import java.util.Observer;

public class Checkers_Screen {

	static JFrame frame;
	static Board mainBoard;
	int numOfRows = 8;
	int numOfColumns = 8;
	static final int numOfPlayerPieces = 12;
	String playerOne = "playerOne";
	String playerTwo = "playerTwo";
	static Piece[] playerOnePieces = new Piece[numOfPlayerPieces];
	static Piece[] playerTwoPieces = new Piece[numOfPlayerPieces];
	JLabel playerOneLabel = new JLabel("PLAYER 1");
	JLabel playerTwoLabel = new JLabel("PLAYER 2");
	JPanel boardDisplayPanel;
	JPanel leftPanel = new JPanel();
	JPanel rightPanel = new JPanel();
	Border lowerEtched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
	JButton forfeitButton = new JButton("FORFEIT GAME");
	
	static int currentPlayer = 1; // makes the Player One the player to start the game off
	static boolean gameEnd = true;
	
	public static void main(String args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Checkers_Screen window = new Checkers_Screen();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Checkers_Screen(){
		setUpBoard(mainBoard);
		initialize();
		playGame();
	}
	
	public void setUpBoard(Board b){
		// Creating the main Checkers board
		mainBoard = new Board(numOfRows, numOfColumns);
	
		// Creating the 2 sets of Checkers pieces and names them either
		// "playerOne" or "playerTwo"	
		for(int i = 0; i < numOfPlayerPieces; i++){
			playerOnePieces[i] = new RoundPiece(playerOne, new Color(255, 255, 204));
		}
		for(int i = 0; i < numOfPlayerPieces; i++){
			playerTwoPieces[i] = new RoundPiece(playerTwo, new Color(210, 180, 140));
		}
			
		// Setting the Checkers pieces onto the board
		playerOnePieces[0].place(mainBoard, 0, 1); playerOnePieces[1].place(mainBoard, 0, 3);
		playerOnePieces[2].place(mainBoard, 0, 5); playerOnePieces[3].place(mainBoard, 0, 7);
		playerOnePieces[4].place(mainBoard, 1, 0); playerOnePieces[5].place(mainBoard, 1, 2);
		playerOnePieces[6].place(mainBoard, 1, 4); playerOnePieces[7].place(mainBoard, 1, 6);
		playerOnePieces[8].place(mainBoard, 2, 1); playerOnePieces[9].place(mainBoard, 2, 3);
		playerOnePieces[10].place(mainBoard, 2, 5); playerOnePieces[11].place(mainBoard, 2, 7);
				
		playerTwoPieces[0].place(mainBoard, 5, 0); playerTwoPieces[1].place(mainBoard, 5, 2);
		playerTwoPieces[2].place(mainBoard, 5, 4); playerTwoPieces[3].place(mainBoard, 5, 6);
		playerTwoPieces[4].place(mainBoard, 6, 1); playerTwoPieces[5].place(mainBoard, 6, 3);
		playerTwoPieces[6].place(mainBoard, 6, 5); playerTwoPieces[7].place(mainBoard, 6, 7);
		playerTwoPieces[8].place(mainBoard, 7, 0); playerTwoPieces[9].place(mainBoard, 7, 2);
		playerTwoPieces[10].place(mainBoard, 7, 4); playerTwoPieces[11].place(mainBoard, 7, 6);
	}
	
	public void initialize(){
		/* 
		 * The board is drawn in a Swing JPanel, but we have to get this JPanel 
		 * and put it into our own GUI which is done by...
		 */
		boardDisplayPanel = mainBoard.getJPanel(); // main Checkers board display
		boardDisplayPanel.setMinimumSize(new Dimension(450, 450));
		boardDisplayPanel.setPreferredSize(new Dimension(450, 450));
		
		// Creating/setting up the main game window
		frame = new JFrame("Online Checkers");
		frame.setSize(700, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Setting up the menu bar GUI
		JMenuBar menuBar;
		JMenu file, help;
		JMenuItem exitGame, instructions, about;
		
		menuBar = new JMenuBar();
		file = new JMenu("File");
		file.setMnemonic(KeyEvent.VK_F);
		menuBar.add(file);
		exitGame = new JMenuItem("Exit", KeyEvent.VK_E);
		file.add(exitGame);
		
		help = new JMenu("Help");
		help.setMnemonic(KeyEvent.VK_H);
		menuBar.add(help);
		instructions = new JMenuItem("Instructions", KeyEvent.VK_I);
		help.add(instructions);
		about = new JMenuItem("About", KeyEvent.VK_A);
		help.add(about);
		
		frame.setJMenuBar(menuBar);
		
		// Setting up the menu bar functionality
		exitGame.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				frame.setVisible(false);
				frame.dispose();
			}
		});
		instructions.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Instructions_Screen is = new Instructions_Screen();
				is.frame.setVisible(true);
			}
		});
		about.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				About_Screen as = new About_Screen();
				as.frame.setVisible(true);
			}
		});
		
		/*
		 * Setting up the components on the window:
		 * 		Left Panel (which will contain 3 components) and the Right Panel 
		 * 		(which will contain buttons)
		 */
		Container pane = frame.getContentPane();
		GridBagLayout gblOne = new GridBagLayout();
		GridBagLayout gblTwo = new GridBagLayout();
		GridBagConstraints gbcOne = new GridBagConstraints();
		GridBagConstraints gbcTwo = new GridBagConstraints();
		pane.setLayout(gblOne);
		gbcOne.fill = GridBagConstraints.HORIZONTAL;
		
		leftPanel.setBorder(lowerEtched);		
		gbcOne.weightx = 0.75;
		gbcOne.gridx = 0;
		gbcOne.gridy = 0;
		gblOne.setConstraints(leftPanel, gbcOne);
		pane.add(leftPanel);
		
		rightPanel.setBorder(lowerEtched);
		gbcOne.weightx = 0.25;
		gbcOne.gridx = 1;
		gbcOne.gridy = 0;
		gblOne.setConstraints(rightPanel, gbcOne);
		pane.add(rightPanel);
		
		leftPanel.setLayout(gblTwo);
		gbcTwo.fill = GridBagConstraints.VERTICAL;
		
		gbcTwo.gridx = 0;
		gbcTwo.gridy = 0;
		gblTwo.setConstraints(playerOneLabel, gbcTwo);
		leftPanel.add(playerOneLabel);
		
		gbcTwo.gridx = 0;
		gbcTwo.gridy = 1;
		gblTwo.setConstraints(boardDisplayPanel, gbcTwo);
		leftPanel.add(boardDisplayPanel);
		
		gbcTwo.gridx = 0;
		gbcTwo.gridy = 2;
		gblTwo.setConstraints(playerTwoLabel, gbcTwo);
		leftPanel.add(playerTwoLabel);
		
		forfeitButton.setFocusable(false);
		rightPanel.add(forfeitButton);
		
		frame.setVisible(true);
	}
	
	public static void playGame(){
		if(currentPlayer == 1){
			for(int i = 0; i < numOfPlayerPieces; i++){
				playerOnePieces[i].setDraggable(true);
				playerTwoPieces[i].setDraggable(false);
				//System.out.println("    draggable = " + playerOnePieces[i].isDraggable());
				//System.out.println("    draggable = " + playerTwoPieces[i].isDraggable());
			}
			//currentPlayer = 2;
		}
		if(currentPlayer == 2){
			for(int i = 0; i < numOfPlayerPieces; i++){
				playerOnePieces[i].setDraggable(false);
				playerTwoPieces[i].setDraggable(true);
			}
			//currentPlayer = 1;
		}
    }
}
