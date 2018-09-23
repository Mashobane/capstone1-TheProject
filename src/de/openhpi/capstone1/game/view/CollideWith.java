package de.openhpi.capstone1.game.view;

import de.openhpi.capstone1.game.starter.Settings;
import processing.core.PApplet;

/**
 * The Class CollideWith.
 */
public class CollideWith extends AbstractView {

	/** The Constant X Coordinate Position. */
	public static final int X = 0;

	/** The Constant Y Coordinate Position. */
	public static final int Y = 1;

	/** The ball X,Y speed. */
	int[] ballSpeed = new int[2];

	/**
	 * Instantiates a new collide with.
	 *
	 * @param display the display
	 */

	public CollideWith(final PApplet display) {
		super(display);
	}

	/**
	 * Collide with wall.
	 *
	 * @param xBallPosition   the xBallPosition
	 * @param yBallPosition   the yBall Position
	 * @param xSpeed          the xSpeed
	 * @param ySpeed          the ySpeed
	 * @param xPaddlePosition the xPaddlePosition
	 * @return true, if successful
	 */
	public boolean collideWithWall(final int xBallPosition, final int yBallPosition, int xSpeed, int ySpeed,
			final int xPaddlePosition) {
		final int d = Math.abs(
				(yBallPosition + Settings.BALL_SIZE / 2) - (int) (Settings.WINDOW_HEIGHT - Settings.PADDLE_HEIGHT));

		if ((xBallPosition + Settings.BALL_SIZE / 2 == Settings.WINDOW_WIDTH)
				|| (xBallPosition - Settings.BALL_SIZE / 2 == 0)) {
			xSpeed = -xSpeed;

			ballSpeed[X] = xSpeed;
			ballSpeed[Y] = ySpeed;
		} else if (yBallPosition + Settings.BALL_SIZE / 2 == Settings.WINDOW_HEIGHT) {
			// ball collided with bottom edge of the screen?
			System.out.println("Game Over");

			ballSpeed[X] = 0;
			ballSpeed[Y] = 0;

			return true;
		} else if (yBallPosition - Settings.BALL_SIZE / 2 <= 0) {
			ySpeed = -ySpeed;

			ballSpeed[X] = xSpeed;
			ballSpeed[Y] = ySpeed;
		} else if (d < Settings.BALL_INVARIANCE) {
			if (xBallPosition + Settings.BALL_SIZE >= xPaddlePosition && xBallPosition
					+ Settings.BALL_SIZE <= xPaddlePosition + (int) Settings.PADDLE_WIDTH + Settings.BALL_SIZE) {

				ySpeed = -ySpeed;

				if (xPaddlePosition >= Settings.WINDOW_WIDTH) {
					xSpeed = xSpeed + 1;
					xSpeed += 1;
				} else {
					xSpeed = xSpeed - 1;
					xSpeed -= 1;
				}

				ballSpeed[X] = xSpeed;
				ballSpeed[Y] = ySpeed;
			}
		} else {
			ballSpeed[X] = xSpeed;
			ballSpeed[Y] = ySpeed;
		}

		return false;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see de.openhpi.capstone1.game.view.AbstractView#update()
	 */
	@Override
	public void update() {

	}
}
