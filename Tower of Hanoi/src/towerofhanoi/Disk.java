/**
 * 
 */
package towerofhanoi;

import cs2.Shape;
import java.util.Random;
import java.awt.Color;
// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Abigail Sun (asun14)

/**
 * This Disk class implements methods used for the disks
 * in the program.
 * 
 * @author Abigail Sun (asun14)
 * @version 2020.10.19
 *
 */
public class Disk extends Shape implements Comparable<Disk> {

    /**
     * Sets up the constructor by calling super and using
     * random to set the color.
     * 
     * @param width
     *            The width of the disk
     */
    public Disk(int width) {
        super(0, 0, width, PuzzleWindow.DISK_HEIGHT);
        Random rand = new Random();
        Color color = new Color(rand.nextInt(256), rand.nextInt(256), rand
            .nextInt(256));
        this.setBackgroundColor(color);
    }


    /**
     * This method determines and compares the size of a disk to other disks.
     * 
     * If otherDisk is null, throw an IllegalArgumentException.
     * Otherwise, compare widths and return a negative number if this Disk is
     * smaller than the disk parameter, a positive number for the opposite, and
     * a zero if their widths are equal.
     * 
     * @param otherDisk
     *            The disk being compared
     * @return The difference between the widths of the two disks
     */
    public int compareTo(Disk otherDisk) {
        if (otherDisk == null) {
            throw new IllegalArgumentException();
        }
        //return this.getWidth() - otherDisk.getWidth();
        if (this.getWidth() < otherDisk.getWidth()) {
            return -1;
        }
        if (this.getWidth() > otherDisk.getWidth()) {
            return 1;
        }
        else {
            return 0;
        }
    }


    /**
     * @return Returns the width of this Disk as a string by using
     *         Integer.toString()
     */
    public String toString() {
        return Integer.toString(this.getWidth());
    }


    /**
     * This method confirms that two disks are equal if they're
     * the same width.
     * 
     * @param other
     *            The object that is being compared to this
     * @return The width of the disks are equal
     */
    public boolean equals(Object other) {

        if (other == null) {
            return false;
        }
        if (this == other) {
            return true;
        }
        if (other.getClass() == this.getClass()) {
            Disk temp = (Disk)other;
            //if (this.compareTo(temp) == 0) {
                //return true;
            //}
            return temp.getWidth() == this.getWidth();
        }
        return false;
    }

}
