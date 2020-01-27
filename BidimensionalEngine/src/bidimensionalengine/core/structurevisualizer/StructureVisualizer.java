package bidimensionalengine.core.structurevisualizer;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.JFrame;

import bidimensionalengine.core.Window;

/**
 * Helps with visualization of the games structure/hierarchy. Graphics handled
 * in {@code StructureVisualizerCustomGraphics}.
 * 
 * @author Dylan Raiff
 * @version 1.0
 */
public class StructureVisualizer extends JFrame
{
	/**
	 * Singleton {@code StructureVisualizer} variable.
	 */
	private static StructureVisualizer instance;

	/**
	 * {@code Thread} running the visualizer.
	 */
	private Thread visualizerThread;

	/**
	 * {@code StructureVisualizerCustomGraphics} drawing this visualizer.
	 */
	private StructureVisualizerCustomGraphics gfx;

	/**
	 * Creates a visualizer for the game's structure.
	 */
	public StructureVisualizer()
	{
		super("Structure Visualizer");

		if (instance != null)
		{
			System.err.println("Two instances of bidimensionalengine.core.StructureVisualizer are not allowed.");
			return;
		}
		StructureVisualizer.instance = this;
		this.gfx = new StructureVisualizerCustomGraphics(this);
		this.add(gfx);

		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		this.setPreferredSize(new Dimension((int) screen.getWidth() / 8, (int) screen.getHeight() / 2));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(new Point((int) screen.getWidth() / 8, (int) screen.getHeight() / 4));

		visualizerThread = new Thread(new Runnable()
		{
			public void run()
			{
				long last = System.currentTimeMillis();
				while (true)
				{
					if (System.currentTimeMillis() - last > 1000 / (Window.getTPS() == 0 ? 1 : Window.getTPS()))
					{
						gfx.repaint();
						last = System.currentTimeMillis();
					}
				}
			}
		});
		visualizerThread.start();

		this.pack();
		this.setVisible(true);
	}
}
