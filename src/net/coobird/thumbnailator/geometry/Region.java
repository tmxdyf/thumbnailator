package net.coobird.thumbnailator.geometry;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;

/**
 * A representation of a region, using a {@link Position} object and a
 * {@link Dimension} object.
 * 
 * @author coobird
 *
 */
public final class Region
{
	/**
	 * Position of the region.
	 */
	private final Position position;
	
	/**
	 * Size of the region.
	 */
	private final Size size;
	
	/**
	 * Instantiates a representation of a region from a {@link Position} and
	 * {@link Size}. 
	 * 
	 * @param position		Position of the region.
	 * @param size			Size of the region.
	 */
	public Region(Position position, Size size)
	{
		super();
		this.position = position;
		this.size = size;
	}
	
	/**
	 * Returns the position of the region.
	 * 
	 * @return 				Position of the region.
	 */
	public Position getPosition()
	{
		return position;
	}
	
	/**
	 * Returns the size of the region.
	 * 
	 * @return 				Size of the region.
	 */
	public Size getSize()
	{
		return size;
	}
	
	/**
	 * Calculates the position and size of the enclosed region, relative to the
	 * enclosing region.
	 * <p>
	 * The portions of the enclosed region which lies outside of the enclosing
	 * region are ignored. Effectively, the {@link Rectangle} returned by this
	 * method is a intersection of the enclosing and enclose regions.
	 * 
	 * @param width		Width of the enclosing region.
	 * @param height	Height of the enclosing region.
	 * @return			Position and size of the enclosed region.
	 */
	public Rectangle calculate(int width, int height)
	{
		Dimension d = size.calculate(width, height);

		Point p = position.calculate(
				width, height, d.width, d.height, 0, 0, 0, 0
		);
		
		Rectangle outerRectangle = new Rectangle(0, 0, width, height);
		Rectangle innerRectangle = new Rectangle(p, d);
		
		return outerRectangle.intersection(innerRectangle);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "Region [position=" + position + ", size=" + size + "]";
	}
}
