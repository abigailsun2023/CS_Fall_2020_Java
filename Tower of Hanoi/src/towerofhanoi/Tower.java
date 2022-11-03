package towerofhanoi;
// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Abigail Sun (asun14)

/**
 * This Tower class initializes the methods needed for towers
 * in this program.
 * 
 * @author Abigail Sun (asun14)
 * @version 2020.10.20
 *
 */
public class Tower extends LinkedStack<Disk> {
    private Position position;

    /**
     * This sets up the constructor by calling super to create
     * a stack and then storing the position in a field.
     * 
     * @param position
     *            The position of the tower
     * 
     */
    public Tower(Position position) {
        super();
        this.position = position;
    }


    /**
     * Serves as a getter method by returning position
     * 
     * @return The position
     */
    public Position position() {
        return position;
    }


    /**
     * This method overrides the push() method in the LinkedStack class.
     * Checks if it's a valid push (only if the tower is already empty
     * or the top disk is larger than the disk being pushed).
     */
    @Override
    public void push(Disk disk) {
        System.out.println("Performing Tower Push Operation...");

        if (disk == null) {
            throw new IllegalArgumentException();
        }
        else if ((isEmpty()) || (disk.compareTo(this.peek()) ==  -1)) {
            super.push(disk);
        }
        else {
            throw new IllegalStateException();
        }

    }

}
