package boardGame;

public class Validation {
	
	public static boolean canMakeJump(Piece p, Board b, int r, int c)
	{
		return false;
	}
	public static boolean isValidMove(Piece p, Board b, int r, int c)
	{
		if(p.isRegularPiece())
		{
			if(isRegularMove(p, b, r, c))
			{
				return true;
			}
			else if(isValidRegularJump(p, b, r, c))
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		return false;
	}
	
	/*
	 * isDiagonal: int * int * int * int -> boolean
	 * REQUIRES: prow, pcol, mrow, mcol are not out of bounds
	 * ENSURES: returns true if the move coordintates are diagonal by 1 square to the current player position
	 * */
	private static boolean isDiagonal(int prow, int pcol, int mrow, int mcol)
	{
		return (mrow == prow + 1 && mcol == pcol + 1) || (mrow == prow - 1 && mcol == pcol + 1) || (mrow == prow + 1 && mcol == pcol - 1) || (mrow == prow - 1 && mcol == pcol - 1);
	}
	/*
	 * isRegularMove: Piece * Board * int * int -> bool
	 * REQUIRES: Piece != NULL, Board != NULL, move coordinates within bounds
	 * ENSURES: returns true if the move coordinates are a valid regular piece move
	 * */
	public static boolean isRegularMove(Piece p, Board b, int r, int c)
	{
		int prow = p.getRow();
		int pcol = p.getColumn();
		if(!isDiagonal(prow, pcol, r, c))
		{
			return false;
		}
		else
		{
			//check if move location is empty
			Piece moveloc = b.getPiece(r, c);
			if(moveloc != null)
			{
				return false;
			}
			//check if movement is valid for specific player
			if(p.getName().equals("PlayerOne")) //check if piece moving "down" the board (up the column number)
			{
				return pcol < c;
			}
			else if(p.getName().equals("PlayerTwo")) //check if piece moving "up" the board (down the column number)
			{
				return pcol > c;
			}
			else
			{
				return false;
			}
		}
	}
	/*
	 * isJumpCoord: int * int * int * int -> bool
	 * REQUIRES: all inputs are in the board bounds
	 * ENSURES: returns true if the move coordinates are a valid jump coordinate (Not if the jump is valid, just that the
	 * coordinates are valid) false otherwise.
	 * */
	private static boolean isJumpCoord(int prow, int pcol, int mrow, int mcol)
	{
		return (mrow == prow + 2 && mcol == pcol + 2) || (mrow == prow - 2 && mcol == pcol + 2) || (mrow == prow + 2 && mcol == pcol - 2) || (mrow == prow - 2 && mcol == pcol - 2);
	}
	
	/*
	 * isValidRegularJump: Board * Piece * int * int -> bool
	 * REQUIRES: Board b != NULL, Piece p != NULL, mrow, mcol are within the bounds of the board.  
	 * ENSURES: returns true if the move is a proper regular jump, otherwise, return false
	 * */
	public static boolean isValidRegularJump(Piece p, Board b, int mrow, int mcol)
	{
		int prow = p.getRow();
		int pcol = p.getColumn();
		if(p.getName().equals("PlayerOne")) //their pieces go DOWN (aka + numbers)
		{
			if(!isJumpCoord(prow, pcol, mrow, mcol) || mcol < pcol) //if piece is not moving "down" (move is < current pos)
			{
				return false;
			}
			//get the captured piece
			Piece capture;
			if(mrow > prow)
			{
				capture = b.getPiece(mrow -1, mcol - 1);
			}
			else
			{
				capture = b.getPiece(mrow + 1, mcol - 1);
			}
			//check if capture piece is actually a player piece
			if(capture == null)
			{
				return false;
			}
			//Check if capture piece belongs to Playertwo
			if(!capture.getName().equals("PlayerTwo"))
			{
				return false;
			}
			//check if the piece on the board where the player will move is empty
			Piece jump = b.getPiece(mrow, mcol);
			if(jump != null)
			{
				return false;
			}
			return true;
		}
		else if(p.getName().equals("PlayerTwo"))//player == playerTwo
		{
			if(!isJumpCoord(prow, pcol, mrow, mcol) || mcol > pcol) //if piece is not moving "up" (move is > current pos)
			{
				return false;
			}
			//get the captured piece
			Piece capture;
			if(mrow > prow)
			{
				capture = b.getPiece(mrow - 1, mcol + 1);
			}
			else
			{
				capture = b.getPiece(mrow + 1, mcol + 1);
			}
			//check if capture piece is actually a player piece
			if(capture == null)
			{
				return false;
			}
			//Check if capture piece belongs to PlayerOne
			if(!capture.getName().equals("PlayerOne"))
			{
				return false;
			}
			//check if the piece on the board where the player will move is empty
			Piece jump = b.getPiece(mrow, mcol);
			if(jump != null)
			{
				return false;
			}
			return true;
		}
		else //the input piece belongs to neither the playerOne or PlayerTwo
		{
			return false;
		}
	}
}
