package bidimensionalengine.core;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.JFrame;

/**
 * Helps with visualization of the games structure/hierarchy. Graphics handled
 * in {@code StructureVisualizerCustomGraphics}.
 * 
 * @author Dylan Raiff
 * @version 1.0
 */
class StructureVisualizer extends JFrame
{
	/**
	 * Creates a visualizer for the game's structure.
	 */
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
}
