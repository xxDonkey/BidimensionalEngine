package bidimensionalengine.ui;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

/**
 * @author Dylan Raiff
 * @version 1.0
 */
public class Container extends UIElement
{
	/**
	 * All {@code UIElements} that are contained in this {@code Container}.
	 */
	private ArrayList<UIElement> children;

	/**
	 * Creates a new {@code Container}.
	 * 
	 * @param name   name of the container
	 * @param parent container this {@code UIElement} is contained in
	 */
	public Container(String name, Container parent)
	{
		super(name, parent);
		children = new ArrayList<UIElement>();
	}

	/**
	 * Creates and adds an {@code UIElement} of the specified type. If any error was
	 * thrown, or the class is not an extension of {@code UIElement}, null is
	 * returned. Otherwise, returns the added element.
	 * 
	 * @param type type of element to add
	 * @param name name of element to add
	 * @return added element
	 */
	public UIElement addElement(Class<?> type, String name)
	{
		Object obj = null;
		try
		{
			obj = type.getConstructors()[0].newInstance(name, this);
		}
		catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| SecurityException e)
		{
			e.printStackTrace();
		}

		if (obj != null && obj instanceof UIElement)
		{
			children.add((UIElement) obj);
			return (UIElement) obj;
		}
		return null;
	}

	/**
	 * Removes a given {@code UIElement} from the {@code children} list.
	 * 
	 * @param element element to remove
	 */
	public void removeElement(UIElement element)
	{ children.remove(element); }
}
