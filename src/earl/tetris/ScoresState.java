/**
 * 
 */
package earl.tetris;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 * @author Earl-team
 *
 */
public class ScoresState extends BasicGameState {

	/**
	 * 
	 */
	public ScoresState() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see org.newdawn.slick.state.GameState#init(org.newdawn.slick.GameContainer, org.newdawn.slick.state.StateBasedGame)
	 */
	@Override
	public void init(GameContainer arg0, StateBasedGame arg1)
			throws SlickException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.newdawn.slick.state.GameState#render(org.newdawn.slick.GameContainer, org.newdawn.slick.state.StateBasedGame, org.newdawn.slick.Graphics)
	 */
	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException  {
		g.setColor(Color.white);
		g.drawString("Butt Scores", 50, 10);

	}

	/* (non-Javadoc)
	 * @see org.newdawn.slick.state.GameState#update(org.newdawn.slick.GameContainer, org.newdawn.slick.state.StateBasedGame, int)
	 */
	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2)
			throws SlickException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.newdawn.slick.state.BasicGameState#getID()
	 */
	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return Tetris.STATE_INT_SCORE;
	}

}
