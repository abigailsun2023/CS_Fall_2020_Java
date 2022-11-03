/**
 * 
 */
package prj5;

import java.io.FileNotFoundException;
import bsh.ParseException;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Abigail Sun (asun14)
/**
 * This ProjectRunner class helps run the program.
 * 
 * @author Abigail Sun (asun14)
 * @version 2020.12.04
 *
 */
public class ProjectRunner {
    /**
     * This main method helps run the program
     * 
     * @param args
     *            Arguments passed through the ProjectRunner
     * @throws ParseException
     * @throws FileNotFoundException
     */
    public static void main(String args[])
        throws ParseException,
        FileNotFoundException {
        if (args.length >= 1) {
            new CovidDataReader(args[0]);
        }
        new CovidDataReader("Cases_and_Deaths_by_race_CRDT_Sep2020.csv");
    }

}
