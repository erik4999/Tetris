package earl.tetris;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 * @author Earl-team This is our MAIN class for Tetris that will be the entry
 *         point for the program global constant variables will be defined here
 *         for now
 */
public class Tetris extends StateBasedGame {
	public static int STATE_INT_MENU = 0;
	public static int STATE_INT_GAME = 1;
	public static int STATE_INT_SCORE = 2;

	/**
	 * @param name
	 *            The title of the dialog of the main program.
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
		addState(new GameState());
		addState(new Menu());
		addState(new ScoresState());

	}

	/**
	 * @param args
	 *            The arguments from command line execution of main program
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
