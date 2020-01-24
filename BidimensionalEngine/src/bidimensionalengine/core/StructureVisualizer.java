package bidimensionalengine.core;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.JFrame;

/**
 * @author Dylan Raiff
 * @version 1.0
 */
class StructureVisualizer extends JFrame
{
	private final static int DEFAULT_WIDTH = 250;

	private final static int DEFAULT_HEIGHT = 600;

	public StructureVisualizer()
	{
		super("Structure Visualizer");

		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();

		this.setPreferredSize(new Dimension((int) screen.getWidth() / 8, (int) screen.getHeight() / 2));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(new Point((int) screen.getWidth() / 8, (int) screen.getHeight() / 4));

		this.pack();
		this.setVisible(true);
	}

	public void graphics(Graphics2D g)
	{ g.setBackground(Color.WHITE); }
}
