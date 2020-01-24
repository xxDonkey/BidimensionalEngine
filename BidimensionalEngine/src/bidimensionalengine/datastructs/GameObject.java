package bidimensionalengine.datastructs;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import bidimensionalengine.core.Window;
import bidimensionalengine.playercomponents.Image;
import bidimensionalengine.playercomponents.ObjectComponent;
import bidimensionalengine.playercomponents.Transform;
import bidimensionalengine.ui.UIElement;

/**
 * @author Dylan Raiff
 * @version 1.0
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

		if (parent != null)
			parent.addChild(this);

		if (Window.getGameLoop() != null && !(this instanceof UIElement))
			Window.getGameLoop().onCreateGameObject(this);
	}

	/**
	 * Adds a child to the list.
	 * 
	 * @param child child to add.
	 */
	private void addChild(GameObject child)
	{ children.add(child); }

	/**
	 * Called every tick in the main thread.
	 */
	public void update()
	{

	}

	/**
	 * Creates and adds a component of the specified type. If any error was thrown,
	 * or the class is not an extension of {@code ObjectCompoennt}, null is
	 * returned. Otherwise, returns the added component.
	 * 
	 * @param type class of component to add
	 */
	public ObjectComponent addComponent(Class<?> type)
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

			return (ObjectComponent) obj;
		}
		return null;
	}

	/**
	 * Removes a componnent to this game object.
	 * 
	 * @param component component to remove
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
	 * Gets the component of a specified type.
	 * 
	 * @param type type of component to retrieve
	 * @return desired component
	 */
	public ObjectComponent getComponent(Class<?> type)
	{
		for (ObjectComponent component : components)
		{
			if (component.getClass().toString().equals(type.getClass().toString()))
				return component;
		}

		return null;
	}

	/**
	 * Recursively finds all game objects related to {@code this}.
	 * 
	 * @return all desendants
	 */
	public ArrayList<GameObject> getDesendants()
	{
		if (children.size() == 0)
			return new ArrayList<GameObject>();

		ArrayList<GameObject> descendants = new ArrayList<GameObject>();
		for (GameObject child : children)
		{
			ArrayList<GameObject> childDescendants = child.getDesendants();
			for (GameObject descendant : childDescendants)
			{
				descendant.addChild(descendant);
			}
		}

		return descendants;
	}

	/**
	 * Destorys this game object.
	 */
	public void destory()
	{ Window.getGameLoop().onDestoryGameObject(this); }

	/* Access methods */

	/**
	 * @return name of the game object
	 */
	public String getName()
	{ return name; }

	/**
	 * @return parent of the game object
	 */
	public GameObject getParent()
	{ return parent; }

	/**
	 * @return transform of the game object
	 */
	public Transform getTransform()
	{ return transform; }

	/**
	 * @return list of children of the game object
	 */
	public ArrayList<GameObject> getChildren()
	{ return children; }

}
