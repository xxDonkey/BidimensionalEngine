package bidimensionalengine.graphics;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.util.ArrayList;

import bidimensionalengine.datastructs.Vector2;

public class Drawer
{
	/**
	 * {@code Graphics2D} to draw to.
	 */
	private Graphics2D g;

	/**
	 * A list of all points that will be used to create a custom polygon.
	 */
	private ArrayList<Vector2> polygonVerticies;

	/**
	 * Fill color of the drawer.
	 */
	public Color fillColor = Color.WHITE;

	/**
	 * Border color of the drawer.
	 */
	public Color borderColor = Color.BLACK;

	/**
	 * How many pixels thick the border of each drawn shape is. Cannot be less than
	 * 1.
	 */
	public int borderThickness = 1;

	/**
	 * Assigns a {@code Graphics2D}.
	 * 
	 * @param g graphics object of {@code this}
	 */
	public Drawer(Graphics2D g)
	{
		this.g = g;
		polygonVerticies = new ArrayList<Vector2>();
	}

	/**
	 * Draws a rect with the dimensions (w, h) with a top left corner at (x, y).
	 * 
	 * @param x x coordinate of the rectangle
	 * @param y y coordinate of the rectangle
	 * @param w width of the rectangle
	 * @param h height of the rectangle
	 */
	public void rect(int x, int y, int w, int h)
	{
		g.setColor(borderColor);
		g.fillRect(x, y, w, h);

		g.setColor(fillColor);
		g.fillRect(x + (borderThickness - 1), y + (borderThickness - 1), w - 2 * (borderThickness - 1),
				h - 2 * (borderThickness - 1));
	}

	/**
	 * Draws an ellipse with the dimensions (w, h) with a top left corner (where two
	 * lines tangent to the cirle and perpendicular to eachother would intersect) at
	 * (x, y).
	 * 
	 * @param x x coordinate of the ellipse
	 * @param y y coordinate of the ellipse
	 * @param w width of the ellipse
	 * @param h height of the ellipse
	 */
	public void ellipse(int x, int y, int w, int h)
	{
		g.setColor(borderColor);
		g.fillOval(x, y, w, h);

		g.setColor(fillColor);
		g.fillOval(x + (borderThickness - 1), y + (borderThickness - 1), w - 2 * (borderThickness - 1),
				h - 2 * (borderThickness - 1));
	}

	/**
	 * Draws an image with dimensions (w, h) with a top left corner at (x, y).
	 * 
	 * @param sprite sprite to draw
	 * @param x      x coordinate of the image
	 * @param y      y coordinate of the image
	 * @param w      width of the image's bounding box
	 * @param h      height of the image's bounding box
	 * @param border whether or not to draw a border
	 */
	public void image(Sprite sprite, int x, int y, int w, int h, boolean border)
	{
		if (border)
		{
			g.setColor(borderColor);
			g.fillRect(x, y, w, h);

			x += borderThickness - 1;
			y += borderThickness - 1;

			w -= 2 * (borderThickness - 1);
			h -= 2 * (borderThickness - 1);
		}

		g.drawImage(sprite.getImage(), x, y, w, h, null);
	}

	public void polygon(Polygon poly)
	{
		g.setColor(fillColor);
		g.fillPolygon(poly);
	}

	/**
	 * Draws a point at (x, y). Scallable with {@code borderThickness}.
	 * 
	 * @param x x coordinate of the point
	 * @param y y coordinate of the point
	 */
	public void point(int x, int y)
	{
		g.setColor(borderColor);
		g.fillOval(x, y, 2 + borderThickness, 2 + borderThickness);
	}

	/**
	 * Calls {@code point} and adds the point ot the {@code polygonVerticies} list.
	 * 
	 * @param x x coordinate of the point
	 * @param y y coordinate of the point
	 */
	public void vertex(int x, int y)
	{
		point(x, y);

		polygonVerticies.add(new Vector2(x, y));
	}

	/**
	 * Generates a polygon from {@code polygonVerticies}.
	 * 
	 * @return the stored polygon
	 */
	public Polygon getShape()
	{
		Polygon poly = new Polygon();
		for (Vector2 v : polygonVerticies)
		{
			poly.addPoint((int) v.x, (int) v.y);
		}

		polygonVerticies.clear();
		return poly;
	}
}
