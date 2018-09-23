package de.openhpi.capstone1.game.starter;

import de.openhpi.capstone1.game.builder.GameOverScreen;
import de.openhpi.capstone1.game.builder.GameScreen;
import de.openhpi.capstone1.game.builder.InteractiveComponent;
import de.openhpi.capstone1.game.builder.InteractiveComponentBuilder;
import de.openhpi.capstone1.game.builder.StartupScreen;
import de.openhpi.capstone1.game.controller.GameState;
import de.openhpi.capstone1.game.controller.GameState.State;
import processing.core.PApplet;
import processing.event.KeyEvent;

/**
 * The Class TheApp.
 */
public class TheApp extends PApplet {

	/** The game screen. */
	private InteractiveComponent gameScreen;

	/** The startup screen. */
	private InteractiveComponent startupScreen;

	private InteractiveComponent gameOverScreen;

	/*
	 * (non-Javadoc)
	 *
	 * @see processing.core.PApplet#settings()
	 */
	@Override
	public void settings() {
		// Size of the window
		size(Settings.WINDOW_WIDTH, Settings.WINDOW_HEIGHT);

		// IMPORTANT: If you experience any graphical issues, set this to 3 or 2,
		// alternatively remove it.
		smooth(4);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see processing.core.PApplet#setup()
	 */
	@Override
	public void setup() { // setup() runs once
		frameRate(60);

		gameScreen = InteractiveComponentBuilder.create(this, GameScreen.class);
		startupScreen = InteractiveComponentBuilder.create(this, StartupScreen.class);
		gameOverScreen = InteractiveComponentBuilder.create(this, GameOverScreen.class);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see processing.core.PApplet#draw()
	 */
	@Override
	public void draw() { // draw() loops forever, until stopped
		if (GameState.State() == State.STOPPED) {
			startupScreen.update();
		} else if (GameState.State() == State.RUNNING) {
			gameScreen.update();
		} else {
			gameOverScreen.update();
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see processing.core.PApplet#keyPressed()
	 */
	@Override
	public void keyPressed(final KeyEvent keyEvent) {
		if (keyEvent.getKey() == ENTER && GameState.State() != State.RUNNING) {
			GameState.Start();
		} else if (keyEvent.getKey() == PApplet.BACKSPACE) {
			GameState.Stop();
		}
	}
}
