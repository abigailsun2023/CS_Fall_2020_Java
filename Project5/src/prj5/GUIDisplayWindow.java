// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Abigail Sun (asun14)
/**
 * This GUIDisplayWindow displays all the data as graphs to the user in the
 * window.
 *
 * @author Abigail Sun (asun14)
 * @version 2020.12.04
 * 
 */
package prj5;

import java.awt.Color;
import java.util.HashMap;
import cs2.Button;
import cs2.Shape;
import cs2.SquareShape;
import cs2.TextShape;
import cs2.Window;
import cs2.WindowSide;
/**
 * @author Abigail Sun (asun14)
 * @version 2020.12.04
 *
 */
public class GUIDisplayWindow {
    private Window window;
    private Button sortAlpha;
    private Button sortCFR;
    private Button quit;
    private Button DCRep;
    private Button GARep;
    private Button MDRep;
    private Button NCRep;
    private Button TNRep;
    private Button VARep;
    private HashMap<String, SLList<CFRDataPoint>> cfrData;
    private static Color[] BAR_COLORS = new Color[7];
    private String currentStateDisplayed;
    private int buttonstate = -1;

    /**
     * The constructor for the GUIDisplayWindow
     * 
     * @param data
     *            The data we made in the HashMap in the CovidDataReader
     */
    public GUIDisplayWindow(HashMap<String, SLList<CFRDataPoint>> data) {
        cfrData = data;
        window = new Window();
        window.setTitle("COVID Graphing Across States");

        // Initialize buttons
        sortAlpha = new Button("Sort by Alpha");
        sortAlpha.onClick(this, "clickedAlpha");

        quit = new Button("Quit");
        quit.onClick(this, "clickedQuit");

        sortCFR = new Button("Sort by CFR");
        sortCFR.onClick(this, "clickedCFR");

        DCRep = new Button("Represent DC");
        DCRep.onClick(this, "clickedDC");

        GARep = new Button("Represent GA");
        GARep.onClick(this, "clickedGA");

        MDRep = new Button("Represent MD");
        MDRep.onClick(this, "clickedMD");

        NCRep = new Button("Represent NC");
        NCRep.onClick(this, "clickedNC");

        TNRep = new Button("Represent TN");
        TNRep.onClick(this, "clickedTN");

        VARep = new Button("Represent VA");
        VARep.onClick(this, "clickedVA");

        window.addButton(sortAlpha, WindowSide.NORTH);
        window.addButton(quit, WindowSide.NORTH);
        window.addButton(sortCFR, WindowSide.NORTH);
        window.addButton(DCRep, WindowSide.SOUTH);
        window.addButton(GARep, WindowSide.SOUTH);
        window.addButton(MDRep, WindowSide.SOUTH);
        window.addButton(NCRep, WindowSide.SOUTH);
        window.addButton(TNRep, WindowSide.SOUTH);
        window.addButton(VARep, WindowSide.SOUTH);

        // Colors
        BAR_COLORS[0] = new Color(165, 209, 232);
        BAR_COLORS[1] = new Color(173, 147, 189);
        BAR_COLORS[2] = new Color(102, 176, 174);
        BAR_COLORS[3] = new Color(112, 148, 180);
        BAR_COLORS[4] = new Color(127, 96, 147);
    }


