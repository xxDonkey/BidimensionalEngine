package bidimensionalengine.engine.datastructs;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import bidimensionalengine.core.Window;
import bidimensionalengine.engine.playercomponents.ObjectComponent;

/**
 * @author Dylan Raiff
 */
public class GameObject
{
	/**
	 * Name of the {@code GameObject}.
	 */
	private String name;

	/**
	 * {@code GameObject} that this is parented to in the hierarchy.
	 */
	private GameObject parent;

	/**
	 * A list containing objects of type {@code GameObject}, where each element has
	 * its parent set to this.
	 */
	private ArrayList<GameObject> children;

	/**
	 * A list containing objects of type {@code ObjectComponent}, representing all
	 * components attached to this {@code GameObject}.
	 */
	private ArrayList<ObjectComponent> components;

	/**
	 * Default constructor.
	 * 
	 * @param name   name of the game object
	 * @param parent parent of the game object
	 */
	public GameObject(String name, GameObject parent)
	{
		this.name = name;
		this.parent = parent;

		children = new ArrayList<GameObject>();
		components = new ArrayList<ObjectComponent>();

		if (Window.getGameLoop() != null)
			Window.getGameLoop().onCreateGameObject(this);
	}

	public void update()
	{

	}

	/**
	 * 
	 * 
	 * @param component
	 */
	public boolean addComponent(Class<?> type)
	{
		Object obj = null;
		try
		{
			obj = type.getDeclaredConstructors()[0].newInstance(this);
		}
		catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| SecurityException e)
		{
			e.printStackTrace();
		}

		if (obj != null && obj instanceof ObjectComponent)
		{
			components.add((ObjectComponent) obj);
			return true;
		}
		return false;
	}

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
}
