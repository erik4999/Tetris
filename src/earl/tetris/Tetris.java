/**
 * 
 */
package earl.tetris;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 * @author Erik.Schmitt
 *
 */
public class Tetris extends StateBasedGame {
public static int STATE_INT_MENU = 0;
public static int STATE_INT_GAME = 1;
	/**
	 * @param name
	 */
	public Tetris(String name) {
		super(name);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.newdawn.slick.state.StateBasedGame#initStatesList(org.newdawn.slick.
	 * GameContainer)
	 */
	@Override
	public void initStatesList(GameContainer container) throws SlickException {
		addState(new Menu());
		addState(new GameState());

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			AppGameContainer app = new AppGameContainer(new Tetris("Tetris"));
			app.setShowFPS(false);
			app.start();
		} catch (SlickException e) {
			e.printStackTrace();
		}

	}

}
