/**
 * Represents a property with a name, city, rent amount, owner, and plot.
 */
public class Property {
    private String propertyName;
    private String city;
    private double rentAmount;
    private String owner;
    private Plot plot;

    /**
     * Constructor with a default plot at (0,0,1,1).
     * @param propertyName Name of the property.
     * @param city City where the property is located.
     * @param rentAmount Rent amount of the property.
     * @param owner Owner of the property.
     */
    public Property(String propertyName, String city, double rentAmount, String owner) {
        this.propertyName = propertyName;
        this.city = city;
        this.rentAmount = rentAmount;
        this.owner = owner;
        this.plot = new Plot(); // Default plot
    }

    /**
     * Parameterized constructor with custom plot.
     * @param propertyName Name of the property.
     * @param city City where the property is located.
     * @param rentAmount Rent amount of the property.
     * @param owner Owner of the property.
     * @param x X-coordinate of the property's plot.
     * @param y Y-coordinate of the property's plot.
     * @param width Width of the property's plot.
     * @param depth Depth of the property's plot.
     */
    public Property(String propertyName, String city, double rentAmount, String owner, int x, int y, int width, int depth) {
        this.propertyName = propertyName;
        this.city = city;
        this.rentAmount = rentAmount;
        this.owner = owner;
        this.plot = new Plot(x, y, width, depth);
    }

    // Getters
    public String getPropertyName() { return propertyName; }
    public String getCity() { return city; }
    public double getRentAmount() { return rentAmount; }
    public String getOwner() { return owner; }
    public Plot getPlot() { return plot; }

    /**
     * Returns the property's details as a string.
     * @return A string in the format "propertyName,city,owner,rentAmount".
     */
    @Override
    public String toString() {
        return propertyName + "," + city + "," + owner + "," + rentAmount;
    }
}
