package bidimensionalengine.engine.datastructs;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import bidimensionalengine.core.Window;
import bidimensionalengine.engine.playercomponents.Image;
import bidimensionalengine.engine.playercomponents.ObjectComponent;
import bidimensionalengine.engine.playercomponents.Transform;

/**
 * @author Dylan Raiff
 */
public class GameObject
{
	/**
	 * Name of the {@code GameObject}.
	 */
	protected String name;

	/**
	 * {@code GameObject} that this is parented to in the hierarchy.
	 */
	protected GameObject parent;

	/**
	 * {@code Transform} that belongs to the game object.
	 */
	protected Transform transform;

	/**
	 * A list containing objects of type {@code GameObject}, where each element has
	 * its parent set to this.
	 */
	protected ArrayList<GameObject> children;

	/**
	 * A list containing objects of type {@code ObjectComponent}, representing all
	 * components attached to this {@code GameObject}.
	 */
	protected ArrayList<ObjectComponent> components;

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

		this.transform = new Transform(this);

		this.children = new ArrayList<GameObject>();
		this.components = new ArrayList<ObjectComponent>();

		if (Window.getGameLoop() != null)
			Window.getGameLoop().onCreateGameObject(this);
	}

	/**
	 * Called every tick in the main thread.
	 */
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
			if (obj instanceof Image)
			{
				Window.getGFX().addImageRenderMethod(((Image) obj)::render);
			}

			return true;
		}
		return false;
	}

	/**
	 * 
	 * @param component
	 */
	public void removeComponent(ObjectComponent component)
	{
		components.remove(component);
		if (component instanceof Image)
		{
			Window.getGFX().removeImageRenderMethod(((Image) component)::render);
		}
	}

	/**
	 * 
	 */
	public void destory()
	{ Window.getGameLoop().onDestoryGameObject(this); }

	/* Access methods */

	public String getName()
	{ return name; }

	public Transform getTransform()
	{ return transform; }

}
