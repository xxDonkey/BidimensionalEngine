package bidimensionalengine.ui;

import bidimensionalengine.graphics.Sprite;
import bidimensionalengine.graphics.SpriteLoader;

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
	 * Sprite of the filled slider (space to the right of the slider button).
	 */
	public Sprite fillSprite;

	/**
	 * Background sprite of the slider.
	 */
	public Sprite backgroundSprite;

	/**
	 * Creates a new slider.
	 * 
	 * @param name   name of the slider
	 * @param parent parent of the slider
	 */
	public Slider(String name, Container parent)
	{ super(name, parent); }

	/**
	 * Assigns all three {@code Sprite} variables at once.
	 * 
	 * @param buttonSpriteName     name of the button sprite
	 * @param fillSpriteName       name of the fill sprite
	 * @param backgroundSpriteName name of the background sprite
	 */
	public void setSprites(String buttonSpriteName, String fillSpriteName, String backgroundSpriteName)
	{
		this.buttonSprite = SpriteLoader.getSprite(buttonSpriteName);
		this.fillSprite = SpriteLoader.getSprite(fillSpriteName);
		this.backgroundSprite = SpriteLoader.getSprite(backgroundSpriteName);
	}

	@Override
	public void update()
	{

	}

}
