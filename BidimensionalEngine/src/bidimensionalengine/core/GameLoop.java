package bidimensionalengine.core;

import java.util.ArrayList;

import bidimensionalengine.datastructs.GameObject;
import bidimensionalengine.ui.UIElement;

/**
 * @author Dylan Raiff
 * @version 1.0
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

		long lastTime = System.currentTimeMillis() - 1000;
		while (Window.getTPS() != -1)
		{
			if (Math.abs(System.currentTimeMillis() - lastTime) > 1000d * (1d / Window.getTPS()))
			{
				if (Window.getUpdateMethod() != null)
					Window.getUpdateMethod().method();

				for (GameObject gameObject : gameObjects)
					gameObject.update();

				if (!Window.getInstance().isVisible())
					Window.getInstance().setVisible(true);
				else
					Window.getGFX().repaint();

				lastTime = System.currentTimeMillis();
			}
		}

		Window.getInstance().setVisible(true);
	}
}
