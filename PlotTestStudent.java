

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlotTestStudent {

    private Plot defaultPlot;
    private Plot parameterizedPlot;
    private Plot copyPlot;

    @BeforeEach
    void setUp() {
        defaultPlot = new Plot(); // Using default constructor
        parameterizedPlot = new Plot(2, 3, 5, 6); // Using parameterized constructor
        copyPlot = new Plot(parameterizedPlot); // Using copy constructor
    }

    @Test
    void testDefaultConstructor() {
        assertEquals(0, defaultPlot.getX());
        assertEquals(0, defaultPlot.getY());
        assertEquals(1, defaultPlot.getWidth());
        assertEquals(1, defaultPlot.getDepth());
    }

    @Test
    void testParameterizedConstructor() {
        assertEquals(2, parameterizedPlot.getX());
        assertEquals(3, parameterizedPlot.getY());
        assertEquals(5, parameterizedPlot.getWidth());
        assertEquals(6, parameterizedPlot.getDepth());
    }

    @Test
    void testCopyConstructor() {
        assertEquals(parameterizedPlot.getX(), copyPlot.getX());
        assertEquals(parameterizedPlot.getY(), copyPlot.getY());
        assertEquals(parameterizedPlot.getWidth(), copyPlot.getWidth());
        assertEquals(parameterizedPlot.getDepth(), copyPlot.getDepth());
    }

    @Test
    void testGettersAndSetters() {
        defaultPlot.setX(10);
        defaultPlot.setY(15);
        defaultPlot.setWidth(7);
        defaultPlot.setDepth(8);

        assertEquals(10, defaultPlot.getX());
        assertEquals(15, defaultPlot.getY());
        assertEquals(7, defaultPlot.getWidth());
        assertEquals(8, defaultPlot.getDepth());
    }

    @Test
    void testOverlaps() {
        Plot plot1 = new Plot(0, 0, 4, 4);
        Plot plot2 = new Plot(2, 2, 4, 4); // Overlapping with plot1
        Plot plot3 = new Plot(5, 5, 3, 3); // Non-overlapping with plot1

        assertTrue(plot1.overlaps(plot2));
        assertFalse(plot1.overlaps(plot3));
    }

    @Test
    void testEncompasses() {
        Plot plot1 = new Plot(0, 0, 10, 10);
        Plot plot2 = new Plot(2, 2, 3, 3); // Fully inside plot1
        Plot plot3 = new Plot(-1, -1, 5, 5); // Partially outside plot1

        assertTrue(plot1.encompasses(plot2));
        assertFalse(plot1.encompasses(plot3));
    }

    @Test
    void testToString() {
        assertEquals("0,0,1,1", defaultPlot.toString());
        assertEquals("2,3,5,6", parameterizedPlot.toString());
    }
}
