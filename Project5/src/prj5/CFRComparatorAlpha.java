// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I 
// accept the actions of those who do.
// -- Mithran Mohanraj (mithran)
package prj5;

import java.util.Comparator;

/**
 * This class compares two CFR data points by race name
 * 
 * @author Mithran Mohanraj (mithran)
 * @version 11.21.2020
 */
public class CFRComparatorAlpha implements Comparator<CFRDataPoint> {

    /**
     * @param o1
     *            The first data point
     * @param o2
     *            The second data point
     * 
     * @return negative if o1 comes before o2 in the alphabet,
     *         0 if they are completely the same (unlikely) and
     *         positive if o1 is after o2 in the alphabet
     *
     */
    @Override
    public int compare(CFRDataPoint o1, CFRDataPoint o2) {
        return o1.getRace().compareToIgnoreCase(o2.getRace());
    }

}
