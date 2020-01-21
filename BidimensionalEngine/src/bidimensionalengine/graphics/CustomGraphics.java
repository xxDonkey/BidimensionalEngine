package bidimensionalengine.graphics;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.function.Consumer;

import bidimensionalengine.core.Window;

/**
 * @author Dylan Raiff
 * @version 1.0
 */
public final class CustomGraphics extends Component
{
	/**
	 * Methods to be called to render UI.
	 */
	private ArrayList<Consumer<Graphics2D>> imageRenderMethods;

	/**
	 * Initializes the {@code imageRenderMethods} {@code ArrayList}.
	 */
	public CustomGraphics()
	{ imageRenderMethods = new ArrayList<Consumer<Graphics2D>>(); }

	/**
	 * Called behind the scenes. <br>
	 * Calls the graphics function passed to the constructor of
	 * {@code bidimensionalengine.core.Window}.
	 */
	@Override
	public void paint(Graphics g)
	{
		if (Window.getTPS() > 0 && (Window.getThread() == null || !Window.getThread().isAlive()))
			return;

		Window.getGraphicsMethod().accept((Graphics2D) g);

		for (Consumer<Graphics2D> method : imageRenderMethods)
			method.accept((Graphics2D) g);
	}

	/**
	 * Adds a method to list list of render methods to call.
	 * 
	 * @param method method to add
	 */
	public void addImageRenderMethod(Consumer<Graphics2D> method)
	{ imageRenderMethods.add(method); }

	/**
	 * Removes a method to list list of render methods to call.
	 * 
	 * @param method method to remove
	 */
	public void removeImageRenderMethod(Consumer<Graphics2D> method)
	{ imageRenderMethods.remove(method); }
}
