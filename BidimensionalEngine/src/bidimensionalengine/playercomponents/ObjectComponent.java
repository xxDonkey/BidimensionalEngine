package bidimensionalengine.playercomponents;

import bidimensionalengine.datastructs.GameObject;

/**
 * @author Dylan Raiff
 * @version 1.0
 */
public abstract class ObjectComponent
{
	public abstract void update();

	protected GameObject gameObject;

	public ObjectComponent(GameObject gameObject)
	{ this.gameObject = gameObject; }

	/* Access methods */

	public GameObject getParent()
	{ return gameObject; }

}
