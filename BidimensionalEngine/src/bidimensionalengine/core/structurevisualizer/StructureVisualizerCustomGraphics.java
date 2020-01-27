package bidimensionalengine.core.structurevisualizer;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;

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
	 * Number of names draw on the structure visualizer.
	 */
	private int numNamesDrawn = 0;

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

		for (GameObject gameObject : Window.getGameLoop().getGameObjects())
		{
			if (gameObject.getParent() == null)
				drawChildren(d, gameObject);
		}

		numNamesDrawn = 0;
	}

	private void drawChildren(Drawer d, GameObject gameObject)
	{
		int depth = getDepth(gameObject);
		d.text(gameObject.getName(), 10 + 20 * depth, 15 + (numNamesDrawn * 20));
		numNamesDrawn++;

		if (gameObject.getChildren().size() == 0)
			return;

		for (GameObject child : gameObject.getChildren())
		{
			drawChildren(d, child);
		}
	}

	private int getDepth(GameObject gameObject)
	{
		int depth = 0;
		while (gameObject.getParent() != null)
		{
			depth++;
			gameObject = gameObject.getParent();
		}
		return depth;
	}
}
