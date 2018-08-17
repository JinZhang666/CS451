package boardGame;

import java.awt.*;

public class RoundKingPiece extends Piece{
	
	private Color color = Color.red;
	
	/**
     * Constructs a <code>RoundKingPiece</code>.
     **/
    public RoundKingPiece() {
    }
    
    /**
     * Constructs a <code>RoundKingPiece</code> of the given color.
     * 
     * @param color The <code>Color</code> of the new piece.
     **/
     public RoundKingPiece(Color color) {
        this.color = color;
    }
     
     /**
      * Constructs a <code>RoundKingPiece</code> with the given name and color.
      * 
      * @param name A name for the new Piece.
      * @param color The <code>Color</code> of the new Piece.
      **/
     public RoundKingPiece(String name, Color color) {
         super(name);
         this.color = color;
     }
	
	/**
     * Draws this <code>RoundKingPiece</code> on the given <code>Graphics</code>.
     * Drawing should be limited to the provided <code>java.awt.Rectangle</code>.
     * 
     * @param g The graphics on which to draw.
     * @param r The rectangle in which to draw.
     */
    @Override
    public void paint(Graphics g, Rectangle r) {
        // creates black border to differentiate round pieces from board
    	g.setColor(Color.BLACK);
    	g.fillOval(r.x, r.y, r.width, r.height);
    	
    	// paints the round king piece with a 'k' to differentiate it
    	// from a regular round piece
    	Color oldColor = g.getColor();
        g.setColor(color);
        g.fillOval(r.x + 1, r.y + 1, r.width - 2, r.height - 2);
        FontMetrics fm = g.getFontMetrics();
        String k = "K";
        double textWidth = fm.getStringBounds(k, g).getWidth(); 
        g.setColor(Color.black);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString(k, (int)(r.x + textWidth*3-2),(int)(r.y + (fm.getMaxAscent()*2+7)));
        
        if (this.equals(board.getSelectedPiece())) {
            g.setColor(Color.RED);
            g.drawOval(r.x + 1, r.y + 1, r.width - 2, r.height - 2);
            g.setColor(Color.WHITE);
            g.drawOval(r.x + 2, r.y + 2, r.width - 4, r.height - 4);
        }
        g.setColor(oldColor);
    }
}
