package towerofhanoi;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;
import cs2.Button;
import cs2.Shape;
import cs2.Window;
import cs2.WindowSide;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Abigail Sun (asun14)

/**
 * This PuzzleWindow class displays all the stuff in the GUI
 * 
 * @author Abigail Sun (asun14)
 * @version 2020.10.19
 *
 */
public class PuzzleWindow implements Observer {

    private HanoiSolver game;
    private Shape left;
    private Shape middle;
    private Shape right;
    private Window window;

    private final int DISK_GAP = 5;
    public static final int DISK_HEIGHT = 10;
    private final int WIDTH_FACTOR = 10;

    private Button solveButton;

    /**
     * This method updates the front-end, after the back-end has been changed.
     * Only need the position parameter so it can peek at the Disk that was
     * just moved to get needed information for the display.
     * The back-end already moved the disks between the Towers.
     */
    private void moveDisk(Position position) {
        Disk currentDisk = game.getTower(position).peek();
        Shape currentPole;
        switch (position) {
            case LEFT:
                currentPole = left;
                break;
            case MIDDLE:
                currentPole = middle;
                break;
            case RIGHT:
                currentPole = right;
                break;
            default:
                currentPole = left;
                break;
        }

        int pole = game.getTower(position).size();

        int x = currentPole.getX();
        int y = currentPole.getY() + currentPole.getHeight() - (DISK_HEIGHT
            * pole - (DISK_GAP * pole - 1));

        currentDisk.moveTo(x - (currentDisk.getWidth() - currentPole.getWidth())
            / 2, y - DISK_GAP);

    }


    /**
     * The sleep method uses a try catch to pause between
     * Disk movements.
     */
    private void sleep() {
        try {
            Thread.sleep(500);
        }
        catch (Exception e) {
        }

    }


    /**
     * Sets up the constructor by initializing the measurements
     * of the poles, disks, and spacing.
     * Also initializes the window and buttons.
     */
    public PuzzleWindow(HanoiSolver game) {
        this.game = game;
        game.addObserver(this);
        window = new Window("Tower of Hanoi");

        int POLE_Y = 210;
        int POLE_X = 110;
        int POLE_SPACE = 175;
        int POLE_WIDTH = 5;
        int POLE_HEIGHT = game.disks() * (DISK_GAP + DISK_HEIGHT);

        left = new Shape(POLE_X, POLE_Y, POLE_WIDTH, POLE_HEIGHT, Color.BLACK);
        middle = new Shape(POLE_X + POLE_SPACE, POLE_Y, POLE_WIDTH, POLE_HEIGHT,
            Color.BLACK);
        right = new Shape(POLE_X + (POLE_SPACE * 2), POLE_Y, POLE_WIDTH,
            POLE_HEIGHT, Color.BLACK);

        for (int i = game.disks(); i > 0; i--) {
            game.getTower(Position.RIGHT).push(new Disk(WIDTH_FACTOR * i));
            window.addShape(game.getTower(Position.RIGHT).peek());
            moveDisk(Position.RIGHT);
        }

        window.addShape(this.left);
        window.addShape(this.middle);
        window.addShape(this.right);

        solveButton = new Button("Solve");
        window.addButton(solveButton, WindowSide.SOUTH);
        solveButton.onClick(this, "clickedSolve");

    }


    /**
     * Is called automatically when the game’s move method calls notifyObservers
     */
    @Override
    public void update(Observable o, Object arg) {
        if (arg.getClass() == Position.class) {
            moveDisk((Position)arg);

        }
        sleep();

    }


    /**
     * Initializes the solve button to solve the puzzle.
     */
    public void clickedSolve(Button button) {
        button.disable();
        new Thread() {
            public void run() {
                game.solve();
            }
        }.start();

    }

}
