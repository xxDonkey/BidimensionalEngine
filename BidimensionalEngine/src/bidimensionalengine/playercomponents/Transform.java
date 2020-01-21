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
	Vector2 position;

	/**
	 * Transform's rotation as a {@code Vector2}.
	 */
	Vector2 rotation;

	/**
	 * 
	 * @param gameObject
	 */
	public Transform(GameObject gameObject)
	{
		super(gameObject);

		position = new Vector2(0, 0);
		rotation = new Vector2(0, 0);
	}

	/**
	 * 
	 */
	@Override
	public void update()
	{}

	/**
	 * 
	 * @param translationVector
	 */
	public void translate(Vector2 translationVector)
	{ this.position.add(translationVector); }

	/**
	 * 
	 * @param rotationVector
	 */
	public void rotate(Vector2 rotationVector)
	{ this.rotation.add(rotationVector); }

}
