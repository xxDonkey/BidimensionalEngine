package bidimensionalengine.graphics.particles;

import java.util.ArrayList;

import bidimensionalengine.datastructs.Vector2;
import bidimensionalengine.graphics.Sprite;

/**
 * @author Dylan Raiff
 * @version 1.0
 */
public class ParticleSystem
{
	/**
	 * List of all living particles.
	 */
	private ArrayList<Vector2> particles;

	/**
	 * Sprite of all particles.
	 */
	private Sprite particleSprite;

	/**
	 * Time, in seconds, that the particles stay in the world.
	 */
	public double lifeSpan;

	/**
	 * The speed each particle spawns in with.
	 */
	public double initialSpeed;

	/**
	 * Amount of speed lost each update.
	 */
	public double speedDecay;

	/**
	 * Amount of size lost each update.
	 */
	public double sizeDecay;

	/**
	 * How much gravity affects the particles.
	 */
	public double gravityMultiplier;

	/**
	 * How bouncy the particles are on collision.
	 */
	public double bounciness;

	/**
	 * Default constructor, initializes variables to default values.
	 */
	public ParticleSystem()
	{
		particles = new ArrayList<Vector2>();

		lifeSpan = 1;
		gravityMultiplier = 0;
		bounciness = 0;
	}

	/**
	 * Constructor that initializes variables to desired amounts.
	 * 
	 * @param lifeSpan          life span of each particle
	 * @param gravityMultiplier how much gravity affects each particle
	 * @param bounciness        bounciness of each particle
	 */
	public ParticleSystem(double lifeSpan, double gravityMultiplier, double bounciness)
	{
		particles = new ArrayList<Vector2>();

		this.lifeSpan = lifeSpan;
		this.gravityMultiplier = gravityMultiplier;
		this.bounciness = bounciness;
	}

	public static final void update()
	{

	}

}
