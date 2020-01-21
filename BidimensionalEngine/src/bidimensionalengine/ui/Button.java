package bidimensionalengine.ui;

import java.awt.MouseInfo;

import bidimensionalengine.core.Window;
import bidimensionalengine.core.Window.ComplexInterface;
import bidimensionalengine.datastructs.Vector2;
import bidimensionalengine.graphics.Sprite;

/**
 * @author Dylan Raiff
 * @version 1.0
 */
public class Button extends UIElement
{
	/**
	 * Sprite the button takes during default operation.
	 */
	public Sprite defaultSprite;

	/**
	 * Sprite the button uses while the mouse is hovering over it.
	 */
	public Sprite hoverSprite;

	/**
	 * Sprite the button uses while the mouse is pressing it.
	 */
	public Sprite pressedSprite;

	/**
	 * Method to be called on button click.
	 */
	public ComplexInterface onClick;

	/**
	 * Size of the button.
	 */
	public Vector2 size;

	/**
	 * Creates a new button.
	 * 
	 * @param name   name of the button
	 * @param parent parent of the button
	 */
	public Button(String name, Container parent)
	{
		super(name, parent);

		size = new Vector2(10, 20);
	}

	@Override
	public void update()
	{
		if (!Window.getInstance().isVisible())
			return;

		// if (defaultSprite == null || hoverSprite == null || pressedSprite == null)
		// {
		// System.err.println("One or more sprites in " + this + " are null.");
		// return;
		// }

		System.out.println(isMouseHovering());
	}

	private boolean isMouseHovering()
	{
		int x = MouseInfo.getPointerInfo().getLocation().x - Window.getInstance().getLocationOnScreen().x;
		int y = MouseInfo.getPointerInfo().getLocation().x - Window.getInstance().getLocationOnScreen().x;

		if (x >= transform.getPosition().x && x <= transform.getPosition().x + size.x && y >= transform.getPosition().y
				&& y <= transform.getPosition().y + size.y)
			return true;

		return false;
	}
}
