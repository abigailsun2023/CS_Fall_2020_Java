/**
 * 
 */
package game;

import bag.SimpleBagInterface;
import student.TestableRandom;
//Virginia Tech Honor Code Pledge:
//
//As a Hokie, I will conduct myself with honor and integrity at all times.
//I will not lie, cheat, or steal, nor will I accept the actions of those 
//who do.
//-- Abigail Sun (asun14)
/**
 * This SimpleArrayBag class contains methods that implements
 * methods from SimpleBagInterface.
 * 
 * @author Abigail Sun (asun14)
 * @version 2020.10.05
 *
 * @param <T> The type for SimpleArrayBag
 */
public class SimpleArrayBag<T> implements SimpleBagInterface<T> {

    private T[] bag;
    final static private int MAX = 25;
    private int numberOfEntries;
    
    
    /**
     * Sets up the constructor by initializing the bag field to a new
     * array of T objects of size MAX. as well as setting numberOfEntries
     * to 0.
     */
    @SuppressWarnings("unchecked")
    public SimpleArrayBag() {
        T[] tempbag = (T[]) new Object[MAX];
        bag = tempbag;
        numberOfEntries = 0;
    }
    

    /**
     * Gets the current size of the bag by returning the number
     * of entries.
     * 
     * @return The numberOfEntries in a bag
     */
    @Override
    public int getCurrentSize() {
        return numberOfEntries;
    }


    /**
     * This method is called when the bag is empty/null
     * 
     * @return Returns numberOfEntries as 0 when the bag is empty.
     */
    @Override
    public boolean isEmpty() {
        return numberOfEntries == 0;
    }
    
    
    /**
     * Checks if the numberOfEntries is less than 25.
     * If it is less, then anEntry is placed in the index 
     * given by numberOfEntries and returns true
     * 
     * Returns false if it is more than or equal to 25, or if
     * anEntry is null.
     * 
     * @param anEntry The item/shape added to the bag
     * @return True when an item is added to the bag
     */
    @Override
    public boolean add(T anEntry) {
        if (numberOfEntries >= MAX) {
            return false;
        }
        
        if (anEntry == null) {
            return false;  
        }
        
        bag[numberOfEntries] = anEntry;
        numberOfEntries++;
        
        return true;
    }

    /**
     * Uses the TestableRandom class to generate random numbers with
     * numberOfEntries as the bounds.
     * 
     * If isEmpty returns true then it returns null.
     * 
     * If it isn't empty, then it will generate a random number from
     * the numberOfEntries and will return the entry at that index in 
     * the bag.
     * 
     */
    @Override
    public T pick() {
        if (isEmpty()) {
            return null;
        }
        else {
            TestableRandom generator = new TestableRandom(); 
            int index = generator.nextInt(numberOfEntries);
            return bag[index];
        }
    }
    
    
    /**
     * A private method that is a helper method for remove().
     * This checks if the entry matches anEntry using the equals()
     * method.
     * 
     * If it's equal, then return the index in which it was found.
     * If not, then return -1. 
     * 
     * @param anEntry The item/shape added to the bag
     */
    private int getIndexOf(T anEntry)
    {
        for (int i = 0; i < numberOfEntries; i++) {
            if (bag[i].equals(anEntry)) { 
                return i;
            }
        }
        return -1;
    }


    /**
     * Calls getIndexOf() to check if ArrayBag contains the entry to remove.
     * If getIndexOf() returns -1, then remove() returns false.
     * If getIndexOf() returns i, then the first occurrence of anEntry will
     * be removed from the bag.
     * 
     * @param anEntry The item/shape added to the bag
     * @return Returns true if item is removed
     */
    @Override
    public boolean remove(T anEntry) {
        int index = getIndexOf(anEntry);
        if (index == -1) { 
            return false;
        }
        for (int i = index; i < numberOfEntries - 1; i++)
        {
            bag[i] = bag[i + 1];
        }
        bag[numberOfEntries - 1] = null;
        numberOfEntries--;
        return true;
    }

}
