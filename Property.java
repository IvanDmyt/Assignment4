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



public class Property {
    private String propertyName;
    private String city;
    private String owner;
    private double rentalAmount;
    private Plot plot; // Default plot with x=0, y=0, width=1, depth=1

    // Constructors
    public Property() {
        this.propertyName = "";
        this.city = "";
        this.owner = "";
        this.rentalAmount = 0.0;
        this.plot = new Plot(); // Default plot
    }

    public Property(String propertyName, String city, double rentalAmount, String owner) {
        this.propertyName = propertyName;
        this.city = city;
        this.owner = owner;
        this.rentalAmount = rentalAmount;
        this.plot = new Plot(); // Default plot (0,0,1,1)
    }

    public Property(String propertyName, String city, double rentalAmount, String owner, int x, int y, int width, int depth) {
        this.propertyName = propertyName;
        this.city = city;
        this.owner = owner;
        this.rentalAmount = rentalAmount;
        this.plot = new Plot(x, y, width, depth);
    }

    // Copy Constructor
    public Property(Property otherProperty) {
        this.propertyName = otherProperty.propertyName;
        this.city = otherProperty.city;
        this.owner = otherProperty.owner;
        this.rentalAmount = otherProperty.rentalAmount;
        this.plot = new Plot(otherProperty.plot); // Copy plot
    }

    // Getter and Setter methods
    public String getPropertyName() { return propertyName; }
    public void setPropertyName(String propertyName) { this.propertyName = propertyName; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getOwner() { return owner; }
    public void setOwner(String owner) { this.owner = owner; }

    public double getRentAmount() { return rentalAmount; }
    public void setRentAmount(double rentalAmount) { this.rentalAmount = rentalAmount; }

    public Plot getPlot() { return plot; }
    public void setPlot(int x, int y, int width, int depth) {
        this.plot = new Plot(x, y, width, depth);
    }

    // toString method that returns "propertyName,city,owner,rentalAmount" format
    @Override
    public String toString() {
        return propertyName + "," + city + "," + owner + "," + rentalAmount;
    }
}
