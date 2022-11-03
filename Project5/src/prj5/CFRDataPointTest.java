// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I 
// accept the actions of those who do.
// -- Mithran Mohanraj (mithran)
package prj5;

/**
 * This class ensures that the comparisons between CFR 
 * datapoints work as intended
 * @author Mithran Mohanraj (mithran)
 * @version 11.21.2020
 */
public class CFRDataPointTest extends student.TestCase {
    private CFRDataPoint asian;
    private CFRDataPoint white;
    private CFRDataPoint black;
    
    /**
     * Sets up fields
     */
    public void setUp() {
        asian = new CFRDataPoint(13124, 17, "Asian");
        white = new CFRDataPoint(143, 15, "White");
        black = new CFRDataPoint(143, 15, "black");
    }
    
    /**
     * Sets up fields
     */
    public void testGetters() {
        assertEquals("Asian", asian.getRace());
        assertEquals(17.0, asian.getValue(), 0.01);
        assertEquals(13124, asian.getCase());
    }
    
    /**
     * Tests comparator alpha
     */
    public void testAlphaComp() {
        CFRComparatorAlpha alpha = new CFRComparatorAlpha();
        assertTrue(0 > alpha.compare(asian, black));
        assertEquals(0, alpha.compare(asian, asian));
        assertTrue(0 < alpha.compare(white, black));
    }
    
    /**
     * Tests comparator num
     */
    public void testNumComp() {
        CFRComparatorNum num = new CFRComparatorNum();
        assertTrue(0 > num.compare(asian, black));
        assertTrue(0 < num.compare(white, black));
        assertEquals(0, num.compare(black, black));
        assertTrue(0 < num.compare(black, asian));
    }
}
