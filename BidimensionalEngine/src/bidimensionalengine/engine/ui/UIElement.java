package bidimensionalengine.engine.ui;

import bidimensionalengine.engine.datastructs.GameObject;
import bidimensionalengine.engine.playercomponents.Transform;

public abstract class UIElement extends GameObject
{
	protected Container parent;

	protected Transform transform;

	public UIElement(String name, Container parent)
	{
		super(name, (GameObject) parent);
		this.parent = parent;

		this.transform = new Transform((GameObject) parent);
	}

	public String getName()
	{ return name; }

	public Container getParent()
	{ return parent; }
}
