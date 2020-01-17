package bidimensionalengine.engine.playercomponents;

import bidimensionalengine.engine.datastructs.GameObject;
import bidimensionalengine.engine.datastructs.Vector2;

public class Transform extends ObjectComponent
{
	/**
	 * 
	 */
	Vector2 position;

	/**
	 * 
	 */
	Vector2 rotation;

	/**
	 * 
	 * @param gameObject
	 */
	public Transform(GameObject gameObject)
	{
		super(gameObject);

		position = Vector2.zero;
		rotation = Vector2.zero;
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
