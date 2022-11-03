// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I 
// accept the actions of those who do.
// -- Mithran Mohanraj (mithran)

package prj5;

import java.util.HashMap;

/**
 * This class tests output because it needs to be 
 * tested for some reason
 * @author Mithran Mohanraj
 * @version 11.21.2020
 */
public class OutputTest extends student.TestCase {
    /**
     * No setup
     */
    public void setUp() {
        //no
    }
    
    /**
     * Makes sure output can print
     */
    public void testOutput() {
        SLList<CFRDataPoint> no = new SLList<CFRDataPoint>();
        no.add(new CFRDataPoint(100, 2.0, "Hi"));
        HashMap<String, SLList<CFRDataPoint>> yes = 
            new HashMap<String, SLList<CFRDataPoint>>();
        yes.put("Bye", no);
        new Output(yes);
        assertEquals("Bye\r\n" + 
            "Hi: 100 cases, 2% CFR\r\n" + 
            "=====\r\n" + 
            "Hi: 100 cases, 2% CFR\r\n" + 
            "=====\r\n" + 
            "", systemOut().getHistory());
    }
}
