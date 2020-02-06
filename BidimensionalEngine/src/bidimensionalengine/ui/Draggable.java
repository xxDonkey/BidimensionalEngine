package bidimensionalengine.ui;

import bidimensionalengine.playercomponents.Transform;

/**
 * @author Dylan Raiff
 * @version 1.0
 */
public interface Draggable
{
	/**
	 * @return {@code Transform} of the draggable.
	 */
	Transform getTransform();

	/**
	 * Called the frame this object starts to be dragged.
	 */
	void onDragStarted();

	/**
	 * Called during the time this object is being dragged.
	 */
	void onDrag();

	/**
	 * Called the frame this object stops being dragged.
	 */
	void onDragEnded();
}
