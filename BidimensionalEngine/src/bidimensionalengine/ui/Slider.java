package bidimensionalengine.ui;

import bidimensionalengine.core.Window;
import bidimensionalengine.datastructs.Vector2;
import bidimensionalengine.graphics.Sprite;
import bidimensionalengine.graphics.SpriteLoader;
import bidimensionalengine.playercomponents.Image;

/**
 * @author Dylan Raiff
 * @version 1.0
 */
public class Slider extends UIElement
{
	/**
	 * Sprite of the slider button.
	 */
	public Sprite buttonSprite;

	/**
	 * Background sprite of the slider.
	 */
	public Sprite backgroundSprite;

	/**
	 * Dimensions of the silder.
	 */
	public Vector2 size;

	/**
	 * Size of the silder's button.
	 */
	public Vector2 buttonSize;

	/**
	 * Button belonging to of the slider.
	 */
	private Button button;

	/**
	 * Background image of the slider.
	 */
	private Image image;

	/**
	 * Creates a new slider.
	 * 
	 * @param name   name of the slider
	 * @param parent parent of the slider
	 */
	public Slider(String name, Container parent)
	{
		super(name, parent);

		if (Window.getOnMouseInputMethodData() == null || Window.getOnMouseInputMethodData().onMousePressed == null
				|| Window.getOnMouseInputMethodData().onMouseReleased == null)
		{
			abort(this);
		}

		size = new Vector2(50, 5);
		buttonSize = new Vector2(10, 10);

		button = new Button(name + ".button", null);
		image = (Image) addComponent(Image.class);
	}

	/**
	 * Assigns all three {@code Sprite} variables at once.
	 * 
	 * @param buttonSpriteName     name of the button sprite
	 * @param fillSpriteName       name of the fill sprite
	 * @param backgroundSpriteName name of the background sprite
	 */
	public void setSprites(String buttonSpriteName, String backgroundSpriteName)
	{
		this.buttonSprite = SpriteLoader.getSprite(buttonSpriteName);
		this.backgroundSprite = SpriteLoader.getSprite(backgroundSpriteName);
	}

	@Override
	public void update()
	{
		if (image == null || button == null || buttonSprite == null)
			return;

		image.size = size;
		button.size = buttonSize;

		if (!Window.getInstance().isVisible())
			return;

		image.sprite = backgroundSprite;
		button.setSprites(buttonSprite.getName(), buttonSprite.getName(), buttonSprite.getName());

		if (button.isPressed())
		{
			System.out.println(button.size);
		}
	}

}
