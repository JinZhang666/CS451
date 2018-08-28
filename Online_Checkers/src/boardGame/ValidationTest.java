package boardGame;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;

import org.junit.Before;
import org.junit.jupiter.api.Test;

class ValidationTest {
	Board mainBoard;
	
	@Test
	void testCanMakeJump() {
		mainBoard = new Board(8, 8);
		Piece[] playerOnePieces = new Piece[12];
		Piece[] playerTwoPieces = new Piece[12];
		for(int i = 0; i < 12; i++){
			playerOnePieces[i] = new RoundKingPiece("playerOne", new Color(255, 255, 204));
		}
		for(int i = 0; i < 12; i++){
			playerTwoPieces[i] = new RoundPiece("playerTwo", new Color(210, 180, 140));
		}
	
		// Setting the Checkers pieces onto the board
		playerOnePieces[0].place(mainBoard, 0, 1); playerOnePieces[1].place(mainBoard, 0, 3);
		playerOnePieces[2].place(mainBoard, 0, 5); playerOnePieces[3].place(mainBoard, 0, 7);
		playerOnePieces[4].place(mainBoard, 1, 0); playerOnePieces[5].place(mainBoard, 1, 2);
		playerOnePieces[6].place(mainBoard, 1, 4); playerOnePieces[7].place(mainBoard, 1, 6);
		playerOnePieces[8].place(mainBoard, 4, 1); playerOnePieces[9].place(mainBoard, 2, 3);//
		playerOnePieces[10].place(mainBoard, 2, 4); playerOnePieces[11].place(mainBoard, 2, 7);//
		
		playerTwoPieces[0].place(mainBoard, 5, 0); playerTwoPieces[1].place(mainBoard, 5, 2);//
		playerTwoPieces[2].place(mainBoard, 5, 4); playerTwoPieces[3].place(mainBoard, 5, 6);//
		playerTwoPieces[4].place(mainBoard, 6, 1); playerTwoPieces[5].place(mainBoard, 6, 3);
		playerTwoPieces[6].place(mainBoard, 6, 5); playerTwoPieces[7].place(mainBoard, 6, 7);
		playerTwoPieces[8].place(mainBoard, 7, 0); playerTwoPieces[9].place(mainBoard, 7, 2);
		playerTwoPieces[10].place(mainBoard, 7, 4); playerTwoPieces[11].place(mainBoard, 7, 6);
		//boolean m1 = Validation.canMakeJump(mainBoard.getPiece(0, 1), mainBoard);
		//boolean m2 = Validation.canMakeJump(mainBoard.getPiece(5, 0), mainBoard);
		
		//assertEquals("", false, m1);
		//assertEquals("", true, m2);
		
	}

	@Test
	void testCanMakeKingJump() {
		//fail("Not yet implemented");
	}

	@Test
	void testIsValidMove() {
		//fail("Not yet implemented");
	}

