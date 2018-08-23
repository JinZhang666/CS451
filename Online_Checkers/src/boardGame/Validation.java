package boardGame;

public class Validation {
	
	public static boolean canMakeJump(Piece p, Board b)
	{
		int r = p.getRow();
		int c = p.getColumn();
		int boundr = b.getRows();
		int boundc = b.getColumns();
		Piece NWPiece;
		Piece NEPiece;
		Piece SWPiece;
		Piece SEPiece;
		Piece NWCap;
		Piece NECap;
		Piece SWCap;
		Piece SECap;
		if(p.getName().equals("PlayerTwo"))
		{
			if(r - 2 >= 0 && c - 2 >= 0)
			{
				NWPiece = b.getPiece(r - 2, c - 2);
				if(NWPiece != null) //check if move location is empty
				{
					NWCap = b.getPiece(r - 1, c - 1);
					//check if NWcapture piece has different player
					if(!NWCap.getName().equals(p.getName()))
					{
						return true;
					}
				}
			}
			if(r + 2 < boundr && c + 2 < boundc)
			{
				NEPiece = b.getPiece(r + 2, c + 2);
				if(NEPiece != null)
				{
					NECap = b.getPiece(r + 1, c + 1);
					//check if SECap piece has different player
					if(!NECap.getName().equals(p.getName()))
					{
						return true;
					}
				}
			}
		}
		if(p.getName().equals("PlayerOne"))
		{
			if(r - 2 >= 0 && c + 2 < boundc)
			{
				SWPiece = b.getPiece(r - 2, c + 2);
				if(SWPiece != null)
				{
					SWCap = b.getPiece(r - 1, c + 1);
					//check if SWCap piece has different player
					if(!SWCap.getName().equals(p.getName()))
					{
						return true;
					}
				}
			}
			if(r + 2 < boundr && c - 2 >= 0)
			{
				SEPiece = b.getPiece(r + 2, c - 2);
				if(SEPiece != null) //check if move location is empty
				{
					SECap = b.getPiece(r + 1, c - 1);
					//check if NECap piece has different player
					if(!SECap.getName().equals(p.getName()))
					{
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public static boolean canMakeKingJump(Piece p, Board b)
	{
		int r = p.getRow();
		int c = p.getColumn();
		int boundr = b.getRows();
		int boundc = b.getColumns();
		Piece NWPiece;
		Piece NEPiece;
		Piece SWPiece;
		Piece SEPiece;
		Piece NWCap;
		Piece NECap;
		Piece SWCap;
		Piece SECap;
		if(r - 2 >= 0 && c - 2 >= 0)
		{
			NWPiece = b.getPiece(r - 2, c - 2);
			if(NWPiece != null) //check if move location is empty
			{
				NWCap = b.getPiece(r - 1, c - 1);
				//check if NWcapture piece has different player
				if(!NWCap.getName().equals(p.getName()))
				{
					return true;
				}
			}
		}
		if(r + 2 < boundr && c - 2 >= 0)
		{
			SEPiece = b.getPiece(r + 2, c - 2);
			if(SEPiece != null) //check if move location is empty
			{
				SECap = b.getPiece(r + 1, c - 1);
				//check if NECap piece has different player
				if(!SECap.getName().equals(p.getName()))
				{
					return true;
				}
			}
		}
		if(r - 2 >= 0 && c + 2 < boundc)
		{
			SWPiece = b.getPiece(r - 2, c + 2);
			if(SWPiece != null)
			{
				SWCap = b.getPiece(r - 1, c + 1);
				//check if SWCap piece has different player
				if(!SWCap.getName().equals(p.getName()))
				{
					return true;
				}
			}
		}
		if(r + 2 < boundr && c + 2 < boundc)
		{
			NEPiece = b.getPiece(r + 2, c + 2);
			if(NEPiece != null)
			{
				NECap = b.getPiece(r + 1, c + 1);
				//check if SECap piece has different player
				if(!NECap.getName().equals(p.getName()))
				{
					return true;
				}
			}
		}
		return false;

	}
	public static boolean isValidMove(Piece p, Board b, int r, int c)
	{
		//check if entered values are fine
		if(p == null || b == null || 0 > r || 0 > c || b.getColumns() < c || b.getRows() < r)
		{
			return false;
		}
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
		else if(p.isKingPiece())
		{
			if(isKingMove(p, b, r, c))
			{
				return true;
			}
			else if(isValidKingJump(p, b, r, c))
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			return false;
		}
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
			if(p.getName().equals("PlayerOne")) //check if piece moving "down" the board (up the row number)
			{
				return prow < r;
			}
			else if(p.getName().equals("PlayerTwo")) //check if piece moving "up" the board (down the row number)
			{
				return prow > r;
			}
			else
			{
				return false;
			}
		}
	}
	
	/*
	 * isKingMove: Piece * Board * int * int -> bool
	 * REQUIRES: Piece != NULL, Board != NULL, move coordinates within bounds
	 * ENSURES: returns true if the move coordinates are a valid King piece move
	 * */
	public static boolean isKingMove(Piece p, Board b, int r, int c)
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
			return moveloc == null;
			//King can move forward or back, so this is sufficient
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
	public static boolean isValidRegularJump(Piece p, Board b, int r, int c)
	{
		int prow = p.getRow();
		int pcol = p.getColumn();
		if(p.getName().equals("PlayerOne")) //their pieces go DOWN (aka + numbers)
		{
			if(!isJumpCoord(prow, pcol, r, c) || r < prow) //if piece is not moving "down" (move is < current pos)
			{
				return false;
			}
			//get the captured piece
			Piece capture;
			if(c > pcol)
			{
				capture = b.getPiece(r - 1, c - 1);
			}
			else
			{
				capture = b.getPiece(r - 1, c + 1);
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
			Piece jump = b.getPiece(r, c);
			if(jump != null)
			{
				return false;
			}
			return true;
		}
		else if(p.getName().equals("PlayerTwo"))//player == playerTwo
		{
			if(!isJumpCoord(prow, pcol, r, c) ||r > prow) //if piece is not moving "up" (move is > current pos)
			{
				return false;
			}
			//get the captured piece
			Piece capture;
			if(c > pcol)
			{
				capture = b.getPiece(r + 1, c - 1);
			}
			else
			{
				capture = b.getPiece(r + 1, c + 1);
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
			Piece jump = b.getPiece(r, c);
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
	
	public static boolean isValidKingJump(Piece p, Board b, int r, int c)
	{
		int prow = p.getRow();
		int pcol = p.getColumn();
		if(!isJumpCoord(prow, pcol, r, c)) //if piece is not moving "up" (move is > current pos)
		{
			return false;
		}
		//check if move location is empty
		Piece moveloc = b.getPiece(r, c);
		if(moveloc != null)
		{
			return false;
		}
		//get captured piece
		Piece capture;
		if(r > prow && c > pcol)
		{
			capture = b.getPiece(r - 1, c - 1);
		}
		else if(r > prow && c < pcol)
		{
			capture = b.getPiece(r - 1,	c + 1);
		}
		else if(r < prow  && c > pcol)
		{
			capture = b.getPiece(r + 1, c - 1);
		}
		else if(r < prow && c < pcol)
		{
			capture = b.getPiece(r + 1, c + 1);
		}
		else
		{
			//isJumpCoord does not work
			return false;
		}
		//check if capture piece is empty
		if(capture == null)
		{
			return false;
		}
		//Check if players are different
		if(p.getName().equals("PlayerOne"))
		{
			return capture.getName().equals("PlayerTwo");
		}
		else if(p.getName().equals("PlayerTwo"))
		{
			return capture.getName().equals("PlayerOne");
		}
		else
		{
			return false;
		}
	}
}
