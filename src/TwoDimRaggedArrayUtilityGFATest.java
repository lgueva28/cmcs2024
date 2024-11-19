import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This class represents GFA test cases for a TwoDimRaggedArrayUtility object.
 * 
 * @author Farnaz Eivazi
 * @version 7/13/2022
 * 
 */
public class TwoDimRaggedArrayUtilityGFATest {
    
    private double[][] dataSet1 = {{1, 2, 3}, {4, 5}, {6, 7, 8, 9}};
    
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * Test the getRowTotal method
     * Returns the total of all the elements of row 1.
     * Row 0 refers to the first row in the two dimensional array
     */
    @Test
    public void testGetRowTotal() {
        assertEquals(9.0, TwoDimRaggedArrayUtility.getRowTotal(dataSet1, 1), 0.001);
    }

    /**
     * Test the getColumnTotal method
     * Returns the total of all the elements in column 1.
     * Column 0 refers to the first column in the two-dimensional array.
     */
    @Test
    public void testGetColumnTotal() {
        assertEquals(11.0, TwoDimRaggedArrayUtility.getColumnTotal(dataSet1, 1), 0.001);
    }

    /**
     * Test the getTotal method
     * Returns the total of all the elements in the array.
     */
    @Test
    public void testGetTotal() {
        assertEquals(45.0, TwoDimRaggedArrayUtility.getTotal(dataSet1), 0.001);
    }

    /**
     * Test the getHighestInColumn method
     * Returns the highest value in column 2.
     */
    @Test
    public void testGetHighestInColumn() {
        assertEquals(9.0, TwoDimRaggedArrayUtility.getHighestInColumn(dataSet1, 2), 0.001);
    }

    /**
     * Test the getLowestInColumn method
     * Returns the lowest value in column 1.
     */
    @Test
    public void testGetLowestInColumn() {
        assertEquals(2.0, TwoDimRaggedArrayUtility.getLowestInColumn(dataSet1, 1), 0.001);
    }

    /**
     * Test the calculateHolidayBonus method
     * This method calculates the holiday bonus for each store.
     */
    @Test
    public void testCalculateHolidayBonus() {
        double[] expectedBonuses = {30.0, 20.0, 60.0};
        double[] actualBonuses = HolidayBonus.calculateHolidayBonus(dataSet1);
        assertArrayEquals(expectedBonuses, actualBonuses, 0.001);
    }

    /**
     * Test the calculateTotalHolidayBonus method
     * This method calculates the total holiday bonus for all stores.
     */
    @Test
    public void testCalculateTotalHolidayBonus() {
        assertEquals(110.0, HolidayBonus.calculateTotalHolidayBonus(dataSet1), 0.001);
    }
}
