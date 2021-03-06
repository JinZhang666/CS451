/*
 * Author: Kimberly Ly
 * Date: 	8/27/2018
 * Updates: 8/19/2018 - Integrated this window into the overall application flow 
 * 				(splash screen -> login screen -> main screen's "Start Game" -> checkers screen)
 * 			8/19/2018 and on - Work added to start the game between the 2 players
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

import appwarp.WarpController;
import appwarp.WarpListener;

import java.awt.EventQueue;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.Observable;
import java.util.Observer;
import java.awt.Insets;

public class Checkers_Screen implements WarpListener {

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
	JButton confirmButton = new JButton("CONFIRM MOVE");
	JButton cancelButton = new JButton("CANCEL MOVE");
	
	static int currentPlayer = 1; // makes the Player One the player to start the game off
	static boolean gameEnd = false;
	
	public static void main(String[] args) {
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
		playGame(currentPlayer);
		WarpController.getInstance().setListener(this);
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
		//frame.setSize(700, 600);
		frame.setBounds(300, 0, 750, 625);
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
				Credit_Screen cs = new Credit_Screen();
				cs.frame.setVisible(true);
				frame.dispose();
			}
		});
		instructions.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				In_Game_Instructions_Screen is = new In_Game_Instructions_Screen();
				is.frame.setVisible(true);
			}
		});
		about.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				In_Game_About_Screen as = new In_Game_About_Screen();
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
		GridBagConstraints gbc_leftPanel = new GridBagConstraints();
		gbc_leftPanel.insets = new Insets(0, 0, 5, 5);
		gbc_leftPanel.gridx = 0;
		gbc_leftPanel.gridy = 0;
		pane.add(leftPanel, gbc_leftPanel);
		
		rightPanel.setBorder(lowerEtched);
		gbcOne.weightx = 0.25;
		gbcOne.gridx = 1;
		gbcOne.gridy = 0;
		gblOne.setConstraints(rightPanel, gbcOne);
		GridBagConstraints gbc_rightPanel = new GridBagConstraints();
		gbc_rightPanel.insets = new Insets(0, 0, 5, 0);
		gbc_rightPanel.gridx = 1;
		gbc_rightPanel.gridy = 0;
		pane.add(rightPanel, gbc_rightPanel);
		
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
		
		forfeitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(currentPlayer ==1) {
					Forfeited_Screen fs = new Forfeited_Screen("Player One");
					fs.frame.setVisible(true);
					frame.dispose();
				}else {
					Forfeited_Screen fs = new Forfeited_Screen("Player Two");
					fs.frame.setVisible(true);
					frame.dispose();
				}
			}
		});
		
		forfeitButton.setFocusable(false);
		GridBagConstraints gbc_confirmButton = new GridBagConstraints();
		gbc_confirmButton.gridx = 1;
		gbc_confirmButton.gridy = 1;
		frame.getContentPane().add(forfeitButton, gbc_confirmButton);
		
		confirmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				moveCount++;
				System.out.println("Move count " + moveCount);
				
				if(moveCount != 40 || kingCount > 0) {

					//remove captured piece
					if(Validation.capture != null) {
						mainBoard.remove(Validation.capture);
						
						//count how many pieces are captured
						if(currentPlayer == 1) {
							capturedTwo++;
							System.out.println("cap 2 " + capturedTwo);
							if(capturedTwo == 12) {
								Game_End_Screen ge = new Game_End_Screen("Player One Won!");
								ge.frame.setVisible(true);
								frame.dispose();
							}
						}else {
							capturedOne++;
							System.out.println("cap 1 " + capturedOne);
							if(capturedOne == 12) {
								Game_End_Screen ge = new Game_End_Screen("Player Two Won!");
								ge.frame.setVisible(true);
								frame.dispose();
							}
						}
						
						//check if more jumps are available
						if(mainBoard.getSelectedPiece().isRegularPiece()) {
							if(toRow > 1 && toRow < 6) {
								canMakeJump = Validation.canMakeJump(mainBoard.getSelectedPiece(), mainBoard, toRow, toCol);
							}
						}else if(mainBoard.getSelectedPiece().isKingPiece()) {
							canMakeJump = Validation.canMakeKingJump(mainBoard.getSelectedPiece(), mainBoard, toRow, toCol);
						}
					}
					Validation.capture = null;
					
					if(currentPlayer == 1) {
						//check if piece can make move jumps
						if(!canMakeJump) {
							currentPlayer = 2;
						}else {
							System.out.print("More jumps are available with that same piece.");
						}
						//if player1 reached the opposite side it becomes king
						if(toRow == 7 && mainBoard.getSelectedPiece().isRegularPiece()) {
							RoundKingPiece king = new RoundKingPiece(Color.red);
							mainBoard.remove(mainBoard.getSelectedPiece());
							mainBoard.place(king, toRow, toCol);
							kingCount++;
							currentPlayer = 2;
						}
						currentPlayer = 2;
					}else if(currentPlayer == 2){
						//check if piece can make more jumps
						if(!canMakeJump) {
							currentPlayer = 1;
						}else {
							System.out.print("More jumps are available with that same piece.");
						}
						//if player2 reached the opposite side it becomes king
						if(toRow == 0 && mainBoard.getSelectedPiece().isRegularPiece()) {
							RoundKingPiece king = new RoundKingPiece(Color.black);
							mainBoard.remove(mainBoard.getSelectedPiece());
							mainBoard.place(king, toRow, toCol);
							kingCount++;
							currentPlayer = 1;
						}
						currentPlayer = 1;
					}
					canMakeJump = false;
					alreadyMoved = false;
					playGame(currentPlayer);
					
				}else if(moveCount == 40 && kingCount == 0){
					Tie_Screen tie = new Tie_Screen();
					tie.frame.setVisible(true);
					frame.dispose();
				}
				
				canMakeJump = false;
				alreadyMoved = false;
				playGame(currentPlayer);
			}
		});
		
		confirmButton.setFocusable(false);
		rightPanel.add(confirmButton);
		
		//cancel move
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alreadyMoved = false;
				mainBoard.remove(mainBoard.getSelectedPiece());
				mainBoard.place(mainBoard.getSelectedPiece(), tempRow, tempCol);
				playGame(currentPlayer);
			}
		});
		cancelButton.setFocusable(false);
		rightPanel.add(cancelButton);
		
		frame.setVisible(true);
	}
	
	static int fromRow = -1;
	static int fromCol = -1;
	static int toRow = -1;
	static int toCol = -1;
	static int tempRow = -1;
	static int tempCol = -1;
	static int moveCount = 0;
	static int kingCount = 0;
	static int capturedOne = 0;
	static int capturedTwo = 0;
	static boolean alreadyMoved;
	static boolean isValidMove;
	static boolean canMakeJump;

	/*
	 * Check whether the move is valid and alternating between the two players
	 */
	
	public static void moveValidation(int nextPlayer) {
		mainBoard.dragEvent.addObserver(new Observer() {
			@Override
			public void update(Observable o, Object arg) {
				fromRow = mainBoard.getSelectedRow();
				fromCol = mainBoard.getSelectedColumn();
				toRow = mainBoard.getPlacedRow();
				toCol = mainBoard.getPlacedColC();
				tempRow = mainBoard.getSelectedRow();
				tempCol = mainBoard.getSelectedColumn();

				//check if move is valid
				isValidMove = Validation.isValidMove(mainBoard.getSelectedPiece(), mainBoard, fromRow, fromCol, toRow, toCol);
								
				if(!isValidMove || alreadyMoved) {
					//return piece to original square if move is not valid
					mainBoard.remove(mainBoard.getSelectedPiece());
					mainBoard.place(mainBoard.getSelectedPiece(), fromRow, fromCol);
					alreadyMoved = false;
				}else {
					//alreadyMoved = true;
				}

			    
							String player1PiecesInfo = "";
							String player2PiecesInfo = "";
						    for(int i = 0; i < 12; i++) {
				
						    	
								   player1PiecesInfo += Integer.toString(playerOnePieces[i].getRow());
								   player1PiecesInfo += Integer.toString(playerOnePieces[i].getColumn());
								   player2PiecesInfo += Integer.toString(playerTwoPieces[i].getRow());
								   player2PiecesInfo += Integer.toString(playerTwoPieces[i].getColumn());

							}
							System.out.println(player1PiecesInfo+ "||" + player2PiecesInfo);
							String allPiecesInfo = player1PiecesInfo + "||" + player2PiecesInfo;
					    	
							try {
					    		WarpController.getInstance().sendGameUpdate(allPiecesInfo);
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
						
					        System.out.println("Get all the info after I action");	
			
			
			
			
			}

		});
	}
	
    @Override
	public void onWaitingStarted(String message) {
    	
    }
	
    @Override
	public void onError(String message) {
    
    }
	
    @Override
	public void onGameStarted(String message) {
    	
    }
	
    @Override
	public void onGameFinished(int code, boolean isRemote) {
    	
    }
	
    //JIN
    @Override
	public void onGameUpdateReceived(String message) {
    	System.out.println("checker_screen");
    	System.out.println(message);
    	String player1Pieces = message.substring(0, message.indexOf("||"));
		String player2Pieces = message.substring(message.indexOf("||")+2, message.length());
		System.out.println(player1Pieces);
		System.out.println(player2Pieces);
		
		for(int i=0; i<24; i=i+2) {
			mainBoard.remove(playerOnePieces[i/2]);
			int currentPieceRow1 = Integer.parseInt(player1Pieces.substring(i,i+1));
			//System.out.println("The player one piece #" + i + " row: " + currentPieceRow1);
			int currentPieceColumn1 = Integer.parseInt(player1Pieces.substring(i+1,i+2));
			//System.out.println("The player one piece #" + i + " column: " + currentPieceColumn1);
			playerOnePieces[i/2].place(mainBoard, currentPieceRow1, currentPieceColumn1);
			
			mainBoard.remove(playerTwoPieces[i/2]);
			int currentPieceRow2 = Integer.parseInt(player2Pieces.substring(i,i+1));
			int currentPieceColumn2 = Integer.parseInt(player2Pieces.substring(i+1,i+2));
			playerTwoPieces[i/2].place(mainBoard, currentPieceRow2, currentPieceColumn2);
		}
    }
	
	/*
	 * Player 1 starts first 
	 * it calls the moveValidation function
	 * to validates moves and alternates
	 */
	public static void playGame(int player){
		
		if(player == 1){
			for(int i = 0; i < numOfPlayerPieces; i++){
				playerOnePieces[i].setDraggable(true);
				playerTwoPieces[i].setDraggable(false);
			}
			
			moveValidation(2);
		}
		else if(player == 2){
			for(int i = 0; i < numOfPlayerPieces; i++){
				playerOnePieces[i].setDraggable(false);
				playerTwoPieces[i].setDraggable(true);
			}

			moveValidation(1);
		}
    }
}