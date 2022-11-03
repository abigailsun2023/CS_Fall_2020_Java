/**
 * 
 */
package towerofhanoi;
//Virginia Tech Honor Code Pledge:
//
//As a Hokie, I will conduct myself with honor and integrity at all times.
//I will not lie, cheat, or steal, nor will I accept the actions of those who do.
//-- Abigail Sun (asun14)

/**
 * This Project Runner class helps run the program
 * 
 * @author Abigail Sun (asun14)
 * @version 2020.10.20
 *
 */
public class ProjectRunner {
    
    /**
     * 
     * @param args
     */
    public static void main(String[] args) {
        int disks = 5;
        if (args.length == 1) {
            disks = Integer.parseInt(args[0]);
        }
        HanoiSolver solver = new HanoiSolver(disks);
        PuzzleWindow window = new PuzzleWindow(solver);
       
    }

}
