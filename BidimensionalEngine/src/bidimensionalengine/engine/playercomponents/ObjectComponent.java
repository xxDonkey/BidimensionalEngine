package bidimensionalengine.engine.playercomponents;

import bidimensionalengine.core.Window;
import bidimensionalengine.engine.datastructs.GameObject;

/**
 * @author Dylan Raiff
 */
public abstract class ObjectComponent
{
	public abstract void update();

	private GameObject parent;
	private PlayerComponentType type;

	public ObjectComponent(GameObject parent, PlayerComponentType type)
	{
		this.parent = parent;
		this.type = type;

		Window.getGameLoop().onCreateObjectComponent(this);
	}

	public void destory()
	{ Window.getGameLoop().onDestoryObjectComponent(this); }

	/* Access methods */

	public GameObject getParent()
	{ return parent; }

	public PlayerComponentType getType()
	{ return type; }
}
