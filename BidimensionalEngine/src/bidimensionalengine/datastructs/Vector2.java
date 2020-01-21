package bidimensionalengine.datastructs;

/**
 * @author Dylan Raiff
 * @version 1.0
 */
public final class Vector2
{
	/* Static data */

	/**
	 * An empty {@code Vector2} that is always referenceable.
	 */
	public static final Vector2 zero = new Vector2(0, 0);

	/**
	 * Calculates the dot product of two vectors {@code v1} and {@code v2}.
	 * 
	 * @param v1 first vector
	 * @param v2 second vector
	 * @return dot product of the two vectors
	 */
	public static double dotProduct(Vector2 v1, Vector2 v2)
	{ return v1.x * v2.x + v1.y * v2.y; }

	/**
	 *
	 * Calculates the two input 2D cross product. <br>
	 * The implemented formula is: <u>crossProduct(U, V) = (U.x * V.y - U.y *
	 * V.x)</u>
	 * 
	 * @param v1 first vector
	 * @param v2 second vector
	 * @return cross product of the two vectors
	 */
	public static double crossProduct(Vector2 v1, Vector2 v2)
	{ return v1.x * v2.y - v2.x * v1.y; }

	/**
	 *
	 * Calculates the single input 2D cross product. <br>
	 * The implemented formula is: <u>crossProduct(U) = (U.y, -U.x)</u>
	 * 
	 * @param v1 first vector
	 * @param v2 second vector
	 * @return {@code v1} with a reversed y-axis
	 */
	public static Vector2 crossProduct(Vector2 v1)
	{ return new Vector2(v1.x, -v1.y); }

	/**
	 * Linearly interpolates between the two points.
	 * 
	 * @param p1 first point
	 * @param p2 second point
	 * @return a {@code Vector2} which is linerally interpolated based off the input
	 *         points
	 */
	public static Vector2 lerp(Vector2 p1, Vector2 p2)
	{
		double x = p1.x * 0.5d + p2.x * 0.5d;
		double y = p1.y * 0.5d + p2.y * 0.5d;

		return new Vector2(x, y);
	}

	/**
	 * Linearly interpolates between the two points.
	 * 
	 * @param p1    first point
	 * @param p2    second point
	 * @param ratio which side to lerp towards. > 0.5 means closer to p1, < 0.5
	 *              means closer to p2
	 * @return a {@code Vector2} which is linerally interpolated based off the input
	 *         points and ratio
	 */
	public static Vector2 lerp(Vector2 p1, Vector2 p2, double ratio)
	{
		double x = p1.x * ratio + p2.x * (1 - ratio);
		double y = p1.y * ratio + p2.y * (1 - ratio);

		return new Vector2(x, y);
	}

	/**
	 * {@code Vector2} representing up.
	 */
	public static final Vector2 up = new Vector2(0, 1);

	/**
	 * {@code Vector2} representing up.
	 */
	public static final Vector2 right = new Vector2(1, 0);

	/**
	 * {@code Vector2} representing up.
	 */
	public static final Vector2 down = new Vector2(0, -1);

	/**
	 * {@code Vector2} representing up.
	 */
	public static final Vector2 left = new Vector2(-1, 0);

	/* Instance data */

	/**
	 * {@code x} component of the vector.
	 */
	public double x;
	/**
	 * {@code y} component of the vector.
	 */
	public double y;

	/**
	 * Creates a new {@code Vector2} with components ({@code x}, {@code y}).
	 * 
	 * @param x initial x
	 * @param y initial y
	 */
	public Vector2(double x, double y)
	{
		this.x = x;
		this.y = y;
	}

	/**
	 * Creates a new, empty {@code Vector2}.
	 */
	public Vector2()
	{
		this.x = 0;
		this.y = 0;
	}

	/**
	 * Performs addition between the components of {@code this} and {@code v}.
	 * 
	 * @param v {@code Vector2} to add
	 * @return a {@code Vector2} whose components are the sums of the respective
	 *         components of {@code this} and {@code v}.
	 */
	public Vector2 add(Vector2 v)
	{
		x += v.x;
		y += v.y;

		return new Vector2(x, y);
	}

	/**
	 * Performs subtraction between the components of {@code this} and {@code v}.
	 * 
	 * @param v {@code Vector2} to subtract
	 * @return a {@code Vector2} whose components are the differences of the
	 *         respective components of {@code this} and {@code v}.
	 */
	public Vector2 sub(Vector2 v)
	{
		x -= v.x;
		y -= v.y;

		return new Vector2(x, y);
	}

	/**
	 * Performs multiplication between the components of {@code this} and {@code v}.
	 * 
	 * @param v {@code Vector2} to multiply
	 * @return a {@code Vector2} whose components are the products of the respective
	 *         components of {@code this} and {@code v}.
	 */
	public Vector2 mul(Vector2 v)
	{
		x *= v.x;
		y *= v.y;

		return new Vector2(x, y);
	}

	/**
	 * Performs division between the components of {@code this} and {@code v}.
	 * 
	 * @param v {@code Vector2} to divide
	 * @return a {@code Vector2} whose components are the quotients of the
	 *         respective components of {@code this} and {@code v}.
	 */
	public Vector2 div(Vector2 v)
	{
		x /= v.x;
		y /= v.y;

		return new Vector2(x, y);
	}

	public String toString()
	{ return String.format("(%.2f, %.2f)", x, y); }
}
