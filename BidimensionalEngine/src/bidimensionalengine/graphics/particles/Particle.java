package bidimensionalengine.graphics.particles;

import bidimensionalengine.datastructs.Vector2;

/**
 * @author Dylan Raiff
 * @version 1.0
 */
final class Particle
{
	public Vector2 position;
	public Vector2 size;

	public Particle()
	{
		this.position = new Vector2();
		this.size = new Vector2();
	}

	public Particle(Vector2 position, Vector2 size)
	{
		this.position = position;
		this.size = size;
	}
}
