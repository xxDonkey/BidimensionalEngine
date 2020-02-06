package bidimensionalengine.input;

import java.util.ArrayList;

import bidimensionalengine.ui.Draggable;

/**
 * @author Dylan Raiff
 * @version 1.0
 */
public class DragInput
{
	/**
	 * Holds all draggable objects that have been instaniated.
	 */
	public ArrayList<Draggable> draggables;

	/**
	 * Creates a new {@code DrapInput}.
	 */
	public DragInput()
	{ draggables = new ArrayList<Draggable>(); }

	void update()
	{

	}
}
