package bidimensionalengine.datastructs;

public class Vector2
{
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
	 * {@code x} component of the vector.
	 */
	public double x;
	/**
	 * {@code y} component of the vector.
	 */
	public double y;

	public Vector2(double x, double y)
	{
		this.x = x;
		this.y = y;
	}

	/**
	 * Performs addition between the components of {@code this} and {@code v}.
	 * 
	 * @param v {@code Vector2} to add
	 * @return a {@code Vector2} whose components are the sums of the respective
	 *         components of {@code this} and {@code v}.
	 */
	public Vector2 add(Vector2 v)
	{ return new Vector2(x + v.x, y + v.y); }

	/**
	 * Performs subtraction between the components of {@code this} and {@code v}.
	 * 
	 * @param v {@code Vector2} to subtract
	 * @return a {@code Vector2} whose components are the differences of the
	 *         respective components of {@code this} and {@code v}.
	 */
	public Vector2 sub(Vector2 v)
	{ return new Vector2(x - v.x, y - v.y); }

	/**
	 * Performs multiplication between the components of {@code this} and {@code v}.
	 * 
	 * @param v {@code Vector2} to multiply
	 * @return a {@code Vector2} whose components are the products of the respective
	 *         components of {@code this} and {@code v}.
	 */
	public Vector2 mul(Vector2 v)
	{ return new Vector2(x * v.x, y * v.y); }

	/**
	 * Performs division between the components of {@code this} and {@code v}.
	 * 
	 * @param v {@code Vector2} to divide
	 * @return a {@code Vector2} whose components are the quotients of the
	 *         respective components of {@code this} and {@code v}.
	 */
	public Vector2 div(Vector2 v)
	{ return new Vector2(x / v.x, y / v.y); }

}
