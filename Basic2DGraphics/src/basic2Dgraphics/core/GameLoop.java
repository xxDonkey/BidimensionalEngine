package basic2Dgraphics.core;

/**
 * @author Dylan Raiff
 */
public class GameLoop implements Runnable
{
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
