package bidimensionalengine.engine.playercomponents;

import java.awt.Graphics2D;

import bidimensionalengine.core.Window;
import bidimensionalengine.core.graphics.Sprite;
import bidimensionalengine.engine.datastructs.GameObject;

public class Image extends ObjectComponent
{
	public Sprite sprite;

	public Image(GameObject gameObject)
	{
		super(gameObject);

	}

	@Override
	public void update()
	{

	}

	public void render(Graphics2D g)
	{
		int x = (int) gameObject.getTransform().position.x;
		int y = (int) gameObject.getTransform().position.y;

		g.drawImage(sprite.getImage(), x, y, Window.getGFX());
	}

}
