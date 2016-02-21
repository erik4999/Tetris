/**
 * 
 */
package earl.tetris;

import java.util.ArrayList;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;

/**
 * @author Erik.Schmitt
 *
 */
public abstract class TetrisShape {

	protected int x;
	protected int y;
	protected ArrayList<Piece> pieces;

	
	public TetrisShape(int x, int y) {
		pieces = new ArrayList<Piece>();
		this.x = x;
		this.y = y;
	}//End TetrisShape method

	public abstract void rotate();

	public abstract void dismantle();

	public abstract void loadPieces();

	public ArrayList<Piece> getPieces() {
		return pieces;
	}//End getPieces method

	public void move(int x, int y) {
		for (int i = 0; i < pieces.size(); i++) {
			pieces.get(i).move(x, y);
		}	
	}//End move method
	public boolean intersects(Rectangle r)
	{
		for (int i=0;i<pieces.size();i++)
		{
			if (pieces.get(i).intersects(r))
				return true;
		}
		return false;
	}
}//End TetrisShape method
