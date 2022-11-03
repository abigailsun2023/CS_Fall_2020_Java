// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I 
// accept the actions of those who do.
// -- Mithran Mohanraj (mithran)

package prj5;

import java.io.FileNotFoundException;
import bsh.ParseException;

/**
 * This runs the whole project
 *
 * @author Mithran Mohanraj (mithran)
 * @version 11.21.2020
 */
public class Input {
    /**
     * This calls CovidDataReader's constructor
     * 
     * @param args should contain filename to read or 
     * default will be used
     * @throws FileNotFoundException 
     * @throws ParseException 
     */
    public static void main(String args[]) {
        try {
            if (args.length == 1) {
                new CovidDataReader(args[0]);
            }
            else {
                new CovidDataReader("Cases_and_Deaths_by_race_CRDT_Sep2020.csv");
            }
        }
        catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
