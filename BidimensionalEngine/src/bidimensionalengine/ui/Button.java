package bidimensionalengine.ui;

import java.awt.MouseInfo;

import bidimensionalengine.core.Window;
import bidimensionalengine.core.Window.ComplexInterface;
import bidimensionalengine.datastructs.Vector2;
import bidimensionalengine.graphics.Sprite;
import bidimensionalengine.playercomponents.Image;

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
	 * {@code Image} component of this button.
	 */
	private Image image;

	/**
	 * Whether or not the mouse is hovering over the button.
	 */
	private boolean hovering;

	/**
	 * Whether or not the button is being pressed.
	 */
	private boolean pressed;

	/**
	 * Creates a new button.
	 * 
	 * @param name   name of the button
	 * @param parent parent of the button
	 */
	public Button(String name, Container parent)
	{
		super(name, parent);

		if (Window.getOnMouseInputMethodData() == null)
			System.err.println("Error: for the Button class to function, mouse input must be on.");

		size = new Vector2(10, 20);

		image = (Image) addComponent(Image.class);
	}

	/**
	 * Assigns all three {@code Sprite} variables at once.
	 * 
	 * @param defaultSprite sprite to assign to {@code defaultSprite}.
	 * @param hoverSprite   sprite to assign to {@code hoverSprite}.
	 * @param pressedSprite sprite to assign to {@code pressedSprite}.
	 */
	public void setSprites(Sprite defaultSprite, Sprite hoverSprite, Sprite pressedSprite)
	{
		this.defaultSprite = defaultSprite;
		this.hoverSprite = hoverSprite;
		this.pressedSprite = pressedSprite;
	}

	@Override
	public void update()
	{
		if (!Window.getInstance().isVisible())
			return;

		if (!hovering)
		{
			image.sprite = defaultSprite;
			pressed = false;
		}
		else if (!pressed)
			image.sprite = hoverSprite;
		else
			image.sprite = pressedSprite;

		int x = MouseInfo.getPointerInfo().getLocation().x - Window.getInstance().getLocationOnScreen().x;
		int y = MouseInfo.getPointerInfo().getLocation().x - Window.getInstance().getLocationOnScreen().x;

		hovering = (x >= transform.position.x && x <= transform.position.x + size.x && y >= transform.position.y
				&& y <= transform.position.y + size.y);

		// System.out.println(hovering + " " + pressed);
	}

	/**
	 * Called when the mouse is clicked.
	 */
	public void onMouseClick()
	{
		pressed = true;

		if (onClick != null)
			onClick.method();
	}

	/**
	 * Called when the mouse is released.
	 */
	public void onMouseRelease()
	{ pressed = false; }

	private boolean isMouseHovering()
	{
		int x = MouseInfo.getPointerInfo().getLocation().x - Window.getInstance().getLocationOnScreen().x;
		int y = MouseInfo.getPointerInfo().getLocation().x - Window.getInstance().getLocationOnScreen().x;

		if (x >= transform.position.x && x <= transform.position.x + size.x && y >= transform.position.y
				&& y <= transform.position.y + size.y)
			return true;

		return false;
	}
}
