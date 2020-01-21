package bidimensionalengine.ui;

import bidimensionalengine.core.Window;
import bidimensionalengine.datastructs.GameObject;
import bidimensionalengine.playercomponents.Transform;

/**
 * @author Dylan Raiff
 * @version 1.0
 */
public abstract class UIElement extends GameObject
{
	/**
	 * Container that this {@code UIElement} belongs to.
	 */
	protected Container uiParent;

	/**
	 * Creates a standard {@code UIElement}.
	 * 
	 * @param name   of the element
	 * @param parent container the element belongs to
	 */
	public UIElement(String name, Container parent)
	{
		super(name, (GameObject) parent);
		this.parent = parent;

		this.transform = new Transform((GameObject) parent);

		if (Window.getGameLoop() != null)
			Window.getGameLoop().onCreateGameObject(this);
	}

	/* Access methods */

	/**
	 * @return {@code Container} this element is in
	 */
	public Container getParent()
	{ return uiParent; }
}
