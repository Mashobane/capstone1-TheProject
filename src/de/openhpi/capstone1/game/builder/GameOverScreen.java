package de.openhpi.capstone1.game.builder;

import de.openhpi.capstone1.game.view.Background;
import de.openhpi.capstone1.game.view.Text;
import processing.core.PApplet;

/**
 * The Class GameOverScreen.
 */
public class GameOverScreen extends InteractiveComponent {

	/**
	 * Instantiates a new game over screen.
	 *
	 * @param display the display
	 */
	public GameOverScreen(final PApplet display) {
		super(display);

		views.add(new Background(display));
		views.add(new Text(display, "Game Over\n" + "¯\\_(X.x)_/¯\n" + "Press ENTER to restart ♪♫♪", true));
	}
}
