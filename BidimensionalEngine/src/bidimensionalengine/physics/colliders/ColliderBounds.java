package bidimensionalengine.physics.colliders;

import bidimensionalengine.datastructs.Vector2;

/**
 * @author Dylan Raiff
 * @version 1.0
 */
final class ColliderBounds
{
	/**
	 * Private constructer to disallow instantiation of the class.
	 */
	private ColliderBounds()
	{}

	public static Vector2[] boxColliderBounds(Vector2 size)
	{
		Vector2[] bounds = { new Vector2(-size.x / 2, -size.y / 2), new Vector2(size.x / 2, -size.y / 2),
				new Vector2(size.x / 2, size.y / 2), new Vector2(-size.x / 2, size.y / 2) };
		return bounds;
	}
}
