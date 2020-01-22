package bidimensionalengine.ui;

import java.awt.MouseInfo;

import bidimensionalengine.core.Window;
import bidimensionalengine.datastructs.Vector2;
import bidimensionalengine.graphics.Sprite;
import bidimensionalengine.graphics.SpriteLoader;
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
	public ComplexButtonInterface onClick;

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

		if (Window.getOnMouseInputMethodData() == null || Window.getOnMouseInputMethodData().onMousePressed == null
				|| Window.getOnMouseInputMethodData().onMouseReleased == null)
		{
			System.err.println(
					"Error: for the Button class to function, MouseInput:onMousePressed and MouseInput:onMouseReleased must be enabled/");
			return;
		}

		size = new Vector2(50, 50);

		image = (Image) addComponent(Image.class);
	}

	/**
	 * Assigns all three {@code Sprite} variables at once.
	 * 
	 * @param defaultSprite sprite to assign to {@code defaultSprite}.
	 * @param hoverSprite   sprite to assign to {@code hoverSprite}.
	 * @param pressedSprite sprite to assign to {@code pressedSprite}.
	 */
	public void setSprites(String defaultSpriteName, String hoverSpriteName, String pressedSpriteName)
	{
		this.defaultSprite = SpriteLoader.getSprite(defaultSpriteName);
		this.hoverSprite = SpriteLoader.getSprite(hoverSpriteName);
		this.pressedSprite = SpriteLoader.getSprite(pressedSpriteName);
	}

	@Override
	public void update()
	{
		image.size = size;

		if (!Window.getInstance().isVisible())
			return;

		if (!hovering)
			image.sprite = defaultSprite;
		else if (!pressed)
			image.sprite = hoverSprite;
		else
			image.sprite = pressedSprite;

		int x = MouseInfo.getPointerInfo().getLocation().x - Window.getInstance().getLocationOnScreen().x
				+ (int) Window.getGFX().translationVector.x;
		int y = MouseInfo.getPointerInfo().getLocation().y - Window.getInstance().getLocationOnScreen().y
				+ (int) Window.getGFX().translationVector.y;

		hovering = (x >= transform.position.x && x <= transform.position.x + size.x && y >= transform.position.y
				&& y <= transform.position.y + size.y);
	}

	/**
	 * Called when the mouse is clicked.
	 */
	public void onMouseClick()
	{
		pressed = true;

		if (onClick != null)
			onClick.method(this);
	}

	/**
	 * Called when the mouse is released.
	 */
	public void onMouseRelease()
	{ pressed = false; }

	/**
	 * @return whether or not the button is pressed
	 */
	public boolean isPressed()
	{ return pressed; }

	/**
	 * Stores a method.<br>
	 * <BLOCKQUOTE> <u>Returns:</u> void <br>
	 * <u>Arguments (1):</u> Button </BLOCKQUOTE>
	 * 
	 * @author Dylan Raiff
	 */
	public static interface ComplexButtonInterface
	{
		/**
		 * Stored method of the {@code ComplexButtonInterface}.
		 */
		public void method(Button button);
	}
}
