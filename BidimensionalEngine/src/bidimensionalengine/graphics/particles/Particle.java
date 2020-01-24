package bidimensionalengine.graphics.particles;

import bidimensionalengine.datastructs.Vector2;

/**
 * @author Dylan Raiff
 * @version 1.0
 */
class Particle
{
	public Vector2 position;
	public Vector2 size;
	public Vector2 direction;

	public double speed = 0;

	private long timeCreated;

	public Particle()
	{
		this.position = new Vector2();
		this.size = new Vector2();

		timeCreated = System.currentTimeMillis();
	}

	/**
	 * Gets the age of the particle.
	 * 
	 * @return the age of the particle, in milliseconds
	 */
	public long getAge()
	{ return System.currentTimeMillis() - timeCreated; }

	public Particle(Vector2 position, Vector2 size)
	{
		this.position = position;
		this.size = size;
	}
}
