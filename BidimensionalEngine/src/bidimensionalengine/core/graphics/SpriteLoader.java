package bidimensionalengine.core.graphics;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import bidimensionalengine.core.Window;

/**
 * @author Dylan Raiff
 */
public final class SpriteLoader
{
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
			FileInputStream fileInputStream = new FileInputStream(new File(Window.getAssetDirectory() + filename));
			img = ImageIO.read(fileInputStream);
			loadedSprites.add(new Sprite(null, img));
		}
		catch (IOException e)
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
	public Sprite getSprite(int index)
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
	public Sprite getSprite(String name)
	{
		for (Sprite s : loadedSprites)
		{
			if (s.getName().equals(name))
				return s;
		}

		return null;
	}
}
