package bidimensionalengine.core;

import java.util.ArrayList;

import bidimensionalengine.engine.datastructs.GameObject;

/**
 * @author Dylan Raiff
 */
public final class GameLoop implements Runnable
{
	/**
	 * Holds all of the engine's active {@code GameObject}.
	 */
	private ArrayList<GameObject> gameObjects = new ArrayList<GameObject>();

	/**
	 * 
	 * @param gameObject
	 */
	public void onCreateGameObject(GameObject gameObject)
	{ gameObjects.add(gameObject); }

	/**
	 * 
	 * @param gameObject
	 */
	public void onDestoryGameObject(GameObject gameObject)
	{ gameObjects.remove(gameObject); }

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

				for (GameObject gameObject : gameObjects)
					gameObject.update();

				Window.getGFX().repaint();

				lastTime = System.currentTimeMillis();
			}
		}

	}
}
