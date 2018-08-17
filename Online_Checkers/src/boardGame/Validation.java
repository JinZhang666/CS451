package boardGame;

public class Validation {
	public static boolean isValidMove(Piece p, Board b, int playernum, int r, int c)
	{
		return false;
	}
	
	private static boolean isDiagonal(int piecer, int piecec, int mover, int movec)
	{
		return (mover == piecer + 1 && movec == piecec + 1) || (mover == piecer - 1 && movec == piecec + 1) || (mover == piecer + 1 && movec == piecec - 1) || (mover == piecer - 1 && movec == piecec - 1);
	}
	
	private static boolean isValidRegularJump();
}
