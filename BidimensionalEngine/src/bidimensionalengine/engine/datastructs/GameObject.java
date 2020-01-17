package bidimensionalengine.engine.datastructs;

import java.util.ArrayList;

import bidimensionalengine.core.Window;
import bidimensionalengine.engine.playercomponents.ObjectComponent;
import bidimensionalengine.engine.playercomponents.PlayerComponentType;

/**
 * @author Dylan Raiff
 */
public class GameObject
{
	/**
	 * 
	 */
	String name;

	/**
	 * 
	 */
	GameObject parent;

	/**
	 * 
	 */
	ArrayList<GameObject> children;

	/**
	 * 
	 */
	ArrayList<ObjectComponent> components;

	/**
	 * 
	 * @param name
	 * @param parent
	 */
	public GameObject(String name, GameObject parent)
	{
		this.name = name;
		this.parent = parent;

		children = new ArrayList<GameObject>();
		components = new ArrayList<ObjectComponent>();

		Window.getGameLoop().onCreateGameObject(this);
	}

	/**
	 * 
	 * @param component
	 */
	public void addComponent(ObjectComponent component)
	{ components.add(component); }

	/**
	 * 
	 * @param component
	 */
	public void removeComponent(ObjectComponent component)
	{ components.remove(component); }

	/**
	 * 
	 */
	public void destory()
	{ Window.getGameLoop().onDestoryGameObject(this); }

	/**
	 * 
	 * @param type
	 * @return
	 */
	public ObjectComponent getComponent(PlayerComponentType type)
	{
		for (ObjectComponent c : components)
		{
			if (c.getType() == type)
				return c;
		}
		return null;
	}

}
