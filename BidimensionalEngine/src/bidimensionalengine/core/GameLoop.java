package bidimensionalengine.core;

import java.util.ArrayList;

import bidimensionalengine.engine.playercomponents.ObjectComponent;

/**
 * @author Dylan Raiff
 */
public class GameLoop implements Runnable
{
	/**
	 * Holds all of the {@code ObjectComponent} attached to each {@code GameObject}.
	 */
	private ArrayList<ObjectComponent> components = new ArrayList<ObjectComponent>();

	public void onCreateObjectComponent(ObjectComponent component)
	{ components.add(component); }

	public void onDestoryObjectComponent(ObjectComponent component)
	{ components.remove(component); }

	/**
	 * Called on the start of the main thread.
	 */
	@Override
	public void run()
	{
		Window.getStartMethod().method();

		long lastTime = System.currentTimeMillis();
		while (Window.getTPS() != -1)
		{
			if (Math.abs(System.currentTimeMillis() - lastTime) > 1000d * (1d / Window.getTPS()))
			{
				if (Window.getUpdateMethod() != null)
					Window.getUpdateMethod().method();

				Window.getGFX().repaint();

				lastTime = System.currentTimeMillis();
			}
		}

	}
}
