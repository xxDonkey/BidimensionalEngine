package bidimensionalengine.core;

import java.util.ArrayList;

import bidimensionalengine.datastructs.GameObject;
import bidimensionalengine.graphics.particles.ParticleSystem;
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
	 * Holds all of the engine's active {@code ParticleSystems}.
	 */
	private ArrayList<ParticleSystem> particleSystems = new ArrayList<ParticleSystem>();

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
	 * @param uiElement game object that is being created
	 */
	public void onCreateUIElement(UIElement uiElement)
	{ uiElements.add(uiElement); }

	/**
	 * Called when a {@code UIElement} is destoryed.
	 * 
	 * @param uiElement UI element that is being destroyed
	 */
	public void onDestoryUIElement(UIElement uiElement)
	{ uiElements.remove(uiElement); }

	/**
	 * Called when a {@code ParticleSystem} is created.
	 * 
	 * @param particleSystem particle system that is being created
	 */
	public void onCreateParticleSystem(ParticleSystem particleSystem)
	{ particleSystems.add(particleSystem); }

	/**
	 * Called when a {@code ParticleSystem} is destoryed.
	 * 
	 * @param particleSystem particle system that is being destroyed
	 */
	public void onDestoryParticleSystem(ParticleSystem particleSystem)
	{ particleSystems.remove(particleSystem); }

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

				for (UIElement uiElement : uiElements)
					uiElement.update();

				for (ParticleSystem particleSystem : particleSystems)
					particleSystem.update();

				if (!Window.getInstance().isVisible())
					Window.getInstance().setVisible(true);
				else
					Window.getGFX().repaint();

				lastTime = System.currentTimeMillis();
			}
		}

		Window.getInstance().setVisible(true);
	}

	/* Access methods */

	/**
	 * @return the list of {@code GameObjecta}
	 */
	public ArrayList<GameObject> getGameObjects()
	{ return gameObjects; }

	/**
	 * @return the list of {@code UIElements}
	 */
	public ArrayList<UIElement> getUIElements()
	{ return uiElements; }
}
