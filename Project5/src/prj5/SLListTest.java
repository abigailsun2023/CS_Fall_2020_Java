// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I 
// accept the actions of those who do.
// -- Mithran Mohanraj (mithran)

package prj5;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This class tests the SLList class except the 
 * equals() and toArray() methods.
 * @author Mithran Mohanraj (mithran)
 * @version 2020.10.23
 */
public class SLListTest extends student.TestCase {
    private SLList<String> list1;
    /**
     * Sets up _ lists for testing
     */
    public void setUp() {
        list1 = new SLList<String>();
    }
    
    /**
     * Tests add
     */
    public void testAdd() {
        String[] array1 = {"Hello0", "Hello1", "Hello2"};
        
        for (int i = 0; i < 3; i++) {
            list1.add("Hello" + i);
        }
        assertTrue(Arrays.equals(array1, list1.toArray()));
        
        
        //Without index null
        Exception exception = null;
        try
        {
            list1.add(null);
            fail("add() is not throwing an exception when it should");
        }
        catch (Exception e)
        {
            exception = e;
        }
        assertTrue("add() is throwing the wrong type of exceptions",
                   exception instanceof IllegalArgumentException);
        
        
    }
    
    /**
     * Tests add with index
     */
    public void testAddIndex() {
        String[] array3 = {"Hello0", "Hello0", "Hello1", "Hello1.5", "Hello2"};
        for (int i = 0; i < 3; i++) {
            list1.add(i, "Hello" + i);
        }       
        list1.add(2, "Hello1.5");
        list1.add(0, "Hello0");
        assertTrue(Arrays.equals(array3, list1.toArray()));
        //With index null
        Exception exception = null;
        try
        {
            list1.add(1, null);
            fail("add() is not throwing an exception when it should");
        }
        catch (Exception e)
        {
            exception = e;
        }
        assertTrue("add() is throwing the wrong type of exceptions",
                   exception instanceof IllegalArgumentException);
        
        //With index outofbounds
        exception = null;
        try
        {
            list1.add(6, "error");
            fail("add() is not throwing an exception when it should");
        }
        catch (Exception e)
        {
            exception = e;
        }
        assertTrue("add() is throwing the wrong type of exceptions",
                   exception instanceof IndexOutOfBoundsException);
        
        list1.clear();
        exception = null;
        try
        {
            list1.add(-1, "error");
            fail("add() is not throwing an exception when it should");
        }
        catch (Exception e)
        {
            exception = e;
        }
        assertTrue("add() is throwing the wrong type of exceptions",
                   exception instanceof IndexOutOfBoundsException);
    }
    
    /**
     * Tests isEmpty
     */
    public void testIsEmpty() {
        assertTrue(list1.isEmpty());
        list1.add("Hello");
        assertFalse(list1.isEmpty());
        list1.remove("Hello");
        assertTrue(list1.isEmpty());
    }
    
    /**
     * Tests remove
     */
    public void testRemove() {
        String[] array1 = {"Hello1", "Hello2"};
        String[] array2 = {"Hello2"};
        for (int i = 0; i < 3; i++) {
            list1.add("Hello" + i);
        }
        assertFalse(list1.remove("Hello"));
        assertTrue(list1.remove("Hello0"));
        assertTrue(Arrays.equals(array1, list1.toArray()));
        assertTrue(list1.remove("Hello1"));
        assertTrue(Arrays.equals(array2, list1.toArray()));
        assertTrue(list1.remove("Hello2"));
        assertTrue(Arrays.equals(new String[0], list1.toArray()));
        assertFalse(list1.remove("Hello"));
        
        for (int i = 0; i < 3; i++) {
            list1.add("Hello" + i);
        }
        assertTrue(list1.remove("Hello2"));
    }
    
