package bidimensionalengine.core;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.function.Consumer;

import javax.swing.JFrame;

import bidimensionalengine.graphics.CustomGraphics;
import bidimensionalengine.graphics.SpriteLoader;
import bidimensionalengine.input.KeyboardInput;
import bidimensionalengine.input.MouseInput;

/**
 * Main instantiatable class of the basic2Dgraphics package.
 * 
 * @author Dylan Raiff
 */
public class Window extends JFrame
{
	/**
	 * Singleton variable to assure only one instance of this class is ever
	 * instantiated.
	 */
	private static Window instance;

	/**
	 * How many times per second {@code updateMethod} and {@code graphicsMethod} are
	 * called.
	 */
	private static int tps;

	/**
	 * Reference to the window's {@code CustomGraphics}.
	 */
	private static CustomGraphics gfx;

	/**
	 * Method to be called once upon the start of {@code thread}.
	 */

	private static ComplexInterface startMethod;

	/**
	 * Method to be called every tick on {@code thread}.
	 */
	private static ComplexInterface updateMethod;

	/**
	 * Method to be called every tick to handle graphics.
	 */
	private static Consumer<Graphics2D> graphicsMethod;

	/**
	 * Stores method references to be called by the {@code KeyboardListener}.
	 */
	private static KeyboardInputMethodData onKeyboardInputMethodData;

	/**
	 * Stores method references to be called by the {@code MouseListener}.
	 */
	private static MouseInputMethodData onMouseInputMethodData;

	/**
	 * Directory where all assets are stored.
	 */
	private static String assetDirectory;

	/**
	 * Reference to the main thread.
	 */
	private static Thread thread;

	/* Access methods so variables are read-only. */

	public static Window getInstance()
	{ return Window.instance; }

	public static int getTPS()
	{ return Window.tps; }

	public static CustomGraphics getGFX()
	{ return Window.gfx; }

	public static ComplexInterface getStartMethod()
	{ return Window.startMethod; }

	public static ComplexInterface getUpdateMethod()
	{ return Window.updateMethod; }

	public static Consumer<Graphics2D> getGraphicsMethod()
	{ return Window.graphicsMethod; }

	public static KeyboardInputMethodData getOnKeyboardInputMethodData()
	{ return Window.onKeyboardInputMethodData; }

	public static MouseInputMethodData getOnMouseInputMethodData()
	{ return Window.onMouseInputMethodData; }

	public static String getAssetDirectory()
	{ return Window.assetDirectory; }

	public static Thread getThread()
	{ return Window.thread; }

	/**
	 * Window constructer with <b>all possible arguements</b>. Creates a window and
	 * sets up runtime calls.
	 * 
	 * @param name                      name of the window
	 * @param width                     width of the window
	 * @param height                    height of the window
	 * @param ticksPerSecond            number of times per second to update game
	 *                                  logic and graphics
	 * @param assetDirectory            directory of assets: <u>images to use in
	 *                                  graphics, audio files, etc...</u>
	 * @param startMethod               reference to the method that will be called
	 *                                  once on start <br>
	 *                                  <BLOCKQUOTE><u>Returns:</u> void <br>
	 *                                  <u>Arguments</u>: None
	 * @param updateMethod              reference to the method that will be called
	 *                                  every tick <br>
	 *                                  <BLOCKQUOTE><u>Returns:</u> void <br>
	 *                                  <u>Arguments</u>: None
	 * @param graphicsMethod            reference to the method that will draw
	 *                                  graphics <br>
	 *                                  <BLOCKQUOTE><u>Returns:</u> void <br>
	 *                                  <u>Arguments (1)</u>: Graphics2D
	 * @param onKeyboardInputMethodData object with references to the methods that
	 *                                  will be called by the key listener
	 * @param onMouseInputMethodData    object with references to the methods that
	 *                                  will be called by the mouse listener
	 */
	public Window(String name, int width, int height, int ticksPerSecond, String assetDirectory,
			ComplexInterface startMethod, ComplexInterface updateMethod, Consumer<Graphics2D> graphicsMethod,
			KeyboardInputMethodData onKeyboardInputMethodData, MouseInputMethodData onMouseInputMethodData)
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

		Window.onKeyboardInputMethodData = onKeyboardInputMethodData;
		Window.onMouseInputMethodData = onMouseInputMethodData;

