package basic2Dgraphics;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 * @author Dylan Raiff
 */
class CustomGraphics extends Component
{
	public void paint(Graphics g)
	{ Window.getGraphicsMethod().accept((Graphics2D) g); }
}
