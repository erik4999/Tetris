package earl.tetris;

import java.util.ArrayList;

public class Square extends TetrisShape {

	public Square(int x, int y) {
		super(x, y);
		loadPieces();
	}// End constructor

	@Override
	public void rotate() {
		// TODO Auto-generated method stub

	}// End rotate method

	@Override
	public void dismantle() {
		// TODO Auto-generated method stub

	}// End dismantle method

	@Override
	public void loadPieces() {
		Piece p1 = new Piece(x, y);
		Piece p2 = new Piece(x + Piece.PIECE_MAX, y);
		Piece p3 = new Piece(x + Piece.PIECE_MAX, y + Piece.PIECE_MAX);
		Piece p4 = new Piece(x, y + Piece.PIECE_MAX);

		this.pieces.add(p1);
		this.pieces.add(p2);
		this.pieces.add(p3);
		this.pieces.add(p4);

	}// End loadPieces method

}// End Square class
