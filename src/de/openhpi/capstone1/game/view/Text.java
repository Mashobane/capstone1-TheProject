package de.openhpi.capstone1.game.view;

import de.openhpi.capstone1.game.starter.Settings;
import processing.core.PApplet;

/**
 * The Class Text.
 */
public class Text extends AbstractView {

	/** The current text. */
	private String currentText = "";

	/** The x position. */
	private float xPosition = 0;

	/** The x position. */
	private float yPosition = 0;

	/** The centered. */
	private Boolean centered = false;

	/**
	 * Instantiates a new text.
	 *
	 * @param display the display
	 * @param text    the text
	 * @param x       the x
	 * @param y       the y
	 */
	public Text(final PApplet display, final String text, final float x, final float y) {
		super(display);

		setText(text, x, y, false);
	}

	/**
	 * Instantiates a new text.
	 *
	 * @param display the display
	 * @param text    the text
	 * @param center  the center
	 */
	public Text(final PApplet display, final String text, final Boolean center) {
		super(display);

		setText(text, 0, 0, center);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see de.openhpi.capstone1.game.view.AbstractView#update()
	 */
	@Override
	public void update() {
		display.fill(Settings.TEXT_COLOR);
		display.textSize(Settings.WINDOW_WIDTH * Settings.TEXT_SIZE_MULTIPLICATOR);

		if (centered) {
			display.textAlign(PApplet.CENTER, PApplet.CENTER);
			display.text(currentText, Settings.WINDOW_WIDTH / 2.0f,
					Settings.WINDOW_HEIGHT / 2.0f - (display.textAscent() - display.textDescent()) / 2);
		} else {
			display.text(currentText, xPosition, yPosition);
		}
	}

	/**
	 * Gets the text.
	 *
	 * @return the text
	 */
	public String getText() {
		return currentText;
	}

	/**
	 * Sets the text.
	 *
	 * @param text   the new text
	 * @param x      the x
	 * @param y      the y
	 * @param center the center
	 */
	public void setText(final String text, final float x, final float y, final Boolean center) {
		this.currentText = text;
		this.xPosition = x;
		this.yPosition = y;
		this.centered = center;
	}
}
