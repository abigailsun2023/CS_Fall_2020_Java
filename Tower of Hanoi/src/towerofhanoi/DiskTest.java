/**
 * 
 */
package towerofhanoi;

import student.TestCase;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Abigail Sun (asun14)

/**
 * This DiskTest class tests all the methods in the Disk class
 * 
 * @author Abigail Sun (asun14)
 * @version 2020.10.19
 *
 */
public class DiskTest extends TestCase {

    private Disk disk;
    private Disk disk2;
    private Disk disk3;
    private Disk disk4;

    /**
     * Sets up the test cases
     */
    public void setUp() {
        disk = new Disk(0);
        disk2 = new Disk(2);
        disk3 = null;
        disk4 = new Disk(2);
    }


    /**
     * Tests the compareTo() method by comparing one
     * disk to another.
     */
    public void testCompareTo() {
        assertEquals(2, disk2.compareTo(disk));
        assertEquals(0, disk2.compareTo(disk4));
    }


    /**
     * Test the compareTo method by using a try catch when
     * compareTo is called onto disks with a negative difference
     * in width.
     */
    public void testCompareToTryCatch() {
        Exception exception = null;
        try {
            disk.compareTo(disk3);
            fail("compareTo() is not throwing an exception when it should");
        }
        catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception);
        assertTrue("compareTo() is throwing the wrong type of exceptions",
            exception instanceof IllegalArgumentException);
    }


    /**
     * Tests the toString() method by asserting the width
     * of the disks as a string.
     */
    public void testToString() {
        assertEquals("0", disk.toString());
        assertEquals("2", disk2.toString());
    }


    /**
     * Tests the equals() method by asserting if the width
     * of one disk is the same as the other.
     */
    public void testEquals() {
        assertFalse(disk2.equals(disk3));

        assertTrue(disk2.equals(disk4));
        assertTrue(disk2.equals(disk2));
        assertFalse(disk2.equals(disk));

        String otherClass = "";
        assertFalse(disk.equals(otherClass));
    }

}