    /**
     * Helps display the bars and text on the window by accessing the data.
     * This method creates the bars and text that appear on screen, and makes it
     * so that they're both updated depending on which stateRep button is
     * pressed.
     * 
     * @param state
     *            The state that is being represented
     */
    public void displayData(String state) {
        currentStateDisplayed = state;
        SLList<CFRDataPoint> stateRep = cfrData.get(state);

        // String -> Data point
        // Another string - > another data point

        // Make bars
        int barX = 50;
        int barY = 80;
        int barWidth = 10;
        int barHeight = 20;
        int barGap = 150;
        
        
        
        Shape raceBar1 = new Shape(barX, barY, barWidth, (int)(barHeight * Math
            .round(stateRep.get(0).getValue() * 100.0) / 100.0), Color.BLUE);
        Shape raceBar2 = new Shape(barX + barGap, barY, barWidth,
            (int)(barHeight * Math.round(stateRep.get(1).getValue() * 100.0)
                / 100.0), Color.BLUE);
        Shape raceBar3 = new Shape(barX + (barGap * 3), barY, barWidth,
            (int)(barHeight * Math.round(stateRep.get(3).getValue() * 100.0)
                / 100.0), Color.BLUE);
        Shape raceBar4 = new Shape(barX + (barGap * 2), barY, barWidth,
            (int)(barHeight * Math.round(stateRep.get(2).getValue() * 100.0)
                / 100.0), Color.BLUE);
        Shape raceBar5 = new Shape(barX + (barGap * 4), barY, barWidth,
            (int)(barHeight * Math.round(stateRep.get(4).getValue() * 100.0)
                / 100.0), Color.BLUE);

        
        
        window.addShape(raceBar1);
        window.addShape(raceBar2);
        window.addShape(raceBar3);
        window.addShape(raceBar4);
        window.addShape(raceBar5);

        // Give text above the bars
        TextShape textBar1 = new TextShape(barX - 40, 250, stateRep.get(0)
            .getRace() + ": " + Math.round(stateRep.get(0).getValue() * 100.0)
                / 100.0 + "%");
        TextShape textBar2 = new TextShape(barX + barGap - 40, 250,
            stateRep.get(1).getRace() + ": " + Math.round(stateRep.get(1)
                .getValue() * 100.0) / 100.0 + "%");
        TextShape textBar3 = new TextShape(barX + (barGap * 2) - 40, 250,
            stateRep.get(2).getRace() + ": " + Math.round(stateRep.get(2)
                .getValue() * 100.0) / 100.0 + "%");
        TextShape textBar4 = new TextShape(barX + (barGap * 3) - 40, 250,
            stateRep.get(3).getRace() + ": " + Math.round(stateRep.get(3)
                .getValue() * 100.0) / 100.0 + "%");
        TextShape textBar5 = new TextShape(barX + (barGap * 4) - 40, 250,
            stateRep.get(4).getRace() + ": " + Math.round(stateRep.get(4)
                .getValue() * 100.0) / 100.0 + "%");

        
        
        window.addShape(textBar1);
        window.addShape(textBar2);
        window.addShape(textBar3);
        window.addShape(textBar4);
        window.addShape(textBar5);

    }


    /**
     * When the sortAlpha button is clicked, then the order of the bars will be
     * updated alphabetically.
     * 
     * @param button
     *            The alpha button. Will rearrange the bars alphabetically
     */
    public void clickedAlpha(Button button) {
        this.reset();
        CFRComparatorAlpha alpha = new CFRComparatorAlpha();
        if (currentStateDisplayed != null) {
            cfrData.get(currentStateDisplayed).sort(alpha);
            this.displayData(currentStateDisplayed);
        }
        
        if(buttonstate == 0) {
            TextShape DCHeader = new TextShape(0, 0, "");
            DCHeader.setText("DC Case Fatality Ratios By Race");
            DCHeader.setX((window.getGraphPanelWidth() / 2) - (DCHeader
                .getWidth() / 2));
            DCHeader.setY(20);
            window.addShape(DCHeader);
        }
        else if(buttonstate == 1) {
            TextShape GAHeader = new TextShape(0, 0, "");
            GAHeader.setText("GA Case Fatality Ratios By Race");
            GAHeader.setX((window.getGraphPanelWidth() / 2) - (GAHeader
                .getWidth() / 2));
            GAHeader.setY(20);
            window.addShape(GAHeader);
        }
        else if(buttonstate == 2) {
            TextShape MDHeader = new TextShape(0, 0, "");
            MDHeader.setText("MD Case Fatality Ratios By Race");
            MDHeader.setX((window.getGraphPanelWidth() / 2) - (MDHeader
                .getWidth() / 2));
            MDHeader.setY(20);
            window.addShape(MDHeader);
        }
        else if(buttonstate == 3) {
            TextShape NCHeader = new TextShape(0, 0, "");
            NCHeader.setText("NC Case Fatality Ratios By Race");
            NCHeader.setX((window.getGraphPanelWidth() / 2) - (NCHeader
                .getWidth() / 2));
            NCHeader.setY(20);
            window.addShape(NCHeader);
        }
        else if(buttonstate == 4) {
            TextShape TNHeader = new TextShape(0, 0, "");
            TNHeader.setText("TN Case Fatality Ratios By Race");
            TNHeader.setX((window.getGraphPanelWidth() / 2) - (TNHeader
                .getWidth() / 2));
            TNHeader.setY(20);
            window.addShape(TNHeader);
        }
        else if(buttonstate == 5) {
            TextShape VAHeader = new TextShape(0, 0, "");
            VAHeader.setText("VA Case Fatality Ratios By Race");
            VAHeader.setX((window.getGraphPanelWidth() / 2) - (VAHeader
                .getWidth() / 2));
            VAHeader.setY(20);
            window.addShape(VAHeader);
        }
    }


