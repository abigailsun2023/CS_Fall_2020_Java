package game;
//Virginia Tech Honor Code Pledge:
//
//As a Hokie, I will conduct myself with honor and integrity at all times.
//I will not lie, cheat, or steal, nor will I accept the actions of those who do.
//-- Abigail Sun (asun14)
/**
 * The ProjectRunner class has one main() method which will help run
 * the code in the rest of the program.
 * 
 * @author Abigail Sun (asun14)
 * @version 2020.10.03
 *
 */
public class ProjectRunner {
    
    /**
     * The constructor for ProjectRunner is left empty on purpose 
     */
    public ProjectRunner() {
        //null
    }
    
    
    /**
     * main() method helps run the code in the program
     * 
     * @param args The string array for the bag
     */
    public static void main(String[] args) {
        
        if (args.length == 0) {
            new WhackAShape();
        }
        else {
            new WhackAShape(args);
        }
    }

}
