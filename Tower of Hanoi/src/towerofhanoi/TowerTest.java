package towerofhanoi;

import student.TestCase;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Abigail Sun (asun14)

/**
 * This TowerTest class tests all the methods in the Tower class
 * 
 * @author Abigail Sun (asun14)
 * @version 2020.10.19
 *
 */
public class TowerTest extends TestCase {

    private Tower towerLeft;
    private Tower towerMiddle;
    private Tower towerRight;
    private Disk disk;
    private Disk disk2;
    private Disk disk3;

    /**
     * Sets up the test cases
     */
    public void setUp() {
        disk = null;
        disk2 = new Disk(1);
        disk3 = new Disk(2);
        towerLeft = new Tower(Position.LEFT);
        towerMiddle = new Tower(Position.MIDDLE);
        towerRight = new Tower(Position.RIGHT);
    }


    /**
     * Tests the position method by asserting the position of
     * the towers.
     */
    public void testPosition() {
        assertEquals(Position.LEFT, towerLeft.position());
        assertEquals(Position.MIDDLE, towerMiddle.position());
        assertEquals(Position.RIGHT, towerRight.position());
    }


    /**
     * Tests the push() method by using a try catch when a null
     * disk is pushed onto the tower.
     */
    public void testPushTryCatch() {
        Exception exception = null;
        try {
            towerLeft.push(disk);
            fail("push() is not throwing an exception when it should");
        }
        catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception);
        assertTrue("push() is throwing the wrong type of exceptions",
            exception instanceof IllegalArgumentException);
    }
    
    
    /**
     * Tests the push() method by using a try catch when a null
     * disk is pushed onto the tower.
     */
    public void testPushTryCatch2() {
        Exception exception = null;
        try {
            towerLeft.push(disk2);
            towerLeft.push(disk3);
            fail("push() is not throwing an exception when it should");
        }
        catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception);
        assertTrue("push() is throwing the wrong type of exceptions",
            exception instanceof IllegalStateException);
    }


    /**
     * Tests the push method by calling the method onto a tower
     * and asserting that the new item was pushed onto the tower.
     */
    public void testPush() {
        assertEquals(0, towerRight.size());
        towerRight.push(disk2);
        assertEquals(1, towerRight.size());
    }


    /**
     * Tests the push method by pushing multiple disks onto a tower
     * and asserting that the size has increased.
     */
    public void testPush2() {
        assertEquals(0, towerRight.size());
        towerRight.push(disk3);
        towerRight.push(disk2);

        assertEquals(2, towerRight.size());
    }

}
