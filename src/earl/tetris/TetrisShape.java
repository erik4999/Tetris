/**
 * 
 */
package earl.tetris;

import java.util.ArrayList;

import org.newdawn.slick.Graphics;

/**
 * @author Erik.Schmitt
 *
 */
public abstract class TetrisShape {

	protected int x;
	protected int y;
	protected ArrayList<Piece> pieces;

	/**
	 * 
	 */
	public TetrisShape(int x, int y) {
		pieces = new ArrayList<Piece>();
		this.x = x;
		this.y = y;
	}

	public abstract void rotate();

	public abstract void move();

	public abstract void dismantle();

	public abstract void loadPieces();

	public abstract ArrayList<Piece> getPieces();

}
