/**
 * 
 */
package earl.tetris;

import java.util.ArrayList;

import org.newdawn.slick.geom.Rectangle;

/**
 * @author Earl team
 *
 */
public class Pile {

	protected ArrayList<Piece> pieces;

	/**
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public Pile() {

		pieces = new ArrayList<Piece>();
	}

	public void addPiece(Piece p) {
		pieces.add(p);
	}

	public void addShape(TetrisShape s) {

		for (int i = 0; i < s.pieces.size(); i++) {
			addPiece(s.pieces.get(i));
		}
	}

	public boolean intersects(TetrisShape s) {
		Piece p1, p2;
		for (int i = 0; i < s.pieces.size(); i++) {
			p1 = s.pieces.get(i);
			for (int j = 0; j < this.pieces.size(); j++) {
				p2 = this.pieces.get(j);
				if (p1.intersects(p2))
					return true;
			}
		}
		return false;
	}
}
