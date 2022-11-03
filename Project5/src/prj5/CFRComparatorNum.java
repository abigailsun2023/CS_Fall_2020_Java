// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I 
// accept the actions of those who do.
// -- Mithran Mohanraj (mithran)
package prj5;

import java.util.Comparator;

/**
 * This class compares two CFR data points by value
 * 
 * @author Mithran Mohanraj (mithran)
 * @version 11.21.2020
 */
public class CFRComparatorNum implements Comparator<CFRDataPoint> {

    /**
     * @param o1
     *            The first data point
     * @param o2
     *            The second data point
     * 
     * @return Value of o1 - o2 times 1000, unless there is a tie
     *         then alpha comparator will be used
     */
    @Override
    public int compare(CFRDataPoint o1, CFRDataPoint o2) {
        int num = (int)((o2.getValue() - o1.getValue()) * 1000);
        if (num == 0) {
            CFRComparatorAlpha alpha = new CFRComparatorAlpha();
            return alpha.compare(o1, o2);
        }
        return num;
    }

}
