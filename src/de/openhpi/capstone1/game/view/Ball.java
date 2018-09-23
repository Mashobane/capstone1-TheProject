package de.openhpi.capstone1.game.view;

import de.openhpi.capstone1.game.starter.Settings;
import processing.core.PApplet;
import processing.core.PConstants;

/**
 * The Class Ball.
 */
public class Ball extends AbstractView {

	/** The Constant X Coordinate Position. */
	private static final int X = 0;

	/** The Constant Y Coordinate Position. */
	private static final int Y = 1;

	/** The first. */
	private int first = 0;

	/** The paddle X position. */
	private int paddleXPosition = 0;

	/** The x. */
	private int xPosition;

	/** The y. */
	private int yPosition;

	/** The xSpeed. */
	private int xSpeed;

	/** The ySpeed. */
	private int ySpeed;

	/** The ball coordinates. */
	private int[] ballCoord = new int[2];

	/** The collision. */
	private final CollideWith collision = new CollideWith(display);

	/**
	 * Instantiates a new ball.
	 *
	 * @param display the display
	 */
	public Ball(final PApplet display) {
		super(display);
	}

	/**
	 * Sets the speed.
	 *
	 * @param xSpeed the x speed
	 * @param ySpeed the y speed
	 */
	public void setSpeed(final int xSpeed, final int ySpeed) {

		this.xSpeed = xSpeed;
		this.ySpeed = ySpeed;
	}

	/**
	 * Move.
	 *
	 * @return the int[]
	 */
	public int[] move() {
		this.xPosition += xSpeed;
		this.yPosition += ySpeed;

		this.ballCoord[X] = this.xPosition;
		this.ballCoord[Y] = this.yPosition;

		this.xPosition = PApplet.constrain(this.xPosition, Settings.BALL_SIZE / 2,
				Settings.WINDOW_WIDTH - Settings.BALL_SIZE / 2);
		this.yPosition = PApplet.constrain(this.yPosition, Settings.BALL_SIZE / 2,
				Settings.WINDOW_HEIGHT - Settings.BALL_SIZE / 2);

		return ballCoord;
	}

	/**
	 * Random start.
	 */
	public void randomStart() {
		this.xPosition = Settings.WINDOW_WIDTH / 2;
		this.yPosition = Settings.WINDOW_HEIGHT / 2;

		this.xSpeed = Math.round((Math.abs(display.random(Settings.BALL_SPEED * 2) - Settings.BALL_SPEED)));
		this.ySpeed = (int) Math.sqrt(Math.pow(Settings.BALL_SPEED, 2) - this.xSpeed * this.xSpeed)
				+ (int) (display.random(2));

		while (this.ySpeed == 0) {
			this.ySpeed = (int) Math.sqrt(Math.pow(Settings.BALL_SPEED, 2) - this.xSpeed * this.xSpeed);
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see de.openhpi.capstone1.game.view.AbstractView#update()
	 */
	@Override
	public void update() {
		display.ellipseMode(PConstants.CENTER);
		display.fill(Settings.BALL_COLOR);

		if (first == 0) {
			randomStart();
			ballCoord = move();
			display.ellipse(ballCoord[X], ballCoord[Y], Settings.BALL_SIZE, Settings.BALL_SIZE);
			first = 1;
		} else {
			if (collision.collideWithWall(xPosition, yPosition, xSpeed, ySpeed, paddleXPosition)) {
				randomStart();
				ballCoord = move();
				display.ellipse(ballCoord[X], ballCoord[Y], Settings.BALL_SIZE, Settings.BALL_SIZE);
			} else {
				collision.collideWithWall(xPosition, yPosition, xSpeed, ySpeed, paddleXPosition);
				setSpeed(collision.ballSpeed[X], collision.ballSpeed[Y]);
				ballCoord = move();
				display.ellipse(ballCoord[X], ballCoord[Y], Settings.BALL_SIZE, Settings.BALL_SIZE);
			}
		}
	}

	/**
	 * Sets the paddle X position.
	 *
	 * @param paddleXPosition the new paddle X position
	 */
	public void setPaddleXPosition(final int paddleXPosition) {
		this.paddleXPosition = paddleXPosition;
	}
}
