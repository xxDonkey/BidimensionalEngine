package bidimensionalengine.core.structurevisualizer;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;

import bidimensionalengine.core.Window;
import bidimensionalengine.graphics.Drawer;

/**
 * @author Dylan Raiff
 * @version 1.0
 */
public class StructureVisualizerCustomGraphics extends Component
{
	/**
	 * Visualizer {@code this} is drawing for.
	 */
	private StructureVisualizer visualizer;

	/**
	 * Creates a {@code StructureVisualizerCustomGraphics}.
	 * 
	 * @param visualizer visualizer to draw graphics for
	 */
	public StructureVisualizerCustomGraphics(StructureVisualizer visualizer)
	{ this.visualizer = visualizer; }

	@Override
	public void paint(Graphics g)
	{
		Drawer d = new Drawer((Graphics2D) g, visualizer);
		d.background(Color.WHITE);

		if (Window.getGameLoop() == null)
			return;

	}
}
