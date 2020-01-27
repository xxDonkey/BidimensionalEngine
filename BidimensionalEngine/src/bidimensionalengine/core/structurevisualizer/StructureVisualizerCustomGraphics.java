package bidimensionalengine.core.structurevisualizer;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.TreeMap;

import bidimensionalengine.core.Window;
import bidimensionalengine.datastructs.GameObject;
import bidimensionalengine.graphics.Drawer;

/**
 * @author Dylan Raiff
 * @version 1.0
 */
class StructureVisualizerCustomGraphics extends Component
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

		TreeMap<String, GameObject> hierarchy = visualizer.getHierarchy();
		if (hierarchy.isEmpty())
			return;

		TreeMap<GameObject, Integer> desendancy = new TreeMap<GameObject, Integer>();
		for (String key : hierarchy.keySet())
		{

		}
	}
}
