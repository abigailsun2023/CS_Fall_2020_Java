/**
 * 
 */
package towerofhanoi;

import java.util.Observable;
// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Abigail Sun (asun14)

/**
 * This HanoiSolver class implements the methods to solve
 * the Tower Of Hanoi puzzle.
 * 
 * @author Abigail Sun (asun14)
 * @version 2020.10.20
 *
 */
public class HanoiSolver extends Observable {
    private Tower left;
    private Tower middle;
    private Tower right;
    private int numDisks;

    /**
     * Sets up the constructor by initializing the left, middle, and
     * right fields with the corresponding enumeration values as parameters
     * 
     * @param disk
     *            The number of disks
     */
    public HanoiSolver(int disk) {
        this.numDisks = disk;
        left = new Tower(Position.LEFT);
        middle = new Tower(Position.MIDDLE);
        right = new Tower(Position.RIGHT);
        
    }


    /**
     * This method serves as a getter method
     * 
     * @return numDisks in a stack
     */
    public int disks() {
        return numDisks;
    }


    /**
     * This method returns the position of the tower by using the switch
     * statement.
     * 
     * @param pos
     *            The position of the tower
     * @return The position of the tower
     * 
     */
    public Tower getTower(Position pos) {
        switch (pos) {
            case LEFT:
                return left;
            case MIDDLE:
                return middle;
            case RIGHT:
                return right;
            default:
                return middle;
        }

    }


    /**
     * This method returns left, middle, and right as strings
     * using a string builder.
     * 
     * @return The string of the disks in the stack
     */
    public String toString() {
        return left.toString() + middle.toString() + right.toString();
    }


    /**
     * This method executes the specified move
     * 
     * @param source
     *            The initial position of the disks
     * @param destination
     *            The final position of the disks
     */
    private void move(Tower source, Tower destination) {
        System.out.println("Moving from" + source + destination.position());
        Disk disk = source.pop();
        destination.push(disk);

        setChanged();
        notifyObservers(destination.position());
    }


    /**
     * This method will be used by the solve method to "solve" the towers.
     * It does this by starting with the base case where there is only one disk
     * left to move. 
     * Otherwise, it recursively solves smaller sub-problems by
     * calling solveTowers() with slightly different parameters, invoking the
     * move() method when it is necessary for a disk to be moved.
     */
    private void solveTowers(
        int currentDisks,
        Tower startPole,
        Tower tempPole,
        Tower endPole) {

        if (currentDisks == 1) {
            move(startPole, endPole);
        }
        else if (currentDisks > 1) {
            solveTowers(currentDisks - 1, startPole, endPole, tempPole);
            solveTowers(1, startPole, tempPole, endPole);
            solveTowers(currentDisks - 1, tempPole, startPole, endPole);
        }

    }


    /**
     * This method uses the private solveTowers method to "solve" the
     * puzzle.
     */
    public void solve() {
        solveTowers(numDisks, right, middle, left);
    }

}
