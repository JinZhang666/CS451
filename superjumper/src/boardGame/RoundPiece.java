package boardGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 * Example playing piece. This class is only here as an example,
 * and may be discarded.
 */
public class RoundPiece extends Piece {
    
    private Color color = Color.red;
        
    /**
     * Constructs a <code>RoundPiece</code>.
     **/
    public RoundPiece() {
    }
    
    /**
     * Constructs a <code>RoundPiece</code> of the given color.
     * 
     * @param color The <code>Color</code> of the new piece.
     **/
     public RoundPiece(Color color) {
        this.color = color;
    }
     
     /**
      * Constructs a <code>RoundPiece</code> with the given name and color.
      * 
      * @param name A name for the new Piece.
      * @param color The <code>Color</code> of the new Piece.
      **/
     public RoundPiece(String name, Color color) {
         super(name);
         this.color = color;
     }
    
    /**
     * Draws this <code>RoundPiece</code> on the given <code>Graphics</code>.
     * Drawing should be limited to the provided <code>java.awt.Rectangle</code>.
     * 
     * @param g The graphics on which to draw.
     * @param r The rectangle in which to draw.
     */
    @Override
    public void paint(Graphics g, Rectangle r) {
        Color oldColor = g.getColor();
        g.setColor(color);
        g.fillOval(r.x + 1, r.y + 1, r.width - 2, r.height - 2);
        if (this.equals(board.getSelectedPiece())) {
            g.setColor(Color.BLACK);
            g.drawOval(r.x + 1, r.y + 1, r.width - 2, r.height - 2);
            g.setColor(Color.WHITE);
            g.drawOval(r.x + 2, r.y + 2, r.width - 4, r.height - 4);
        }
        g.setColor(oldColor);
    }
}