package bidimensionalengine.graphics;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;

import bidimensionalengine.core.Window;

/**
 * @author Dylan Raiff
 */
public class CustomGraphics extends Component
{
	public void paint(Graphics g)
	{ Window.getGraphicsMethod().accept((Graphics2D) g); }
}
