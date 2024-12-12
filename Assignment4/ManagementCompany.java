/**
 * Represents a management company that manages properties.
 */
public class ManagementCompany {
    public static final int MAX_PROPERTY = 5;  // Maximum properties allowed
    private String name;
    private String taxID;
    private double managementFee;
    private Plot plot;  // Management plot
    private Property[] properties;  // Array to store properties
    private int propertyCount;  // Number of properties added

    /**
     * Default constructor creates a company with a default plot (0,0,10,10).
     */
    public ManagementCompany() {
        this("Management Company", "0000", 0.0, 0, 0, 10, 10);
    }
    
    public ManagementCompany(String name, String taxId, double managementFee) {
    	
    }

    /**
     * Parameterized constructor.
     * @param name Name of the management company.
     * @param taxID Tax ID of the company.
     * @param managementFee Management fee percentage.
     * @param x X-coordinate of the management plot.
     * @param y Y-coordinate of the management plot.
     * @param width Width of the management plot.
     * @param depth Depth of the management plot.
     */
    public ManagementCompany(String name, String taxID, double managementFee, int x, int y, int width, int depth) {
        this.name = name;
        this.taxID = taxID;
        this.managementFee = managementFee;
        this.plot = new Plot(x, y, width, depth);
        this.properties = new Property[MAX_PROPERTY];
        this.propertyCount = 0;
    }

    /**
     * Adds a property to the management company.
     * @param property The property to add.
     * @return -1 if array is full, -2 if property is null, -3 if not within plot, -4 if overlap exists, else index.
     */
    public int addProperty(Property property) {
        if (property == null) return -2;
        if (propertyCount >= MAX_PROPERTY) return -1;
        if (!plot.overlaps(property.getPlot())) return -3;
        
        for (int i = 0; i < propertyCount; i++) {
            if (properties[i].getPlot().overlaps(property.getPlot())) {
                return -4; // Overlapping property
            }
        }
        properties[propertyCount++] = property;
        return propertyCount - 1;  // Index where property was added
    }
    
    public String getName() {
    	return this.name;
    }
    
    public Plot getPlot() { return new Plot();}
    
    public double getTotalRent() { return 0;}
    
    public Property getHighestRentPropperty() {
    	return new Property("", "", 0, "");
    }
    
    public int getPropertiesCount() { return 1;}

    /**
     * Calculates the total rent for all properties.
     * @return Total rent amount.
     */
    public double totalRent() {
        double total = 0;
        for (int i = 0; i < propertyCount; i++) {
            total += properties[i].getRentAmount();
        }
        return total;
    }

    /**
     * Returns a summary of the management company and its properties.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("List of properties for ").append(name).append(", TaxID: ").append(taxID).append("\n");
        for (int i = 0; i < propertyCount; i++) {
            sb.append(properties[i].toString()).append("\n");
        }
        sb.append("Total management Fee: ").append(totalRent() * (managementFee / 100));
        return sb.toString();
    }
}
