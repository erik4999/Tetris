package earl.tetris;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;

public class Piece extends Rectangle {
	public static final int PIECE_MAX = 8;

	public Piece(int x, int y) {
		super(x, y, PIECE_MAX, PIECE_MAX);

	}

	public void move(int x, int y) {

		// TODO: bounds incident handling
		this.x += x;
		this.y += y;

	}// End move method

	public void move(int y) {

		move(0, y);
	}

}
