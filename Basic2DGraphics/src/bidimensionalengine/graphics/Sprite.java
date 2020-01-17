package bidimensionalengine.graphics;

import java.awt.image.BufferedImage;

/**
 * @author Dylan Raiff
 */
public class Sprite
{
	/**
	 * Name of the sprite.
	 */
	private String name;

	/**
	 * The {@code BufferedImage} that holds the sprite's image data.
	 */
	private BufferedImage image;

	/**
	 * Creates a new {@code Sprite} with name {@code name} and the image data of
	 * {@code bufferedImage}
	 * 
	 * @param name          name of sprite
	 * @param bufferedImage image data of sprite
	 */
	public Sprite(String name, BufferedImage bufferedImage)
	{
		this.name = name;
		this.image = bufferedImage;
	}

	/* Access methods */

	public String getName()
	{ return name; }

	public BufferedImage getImage()
	{ return image; }
}
