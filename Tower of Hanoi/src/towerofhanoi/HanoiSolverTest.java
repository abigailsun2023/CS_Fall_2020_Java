package towerofhanoi;

import student.TestCase;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Abigail Sun (asun14)

/**
 * This HanoiSolverTest class tests all the methods in the HanoiSolver class
 * 
 * @author Abigail Sun (asun14)
 * @version 2020.10.19
 *
 */
public class HanoiSolverTest extends TestCase {

    private HanoiSolver solver;
    private HanoiSolver solver2;

    /**
     * Sets up the test cases
     */
    public void setUp() {
        solver = new HanoiSolver(1);
        solver2 = new HanoiSolver(5);

    }


    /**
     * Tests the disks method by asserting that there are
     * 5 disks.
     */
    public void testDisks() {
        assertEquals(5, solver2.disks());
    }


    /**
     * This tests the getTower method by creating
     * 3 towers and asserting the position of those towers.
     */
    public void testGetTower() {
        Tower towerLeft = solver2.getTower(Position.LEFT);
        Tower towerMiddle = solver2.getTower(Position.MIDDLE);
        Tower towerRight = solver2.getTower(Position.RIGHT);

        assertEquals(towerLeft, solver2.getTower(Position.LEFT));
        assertEquals(towerMiddle, solver2.getTower(Position.MIDDLE));
        assertEquals(towerRight, solver2.getTower(Position.RIGHT));
    }


    /**
     * Tests the toString method by pushing disks onto
     * a HanoiSolver and calling the toString method
     */
    public void testToString() {
        Disk disk = new Disk(5);
        Disk disk2 = new Disk(10);
        Disk disk3 = new Disk(15);

        solver2.getTower(Position.LEFT).push(disk);
        solver2.getTower(Position.MIDDLE).push(disk2);
        solver2.getTower(Position.RIGHT).push(disk3);

        assertEquals("[5][10][15]", solver2.toString());
    }


    /**
     * This tests the solve method by pushing 1 disk on
     * the tower.
     */
    public void testSolve() {
        Disk disk3 = new Disk(15);
        Tower tower = solver.getTower(Position.RIGHT);
        tower.push(disk3);

        assertEquals("[][][15]", solver.toString());

        solver.solve();

        assertEquals("[15][][]", solver.toString());
        
    }
    
    
    /**
     * This tests the solve method by pushing 3 disks onto
     * a tower.
     */
    public void testSolve2() {
        Disk disk = new Disk(5);
        Disk disk2 = new Disk(10);
        Disk disk3 = new Disk(15);
        Tower tower = solver.getTower(Position.RIGHT);
        tower.push(disk3);
        tower.push(disk2);
        tower.push(disk);
        
        solver.solve();
        assertEquals("[5,10,15][][]", solver.toString());      
    }

}
