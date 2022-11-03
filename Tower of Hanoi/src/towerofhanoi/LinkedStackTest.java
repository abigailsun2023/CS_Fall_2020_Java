package towerofhanoi;

import java.util.EmptyStackException;
import student.TestCase;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Abigail Sun (asun14)

/**
 * This LinkedStack class tests all the methods in the LinkedStack class
 * 
 * @author Abigail Sun (asun14)
 * @version 2020.10.19
 *
 */
public class LinkedStackTest extends TestCase {

    private LinkedStack<String> stacky;
    private LinkedStack<String> stacky2;

    /**
     * Sets up the test cases
     */
    public void setUp() {
        stacky = new LinkedStack<String>();
        stacky2 = new LinkedStack<String>();
        stacky2.push("1");
    }


    /**
     * Tests the size method by asserting the number
     * of items in the stack.
     */
    public void testSize() {
        assertEquals(0, stacky.size());
        assertEquals(1, stacky2.size());
    }


    /**
     * Tests the isEmpty method by asserting true for
     * a stack with no items inside and assert false for
     * a stack with items inside.
     */
    public void testIsEmpty() {
        assertTrue(stacky.isEmpty());
        assertFalse(stacky2.isEmpty());
    }


    /**
     * Tests the peek method by using try catch onto an
     * non-empty stack. This will assert false for the
     * EmptyStackException.
     */
    public void testPeekTryCatchFalse() {
        Exception thrown = null;
        try {
            // call your method here that will throw the exception
            stacky2.peek();
        }
        catch (Exception exception) {
            thrown = exception;
        }

        // checks whether an Exception was actually thrown
        assertNull(thrown);

        // checks whether the right type of Exception was thrown
        assertFalse(thrown instanceof EmptyStackException);
    }


    /**
     * Tests the peek method by using a try catch onto a null
     * stack. This will assert that it throws an
     * EmptyStackException.
     */
    public void testPeekTryCatchTrue() {
        Exception thrown = null;
        try {
            // call your method here that will throw the exception
            stacky.peek();
        }
        catch (Exception exception) {
            thrown = exception;
        }

        // checks whether an Exception was actually thrown
        assertNotNull(thrown);

        // checks whether the right type of Exception was thrown
        assertTrue(thrown instanceof EmptyStackException);
    }


    /**
     * Tests the push method by calling the method onto a stack
     * and asserting that the new item was pushed onto the stack.
     */
    public void testPush() {
        stacky2.push("2");
        assertEquals("2", stacky2.peek());
    }


    /**
     * Tests the exception for pop by calling pop
     * on an empty stack and using try catch.
     */
    public void testPopTryCatch() {
        Exception thrown = null;
        try {
            // call your method here that will throw the exception
            stacky.pop();
        }
        catch (Exception exception) {
            thrown = exception;
        }

        // checks whether an Exception was actually thrown
        assertNotNull(thrown);

        // checks whether the right type of Exception was thrown
        assertTrue(thrown instanceof EmptyStackException);
    }


    /**
     * Tests pop method by asserting the initial size of the
     * stack, and then asserts the new size after pop is called.
     */
    public void testPop() {
        assertEquals(1, stacky2.size());
        assertEquals("[1]", stacky2.toString());
        stacky2.pop();
        assertEquals(0, stacky2.size());
        System.out.println(stacky2.toString());
        assertEquals("[]", stacky2.toString());
    }


    /**
     * Tests the toString method by asserting the initial
     * string items in the stack, and then pushing more string items
     * and asserting the new string.
     */
    public void testToString() {
        stacky2.push("two");
        stacky2.push("three");
        
        System.out.println(stacky2.toString());
        assertEquals("[three, two, 1]", stacky2.toString());
    }


    /**
     * This tests the clear method by asserting that there
     * is an item in the stack, and then asserts that there's
     * nothing after the clear method is called.
     */
    public void testClear() {
        assertEquals(1, stacky2.size());
        stacky2.clear();
        assertEquals(0, stacky2.size());
    }

}
