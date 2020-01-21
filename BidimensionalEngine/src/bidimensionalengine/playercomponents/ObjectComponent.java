package bidimensionalengine.playercomponents;

import bidimensionalengine.datastructs.GameObject;

/**
 * @author Dylan Raiff
 * @version 1.0
 */
public abstract class ObjectComponent
{
	/**
	 * Called every tick by the {@code GameLoop}.
	 */
	public abstract void update();

	/**
	 * {@code GameObject} this component is attached to.
	 */
	protected GameObject gameObject;

	/**
	 * Creates a new component and attaches it to the given game object.
	 * 
	 * @param gameObject parent, or attached object
	 */
	public ObjectComponent(GameObject gameObject)
	{ this.gameObject = gameObject; }

	/* Access methods */

	/**
	 * @return the {@code GameObject} this component is attached to
	 */
	public GameObject getParent()
	{ return gameObject; }

}
