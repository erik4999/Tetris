/**
 * 
 */
package earl.tetris;

import org.newdawn.slick.Graphics;

/**
 * @author Erik.Schmitt
 *
 */
public abstract class TetrisShape {

	private int x;
	private int y;

	/**
	 * 
	 */
	public TetrisShape(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public abstract void rotate();

	public abstract void move();

	public abstract void dismantle();

	public abstract void loadPieces();

	public abstract Piece[] getPieces();

}
