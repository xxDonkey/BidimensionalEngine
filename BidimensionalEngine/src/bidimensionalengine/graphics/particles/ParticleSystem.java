package bidimensionalengine.graphics.particles;

import java.awt.Graphics2D;
import java.util.ArrayList;

import bidimensionalengine.core.Window;
import bidimensionalengine.datastructs.Vector2;
import bidimensionalengine.graphics.Drawer;
import bidimensionalengine.graphics.Sprite;
import bidimensionalengine.playercomponents.Transform;

/**
 * @author Dylan Raiff
 * @version 1.0
 */
public final class ParticleSystem
{
	/**
	 * Transform of this system.
	 */
	private Transform transform;

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
	 * Normalized direction vector.
	 */
	public Vector2 directionVector;

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
	 * How many particles are added to the system per second.
	 */
	public double particlesAddedPerSecond;

	/**
	 * Variable for keeping track of the time the system last added a particle.
	 */
	private long lastParticleAddedTime;

	/**
	 * Default constructor, initializes variables to default values.
	 */
	public ParticleSystem(Sprite particleSprite)
	{
		this.particleSprite = particleSprite;
		directionVector = new Vector2(1, 1);
		particles = new ArrayList<Particle>();

		lifeSpan = 1;

		initialSpeed = 5;
		speedDecay = 0.02;

		particleSize = 10;
		sizeDecay = 0.02;

		gravityMultiplier = 0;
		bounciness = 0;

		particlesAddedPerSecond = 10;

		onConstructed();
	}

	/**
	 * Constructor that initializes variables to desired amounts.
	 * 
	 * @param lifeSpan          life span of each particle
	 * @param gravityMultiplier how much gravity affects each particle
	 * @param bounciness        bounciness of each particle
	 */
	public ParticleSystem(Sprite particleSprite, Vector2 directionVector, double lifeSpan, double initialSpeed,
			double speedDecay, double particleSize, double sizeDecay, double gravityMultiplier, double bounciness,
			double particlesAddedPerSecond)
	{
		this.particleSprite = particleSprite;
		this.directionVector = directionVector;
		this.particles = new ArrayList<Particle>();

		this.lifeSpan = lifeSpan;

		this.initialSpeed = initialSpeed;
		this.speedDecay = speedDecay;

		this.particleSize = particleSize;
		this.sizeDecay = sizeDecay;

		this.gravityMultiplier = gravityMultiplier;
		this.bounciness = bounciness;

		this.particlesAddedPerSecond = particlesAddedPerSecond;

		onConstructed();
	}

	/**
	 * Called on any constructor call.
	 */
	private void onConstructed()
	{
		Window.getGameLoop().onCreateParticleSystem(this);
		Window.getGFX().addParticleSytemRenderMethod(this::render);

		transform = new Transform(null);
		transform.position = new Vector2(100, 100);

		lastParticleAddedTime = System.currentTimeMillis();
	}

	/**
	 * Adds a particle to the system.
	 */
	private void addParticle()
	{
		particles.add(new Particle()
		{
			{
				this.position = transform.position;
				this.size = new Vector2(particleSize, particleSize);

				this.direction = directionVector.mul(Vector2.random());
				this.speed = initialSpeed;
			}
		});
	}

	/**
	 * Called every tick to update the {@code ParticleSystem}.
	 */
	public void update()
	{
		if (System.currentTimeMillis() - lastParticleAddedTime > 1000)
		{
			addParticle();
			lastParticleAddedTime = System.currentTimeMillis();
		}

		for (

				int i = 0; i < particles.size(); i++)
		{
			Particle particle = particles.get(i);

			if (particle.getAge() > lifeSpan * 1000 || particle.size.x < 1 || particle.size.y < 1
					|| particle.speed == 0)
			{
				particles.remove(particle);
				i--;
			}

			Vector2 speedVector = new Vector2(particle.speed, particle.speed).mul(particle.direction);
			particle.position.add(speedVector);
			particle.speed *= 1 - speedDecay;

			particle.size.mul(new Vector2(1 - sizeDecay, 1 - sizeDecay));
		}
	}

	/**
	 * Called every repaint to render the {@code ParticleSystem}.
	 * 
	 * @param g graphics to draw to
	 */
	public void render(Graphics2D g)
	{
		Drawer d = new Drawer(g, Window.getInstance());
		for (Particle particle : particles)
		{
			d.image(particleSprite, (int) Math.round(particle.position.x), (int) Math.round(particle.position.y),
					(int) Math.round(particle.size.x), (int) Math.round(particle.size.y), false);
		}
	}

	/**
	 * @return {@code Transform} of the system
	 */
	public Transform getTransform()
	{ return transform; }

}
