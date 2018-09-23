package de.openhpi.capstone1.game.controller;

import processing.core.PApplet;

/**
 * The Class GameState.
 */
public class GameState extends Controller {

	/**
	 * The Enum State.
	 */
	public enum State {

		/** The stopped. */
		STOPPED,
		/** The running. */
		RUNNING,
		/** The game over. */
		GAME_OVER
	}

	/** The current state. */
	private static State currentState = State.STOPPED;

	/**
	 * State.
	 *
	 * @return the state
	 */
	public static State State() {
		return currentState;
	}

	/**
	 * Instantiates a new game state.
	 *
	 * @param display the display
	 */
	public GameState(final PApplet display) {
		super(display);
	}

	/**
	 * Start.
	 */
	public static void Start() {
		currentState = State.RUNNING;
	}

	/**
	 * Stop.
	 */
	public static void Stop() {
		currentState = State.STOPPED;
	}

	/**
	 * Game over.
	 */
	public static void GameOver() {
		currentState = State.GAME_OVER;
	}
}
