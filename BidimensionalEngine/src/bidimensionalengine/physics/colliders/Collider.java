package bidimensionalengine.physics.colliders;

import bidimensionalengine.datastructs.Vector2;
import bidimensionalengine.physics.PhysicsMaterial;

/**
 * @author Dylan Raiff
 * @version 1.0
 */
public abstract class Collider
{
	/**
	 * Size of the collider.
	 */
	protected Vector2 size;

	/**
	 * Bounds of the collider.
	 */
	protected Vector2[] bounds;

	/**
	 * {@code PhysicsMaterial} that dictates the properties of the colider.
	 */
	protected PhysicsMaterial physicsMaterial;

	/**
	 * Creates a new collider.
	 * 
	 * @param size            size of the collider
	 * @param bounds          bounds of the collider - an array of verticies
	 * @param physicsMaterial material dictating properties of the collider
	 */
	public Collider(Vector2 size, Vector2[] bounds, PhysicsMaterial physicsMaterial)
	{
		this.size = size;
		this.bounds = bounds;
		this.physicsMaterial = physicsMaterial;
	}

}
