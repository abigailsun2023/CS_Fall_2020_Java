/**
 * 
 */
package game;
import student.TestCase;
import student.TestableRandom;
//Virginia Tech Honor Code Pledge:
//
//As a Hokie, I will conduct myself with honor and integrity at all times.
//I will not lie, cheat, or steal, nor will I accept the actions of those
//who do.
//-- Abigail Sun (asun14)
/**
 * This SimpleArrayBagTest class tests all the methods in the 
 * SimpleArrayBag class.
 * 
 * @author Abigail Sun (asun14)
 * @version 2020.10.05
 *
 */
public class SimpleArrayBagTest extends TestCase {
    
    private SimpleArrayBag<String> baggy1;
    private SimpleArrayBag<String> baggy2;
    
    /**
     * Sets up the test class for SimpleArrayBag
     */
    public void setUp() {
        baggy1 = new SimpleArrayBag<String>();
        baggy1.add("red circle");
        baggy1.add("blue square");
        
        baggy2 = new SimpleArrayBag<String>();
    }
    
    
    /**
     * Tests the getCurrentSize() method in SimpleArrayBag
     */
    public void testGetCurrentSize() {
        assertEquals(2, baggy1.getCurrentSize());
        assertEquals(0, baggy2.getCurrentSize());
    }
    
    
    /**
     * Tests the isEmpty() method in SimpleArrayBag
     */
    public void testIsEmpty() {
        assertTrue(baggy2.isEmpty());
        assertFalse(baggy1.isEmpty());
    }
    
    
    /**
     * Tests the add() method in SimpleArrayBag
     * 
     * In this first scenario, the test will be made to see what would
     * happen if there are 25 or more entries in the bag. This will be 
     * accomplished by making a for-loop to make more than 25 entries 
     * in a bag. 
     * 
     * Should return false (assertFalse).
     */
    public void testAdd1() {
        assertTrue(baggy1.add("red square"));
        
        for (int i = 0; i <= 25; i++) {
            baggy1.add("blue circle");
        }
        
        assertFalse(baggy1.add("blue circle"));
    }
    
    
    /**
     * Tests the add() method in SimpleArrayBag
     * 
     * In this scenario, the test should assertFalse if the bag is null.
     */
    public void testAdd2() {
        assertFalse(baggy2.add(null)); 
    }
    
    
    /**
     * Tests the pick() method in SimpleArrayBag
     */
    public void testPick() {
        TestableRandom.setNextInts(1);
        assertEquals("blue square", baggy1.pick());
        assertNull(baggy2.pick());
    }
    
    
    /**
     * Tests the remove() method in SimpleArrayBag
     */
    public void testRemove() {
        baggy1.remove("red circle");
        assertTrue(baggy1.remove("blue square"));
        assertFalse(baggy1.remove("red circle"));
        baggy1.add("red square");
        baggy1.add("red square");
        baggy1.add("blue circle");
        baggy1.add("red circle");
        assertTrue(baggy1.remove("blue circle"));
    }

}
