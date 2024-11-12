

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ManagmentCompanyTestStudent {

    private ManagementCompany managementCompany;

    @BeforeEach
    void setUp() {
        managementCompany = new ManagementCompany("RealEstate Inc.", "12345", 10.0);
    }

    @Test
    void testConstructor() {
        assertEquals("RealEstate Inc.", managementCompany.getName());
        assertEquals("12345", managementCompany.getTaxID());
        assertEquals(10.0, managementCompany.getManagementFee());
        assertEquals("0,0,10,10", managementCompany.getPlot().toString());
    }

    @Test
    void testGetName() {
        assertEquals("RealEstate Inc.", managementCompany.getName());
    }

    @Test
    void testSetName() {
        managementCompany.setName("NewCompany");
        assertEquals("NewCompany", managementCompany.getName());
    }

    @Test
    void testGetTaxID() {
        assertEquals("12345", managementCompany.getTaxID());
    }

    @Test
    void testSetTaxID() {
        managementCompany.setTaxID("67890");
        assertEquals("67890", managementCompany.getTaxID());
    }

    @Test
    void testGetManagementFee() {
        assertEquals(10.0, managementCompany.getManagementFee());
    }

    @Test
    void testSetManagementFee() {
        managementCompany.setManagementFee(15.0);
        assertEquals(15.0, managementCompany.getManagementFee());
    }

    @Test
    void testAddPropertyObject() {
        Property property = new Property("Property1", "City1", 1000.0, "Owner1", 1, 1, 2, 2);
        int index = managementCompany.addProperty(property);
        assertEquals(0, index); // First property should be at index 0
    }


    @Test
    void testIsManagementFeeValid() {
        assertTrue(managementCompany.isManagementFeeValid());
        managementCompany.setManagementFee(150.0);
        assertFalse(managementCompany.isManagementFeeValid());
    }


    @Test
    void testRemoveLastProperty() {
        managementCompany.addProperty("LastProperty", "LastCity", 1200.0, "OwnerZ");
        assertEquals(1, managementCompany.getPropertiesCount());
        managementCompany.removeLastProperty();
        assertEquals(0, managementCompany.getPropertiesCount());
    }

    @Test
    void testToString() {
        managementCompany.addProperty("Property1", "City1", 1000.0, "Owner1");
        String result = managementCompany.toString();
        assertTrue(result.contains("List of the properties for RealEstate Inc., taxID: 12345"));
        assertTrue(result.contains("total management Fee: 100.0"));
    }
}