		Window.assetDirectory = assetDirectory;

		Window.tps = ticksPerSecond;

		Window.gfx = new CustomGraphics();
		this.add(gfx);

		this.addKeyListener(new KeyboardInput());
		this.addMouseListener(new MouseInput());

		onConstructed(this, width, height);
	}

	/**
	 * Window constructer with <b>no input</b>. Creates a window and sets up runtime
	 * calls.
	 * 
	 * @param name           name of the window
	 * @param width          width of the window
	 * @param height         height of the window
	 * @param ticksPerSecond number of times per second to update game logic and
	 *                       graphics
	 * @param assetDirectory directory of assets: <u>images to use in graphics,
	 *                       audio files, etc...</u>
	 * @param startMethod    reference to the method that will be called once on
	 *                       start <br>
	 *                       <BLOCKQUOTE><u>Returns:</u> void <br>
	 *                       <u>Arguments</u>: None
	 * @param updateMethod   reference to the method that will be called every tick
	 *                       <br>
	 *                       <BLOCKQUOTE><u>Returns:</u> void <br>
	 *                       <u>Arguments</u>: None
	 * @param graphicsMethod reference to the method that will draw graphics <br>
	 *                       <BLOCKQUOTE><u>Returns:</u> void <br>
	 *                       <u>Arguments (1)</u>: Graphics2D
	 */
	public Window(String name, int width, int height, int ticksPerSecond, String assetDirectory,
			ComplexInterface startMethod, ComplexInterface updateMethod, Consumer<Graphics2D> graphicsMethod)
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

		Window.assetDirectory = assetDirectory;

		Window.tps = ticksPerSecond;

		Window.gfx = new CustomGraphics();
		this.add(gfx);

		onConstructed(this, width, height);
	}

	/**
	 * Window constructer with <u>no mouse listener</u>. Creates a window and runs
	 * sets up runtime calls.
	 * 
	 * @param name
	 * @param name                      name of the window
	 * @param width                     width of the window
	 * @param height                    height of the window
	 * @param ticksPerSecond            number of times per second to update game
	 *                                  logic and graphics
	 * @param assetDirectory            directory of assets: <u>images to use in
	 *                                  graphics, audio files, etc...</u>
	 * @param startMethod               reference to the method that will be called
	 *                                  once on start <br>
	 *                                  <BLOCKQUOTE><u>Returns:</u> void <br>
	 *                                  <u>Arguments</u>: None
	 * @param updateMethod              reference to the method that will be called
	 *                                  every tick <br>
	 *                                  <BLOCKQUOTE><u>Returns:</u> void <br>
	 *                                  <u>Arguments</u>: None
	 * @param graphicsMethod            reference to the method that will draw
	 *                                  graphics <br>
	 *                                  <BLOCKQUOTE><u>Returns:</u> void <br>
	 *                                  <u>Arguments (1)</u>: Graphics2D
	 * @param onKeyboardInputMethodData object with references to the methods that
	 *                                  will be called by the key listener
	 */
	public Window(String name, int width, int height, int ticksPerSecond, String assetDirectory,
			ComplexInterface startMethod, ComplexInterface updateMethod, Consumer<Graphics2D> graphicsMethod,
			KeyboardInputMethodData onKeyboardInputMethodData)
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

		Window.onKeyboardInputMethodData = onKeyboardInputMethodData;

		Window.assetDirectory = assetDirectory;

		Window.tps = ticksPerSecond;

		Window.gfx = new CustomGraphics();
		this.add(gfx);

		this.addKeyListener(new KeyboardInput());

		onConstructed(this, width, height);
	}

	/**
	 * Window constructer with <u>no keyboard listener</u>. Creates a window and
	 * runs sets up runtime calls.
	 * 
	 * @param name                   name of the window
	 * @param width                  width of the window
	 * @param height                 height of the window
	 * @param ticksPerSecond         number of times per second to update game logic
	 *                               and graphics
	 * @param assetDirectory         directory of assets: <u>images to use in
	 *                               graphics, audio files, etc...</u>
	 * @param startMethod            reference to the method that will be called
	 *                               once on start <br>
	 *                               <BLOCKQUOTE><u>Returns:</u> void <br>
	 *                               <u>Arguments</u>: None
	 * @param updateMethod           reference to the method that will be called
	 *                               every tick <br>
	 *                               <BLOCKQUOTE><u>Returns:</u> void <br>
	 *                               <u>Arguments</u>: None
	 * @param graphicsMethod         reference to the method that will draw graphics
	 *                               <br>
	 *                               <BLOCKQUOTE><u>Returns:</u> void <br>
	 *                               <u>Arguments (1)</u>: Graphics2D
	 * @param onMouseInputMethodData object with references to the methods that will
	 *                               be called by the mouse listener
	 */
	public Window(String name, int width, int height, int ticksPerSecond, String assetDirectory,
			ComplexInterface startMethod, ComplexInterface updateMethod, Consumer<Graphics2D> graphicsMethod,
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

		Window.assetDirectory = assetDirectory;

		Window.tps = ticksPerSecond;

		Window.gfx = new CustomGraphics();
		this.add(gfx);

		this.addMouseListener(new MouseInput());

		onConstructed(this, width, height);
	}

	/**
	 * Window constructer with <u>no update method, and therefore no input</u>.
	 * Calls the start method and graphics method <b>one time each</b>.
	 * 
	 * @param name
	 * @param name           name of the window
	 * @param width          width of the window
	 * @param height         height of the window
	 * @param assetDirectory directory of assets: <u>images to use in graphics,
	 *                       audio files, etc...</u>
	 * @param startMethod    reference to the method that will be called once on
	 *                       start <br>
	 *                       <BLOCKQUOTE><u>Returns:</u> void <br>
	 *                       <u>Arguments</u>: None
	 * @param graphicsMethod reference to the method that will draw graphics <br>
	 *                       <BLOCKQUOTE><u>Returns:</u> void <br>
	 *                       <u>Arguments (1)</u>: Graphics2D
	 */
	public Window(String name, int width, int height, String assetDirectory, ComplexInterface startMethod,
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

		Window.assetDirectory = assetDirectory;

		Window.tps = -1;

		Window.gfx = new CustomGraphics();
		this.add(gfx);

		onConstructed(this, width, height);
	}

	/**
	 * Consolidates all code that is used by all of the constructors.
	 * 
	 * @param frame  reference to the {@code Window}.
	 * @param width  width of the window
	 * @param height height of the window
	 */
	private static void onConstructed(JFrame frame, int width, int height)
	{
		frame.setPreferredSize(new Dimension(width, height));
		frame.setMaximumSize(new Dimension(width, height));
		frame.setMinimumSize(new Dimension(width, height));

		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		try
		{
			String[] files = new File(Window.assetDirectory).list();
			for (String file : files)
			{
				SpriteLoader.loadImage(file);
			}
		}
		catch (Exception e)
		{
			System.err.println("Images could not be loaded.");
		}

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
		/**
		 * Called when a key has been pressed if not {@code null}.
		 */
		public ComplexKeyEventInterface onKeyPressed;

		/**
		 * Called when a key has been typed if not {@code null}.
		 */
		public ComplexKeyEventInterface onKeyTyped;

		/**
		 * Called when a key has been released if not {@code null}.
		 */
		public ComplexKeyEventInterface onKeyReleased;

		/**
		 * Assigns method refences.
		 * 
		 * @param onKeyPressed  method called on press
		 * @param onKeyTyped    method called on type
		 * @param onKeyReleased method called on release
		 */
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
		/**
		 * Called when the user clicks the listened to component if not {@code null}.
		 */
		public ComplexMouseEventInterface onMouseClicked;

		/**
		 * Called when the cursor enters the bounds of the listened to component if not
		 * {@code null}.
		 */
		public ComplexMouseEventInterface onMouseEntered;

		/**
		 * Called when the cursor enters the bounds of the listened to component if not
		 * {@code null}.
		 */
		public ComplexMouseEventInterface onMouseExited;

		/**
		 * Called when the cursor enters the bounds of the listened to component if not
		 * {@code null}.
		 */
		public ComplexMouseEventInterface onMousePressed;

		/**
		 * Called when the cursor enters the bounds of the listened to component if not
		 * {@code null}.
		 */
		public ComplexMouseEventInterface onMouseReleased;

		/**
		 * Assigns method refences.
		 * 
		 * @param onMouseClicked  method called on click
		 * @param onMouseEntered  method called on enter
		 * @param onMouseExited   method called on exit
		 * @param onMousePressed  method called on press
		 * @param onMouseReleased method called on release
		 */
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
