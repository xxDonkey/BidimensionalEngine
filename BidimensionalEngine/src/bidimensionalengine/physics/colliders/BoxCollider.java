package bidimensionalengine.physics.colliders;

import bidimensionalengine.datastructs.Vector2;
import bidimensionalengine.physics.PhysicsMaterial;

/**
 * @author Dylan Raiff
 * @version 1.0
 */
public class BoxCollider extends Collider
{
	/**
	 * Creates a new {@code BoxCollider}.
	 * 
	 * @param size            size of the collider
	 * @param bounds          bounds of the collider - an array of verticies
	 * @param physicsMaterial material dictating properties of the collider
	 */
	public BoxCollider(Vector2 size, PhysicsMaterial physicsMaterial)
	{ super(size, ColliderBounds.boxColliderBounds(size), physicsMaterial); }
}
