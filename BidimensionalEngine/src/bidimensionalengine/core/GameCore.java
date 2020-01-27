package bidimensionalengine.core;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 * <p>
 * Your {@code Main} or {@code Run} class should implement this interface. In
 * it's {@code main()} method, it should instantiate an instance of itself. <br>
 * This interface is not required, but you will have to manually call the Window
 * constructor, <b>it would be much more difficult.</b>.
 * <p>
 * In order to use input, you must the overridden methods in the {@code super}.
 * At the end of your main class's constructor, invoke
 * {@code super.createWindow}, and pass in all required arguments.
 * <p>
 * <u>Example:</u><br>
 * <BLOCKQUOTE>public Main(String title, String assetDirectory, int width, int
 * height, int ticksPerSecond) <br>
 * { <BLOCKQUOTE>super.onKeyPressed(null);<br>
 * super.createWindow(title, assetDirectory, width, height,
 * ticksPerSecond);</BLOCKQUOTE> }</BLOCKQUOTE>
 * 
 * @author Dylan Raiff
 * @version 1.0
 */
public abstract class GameCore
{
	/**
	 * Whether or not to use the {@code onKeyPressed} method.
	 */
	private boolean useOnKeyPressed;

	/**
	 * Whether or not to use the {@code onKeyTyped} method.
	 */
	private boolean useOnKeyTyped;

	/**
	 * Whether or not to use the {@code onKeyReleased} method.
	 */
	private boolean useOnKeyReleased;

	/**
	 * Whether or not to use the {@code onMouseClicked} method.
	 */
	private boolean useOnMouseClicked;

	/**
	 * Whether or not to use the {@code onMouseEntered} method.
	 */
	private boolean useOnMouseEntered;

	/**
	 * Whether or not to use the {@code onMouseExited} method.
	 */
	private boolean useOnMouseExited;

	/**
	 * Whether or not to use the {@code onMousePressed} method.
	 */
	private boolean useOnMousePressed;

	/**
	 * Whether or not to use the {@code onMouseReleased} method.
	 */
	private boolean useOnMouseReleased;

	/**
	 * Game's start method. See {@code Window} for more detail.
	 */
	public abstract void start();

	/**
	 * Game's upate method. See {@code Window} for more detail. <br>
	 * Leave empty if unused.
	 */
	public abstract void update();

	/**
	 * Game's graphics method. See {@code Window} for more detail.
	 */
	public abstract void graphics(Graphics2D g);

	/**
	 * Called when a key has been pressed if keyboard input has been turned on. <br>
	 * Call the super if used.
	 */
	public void onKeyPressed(KeyEvent e)
	{ useOnKeyPressed = true; }

	/**
	 * Called when a key has been typed if keyboard input has been turned on. <br>
	 * Call the super if used.
	 */
	public void onKeyTyped(KeyEvent e)
	{ useOnKeyTyped = true; }

	/**
	 * Called when a key has been released if keyboard input has been turned on.
	 * <br>
	 * Call the super if used.
	 */
	public void onKeyReleased(KeyEvent e)
	{ useOnKeyReleased = true; }

	/**
	 * Called when the user clicks the listened to component if mouse input has been
	 * turned on. <br>
	 * Call the super if used.
	 */
	public void onMouseClicked(MouseEvent e)
	{ useOnMouseClicked = true; }

	/**
	 * Called when the cursor enters the bounds of the listened to component if
	 * mouse input has been turned on. <br>
	 * Call the super if used.
	 */
	public void onMouseEntered(MouseEvent e)
	{ useOnMouseEntered = true; }

	/**
	 * Called when the cursor exits the bounds of the listened to component if mouse
	 * input has been turned on. <br>
	 * Call the super if used.
	 */
	public void onMouseExited(MouseEvent e)
	{ useOnMouseExited = true; }

	/**
	 * Called when the user presses a mouse button while the cursor is over the
	 * listened to component if mouse input has been turned on. <br>
	 * Call the super if used.
	 */
	public void onMousePressed(MouseEvent e)
	{ useOnMousePressed = true; }

	/**
	 * Called when the user releases a mouse button after a mouse press over the
	 * listened to component if mouse input has been turned on. <br>
	 * Call the super if used.
	 */
	public void onMouseReleased(MouseEvent e)
	{ useOnMouseReleased = true; }

	/**
	 * <p>
	 * Creates a new {@code Window}. If no input methods are used, and an
	 * {@code ticksPerSecond} is greater than 0, a window with an update method will
	 * be created. Otherwise, a once-updated window will be instantiated.
	 * <p>
	 * If input is used, a window with either keyboard input, mouse input, or both
	 * will be created.
	 * 
	 * @param title          title of the window
	 * @param assetDirectory directory where assets are located
	 * @param width          width of the window
	 * @param height         height of the window
	 * @param ticksPerSecond number of times the window updates in a second
	 */
	public void createWindow(String title, String assetDirectory, int width, int height, boolean update,
			boolean runVisualizer)
	{
		int ticksPerSecond = 0;

		/* Sets ticks per second to predifined 60 tps if update is true. */
		if (update)
			ticksPerSecond = 60;

		Window.KeyboardInputMethodData keyboardInput = new Window.KeyboardInputMethodData(
				useOnKeyPressed ? this::onKeyPressed : null, useOnKeyTyped ? this::onKeyTyped : null,
				useOnKeyReleased ? this::onKeyReleased : null);

		Window.MouseInputMethodData mouseInput = new Window.MouseInputMethodData(
				useOnMouseClicked ? this::onMouseClicked : null, useOnMouseEntered ? this::onMouseEntered : null,
				useOnMouseExited ? this::onMouseExited : null, useOnMousePressed ? this::onMousePressed : null,
				useOnMouseReleased ? this::onMouseReleased : null);

		// Accounts for top bar of a Mac window.
		if (System.getProperty("os.name").startsWith("Mac"))
			height += 23;

		if (keyboardInput.allVoid() && mouseInput.allVoid())
		{
			if (!update)
				new Window(title, width, height, assetDirectory, runVisualizer, this::start, this::graphics, this);
			else
				new Window(title, width, height, ticksPerSecond, assetDirectory, runVisualizer, this::start,
						this::update, this::graphics, this);
		}
		else if (!keyboardInput.allVoid() && mouseInput.allVoid())
		{
			if (!update)
				System.err.println("Cannot have less than or equal to 0 tps and input.");
			else
				new Window(title, width, height, ticksPerSecond, assetDirectory, runVisualizer, this::start,
						this::update, this::graphics, keyboardInput, this);
		}
		else if (keyboardInput.allVoid() && !mouseInput.allVoid())
		{
			if (!update)
				System.err.println("Cannot have less than or equal to 0 tps and input.");
			else
				new Window(title, width, height, ticksPerSecond, assetDirectory, runVisualizer, this::start,
						this::update, this::graphics, mouseInput, this);
		}
		else
		{
			if (ticksPerSecond <= 0)
				System.err.println("Cannot have less than or equal to 0 tps and input.");
			else
				new Window(title, width, height, ticksPerSecond, assetDirectory, runVisualizer, this::start,
						this::update, this::graphics, keyboardInput, mouseInput, this);
		}
	}
}
