package bidimensionalengine.graphics;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import bidimensionalengine.core.StructureVisualizer;
import bidimensionalengine.core.Window;
import bidimensionalengine.datastructs.GameObject;

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

		ArrayList<String> hierarchy = new ArrayList<String>();
		ArrayList<GameObject> nullParents = new ArrayList<GameObject>();

		for (GameObject gameObject : Window.getGameLoop().getGameObjects())
		{
			if (gameObject.getParent() == null)
				nullParents.add(gameObject);
		}

		for (int i = 0; i < hierarchy.size(); i++)
		{
			String line = hierarchy.get(i);
			d.text(line, 10, 15 * (i + 1));
		}
	}
}
