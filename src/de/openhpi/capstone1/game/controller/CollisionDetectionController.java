package de.openhpi.capstone1.game.controller;

import de.openhpi.capstone1.game.starter.Settings;
import processing.core.PApplet;

/**
 * The Class CollideWith.
 */
public class CollisionDetectionController extends Controller {

	/** The Constant X Coordinate Position. */
	public static final int X = 0;

	/** The Constant Y Coordinate Position. */
	public static final int Y = 1;

	/** The ball X,Y speed. */
	private int[] ballSpeed = new int[2];

	/**
	 * Instantiates a new collide with.
	 *
	 * @param display the display
	 */

	public CollisionDetectionController(final PApplet display) {
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
				|| (xBallPosition - Settings.BALL_SIZE / 2 <= 0)) {
			xSpeed = -xSpeed;

			getBallSpeed()[X] = xSpeed;
			getBallSpeed()[Y] = ySpeed;
		} else if (yBallPosition + Settings.BALL_SIZE / 2 == Settings.WINDOW_HEIGHT) {
			// ball collided with bottom edge of the screen?
			GameState.GameOver();

			getBallSpeed()[X] = 0;
			getBallSpeed()[Y] = 0;

			return true;
		} else if (yBallPosition - Settings.BALL_SIZE / 2 <= 0) {
			ySpeed = -ySpeed;

			getBallSpeed()[X] = xSpeed;
			getBallSpeed()[Y] = ySpeed;
		} else if (d < Settings.BALL_INVARIANCE) {
			if (xBallPosition + Settings.BALL_SIZE >= xPaddlePosition && xBallPosition
					+ Settings.BALL_SIZE <= xPaddlePosition + (int) Settings.PADDLE_WIDTH + Settings.BALL_SIZE) {

				ySpeed = -ySpeed;

				if (xPaddlePosition + Settings.PADDLE_WIDTH >= Settings.WINDOW_WIDTH) {
					xSpeed += 1;
				} else {
					xSpeed -= 1;
				}

				getBallSpeed()[X] = xSpeed;
				getBallSpeed()[Y] = ySpeed;
			}
		} else {
			getBallSpeed()[X] = xSpeed;
			getBallSpeed()[Y] = ySpeed;
		}

		return false;
	}

	/**
	 * Gets the ball speed.
	 *
	 * @return the ball speed
	 */
	public int[] getBallSpeed() {
		return ballSpeed;
	}

	/**
	 * Sets the ball speed.
	 *
	 * @param ballSpeed the new ball speed
	 */
	public void setBallSpeed(final int[] ballSpeed) {
		this.ballSpeed = ballSpeed;
	}
}
