package basic2Dgraphics;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.function.Consumer;

import javax.swing.JFrame;

/**
 * Main instantiatable class of the basic2Dgraphics package.
 * 
 * @author Dylan Raiff
 */
public class Window extends JFrame
{

	private static Window instance; /*
									 * Singleton variable to assure only one instance of this class is ever
									 * instantiated.
									 */

	private static int tps; /* How many times per second updateMethod and graphicsMethod are called. */

	private static CustomGraphics gfx; /* Reference to the window's CustomGraphics component. */

	private static ComplexInterface startMethod; /* Method to be called once upon the main thread's start. */
	private static ComplexInterface updateMethod; /* Method to be called every tick on the main thread. */
	private static Consumer<Graphics2D> graphicsMethod; /* Method to be called every tick to handle graphics. */

	/* #fmt:off */

	private static KeyboardInputMethodData onKeyboardInputMethod; /* 
																   * Stores method references to be called by the
																   * keyboard listener.
																   */
	/* #fmt:on */

	private static MouseInputMethodData onMouseInputMethodData; /*
																 * Stores method references to be called by the mouse
																 * listener.
																 */

	private static Thread thread; /* Reference to the main thread. */

	/*
	 * Access methods so variables are read-only.
	 */

	public static int getTPS()
	{ return Window.tps; }

	public static Consumer<Graphics2D> getGraphicsMethod()
	{ return Window.graphicsMethod; }

	public static CustomGraphics getGFX()
	{ return Window.gfx; }

	public static ComplexInterface getStartMethod()
	{ return Window.startMethod; }

	public static ComplexInterface getUpdateMethod()
	{ return Window.updateMethod; }

	public static KeyboardInputMethodData getOnKeyboardInputMethodData()
	{ return Window.onKeyboardInputMethod; }

	public static MouseInputMethodData getOnMouseInputMethodData()
	{ return Window.onMouseInputMethodData; }

	/**
	 * Window constructer with all possible arguements. Creates a window and sets up
	 * runtime calls.
	 * 
	 * @param name                      name of the window
	 * @param width                     width of the window
	 * @param height                    height of the window
	 * @param ticksPerSecond            number of times per second to update game
	 *                                  logic and graphics
	 * @param startMethod               reference to the method that will be called
	 *                                  once on start returns void takes 0 args
	 * @param updateMethod              reference to the method that will be called
	 *                                  every tick returns void takes 0 args
	 * @param graphicsMethod            reference to the method that will draw
	 *                                  graphics returns void takes Graphics2D
	 * @param onKeyboardInputMethodData object with references to the methods that
	 *                                  will be called by the key listener
	 * @param onMouseInputMethodData    object with references to the methods that
	 *                                  will be called by the mouse listener
	 */
	public Window(String name, int width, int height, int ticksPerSecond, ComplexInterface startMethod,
			ComplexInterface updateMethod, Consumer<Graphics2D> graphicsMethod,
			KeyboardInputMethodData onKeyboardInputMethod, MouseInputMethodData onMouseInputMethodData)
	{
		super(name);

		if (instance != null)
		{
			System.err.println("Two instances of basic2Dgraphics.Window are not allowed.");
			return;
		}

		instance = this;

		Window.startMethod = startMethod;
		Window.graphicsMethod = graphicsMethod;
		Window.updateMethod = updateMethod;

		Window.onKeyboardInputMethod = onKeyboardInputMethod;
		Window.onMouseInputMethodData = onMouseInputMethodData;

		Window.tps = ticksPerSecond;

		Window.gfx = new CustomGraphics();
		this.add(gfx);

		this.addKeyListener(new KeyboardInput());
		this.addMouseListener(new MouseInput());

		this.setPreferredSize(new Dimension(width, height));
		this.setMaximumSize(new Dimension(width, height));
		this.setMinimumSize(new Dimension(width, height));

		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);

