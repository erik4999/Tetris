package earl.tetris;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

/**
 * @author Earl-team This is the class for the Game state
 */
public class GameState extends BasicGameState {

	private int frameCount = 0;
	private final int MAX_FPS = 30;
	private TetrisShape activeShape;
	private StateBasedGame theGame;

	public GameState() {
		activeShape = new Square(50, 0);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.newdawn.slick.state.GameState#init(org.newdawn.slick.GameContainer,
	 * org.newdawn.slick.state.StateBasedGame)
	 */
	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException {
		theGame = game;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.newdawn.slick.state.GameState#render(org.newdawn.slick.GameContainer,
	 * org.newdawn.slick.state.StateBasedGame, org.newdawn.slick.Graphics)
	 */
	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {

		if (frameCount < MAX_FPS) {
			for (int i = 0; i < activeShape.pieces.size(); i++) {
				g.draw(activeShape.pieces.get(i));

			}
		}

	}// End render method

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.newdawn.slick.state.GameState#update(org.newdawn.slick.GameContainer,
	 * org.newdawn.slick.state.StateBasedGame, int)
	 */
	@Override
	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {

		if (frameCount < MAX_FPS)
			frameCount++;
		else {
			if (container.getInput().isKeyDown(Input.KEY_LEFT))
				activeShape.move(-Piece.PIECE_MAX, 0);
			if (container.getInput().isKeyDown(Input.KEY_RIGHT))
				activeShape.move(Piece.PIECE_MAX, 0);

			activeShape.move(0, Piece.PIECE_MAX);
			frameCount = 0;
		}

	}// End update method

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.newdawn.slick.state.BasicGameState#getID()
	 */
	@Override
	public int getID() {
		return Tetris.STATE_INT_GAME;
	}// End getID method

	public void keyPressed(int key, char c) {
		switch (key) {
		case Input.KEY_RIGHT:
			activeShape.move(Piece.PIECE_MAX, 0);
			break;
		case Input.KEY_LEFT:
			activeShape.move(-Piece.PIECE_MAX, 0);
			break;
		case Input.KEY_ESCAPE:
			theGame.enterState(Tetris.STATE_INT_MENU, new FadeOutTransition(Color.black),
					new FadeInTransition(Color.black));
		default:
			break;
		}
	}// End keyReleased method

}