    /**
     * The quit button for the GUI
     * 
     * @param button
     *            The quit button. Exits the window when pressed.
     */
    public void clickedQuit(Button button) {
        System.exit(0);

    }


    /**
     * When the sortCFR button is clicked, then the order of the bars will be
     * updated by CFR.
     * 
     * @param button
     *            The CFR order button. Will rearrange the bars and labels
     */
    public void clickedCFR(Button button) {
        this.reset();
        CFRComparatorNum CFR = new CFRComparatorNum();
        if (currentStateDisplayed != null) {
            cfrData.get(currentStateDisplayed).sort(CFR);
            this.displayData(currentStateDisplayed);
        }
        

        if(buttonstate == 0) {
            TextShape DCHeader = new TextShape(0, 0, "");
            DCHeader.setText("DC Case Fatality Ratios By Race");
            DCHeader.setX((window.getGraphPanelWidth() / 2) - (DCHeader
                .getWidth() / 2));
            DCHeader.setY(20);
            window.addShape(DCHeader);
        }
        else if(buttonstate == 1) {
            TextShape GAHeader = new TextShape(0, 0, "");
            GAHeader.setText("GA Case Fatality Ratios By Race");
            GAHeader.setX((window.getGraphPanelWidth() / 2) - (GAHeader
                .getWidth() / 2));
            GAHeader.setY(20);
            window.addShape(GAHeader);
        }
        else if(buttonstate == 2) {
            TextShape MDHeader = new TextShape(0, 0, "");
            MDHeader.setText("MD Case Fatality Ratios By Race");
            MDHeader.setX((window.getGraphPanelWidth() / 2) - (MDHeader
                .getWidth() / 2));
            MDHeader.setY(20);
            window.addShape(MDHeader);
        }
        else if(buttonstate == 3) {
            TextShape NCHeader = new TextShape(0, 0, "");
            NCHeader.setText("NC Case Fatality Ratios By Race");
            NCHeader.setX((window.getGraphPanelWidth() / 2) - (NCHeader
                .getWidth() / 2));
            NCHeader.setY(20);
            window.addShape(NCHeader);
        }
        else if(buttonstate == 4) {
            TextShape TNHeader = new TextShape(0, 0, "");
            TNHeader.setText("TN Case Fatality Ratios By Race");
            TNHeader.setX((window.getGraphPanelWidth() / 2) - (TNHeader
                .getWidth() / 2));
            TNHeader.setY(20);
            window.addShape(TNHeader);
        }
        else if(buttonstate == 5) {
            TextShape VAHeader = new TextShape(0, 0, "");
            VAHeader.setText("VA Case Fatality Ratios By Race");
            VAHeader.setX((window.getGraphPanelWidth() / 2) - (VAHeader
                .getWidth() / 2));
            VAHeader.setY(20);
            window.addShape(VAHeader);
        }

    }


