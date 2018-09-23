package de.openhpi.capstone1.game.builder;

import de.openhpi.capstone1.game.view.Background;
import de.openhpi.capstone1.game.view.Text;
import processing.core.PApplet;

/**
 * The Class StartupScreen.
 */
public class StartupScreen extends InteractiveComponent {

	/**
	 * Instantiates a new startup screen.
	 *
	 * @param display the display
	 */
	public StartupScreen(final PApplet display) {
		super(display);

		views.add(new Background(display));
		views.add(new Text(display,
				"Welcome to our Game!\n" + "Press ENTER to start!\n" + "BACKSPACE to stop!\n" + "ESC to quit!", true));
	}
}
