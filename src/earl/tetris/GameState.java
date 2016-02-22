package earl.tetris;

import java.util.ArrayList;
import java.util.Random;

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
	private final int MAX_FPS = 8;
	private final int MOVE_RATE = 8;
	private Rectangle southWall, westWall, eastWall;
	private TetrisShape activeShape;
	private StateBasedGame theGame;
	private Pile thePile;
	private Random ran;

	public GameState() {

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
		westWall = new Rectangle(-1, 0, 1, container.getHeight());
		eastWall = new Rectangle(container.getWidth(), 0, 1, container.getHeight());
		southWall = new Rectangle(0, container.getHeight(), container.getWidth(), 1);

		thePile = new Pile();
		ran = new Random();

		activeShape = getRandomShape();

		// System.out.println(container.getHeight());
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

		// g.draw(westWall); **Shows the walls**
		// g.draw(eastWall);
		// g.draw(southWall);
		for (int i = 0; i < thePile.pieces.size(); i++) {
			g.draw(thePile.pieces.get(i));
		}
		if (frameCount < MAX_FPS) {
			drawActiveShape(g);

		}
	}

	// End render method

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
				moveActiveShapeLeft();
			if (container.getInput().isKeyDown(Input.KEY_RIGHT))
				moveActiveShapeRight();

			dropActiveShape();

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
			moveActiveShapeRight();
			break;
		case Input.KEY_LEFT:
			moveActiveShapeLeft();
			break;

		case Input.KEY_ESCAPE:
			theGame.enterState(Tetris.STATE_INT_MENU, new FadeOutTransition(Color.black),
					new FadeInTransition(Color.black));
		default:
			break;
		}
	}// End keyReleased method

	private void moveActiveShapeLeft() {
		if (activeShape == null)
			return;

		if (!activeShape.intersects(westWall))
			activeShape.move(-MOVE_RATE, 0);
	}

	private void moveActiveShapeRight() {
		if (activeShape == null)
			return;
		if (!activeShape.intersects(eastWall))
			activeShape.move(MOVE_RATE, 0);
	}

	private void dropActiveShape() {
		if (activeShape == null)
			return;

		TetrisShape shape;
		activeShape.move(0, MOVE_RATE);

		if (activeShape.intersects(southWall) || thePile.intersects(activeShape)) {

			thePile.addShape(activeShape);

			activeShape = getRandomShape();
		}
	}

	private void drawActiveShape(Graphics g) {
		if (activeShape == null)
			return;

		for (int i = 0; i < activeShape.pieces.size(); i++) {
			g.draw(activeShape.pieces.get(i));
		}
	}

	private TetrisShape getRandomShape() {
		int num = ran.nextInt(2);
		// TODO: Return random shapes, NOT JUST SQUARE
		switch (num) {
		case 1:
		default:
			return new Square(50, 0);
		}
	}
}
