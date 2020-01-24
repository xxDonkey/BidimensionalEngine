package bidimensionalengine.graphics.particles;

import java.awt.Graphics2D;
import java.util.ArrayList;

import bidimensionalengine.core.Window;
import bidimensionalengine.graphics.Drawer;
import bidimensionalengine.graphics.Sprite;

/**
 * @author Dylan Raiff
 * @version 1.0
 */
public final class ParticleSystem
{
	/**
	 * List of all living particles.
	 */
	private ArrayList<Particle> particles;

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
	 * Size of each particle.
	 */
	public double particleSize;

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
	public ParticleSystem(Sprite particleSprite)
	{
		this.particleSprite = particleSprite;
		particles = new ArrayList<Particle>();

		lifeSpan = 1;
		initialSpeed = 5;
		speedDecay = 0.1;
		sizeDecay = 0.2;
		gravityMultiplier = 0;
		bounciness = 0;

		onConstructed();
	}

	/**
	 * Constructor that initializes variables to desired amounts.
	 * 
	 * @param lifeSpan          life span of each particle
	 * @param gravityMultiplier how much gravity affects each particle
	 * @param bounciness        bounciness of each particle
	 */
	public ParticleSystem(Sprite particleSprite, double lifeSpan, double initialSpeed, double speedDecay,
			double particleSize, double sizeDecay, double gravityMultiplier, double bounciness)
	{
		this.particleSprite = particleSprite;
		particles = new ArrayList<Particle>();

		this.lifeSpan = lifeSpan;
		this.initialSpeed = initialSpeed;
		this.speedDecay = speedDecay;
		this.particleSize = particleSize;
		this.sizeDecay = sizeDecay;
		this.gravityMultiplier = gravityMultiplier;
		this.bounciness = bounciness;

		onConstructed();
	}

	/**
	 * 
	 */
	private void onConstructed()
	{
		Window.getGameLoop().onCreateParticleSystem(this);
		Window.getGFX().addParticleSytemRenderMethod(this::render);
	}

	/**
	 * Called every tick to update the {@code ParticleSystem}.
	 */
	public void update()
	{

	}

	/**
	 * Called every redraw to render the {@code ParticleSystem}.
	 * 
	 * @param g graphics to draw to
	 */
	public void render(Graphics2D g)
	{
		Drawer d = new Drawer(g);

		for (Particle particle : particles)
		{
			d.image(particleSprite, (int) Math.round(particle.position.x), (int) Math.round(particle.position.y),
					(int) Math.round(particle.size.x), (int) Math.round(particle.size.y), false);
		}
	}

}