	@Test
	void testIsRegularMove() {
		mainBoard = new Board(8, 8);
		Piece[] playerOnePieces = new Piece[12];
		Piece[] playerTwoPieces = new Piece[12];
		for(int i = 0; i < 12; i++){
			playerOnePieces[i] = new RoundKingPiece("playerOne", new Color(255, 255, 204));
		}
		for(int i = 0; i < 12; i++){
			playerTwoPieces[i] = new RoundPiece("playerTwo", new Color(210, 180, 140));
		}
	
		// Setting the Checkers pieces onto the board
		playerOnePieces[0].place(mainBoard, 0, 1); playerOnePieces[1].place(mainBoard, 0, 3);
		playerOnePieces[2].place(mainBoard, 0, 5); playerOnePieces[3].place(mainBoard, 0, 7);
		playerOnePieces[4].place(mainBoard, 1, 0); playerOnePieces[5].place(mainBoard, 1, 2);
		playerOnePieces[6].place(mainBoard, 1, 4); playerOnePieces[7].place(mainBoard, 1, 6);
		playerOnePieces[8].place(mainBoard, 2, 1); playerOnePieces[9].place(mainBoard, 2, 3);//
		playerOnePieces[10].place(mainBoard, 2, 5); playerOnePieces[11].place(mainBoard, 2, 7);//
		
		playerTwoPieces[0].place(mainBoard, 5, 0); playerTwoPieces[1].place(mainBoard, 5, 2);//
		playerTwoPieces[2].place(mainBoard, 5, 4); playerTwoPieces[3].place(mainBoard, 5, 6);//
		playerTwoPieces[4].place(mainBoard, 6, 1); playerTwoPieces[5].place(mainBoard, 6, 3);
		playerTwoPieces[6].place(mainBoard, 6, 5); playerTwoPieces[7].place(mainBoard, 6, 7);
		playerTwoPieces[8].place(mainBoard, 7, 0); playerTwoPieces[9].place(mainBoard, 7, 2);
		playerTwoPieces[10].place(mainBoard, 7, 4); playerTwoPieces[11].place(mainBoard, 7, 6);
		Piece p = mainBoard.getPiece(1, 4);
		//test directional movement of king (should just immediately fail because king
		boolean a1 = Validation.isRegularMove(p, mainBoard, 1, 4);
		boolean a2 = Validation.isRegularMove(p, mainBoard, 0, 4);
		boolean a3 = Validation.isRegularMove(p, mainBoard, 2, 4);
		boolean a4 = Validation.isRegularMove(p, mainBoard, 2, 3);
		boolean a5 = Validation.isRegularMove(p, mainBoard, 2, 5);
		boolean a6 = Validation.isRegularMove(p, mainBoard, 1, 3);
		boolean a7 = Validation.isRegularMove(p, mainBoard, 1, 5);
		boolean a8 = Validation.isRegularMove(p, mainBoard, 0, 3);
		boolean a9 = Validation.isRegularMove(p, mainBoard, 0, 5);
		
		//Test Regular Piece surrounded (no possible moves)
		Piece p1 = mainBoard.getPiece(6, 3);
		boolean b1 = Validation.isRegularMove(p1, mainBoard, 6, 3);
		boolean b2 = Validation.isRegularMove(p1, mainBoard, 5, 3);
		boolean b3 = Validation.isRegularMove(p1, mainBoard, 7, 3);
		boolean b4 = Validation.isRegularMove(p1, mainBoard, 6, 4);
		boolean b5 = Validation.isRegularMove(p1, mainBoard, 5, 4);
		boolean b6 = Validation.isRegularMove(p1, mainBoard, 7, 4);
		boolean b7 = Validation.isRegularMove(p1, mainBoard, 6, 2);
		boolean b8 = Validation.isRegularMove(p1, mainBoard, 5, 2);
		boolean b9 = Validation.isRegularMove(p1, mainBoard, 7, 2);
		
		Piece p2 = mainBoard.getPiece(5, 2);
		boolean c1 = Validation.isRegularMove(p2, mainBoard, 5, 2);
		boolean c2 = Validation.isRegularMove(p2, mainBoard, 6, 2);
		boolean c3 = Validation.isRegularMove(p2, mainBoard, 4, 2);
		boolean c4 = Validation.isRegularMove(p2, mainBoard, 5, 3);
		boolean c5 = Validation.isRegularMove(p2, mainBoard, 6, 3);
		boolean c6 = Validation.isRegularMove(p2, mainBoard, 4, 3); //true
		boolean c7 = Validation.isRegularMove(p2, mainBoard, 5, 1);
		boolean c8 = Validation.isRegularMove(p2, mainBoard, 6, 1);
		boolean c9 = Validation.isRegularMove(p2, mainBoard, 4, 1);//true
		
		assertEquals("Should not be valid move", false, a1);
		assertEquals("Should not be valid move", false, a2);
		assertEquals("Should not be valid move", false, a3);
		assertEquals("Should not be valid move", false, a4);
		assertEquals("Should not be valid move", false, a5);
		assertEquals("Should not be valid move", false, a6);
		assertEquals("Should not be valid move", false, a7);
		assertEquals("Should not be valid move", false, a8);
		assertEquals("Should not be valid move", false, a9);
		
		assertEquals("Should not be valid move", false, b1);
		assertEquals("Should not be valid move", false, b2);
		assertEquals("Should not be valid move", false, b3);
		assertEquals("Should not be valid move", false, b4);
		assertEquals("Should not be valid move", false, b5);
		assertEquals("Should not be valid move", false, b6);
		assertEquals("Should not be valid move", false, b7);
		assertEquals("Should not be valid move", false, b8);
		assertEquals("Should not be valid move", false, b9);
		
		assertEquals("Should not be valid move", false, c1);
		assertEquals("Should not be valid move", false, c2);
		assertEquals("Should not be valid move", false, c3);
		assertEquals("Should not be valid move", false, c4);
		assertEquals("Should not be valid move", false, c5);
		assertEquals("Should not be valid move", true, c6);
		assertEquals("Should not be valid move", false, c7);
		assertEquals("Should not be valid move", false, c8);
		assertEquals("Should not be valid move", true, c9);
	}

