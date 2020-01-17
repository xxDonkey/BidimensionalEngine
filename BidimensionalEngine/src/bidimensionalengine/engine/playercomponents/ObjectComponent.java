package bidimensionalengine.engine.playercomponents;

import bidimensionalengine.engine.datastructs.GameObject;

/**
 * @author Dylan Raiff
 */
public abstract class ObjectComponent
{
	public abstract void update();

	private GameObject gameObject;

	public ObjectComponent(GameObject gameObject)
	{ this.gameObject = gameObject; }

	/* Access methods */

	public GameObject getParent()
	{ return gameObject; }

}
