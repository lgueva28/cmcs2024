/**
 * Represents a rectangular plot with coordinates, width, and depth.
 */
public class Plot {
    private int x, y, width, depth;

    /**
     * Default constructor initializes the plot to (0,0,1,1).
     */
    public Plot() {
        this(0, 0, 1, 1);
    }

    /**
     * Parameterized constructor.
     * @param x X-coordinate of the plot.
     * @param y Y-coordinate of the plot.
     * @param width Width of the plot.
     * @param depth Depth of the plot.
     */
    public Plot(int x, int y, int width, int depth) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.depth = depth;
    }

    /**
     * Copy constructor.
     * @param otherPlot The plot to copy.
     */
    public Plot(Plot otherPlot) {
        this(otherPlot.x, otherPlot.y, otherPlot.width, otherPlot.depth);
    }

    // Getters
    public int getX() { return x; }
    public int getY() { return y; }
    public int getWidth() { return width; }
    public int getDepth() { return depth; }

    /**
     * Checks if this plot overlaps with another plot.
     * @param other The other plot to compare.
     * @return True if the plots overlap; false otherwise.
     */
    public boolean overlaps(Plot other) {
        return !(this.x + this.width <= other.x ||  // This is left of other
                 other.x + other.width <= this.x || // This is right of other
                 this.y + this.depth <= other.y ||  // This is above other
                 other.y + other.depth <= this.y);  // This is below other
    }

    /**
     * Returns the plot's details as a string.
     * @return A string in the format "x,y,width,depth".
     */
    @Override
    public String toString() {
        return x + "," + y + "," + width + "," + depth;
    }
}