	@Test
	void testIsKingMove() {
		mainBoard = new Board(8, 8);
		Piece[] playerOnePieces = new Piece[12];
		Piece[] playerTwoPieces = new Piece[12];
		for(int i = 0; i < 12; i++){
			playerOnePieces[i] = new RoundKingPiece("playerOne", new Color(255, 255, 204));
		}
		for(int i = 0; i < 12; i++){
			playerTwoPieces[i] = new RoundPiece("playerTwo", new Color(210, 180, 140));
		}
	
		// Setting the Checkers pieces onto the board
		playerOnePieces[0].place(mainBoard, 0, 1); playerOnePieces[1].place(mainBoard, 0, 3);
		playerOnePieces[2].place(mainBoard, 0, 5); playerOnePieces[3].place(mainBoard, 0, 7);
		playerOnePieces[4].place(mainBoard, 1, 0); playerOnePieces[5].place(mainBoard, 1, 2);
		playerOnePieces[6].place(mainBoard, 1, 4); playerOnePieces[7].place(mainBoard, 1, 6);
		playerOnePieces[8].place(mainBoard, 2, 1); playerOnePieces[9].place(mainBoard, 2, 3);//
		playerOnePieces[10].place(mainBoard, 3, 4); playerOnePieces[11].place(mainBoard, 2, 7);//
		
		playerTwoPieces[0].place(mainBoard, 5, 0); playerTwoPieces[1].place(mainBoard, 5, 2);//
		playerTwoPieces[2].place(mainBoard, 5, 4); playerTwoPieces[3].place(mainBoard, 5, 6);//
		playerTwoPieces[4].place(mainBoard, 6, 1); playerTwoPieces[5].place(mainBoard, 6, 3);
		playerTwoPieces[6].place(mainBoard, 6, 5); playerTwoPieces[7].place(mainBoard, 6, 7);
		playerTwoPieces[8].place(mainBoard, 7, 0); playerTwoPieces[9].place(mainBoard, 7, 2);
		playerTwoPieces[10].place(mainBoard, 7, 4); playerTwoPieces[11].place(mainBoard, 7, 6);
		Piece p = mainBoard.getPiece(3,4);
		
		boolean a1 = Validation.isKingMove(p, mainBoard, 3, 5);
		boolean a2 = Validation.isKingMove(p, mainBoard, 4, 5);//
		boolean a3 = Validation.isKingMove(p, mainBoard, 2, 5);//
		boolean a4 = Validation.isKingMove(p, mainBoard, 3, 4);
		boolean a5 = Validation.isKingMove(p, mainBoard, 4, 4);
		boolean a6 = Validation.isKingMove(p, mainBoard, 2, 4);
		boolean a7 = Validation.isKingMove(p, mainBoard, 3, 3);
		boolean a8 = Validation.isKingMove(p, mainBoard, 4, 3);//
		boolean a9 = Validation.isKingMove(p, mainBoard, 2, 3);//
		
		assertEquals("Should not be valid move", false, a1);
		assertEquals("Should not be valid move", true, a2);
		assertEquals("Should not be valid move", true, a3);
		assertEquals("Should not be valid move", false, a4);
		assertEquals("Should not be valid move", false, a5);
		assertEquals("Should not be valid move", false, a6);
		assertEquals("Should not be valid move", false, a7);
		assertEquals("Should not be valid move", true, a8);
		assertEquals("Should not be valid move", false, a9);
	}

	@Test
	void testIsValidRegularJump() {
		mainBoard = new Board(8, 8);
		Piece[] playerOnePieces = new Piece[12];
		Piece[] playerTwoPieces = new Piece[12];
		for(int i = 0; i < 12; i++){
			playerOnePieces[i] = new RoundKingPiece("playerOne", new Color(255, 255, 204));
		}
		for(int i = 0; i < 12; i++){
			playerTwoPieces[i] = new RoundPiece("playerTwo", new Color(210, 180, 140));
		}
	
		// Setting the Checkers pieces onto the board
		playerOnePieces[0].place(mainBoard, 0, 1); playerOnePieces[1].place(mainBoard, 0, 3);
		playerOnePieces[2].place(mainBoard, 0, 5); playerOnePieces[3].place(mainBoard, 0, 7);
		playerOnePieces[4].place(mainBoard, 1, 0); playerOnePieces[5].place(mainBoard, 1, 2);
		playerOnePieces[6].place(mainBoard, 1, 4); playerOnePieces[7].place(mainBoard, 1, 6);
		playerOnePieces[8].place(mainBoard, 2, 1); playerOnePieces[9].place(mainBoard, 2, 3);//
		playerOnePieces[10].place(mainBoard, 3, 4); playerOnePieces[11].place(mainBoard, 2, 7);//
		
		playerTwoPieces[0].place(mainBoard, 5, 0); playerTwoPieces[1].place(mainBoard, 5, 2);//
		playerTwoPieces[2].place(mainBoard, 5, 4); playerTwoPieces[3].place(mainBoard, 5, 6);//
		playerTwoPieces[4].place(mainBoard, 6, 1); playerTwoPieces[5].place(mainBoard, 6, 3);
		playerTwoPieces[6].place(mainBoard, 6, 5); playerTwoPieces[7].place(mainBoard, 6, 7);
		playerTwoPieces[8].place(mainBoard, 7, 0); playerTwoPieces[9].place(mainBoard, 7, 2);
		playerTwoPieces[10].place(mainBoard, 7, 4); playerTwoPieces[11].place(mainBoard, 7, 6);
	}

	@Test
	void testIsValidKingJump() {
		//fail("Not yet implemented");
	}

}