    /**
     * Tests remove with index
     */
    public void testRemoveIndex() {
        String[] array1 = {"Hello0", "Hello1"};
        String[] array2 = {"Hello0"};
        for (int i = 0; i < 3; i++) {
            list1.add("Hello" + i);
        }
        
        //out of bound max
        Exception exception = null;
        try
        {
            list1.remove(6);
            fail("remove() is not throwing an exception when it should");
        }
        catch (Exception e)
        {
            exception = e;
        }
        assertTrue("remove() is throwing the wrong type of exceptions",
                   exception instanceof IndexOutOfBoundsException);
        
        assertTrue(list1.remove(2));
        assertTrue(Arrays.equals(array1, list1.toArray()));
        assertTrue(list1.remove(1));
        assertTrue(Arrays.equals(array2, list1.toArray()));
        assertTrue(list1.remove(0));
        assertTrue(Arrays.equals(new String[0], list1.toArray()));
        
        exception = null;
        try
        {
            list1.remove(-1);
            fail("remove() is not throwing an exception when it should");
        }
        catch (Exception e)
        {
            exception = e;
        }
        assertTrue("remove() is throwing the wrong type of exceptions",
                   exception instanceof IndexOutOfBoundsException);
        
        exception = null;
        try
        {
            list1.remove(1);
            fail("remove() is not throwing an exception when it should");
        }
        catch (Exception e)
        {
            exception = e;
        }
        assertTrue("remove() is throwing the wrong type of exceptions",
                   exception instanceof IndexOutOfBoundsException);
        
        for (int i = 0; i < 3; i++) {
            list1.add("Hello" + i);
        }
        for (int i = 0; i < 3; i++) {
            assertTrue(list1.remove(0));
        }
        
    }
    
    /**
     * Test get
     */
    public void testGet() {
        Exception exception = null;
        try
        {
            list1.get(6);
            fail("add() is not throwing an exception when it should");
        }
        catch (Exception e)
        {
            exception = e;
        }
        assertTrue("add() is throwing the wrong type of exceptions",
                   exception instanceof IndexOutOfBoundsException);
        
        for (int i = 0; i < 3; i++) {
            list1.add("Hello" + i);
        }
        
        assertEquals(list1.get(0), "Hello0");
        assertEquals(list1.get(2), "Hello2");
        
    }
    
    /**
     * Test contains
     */
    public void testContains() {
        assertFalse(list1.contains("Hello4"));
        for (int i = 0; i < 3; i++) {
            list1.add("Hello" + i);
        }
        
        assertTrue(list1.contains("Hello0"));
        assertTrue(list1.contains("Hello2"));
        assertFalse(list1.contains("Hello4"));
    }
    
    /**
     * Test clear
     */
    public void testClear() {
        list1.clear();
        for (int i = 0; i < 3; i++) {
            list1.add("Hello" + i);
        }
        assertFalse(list1.isEmpty());
        list1.clear();
        assertTrue(list1.isEmpty());
    }
    
    /**
     * Test last index of
     */
    public void testLastIndexOf() {
        assertEquals(-1, list1.lastIndexOf("Hello2"));
        for (int i = 0; i < 3; i++) {
            list1.add("Hello" + i);
            assertEquals(i, list1.lastIndexOf("Hello" + i));
        }
        for (int i = 0; i < 3; i++) {
            list1.add("Hello" + i);
        }
        assertEquals(5, list1.lastIndexOf("Hello2"));
    }
    
    /**
     * Test toString()
     */
    public void testToString() {
        for (int i = 0; i < 3; i++) {
            list1.add("Hello" + i);
        }
        assertEquals(list1.toString(), "{Hello0, Hello1, Hello2}");
    }
    
    /**
     * Test iterator
     */
    public void testIterator() {
        for (int i = 0; i < 3; i++) {
            list1.add("Hello" + i);
        }
        Iterator<String> hi = list1.iterator();
        for (int i = 0; i < 3; i++) {
            assertTrue(hi.hasNext());
            assertEquals("Hello" + i, hi.next());
        }
        try {
            hi.next();
            fail("Iterator not throwing exception while no next");
        }
        catch (Exception e) {
            assertTrue(e instanceof NoSuchElementException);
        }
    }
    
    /**
     * Test sort
     */
    public void testSort() {
        SLList<CFRDataPoint> list = new SLList<CFRDataPoint>();
        list.sort(new CFRComparatorNum());
        list.add(new CFRDataPoint(5407, 4.7, "asian"));
        list.add(new CFRDataPoint(179563, 7.4, "black"));
        list.add(new CFRDataPoint(97118, 2.3, "latinx"));
        list.add(new CFRDataPoint(108784, 0.2, "other"));
        list.add(new CFRDataPoint(70678, 2.7, "white"));
        list.sort(new CFRComparatorNum());
        assertEquals("{black: 179563 cases, 7.4% CFR, asian: 5407 cases, "
            + "4.7% CFR, "
            + "white: 70678 cases, 2.7% CFR, "
            + "latinx: 97118 cases, 2.3% CFR, other: 108784 cases, 0.2% CFR}", 
            list.toString());
        list.sort(new CFRComparatorAlpha());
        assertEquals("{asian: 5407 cases, 4.7% CFR, black: 179563 cases, "
            + "7.4% CFR, latinx: 97118 cases, 2.3% CFR, other: 108784 cases, "
            + "0.2% CFR, white: 70678 cases, 2.7% CFR}", list.toString());
    }
}
