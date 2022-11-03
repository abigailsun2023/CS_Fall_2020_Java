// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I 
// accept the actions of those who do.
// -- Mithran Mohanraj (mithran)

package prj5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * This class just uses println() to output the data given by CovidDataReader
 * @author Mithran Mohanraj (mithran)
 * @version 11.21.2020
 */
@SuppressWarnings("unchecked")
public class Output {
    
    /**
     * Constructor
     * 
     * @param cfrData Hashmap of cfr data with its corresponding state as key
     */
    public Output(HashMap<String, SLList<CFRDataPoint>> cfrData) {
        
        //Sorts the keyList and then prints
        ArrayList<String> keyList = new ArrayList<String>(cfrData.keySet());
        Collections.sort(keyList, Collections.reverseOrder());
        for (int i = keyList.size() - 1; i >= 0; i--) {
            String key = keyList.get(i);
            System.out.println(key);
            SLList<CFRDataPoint> list = cfrData.get(key);
            list.sort(new CFRComparatorAlpha());
            for (CFRDataPoint x : list) {
                System.out.println(x);
            }
            System.out.println("=====");
            list.sort(new CFRComparatorNum());
            for (CFRDataPoint x : list) {
                System.out.println(x);
            }
            System.out.println("=====");
        }
    }
    
    
}
