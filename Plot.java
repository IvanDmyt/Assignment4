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



public class Plot {
    private int x;        // x-coordinate of the upper-left corner
    private int y;        // y-coordinate of the upper-left corner
    private int width;    // horizontal extent of the plot
    private int depth;    // vertical extent of the plot

    // Default Constructor
    public Plot() {
        this.x = 0;
        this.y = 0;
        this.width = 1;
        this.depth = 1;
    }

    // Parameterized Constructor
    public Plot(int x, int y, int width, int depth) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.depth = depth;
    }

    // Copy Constructor
    public Plot(Plot other) {
        this.x = other.x;
        this.y = other.y;
        this.width = other.width;
        this.depth = other.depth;
    }

    // Getter and Setter methods
    public int getX() { return x; }
    public void setX(int x) { this.x = x; }

    public int getY() { return y; }
    public void setY(int y) { this.y = y; }

    public int getWidth() { return width; }
    public void setWidth(int width) { this.width = width; }

    public int getDepth() { return depth; }
    public void setDepth(int depth) { this.depth = depth; }

    // Method to check if this plot overlaps with another plot
    public boolean overlaps(Plot other) {
        return !(this.x + this.width <= other.x ||  // this is left of other
                 other.x + other.width <= this.x || // other is left of this
                 this.y + this.depth <= other.y ||  // this is above other
                 other.y + other.depth <= this.y);  // other is above this
    }

    // Method to check if this plot fully encompasses another plot (inclusive edges)
    public boolean encompasses(Plot other) {
        return (this.x <= other.x &&
                this.y <= other.y &&
                this.x + this.width >= other.x + other.width &&
                this.y + this.depth >= other.y + other.depth);
    }

    // toString method that returns "[x],[y],[width],[depth]" format
    @Override
    public String toString() {
        return x + "," + y + "," + width + "," + depth;
    }
}
