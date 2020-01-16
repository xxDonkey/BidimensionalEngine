package basic2Dgraphics;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 * @author Dylan Raiff
 */
class CustomGraphics extends Component
{
	private static final long serialVersionUID = -9090743862193079313L;

	public void paint(Graphics g)
	{ Window.getGraphicsMethod().accept((Graphics2D) g); }
}
