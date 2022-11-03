/**
 * 
 */
package game;

import bag.Node;
import bag.SimpleBagInterface;
import student.TestableRandom;
//Virginia Tech Honor Code Pledge:
//
//As a Hokie, I will conduct myself with honor and integrity at all times.
//I will not lie, cheat, or steal, nor will I accept the actions of those 
//who do.
//-- Abigail Sun (asun14)
/**
 * This SimpleLinkedBag class contains methods that implements
 * methods from SimpleBagInterface.
 * 
 * @author Abigail Sun (asun14)
 * @version 2020.10.05
 * 
 * @param <T> The type for SImpleLinkedBag
 */
public class SimpleLinkedBag<T> implements SimpleBagInterface<T> {
    
    private Node<T> firstNode;
    private int numberOfEntries;

    
    /**
     * Initializes the instance variables by setting the firstNode
     * field equal to null and the numberOfEntries equal to 0.
     */
    public SimpleLinkedBag() {
        firstNode = null;
        numberOfEntries = 0;
    }
    
    
    /**
     * Creates a new Node with T anEntry as a parameter.
     * Prepends the node to the SimpleinkedBag by setting the new Node
     * next to be the firstNode and then setting the new Node to the 
     * firstNode field.
     * 
     * Then, increment the numberOfEntries by 1 and return true.
     * If anEntry is null, then add() should return false.
     * 
     * @return True after an object/shape is added.
     */
    @Override
    public boolean add(T anEntry) {
        if (anEntry == null) {
            return false;
        }
        Node<T> newNode = new Node<>(anEntry);
        newNode.setNext(firstNode);
        firstNode = newNode;
        numberOfEntries++;
        return true;
    }


    /**
     * Gets the current size or number of entries in a SimpleLinkedBag.
     */
    @Override
    public int getCurrentSize() {
        return numberOfEntries;
    }


    /**
     * This method is called when the numberOfEntries in a
     * bag is 0.
     * 
     * @return 0 for numberOfEntries when there's no item/shapes
     *         in the bag
     */
    @Override
    public boolean isEmpty() {
        return numberOfEntries == 0;
    }


    /**
     * This pick() method picks a random shape from the bag
     * by using TestableRandom.
     */
    @Override
    public T pick() {
        if (isEmpty()) {
            return null;
        }
        else {
            TestableRandom generator = new TestableRandom();
            int index = generator.nextInt(numberOfEntries);
            Node<T> tempNode = firstNode;
            for (int i = 0; i < index; i++) {
                tempNode = tempNode.getNext();
            }
            return tempNode.getData();
        }
    }
    
    
    /**
     * This remove() method will remove a specific item from the
     * bag.
     * Uses the getReferenceTo() method to find the specific object
     * in the bag.
     * 
     * @return True when an item is removed from the bag.
     */
    @Override
    public boolean remove(T anEntry) {
        if (getReferenceTo(anEntry) == null) {
            return false;
        }
        else {
            Node<T> node = getReferenceTo(anEntry);
            node.setData(firstNode.getData());
            firstNode = firstNode.getNext();
            numberOfEntries--;
        }
        return true;
    }
    
    

    /**
     * This method is used to find a specific item in the bag
     * Will be used in remove method
     * 
     * @param anEntry Entry for which we need to find the reference
     */
    private Node<T> getReferenceTo(T anEntry) {
        boolean found = false;
        Node<T> currentNode = firstNode;
        while (!found && currentNode != null) {
            if (anEntry.equals(currentNode.getData())) {
                found = true;
            }
            else {
                currentNode = currentNode.getNext();
            }
        }
        return currentNode;

    }
    
 
}
