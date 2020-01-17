package bidimensionalengine.engine.ui;

import bidimensionalengine.engine.datastructs.GameObject;
import bidimensionalengine.engine.playercomponents.Transform;

/**
 * @author Dylan Raiff
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
	}

	/**
	 * Called every tick in the main thread.
	 */
	@Override
	public void update()
	{

	}

	/* Access methods */

	public Container getParent()
	{ return uiParent; }
}
