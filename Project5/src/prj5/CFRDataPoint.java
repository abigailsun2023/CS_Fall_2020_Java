// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I 
// accept the actions of those who do.
// -- Mithran Mohanraj (mithran)
package prj5;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * This class is a single data point for CFR
 *
 * @author Mithran Mohanraj (mithran)
 * @version 11.21.2020
 */
public class CFRDataPoint {
    private double value;
    private String race;
    private int cases;

    /**
     * Constructor
     * 
     * @param cases
     *            the amount of cases
     * @param value
     *            CFR value
     * @param race
     *            the race it is associated with
     */
    public CFRDataPoint(int cases, double value, String race) {
        this.cases = cases;
        this.value = value;
        this.race = race;
    }


    /**
     * Getter for race
     * 
     * @return race field
     */
    public String getRace() {
        return race;
    }


    /**
     * Getter for cases
     * 
     * @return cases field
     */
    public int getCase() {
        return cases;
    }


    /**
     * Getter for value
     * 
     * @return value field
     */
    public double getValue() {
        return value;
    }


    /**
     * to string method
     * 
     * @return race: # cases, #% CFR as string
     */
    public String toString() {
        return race + ": " + cases + " cases, " + round(value) + "% CFR";
    }


    /**
     * Formats the percentage value
     * 
     * @param value
     *            always value
     * @return formatted as a percentage string
     */
    private static String round(double value) {
        double num = round(value, 1);
        return fmt(num);
    }


    /**
     * This rounds a double
     */
    private static double round(double value, int places) {
        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }


    /**
     * This gets rid of trailing zero
     * 
     * @param d
     *            double to clean
     * @return cleaned double
     */
    private static String fmt(double d) {
        if (d == (long)d) {
            return String.format("%d", (long)d);
        }
        else {
            return String.format("%s", d);
        }
    }
}
