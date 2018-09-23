package de.openhpi.capstone1.game.controller;

import processing.core.PApplet;

/**
 * The Interface Controller.
 */
public abstract class Controller {
	protected PApplet display;

	Controller(final PApplet display) {
		this.display = display;
	}
}
