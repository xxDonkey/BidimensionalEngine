package bidimensionalengine.engine.playercomponents;

import bidimensionalengine.engine.datastructs.GameObject;

/**
 * @author Dylan Raiff
 */
public abstract class ObjectComponent
{
	public abstract void update();

	private GameObject gameObject;
	private PlayerComponentType type;

	public ObjectComponent(GameObject gameObject, PlayerComponentType type)
	{
		this.gameObject = gameObject;
		this.type = type;
	}

	/* Access methods */

	public GameObject getParent()
	{ return gameObject; }

	public PlayerComponentType getType()
	{ return type; }
}
