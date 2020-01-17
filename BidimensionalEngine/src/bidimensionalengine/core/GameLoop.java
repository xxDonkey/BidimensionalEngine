package bidimensionalengine.core;

import java.util.ArrayList;

import bidimensionalengine.engine.datastructs.GameObject;
import bidimensionalengine.engine.ui.UIElement;

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
	 * Holds all of the engine's active {@code UIElements}.
	 */
	private ArrayList<UIElement> uiElements = new ArrayList<UIElement>();

	/**
	 * Called when a {@code GameObject} is created.
	 * 
	 * @param gameObject game object that is being created
	 */
	public void onCreateGameObject(GameObject gameObject)
	{ gameObjects.add(gameObject); }

	/**
	 * Called when a {@code GameObject} is destoryed.
	 * 
	 * @param gameObject UI element that is being destroyed
	 */
	public void onDestoryGameObject(GameObject gameObject)
	{ gameObjects.remove(gameObject); }

	/**
	 * Called when a {@code UIElement} is created.
	 * 
	 * @param gameObject game object that is being created
	 */
	public void onCreateGameObject(UIElement uiElement)
	{ uiElements.add(uiElement); }

	/**
	 * Called when a {@code UIElement} is destoryed.
	 * 
	 * @param gameObject UI element that is being destroyed
	 */
	public void onDestoryGameObject(UIElement uiElement)
	{ uiElements.remove(uiElement); }

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
