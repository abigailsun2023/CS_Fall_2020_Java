package prj5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
import bsh.ParseException;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I
// accept the actions of those who do.
// -- Mithran Mohanraj (mithran)

/**
 * @author Abigail Sun (asun14)
 * @version 2020.11.21 (I worked on the calcCFR and constructor before I shared
 *          this class code with my group)
 * 
 * @author Mithran Mohanraj (mithran)
 * @version 2020.11.21
 * 
 */
public class CovidDataReader {
    private HashMap<String, SLList<CFRDataPoint>> cfrData;

    /**
     * Constructor for the CovidDataReader class
     * 
     * @param reader
     * @throws FileNotFoundException
     * @throws ParseException
     */
    public CovidDataReader(String fileName)
        throws ParseException,
        FileNotFoundException {
        cfrData = readCovidData(fileName);
        new Output(cfrData);
        new GUIDisplayWindow(cfrData);
    }


    public HashMap<String, SLList<CFRDataPoint>> readCovidData(String fileName)
        throws ParseException,
        FileNotFoundException {

        HashMap<String, SLList<CFRDataPoint>> dict =
            new HashMap<String, SLList<CFRDataPoint>>();
        Scanner scanner = new Scanner(new File(fileName));
        scanner.nextLine();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] split = line.split(", *", -1);

            if (split.length != 11) {
                throw new ParseException("Not enough columns in this file");
            }
            SLList<CFRDataPoint> stateList = new SLList<CFRDataPoint>();
            stateList.add(new CFRDataPoint(parseIntFormat(split[1]), calcCFR(
                split[1], split[6]), "white"));
            stateList.add(new CFRDataPoint(parseIntFormat(split[2]), calcCFR(
                split[2], split[7]), "black"));
            stateList.add(new CFRDataPoint(parseIntFormat(split[3]), calcCFR(
                split[3], split[8]), "latinx"));
            stateList.add(new CFRDataPoint(parseIntFormat(split[4]), calcCFR(
                split[4], split[9]), "asian"));
            stateList.add(new CFRDataPoint(parseIntFormat(split[5]), calcCFR(
                split[5], split[10]), "other"));
            dict.put(split[0], stateList);
        }
        scanner.close();
        return dict;
    }


    /**
     * This method calculates the Case Fatality Ratio from string data
     * 
     * @param cases
     *            Number of people with COVID
     * @param deaths
     *            Number of deaths
     * @return The Case Fatality Ratio (percentage of people who died from
     *         COVID). If NA then returns -1.
     */
    private double calcCFR(String cases, String deaths) {
        try {
            double numCases = Integer.parseInt(cases);
            double numDeaths = Integer.parseInt(deaths);
            return (numDeaths / numCases) * 100;
        }
        catch (NumberFormatException e) {
            return -1;
        }
    }


    private int parseIntFormat(String num) {
        try {
            return Integer.parseInt(num);
        }
        catch (NumberFormatException e) {
            return -1;
        }
    }

}