		GameLoop game = new GameLoop();
		thread = new Thread(game);
		thread.start();
	}

	/**
	 * Window constructer with no mouse listener. Creates a window and runs sets up
	 * runtime calls.
	 * 
	 * @param name
	 * @param name                      name of the window
	 * @param width                     width of the window
	 * @param height                    height of the window
	 * @param ticksPerSecond            number of times per second to update game
	 *                                  logic and graphics
	 * @param startMethod               reference to the method that will be called
	 *                                  once on start returns void takes 0 args
	 * @param updateMethod              reference to the method that will be called
	 *                                  every tick returns void takes 0 args
	 * @param graphicsMethod            reference to the method that will draw
	 *                                  graphics returns void takes Graphics2D
	 * @param onKeyboardInputMethodData object with references to the methods that
	 *                                  will be called by the key listener
	 */
	public Window(String name, int width, int height, int ticksPerSecond, ComplexInterface startMethod,
			ComplexInterface updateMethod, Consumer<Graphics2D> graphicsMethod,
			KeyboardInputMethodData onKeyboardInputMethod)
	{
		super(name);

		if (instance != null)
		{
			System.err.println("Two instances of basic2Dgraphics.Window are not allowed.");
			return;
		}

		instance = this;

		Window.startMethod = startMethod;
		Window.graphicsMethod = graphicsMethod;
		Window.updateMethod = updateMethod;

		Window.onKeyboardInputMethod = onKeyboardInputMethod;

		Window.tps = ticksPerSecond;

		Window.gfx = new CustomGraphics();
		this.add(gfx);

		this.addKeyListener(new KeyboardInput());

		this.setPreferredSize(new Dimension(width, height));
		this.setMaximumSize(new Dimension(width, height));
		this.setMinimumSize(new Dimension(width, height));

		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);

		GameLoop game = new GameLoop();
		thread = new Thread(game);
		thread.start();
	}

	/**
	 * Window constructer with no keyboard listener. Creates a window and runs sets
	 * up runtime calls.
	 * 
	 * @param name                   name of the window
	 * @param width                  width of the window
	 * @param height                 height of the window
	 * @param ticksPerSecond         number of times per second to update game logic
	 *                               and graphics
	 * @param startMethod            reference to the method that will be called
	 *                               once on start returns void takes 0 args
	 * @param updateMethod           reference to the method that will be called
	 *                               every tick returns void takes 0 args
	 * @param graphicsMethod         reference to the method that will draw graphics
	 *                               returns void takes Graphics2D
	 * @param onMouseInputMethodData object with references to the methods that will
	 *                               be called by the mouse listener
	 */
	public Window(String name, int width, int height, int ticksPerSecond, ComplexInterface startMethod,
			ComplexInterface updateMethod, Consumer<Graphics2D> graphicsMethod,
			MouseInputMethodData onMouseInputMethodData)
	{
		super(name);

		if (instance != null)
		{
			System.err.println("Two instances of basic2Dgraphics.Window are not allowed.");
			return;
		}

		instance = this;

		Window.startMethod = startMethod;
		Window.graphicsMethod = graphicsMethod;
		Window.updateMethod = updateMethod;

		Window.onMouseInputMethodData = onMouseInputMethodData;

		Window.tps = ticksPerSecond;

		Window.gfx = new CustomGraphics();
		this.add(gfx);

		this.addMouseListener(new MouseInput());

		this.setPreferredSize(new Dimension(width, height));
		this.setMaximumSize(new Dimension(width, height));
		this.setMinimumSize(new Dimension(width, height));

		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);

		GameLoop game = new GameLoop();
		thread = new Thread(game);
		thread.start();
	}

	/**
	 * Window constructer with no update method, and therefore no input. Calls the
	 * start method and graphics method one time each.
	 * 
	 * @param name
	 * @param name           name of the window
	 * @param width          width of the window
	 * @param height         height of the window
	 * @param ticksPerSecond number of times per second to update game logic and
	 *                       graphics
	 * @param startMethod    reference to the method that will be called once on
	 *                       start returns void takes 0 args
	 * @param graphicsMethod reference to the method that will draw graphics returns
	 *                       void takes Graphics2D
	 */
	public Window(String name, int width, int height, int ticksPerSecond, ComplexInterface startMethod,
			Consumer<Graphics2D> graphicsMethod)
	{
		super(name);

		if (instance != null)
		{
			System.err.println("Two instances of basic2Dgraphics.Window are not allowed.");
			return;
		}

		instance = this;

		Window.startMethod = startMethod;
		Window.graphicsMethod = graphicsMethod;

		Window.tps = ticksPerSecond;

		Window.gfx = new CustomGraphics();
		this.add(gfx);

		this.setPreferredSize(new Dimension(width, height));
		this.setMaximumSize(new Dimension(width, height));
		this.setMinimumSize(new Dimension(width, height));

		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);

		GameLoop game = new GameLoop();
		thread = new Thread(game);
		thread.start();
	}

	/**
	 * Class for storing all method references used by the keyboard listener. All
	 * methods return void and take a KeyEvent.
	 * 
	 * @author Dylan Raiff
	 */
	public static class KeyboardInputMethodData
	{
		public ComplexKeyEventInterface onKeyPressed;
		public ComplexKeyEventInterface onKeyTyped;
		public ComplexKeyEventInterface onKeyReleased;

		public KeyboardInputMethodData(ComplexKeyEventInterface onKeyPressed, ComplexKeyEventInterface onKeyTyped,
				ComplexKeyEventInterface onKeyReleased)
		{
			this.onKeyPressed = onKeyPressed;
			this.onKeyTyped = onKeyTyped;
			this.onKeyReleased = onKeyReleased;
		}
	}

	/**
	 * Class for storing all method references used by the mouse listener. All
	 * methods return void and take a MouseEvent.
	 * 
	 * @author Dylan Raiff
	 */
	public static class MouseInputMethodData
	{
		public ComplexMouseEventInterface onMouseClicked;
		public ComplexMouseEventInterface onMouseEntered;
		public ComplexMouseEventInterface onMouseExited;
		public ComplexMouseEventInterface onMousePressed;
		public ComplexMouseEventInterface onMouseReleased;

		public MouseInputMethodData(ComplexMouseEventInterface onMouseClicked,
				ComplexMouseEventInterface onMouseEntered, ComplexMouseEventInterface onMouseExited,
				ComplexMouseEventInterface onMousePressed, ComplexMouseEventInterface onMouseReleased)
		{
			this.onMouseClicked = onMouseClicked;
			this.onMouseEntered = onMouseEntered;
			this.onMouseExited = onMouseExited;
			this.onMousePressed = onMousePressed;
			this.onMouseReleased = onMouseReleased;
		}
	}

	/**
	 * Stores a method with return type void with no arguments.
	 * 
	 * @author Dylan Raiff
	 */
	@FunctionalInterface
	public static interface ComplexInterface
	{
		public void method();
	}

	/**
	 * Stores a method with return type void with one argument of type KeyEvent.
	 * 
	 * @author Dylan Raiff
	 */
	@FunctionalInterface
	public static interface ComplexKeyEventInterface
	{
		public void method(KeyEvent e);
	}

	/**
	 * Stores a method with return type void with one argument of type MouseEvent.
	 * 
	 * @author Dylan Raiff
	 */
	@FunctionalInterface
	public static interface ComplexMouseEventInterface
	{
		public void method(MouseEvent e);
	}

}
