package bidimensionalengine.graphics;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import bidimensionalengine.core.Window;

/**
 * @author Dylan Raiff
 * @version 1.0
 */
public final class SpriteLoader
{
	/**
	 * Private constructer to disallow instantiation of the class.
	 */
	private SpriteLoader()
	{}

	/**
	 * Atlas of all loaded sprites.
	 */
	private static ArrayList<Sprite> loadedSprites = new ArrayList<Sprite>();

	/**
	 * Loads the specified file. Called in
	 * {@code bidimensionalengine.core.Window.startMethod} for each file found in
	 * {@code bidimensionalengine.core.Window.assetDirectory}.
	 * 
	 * @param filename filename of image to load
	 * @return true if successfully loaded, otherwise false
	 */
	public static boolean loadImage(String filename)
	{
		if (Window.getInstance() == null)
			return false;

		BufferedImage img = null;
		try
		{
			FileInputStream fileInputStream = new FileInputStream(
					new File(Window.getAssetDirectory() + "sprites/" + filename));
			img = ImageIO.read(fileInputStream);
			loadedSprites.add(new Sprite(filename, img));
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * Returns the sprite at the specified index in {@code loadedSprites},
	 * {@code null} if index is out of bounds.
	 * 
	 * @param index index of sprite to retrieve
	 * @return desired sprite
	 */
	public static Sprite getSprite(int index)
	{
		if (index < 0 || index > loadedSprites.size() - 1)
			return null;

		return loadedSprites.get(index);
	}

	/**
	 * Returns the sprite in {@code loadedSprites} if it exists, otherwise
	 * {@code null}.
	 * 
	 * @param name name of sprite to retrive
	 * @return desired sprite
	 */
	public static Sprite getSprite(String name)
	{
		for (Sprite s : loadedSprites)
		{
			if (s.getName().equals(name))
				return s;
		}

		return null;
	}
}
