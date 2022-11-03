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
 * This SimpleLinkedBagTest class tests all the methods in the 
 * SimpleLinkedBag class.
 * 
 * @author Abigail Sun (asun14)
 * @version 2020.10.05
 *
 */
public class SimpleLinkedBagTest extends TestCase {
    private SimpleLinkedBag<String> baggy1;
    private SimpleLinkedBag<String> baggy2;
    
    /**
     * Sets up the test cases
     */
    public void setUp() {
        baggy1 = new SimpleLinkedBag<String>();
        baggy1.add("red square");
        baggy1.add("blue circle");
        
        baggy2 = new SimpleLinkedBag<String>();
    }
  
    
    /**
     * Tests the add() method
     */
    public void testAdd() {
        assertTrue(baggy1.add("red square"));
        assertFalse(baggy1.add(null));
    }
  
    
    /**
     * Tests the getCurrentSize() method
     */
    public void testGetCurrentSize() {
        assertEquals(2, baggy1.getCurrentSize());
    }
  
    
    /**
     * Tests the isEmpty() method
     */
    public void testIsEmpty() {
        assertTrue(baggy2.isEmpty());
        assertFalse(baggy1.isEmpty());
    }

    
    /**
     * Tests the pick() method
     */
    public void testPick() {
        TestableRandom.setNextInts(1);
        assertEquals("red square", baggy1.pick());
        assertNull(baggy2.pick());
    }
  
    
    /**
     * Tests the remove() method
     */
    public void testRemove() {
        baggy1.remove("red square");
        assertTrue(baggy1.remove("blue circle"));
        assertFalse(baggy1.remove("red square"));
    }

}
