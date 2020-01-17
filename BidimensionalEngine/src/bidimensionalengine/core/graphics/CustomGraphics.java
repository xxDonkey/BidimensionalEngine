package bidimensionalengine.core.graphics;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.function.Consumer;

import bidimensionalengine.core.Window;

/**
 * @author Dylan Raiff
 */
public final class CustomGraphics extends Component
{
	/**
	 * Methods to be called to render UI.
	 */
	private ArrayList<Consumer<Graphics2D>> imageRenderMethods;

	/**
	 * Called behind the scenes. <br>
	 * Calls the graphics function passed to the constructor of
	 * {@code bidimensionalengine.core.Window}.
	 */
	@Override
	public void paint(Graphics g)
	{
		Window.getGraphicsMethod().accept((Graphics2D) g);

		for (Consumer<Graphics2D> method : imageRenderMethods)
			method.accept((Graphics2D) g);
	}

	/**
	 * 
	 * @param method
	 */
	public void addImageRenderMethod(Consumer<Graphics2D> method)
	{ imageRenderMethods.add(method); }

	/**
	 * 
	 * @param method
	 */
	public void removeImageRenderMethod(Consumer<Graphics2D> method)
	{ imageRenderMethods.remove(method); }
}
