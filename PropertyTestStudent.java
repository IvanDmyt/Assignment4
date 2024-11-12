

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PropertyTestStudent {

    private Property defaultProperty;
    private Property parameterizedProperty;
    private Property copyProperty;

    @BeforeEach
    void setUp() {
        defaultProperty = new Property(); // Using default constructor
        parameterizedProperty = new Property("Lake House", "Orlando", 2500.0, "John Doe"); // Using parameterized constructor
        copyProperty = new Property(parameterizedProperty); // Using copy constructor
    }

    @Test
    void testDefaultConstructor() {
        assertEquals("", defaultProperty.getPropertyName());
        assertEquals("", defaultProperty.getCity());
        assertEquals("", defaultProperty.getOwner());
        assertEquals(0.0, defaultProperty.getRentAmount());
        assertEquals("0,0,1,1", defaultProperty.getPlot().toString());
    }

    @Test
    void testParameterizedConstructor() {
        assertEquals("Lake House", parameterizedProperty.getPropertyName());
        assertEquals("Orlando", parameterizedProperty.getCity());
        assertEquals("John Doe", parameterizedProperty.getOwner());
        assertEquals(2500.0, parameterizedProperty.getRentAmount());
        assertEquals("0,0,1,1", parameterizedProperty.getPlot().toString());
    }

    @Test
    void testParameterizedConstructorWithPlot() {
        Property propertyWithPlot = new Property("Mountain Cabin", "Aspen", 3500.0, "Jane Smith", 2, 3, 4, 5);
        assertEquals("Mountain Cabin", propertyWithPlot.getPropertyName());
        assertEquals("Aspen", propertyWithPlot.getCity());
        assertEquals("Jane Smith", propertyWithPlot.getOwner());
        assertEquals(3500.0, propertyWithPlot.getRentAmount());
        assertEquals("2,3,4,5", propertyWithPlot.getPlot().toString());
    }

    @Test
    void testCopyConstructor() {
        assertEquals(parameterizedProperty.getPropertyName(), copyProperty.getPropertyName());
        assertEquals(parameterizedProperty.getCity(), copyProperty.getCity());
        assertEquals(parameterizedProperty.getOwner(), copyProperty.getOwner());
        assertEquals(parameterizedProperty.getRentAmount(), copyProperty.getRentAmount());
        assertEquals(parameterizedProperty.getPlot().toString(), copyProperty.getPlot().toString());
    }

    @Test
    void testGettersAndSetters() {
        defaultProperty.setPropertyName("Beach House");
        defaultProperty.setCity("Miami");
        defaultProperty.setOwner("Alice Wonderland");
        defaultProperty.setRentAmount(5000.0);
        defaultProperty.setPlot(1, 2, 3, 4);

        assertEquals("Beach House", defaultProperty.getPropertyName());
        assertEquals("Miami", defaultProperty.getCity());
        assertEquals("Alice Wonderland", defaultProperty.getOwner());
        assertEquals(5000.0, defaultProperty.getRentAmount());
        assertEquals("1,2,3,4", defaultProperty.getPlot().toString());
    }

    @Test
    void testToString() {
        assertEquals("Lake House,Orlando,John Doe,2500.0", parameterizedProperty.toString());
    }
}
