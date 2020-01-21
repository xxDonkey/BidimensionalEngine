package bidimensionalengine.playercomponents;

import java.awt.Graphics2D;

import bidimensionalengine.core.Window;
import bidimensionalengine.datastructs.GameObject;
import bidimensionalengine.graphics.Sprite;
import bidimensionalengine.graphics.SpriteLoader;

/**
 * @author Dylan Raiff
 * @version 1.0
 */
public class Image extends ObjectComponent
{
	public Sprite sprite;

	public Image(GameObject gameObject)
	{
		super(gameObject);
		sprite = null;
	}

	public void setSprite(String spriteName)
	{ sprite = SpriteLoader.getSprite(spriteName); }

	@Override
	public void update()
	{

	}

	public void render(Graphics2D g)
	{
		if (sprite == null)
			return;

		int x = (int) gameObject.getTransform().position.x;
		int y = (int) gameObject.getTransform().position.y;

		g.drawImage(sprite.getImage(), x, y, Window.getGFX());
	}

}
