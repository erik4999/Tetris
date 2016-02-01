/**
 * 
 */
package earl.tetris;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;
import org.newdawn.slick.Color;

/**
 * @author Erik.Schmitt
 *
 */
public class Menu extends BasicGameState {

	private StateBasedGame theGame;

	/**
	 * 
	 */
	public Menu() {
		// TODO Auto-generated constructor stub
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

		g.setColor(Color.white);
		g.drawString("Tetris", 50, 10);

		g.drawString("1. Play Game", 50, 100);
		g.drawString("2. High Scores", 50, 120);
		g.drawString("3. Quit", 50, 140);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.newdawn.slick.state.GameState#update(org.newdawn.slick.GameContainer,
	 * org.newdawn.slick.state.StateBasedGame, int)
	 */
	@Override
	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.newdawn.slick.state.BasicGameState#getID()
	 */
	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return Tetris.STATE_INT_MENU;
	}

	public void keyReleased(int key, char c) {
		switch (key) {
		case Input.KEY_1:
			theGame.enterState(Tetris.STATE_INT_GAME, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));
			break;
		case Input.KEY_2:
			// TODO: Implement later
			break;
		case Input.KEY_3:
			// TODO: Implement later
			break;
		default:
			break;
		}
	}

}
