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

	private int x = 10;
	private int y = 10;
	private int frameCount = 0;
	private final int MAX_FPS = 30;
	private Square testSquare;

	public GameState() {
		testSquare = new Square(x, y);
		
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.newdawn.slick.state.GameState#init(org.newdawn.slick.GameContainer,
	 * org.newdawn.slick.state.StateBasedGame)
	 */
	@Override
	public void init(GameContainer container, StateBasedGame game)
			throws SlickException {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.newdawn.slick.state.GameState#render(org.newdawn.slick.GameContainer,
	 * org.newdawn.slick.state.StateBasedGame, org.newdawn.slick.Graphics)
	 */
	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
	
		if (frameCount < MAX_FPS) {
			for (int i = 0; i < testSquare.pieces.size(); i++) {
				g.draw(testSquare.pieces.get(i));
				
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
	public void update(GameContainer container, StateBasedGame game, int delta)
			throws SlickException {

		if (frameCount < MAX_FPS)
			frameCount++;
		else {
			y++;
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
		// TODO Auto-generated method stub
		return Tetris.STATE_INT_GAME;
	}// End getID method

	public void keyPressed(int key, char c) {
		switch (key) {
		case Input.KEY_RIGHT:
			x += 4;
			break;
		case Input.KEY_LEFT:
			x -= 4;
			break;
		default:
			break;
		}
	}// End keyReleased method

}
