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
	 * 
	 */
	private ArrayList<UIElement> children;

	/**
	 * 
	 * @param name
	 * @param parent
	 */
	public Container(String name, Container parent)
	{
		super(name, parent);
		children = new ArrayList<UIElement>();
	}

	/**
	 * 
	 * @param type
	 * @param name
	 * @return
	 */
	public boolean addElement(Class<?> type, String name)
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
			return true;
		}
		return false;
	}

	/**
	 * 
	 * @param element
	 */
	public void removeElement(UIElement element)
	{ children.remove(element); }
}