    /**
     * When the DCRep button is clicked, it will update the data for the CFR in
     * DC
     * 
     * @param button
     *            The state button that's being pressed
     */
    public void clickedDC(Button button) {
        buttonstate = 0;
        this.reset();
        this.displayData("DC");
        
        TextShape DCHeader = new TextShape(0, 0, "");
        DCHeader.setText("DC Case Fatality Ratios By Race");
        DCHeader.setX((window.getGraphPanelWidth() / 2) - (DCHeader
            .getWidth() / 2));
        DCHeader.setY(20);
        window.addShape(DCHeader);
    }


    /**
     * When the GARep button is clicked, it will update the data for the CFR in
     * GA
     * 
     * @param button
     *            The state button that's being pressed
     */
    public void clickedGA(Button button) {
        buttonstate = 1;
        this.reset();
        this.displayData("GA");
        
        TextShape GAHeader = new TextShape(0, 0, "");
        GAHeader.setText("GA Case Fatality Ratios By Race");
        GAHeader.setX((window.getGraphPanelWidth() / 2) - (GAHeader
            .getWidth() / 2));
        GAHeader.setY(20);
        window.addShape(GAHeader);
    }


    /**
     * When the MDRep button is clicked, it will update the data for the CFR in
     * MD
     * 
     * @param button
     *            The state button that's being pressed
     */
    public void clickedMD(Button button) {
        buttonstate = 2;
        this.reset();
        this.displayData("MD");
        
        TextShape MDHeader = new TextShape(0, 0, "");
        MDHeader.setText("MD Case Fatality Ratios By Race");
        MDHeader.setX((window.getGraphPanelWidth() / 2) - (MDHeader
            .getWidth() / 2));
        MDHeader.setY(20);
        window.addShape(MDHeader);
    }


    /**
     * When the NCRep button is clicked, it will update the data for the CFR in
     * NC
     * 
     * @param button
     *            The state button that's being pressed
     */
    public void clickedNC(Button button) {
        buttonstate = 3;
        this.reset();
        this.displayData("NC");
        
        TextShape NCHeader = new TextShape(0, 0, "");
        NCHeader.setText("NC Case Fatality Ratios By Race");
        NCHeader.setX((window.getGraphPanelWidth() / 2) - (NCHeader
            .getWidth() / 2));
        NCHeader.setY(20);
        window.addShape(NCHeader);
    }


    /**
     * When the TNRep button is clicked, it will update the data for the CFR in
     * TN
     * 
     * @param button
     *            The state button that's being pressed
     */
    public void clickedTN(Button button) {
        buttonstate = 4;
        this.reset();
        this.displayData("DC");
        
        TextShape TNHeader = new TextShape(0, 0, "");
        TNHeader.setText("TN Case Fatality Ratios By Race");
        TNHeader.setX((window.getGraphPanelWidth() / 2) - (TNHeader
            .getWidth() / 2));
        TNHeader.setY(20);
        window.addShape(TNHeader);
    }


    /**
     * When the VARep button is clicked, it will update the data for the CFR in
     * VA
     * 
     * @param button
     *            The state button that's being pressed
     */
    public void clickedVA(Button button) {
        buttonstate = 5;
        this.reset();
        this.displayData("VA");
        
        TextShape VAHeader = new TextShape(0, 0, "");
        VAHeader.setText("VA Case Fatality Ratios By Race");
        VAHeader.setX((window.getGraphPanelWidth() / 2) - (VAHeader
            .getWidth() / 2));
        VAHeader.setY(20);
        window.addShape(VAHeader);

    }


    /**
     * Clears the window so that the new data can be shown which each button
     * click.
     */
    public void reset() {
        window.removeAllShapes();
    }

}
