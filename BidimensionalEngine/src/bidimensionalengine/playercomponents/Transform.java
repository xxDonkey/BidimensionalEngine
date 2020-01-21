package bidimensionalengine.playercomponents;

import bidimensionalengine.datastructs.GameObject;
import bidimensionalengine.datastructs.Vector2;

/**
 * @author Dylan Raiff
 * @version 1.0
 */
public class Transform extends ObjectComponent
{
	/**
	 * Transform's position as a {@code Vector2}.
	 */
	private Vector2 position;

	/**
	 * Transform's rotation in degrees.<br>
	 * Zero degrees is east, or the positive end of the x-axis.
	 */
	private double rotation;

	/**
	 * Creates a new {@code Transform}, cand calls the super constructor.
	 * 
	 * @param gameObject parent game object
	 */
	public Transform(GameObject gameObject)
	{
		super(gameObject);

		position = new Vector2(0, 0);
		rotation = 0;
	}

	@Override
	public void update()
	{}

	/**
	 * Translates the {@code Transform} along a translation vector.
	 * 
	 * @param translationVector vector to move along
	 */
	public void translate(Vector2 translationVector)
	{ this.position.add(translationVector); }

	/**
	 * Rotates the {@code Transform} around the axis sticking out of the computer.
	 * 
	 * @param rotationVector amount to rotate, in degrees
	 */
	public void rotate(double rotationAmount)
	{ this.rotation += rotationAmount; }

	/* Access methods */

	/**
	 * @return position of this {@code Transform}
	 */
	public Vector2 getPosition()
	{ return position; }

	/**
	 * @return rotation of this {@code Transform}
	 */
	public double getRotation()
	{ return rotation; }

}
