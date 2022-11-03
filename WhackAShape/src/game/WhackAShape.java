package game;

import java.awt.Color;
import bag.SimpleBagInterface;
import cs2.Button;
import cs2.CircleShape;
import cs2.Shape;
import cs2.SquareShape;
import cs2.TextShape;
import cs2.Window;
import cs2.WindowSide;
import student.TestableRandom;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Abigail Sun (asun14)
/**
 * The WhackAShape class helps create the actual window from which the 
 * program will run and display using the methods in this class.
 * 
 * @author Abigail Sun (asun14)
 * @version 2020.10.03
 *
 */
public class WhackAShape {
    private SimpleBagInterface<Shape> bag;
    private Window window;
    private TestableRandom randomGenerator;

    /**
     * The default constructor.
     * Can initialize bag as a SimpleArrayBag or SimpleLinkedBag,
     * so chose SimpleLinkedBag.
     * Then initialize the window and quitButton.
     * 
     * Make a string array with the shape names ("red circle",
     * "blue square", etc.) and create a for loop to add shapes
     * from the array into the bag by using TestableRandom
     * 
     */
    public WhackAShape() {
        bag = new SimpleLinkedBag<Shape>();

        window = new Window();
        window.setTitle("WhackAShape");

        Button quitButton = new Button("Quit");
        quitButton.onClick(this, "clickedQuit");
        window.addButton(quitButton, WindowSide.SOUTH);

        String[] string = { "red circle", "blue circle", "red square",
            "blue square" };

        randomGenerator = new TestableRandom();
        int bagSizeIndex = randomGenerator.nextInt(13) + 7;

        int stringIndex = randomGenerator.nextInt(4);

        for (int i = 0; i < bagSizeIndex; i++) {
            Shape shaper = this.buildShape(string[stringIndex]);
            bag.add(shaper);
            stringIndex = randomGenerator.nextInt(4);
        }

        Shape shut = bag.pick();
        window.addShape(shut);
    }


    /**
     * The second constructor will use a try and catch to build
     * a shape if the shape is in the array.
     */
    public WhackAShape(String[] inputs) {
        bag = new SimpleLinkedBag<Shape>();

        window = new Window();
        window.setTitle("WhackAShape");

        Button quitButton = new Button("Quit");
        quitButton.onClick(this, "clickedQuit");
        window.addButton(quitButton, WindowSide.SOUTH);

        String[] string = { "red circle", "blue circle", "red square",
            "blue square" };

        for (int i = 0; i < string.length; i++) {
            try {
                buildShape(string[i]);
                Shape shape = buildShape(string[i]);
                bag.add(shape);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            
        }

        Shape shut = bag.pick();
        window.addShape(shut);
    }


    /**
     * This method returns the window field.
     */
    public Window getWindow() {
        return window;
    }


    /**
     * This returns the bag field.
     */
    public SimpleBagInterface<Shape> getBag() {
        return bag;

    }


    /**
     * This method makes it so that when the Quit button is pressed,
     * it closes out of the window.
     */
    public void clickedQuit(Button button) {
        System.exit(0);
    }


    /**
     * This method will be called whenever a shape is clicked, and will
     * remove that clicked shape from the bag. When the bag is empty,
     * the window should display the textShape with "You win!" in the
     * middle of the screen.
     */
    public void clickedShape(Shape shape) {
        window.removeShape(shape);
        bag.remove(shape);

        Shape shit = bag.pick();
        if (!(shit == null)) {
            window.addShape(shit);
        }
        else {
            TextShape textShape = new TextShape(0, 0, "");
            textShape.setText("You win!");

            textShape.setX((window.getGraphPanelWidth() / 2) - (textShape
                .getWidth() / 2));

            textShape.setY((window.getGraphPanelHeight() / 2) - (textShape
                .getHeight() / 2));

            window.addShape(textShape);
        }

    }


    /**
     * This method will go through the string array and will "build
     * a shape" according to the words/item ("red square", "blue circle",
     * etc.)
     * 
     * @throws IllegalArgumentException
     * 
     * @return currentShape is returned
     */
    private Shape buildShape(String input) {
        randomGenerator = new TestableRandom();
        int size = randomGenerator.nextInt(101) + 100;

        int x = randomGenerator.nextInt(window.getGraphPanelWidth() - size);
        int y = randomGenerator.nextInt(window.getGraphPanelHeight() - size);

        Shape currentShape = null;

        if (input.contains("red")) {
            if (input.contains("square")) {
                currentShape = new SquareShape(x, y, size, Color.RED);
            }
            else if (input.contains("circle")) {
                currentShape = new CircleShape(x, y, size, Color.RED);
            }
        }
        else if (input.contains("blue")) {
            if (input.contains("square")) {
                currentShape = new SquareShape(x, y, size, Color.BLUE);
            }
            else if (input.contains("circle")) {
                currentShape = new CircleShape(x, y, size, Color.BLUE);
            }
        }
        else {
            currentShape = new Shape(x, y, size, Color.BLACK);
            throw new IllegalArgumentException();
        }

        currentShape.onClick(this, "clickedShape");
        return currentShape;

    }

}
