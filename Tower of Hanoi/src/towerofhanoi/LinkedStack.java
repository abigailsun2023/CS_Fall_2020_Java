/**
 * 
 */
package towerofhanoi;
// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Abigail Sun (asun14)

import java.util.EmptyStackException;
import stack.StackInterface;

/**
 * This LinkedStack class initializes all the methods needed
 * for stacks in this program.
 * 
 * @author Abigail Sun (asun14)
 * @version 2020.10.19
 * 
 * @param <T>
 *            The type of LinkedStack
 *
 */
public class LinkedStack<T> implements StackInterface<T> {

    private Node<T> topNode;
    private int size;

    /**
     * 
     */
    public LinkedStack() {
        topNode = null;
        size = 0;
    }


    /**
     * Serves as a getter method by returning size
     * 
     * @return The size in a stack
     */
    public int size() {
        return size;

    }


    /**
     * Checks if the stack is empty
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }


    /**
     * This method will show what item is at the top of the stack
     */
    @Override
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        return topNode.getData();

    }


    /**
     * This method will push the newEntry to the top of the stack
     */
    @Override
    public void push(T anEntry) {
        Node<T> newNode = new Node<T>(anEntry);
        newNode.setData(anEntry);
        newNode.setNextNode(topNode);
        topNode = newNode;

        size++;
    }


    /**
     * This method will throw an EmptyStackException when the stack
     * is empty.
     * Otherwise, take away the Node from the top of the stack and
     * return it's value.
     */
    @Override
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        Node<T> temp = topNode;
        this.topNode = temp.getNextNode();
        size--;

        return temp.getData();
    }


    /**
     * This method turns the node values into a string ("[1]')
     * If it's empty, then the string will just return as an empty
     * bracket ("[]").
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        

        s.append("[");
        Node<T> temp = this.topNode;
        boolean firsty = true;
        for (int i = 0; i < size; i++) {
            if (!firsty) {
                s.append(", ");
            }
            else {
                firsty = false;
            }
            s.append(String.valueOf(temp.getData()));
            temp = temp.getNextNode();
        }
        s.append("]");
        return s.toString();
    }


    /**
     * This method clears the stack by returning null for topNode
     * and 0 for size.
     */
    @Override
    public void clear() {
        this.topNode = null;
        this.size = 0;
    }

    private class Node<T> {

        private Node<T> next;
        private T data;

        /**
         * The constructor for the private class.
         * Sets next equal to null.
         */
        private Node(T entry) {
            this(entry, null);
        }


        /**
         * The second constructor for the private class.
         * Takes in two parameters.
         */
        private Node(T entry, Node<T> nextNode) {
            data = entry;
            next = nextNode;

        }


        /**
         * 
         * @return The next node
         */
        private Node<T> getNextNode() {
            return next;
        }


        /**
         * 
         * @return The data in a stack
         */
        private T getData() {
            return data;
        }


        /**
         * 
         * @param newNext
         *            The next for the nodes
         */
        private void setNextNode(Node<T> newNext) {
            next = newNext;
        }


        /**
         * set data
         * 
         * @param newData
         */
        private void setData(T newData) {
            data = newData;
        }
    }

}
