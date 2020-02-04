package bidimensionalengine.playercomponents;

import java.awt.Graphics2D;

import bidimensionalengine.datastructs.GameObject;
import bidimensionalengine.datastructs.Vector2;
import bidimensionalengine.graphics.Sprite;
import bidimensionalengine.graphics.SpriteLoader;

/**
 * @author Dylan Raiff
 * @version 1.0
 */
public class Image extends ObjectComponent
{
	/**
	 * {@code Sprite} object to render.
	 */
	public Sprite sprite;

	/**
	 * Size of the image.
	 */
	public Vector2 size;

	/**
	 * Creates a new {@code Image}, cand calls the super constructor.
	 * 
	 * @param gameObject parent game object
	 */
	public Image(GameObject gameObject)
	{
		super(gameObject);
		size = new Vector2();
	}

	/**
	 * Sets the name of the sprite.
	 * 
	 * @param spriteName name to give to the sprite
	 */
	public void setSprite(String spriteName)
	{ sprite = SpriteLoader.getSprite(spriteName); }

	@Override
	public void update()
	{

	}

	/**
	 * Renders the image.
	 * 
	 * @param g {@code Graphics2D} object to draw to
	 */
	public void render(Graphics2D g)
	{
		if (sprite == null)
			return;

		int x = (int) gameObject.getTransform().position.x;
		int y = (int) gameObject.getTransform().position.y;

		g.drawImage(sprite.getImage(), x, y, (int) size.x, (int) size.y, null);
	}

}
