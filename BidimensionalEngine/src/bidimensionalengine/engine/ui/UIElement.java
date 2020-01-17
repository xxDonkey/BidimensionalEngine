package bidimensionalengine.engine.ui;

public abstract class UIElement
{
	private String name;
	private Container parent;

	public UIElement(String name, Container parent)
	{
		this.name = name;
		this.parent = parent;
	}

	public String getName()
	{ return name; }

	public Container getParent()
	{ return parent; }
}
