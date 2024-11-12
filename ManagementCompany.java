/*
 * Class: CMSC203 
 * Instructor:Professor Monshi
 * Description: Computer Science class where we study object oriented design using Java programming language
 * Due: 11/11/2024
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming assignment 
* independently. I have not copied the code from a student or   * any source. I have not given my code to any student.
 * Print your Name here: Ivan Sergiyovych Dmytriiev
*/


public class ManagementCompany {
    private String name;
    private String taxID;
    private double managementFee;
    private Plot plot;
    private Property[] properties;
    private int numberOfProperties;

    public static final int MAX_PROPERTY = 5;
    public static final int MGMT_WIDTH = 10;
    public static final int MGMT_DEPTH = 10;

    // Constructors
    public ManagementCompany(String name, String taxID, double managementFee) {
        this.name = name;
        this.taxID = taxID;
        this.managementFee = managementFee;
        this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
        this.properties = new Property[MAX_PROPERTY];
        this.numberOfProperties = 0;
    }

    // Getter and Setter methods
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getTaxID() { return taxID; }
    public void setTaxID(String taxID) { this.taxID = taxID; }

    public double getManagementFee() { return managementFee; }
    public void setManagementFee(double managementFee) { this.managementFee = managementFee; }

    public Plot getPlot() { return plot; }

    // Overloaded addProperty methods
    public int addProperty(Property property) {
        if (property == null) return -2; // Property is null
        if (numberOfProperties >= MAX_PROPERTY) return -1; // Array is full
        if (!plot.encompasses(property.getPlot())) return -3; // Property plot not within management plot

        for (int i = 0; i < numberOfProperties; i++) {
            if (properties[i].getPlot().overlaps(property.getPlot())) return -4; // Overlap detected
        }

        properties[numberOfProperties] = property;
        numberOfProperties++;
        return numberOfProperties - 1; // Return index of added property
    }

    public int addProperty(String propertyName, String city, double rent, String owner) {
        return addProperty(new Property(propertyName, city, rent, owner));
    }

    public int addProperty(String propertyName, String city, double rent, String owner, int x, int y, int width, int depth) {
        return addProperty(new Property(propertyName, city, rent, owner, x, y, width, depth));
    }

    // Method to check if properties array is full
    public boolean isPropertiesFull() {
        return numberOfProperties >= MAX_PROPERTY;
    }

    // Returns the total count of properties managed
    public int getPropertiesCount() {
        return numberOfProperties;
    }

    // Checks if the management fee is between 0 and 100
    public boolean isManagementFeeValid() {
        return managementFee >= 0 && managementFee <= 100;
    }

    // Calculates and returns the total rent amount from all properties
    public double getTotalRent() {
        double totalRent = 0;
        for (int i = 0; i < numberOfProperties; i++) {
            totalRent += properties[i].getRentAmount();
        }
        return totalRent;
    }

    // Returns the property with the highest rent
    public Property getHighestRentProperty() {
        if (numberOfProperties == 0) return null;
        Property highestRentProperty = properties[0];
        for (int i = 1; i < numberOfProperties; i++) {
            if (properties[i].getRentAmount() > highestRentProperty.getRentAmount()) {
                highestRentProperty = properties[i];
            }
        }
        return highestRentProperty;
    }

    // Removes the last property in the array
    public void removeLastProperty() {
        if (numberOfProperties > 0) {
            properties[numberOfProperties - 1] = null;
            numberOfProperties--;
        }
    }

    // Returns a formatted string listing all properties managed by this company
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("List of the properties for ").append(name).append(", taxID: ").append(taxID).append("\n")
          .append("______________________________________________________\n");
        
        for (int i = 0; i < numberOfProperties; i++) {
            sb.append(properties[i].toString()).append("\n");
        }

        sb.append("______________________________________________________\n\n")
          .append(" total management Fee: ").append(getTotalRent() * (managementFee / 100));

        return sb.toString();
    }
}
