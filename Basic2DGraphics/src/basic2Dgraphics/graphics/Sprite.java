package basic2Dgraphics.graphics;

import java.awt.image.BufferedImage;

/**
 * @author Dylan Raiff
 */
public class Sprite
{
	private String name;
	private BufferedImage image;

	public Sprite(String name, BufferedImage bufferedImage)
	{
		this.name = name;
		this.image = bufferedImage;
	}

	public String getName()
	{ return name; }

	public BufferedImage getImage()
	{ return image; }
}
