package edu.iastate.cs228.hw1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

/**
 * @author Clinton Elliott
 * 
 *         The world is represented as a square grid of size width X width.
 * 
 */
public class World {

	private int width; // width of the input grid
	public Living[][] grid; // world grid

	/**
	 * Default constructor reads from a file
	 */
	public World(String inputFileName) throws FileNotFoundException {
		Scanner scan = new Scanner(new File(inputFileName));
		int spaces = 0; // spaces in the world
		int rows = 0; // rows of the given world
		int cols = 0; // columns of the given world
		int age = 0; // age of the animal

		while (scan.hasNext()) {
			spaces++;
			scan.next();
		}
		scan.close();

		width = (int) Math.sqrt(spaces);
		grid = new Living[width][width];
		scan = new Scanner(new File(inputFileName));
		for (rows = 0; rows < width; rows++) {
			for (cols = 0; cols < width; cols++) {
				String space = scan.next();
				age = 0;
				if (space.length() > 1)
					age = Integer.parseInt(space.substring(1));
				space = space.substring(0, 1);

				if (space.equals("B")) {
					grid[rows][cols] = new Badger(this, rows, cols, age);
				} else if (space.equals("R")) {
					grid[rows][cols] = new Rabbit(this, rows, cols, age);
				} else if (space.equals("F")) {
					grid[rows][cols] = new Fox(this, rows, cols, age);
				} else if (space.equals("G")) {
					grid[rows][cols] = new Grass(this, rows, cols);
				} else if (space.equals("E")) {
					grid[rows][cols] = new Empty(this, rows, cols);
				}
			}
		}
		scan.close();

	}

	/**
	 * Constructor that builds a w X w grid without initializing it.
	 * 
	 * @param width
	 *            the grid
	 */
	public World(int givenWidth) {
		grid = new Living[givenWidth][givenWidth];
		width = givenWidth;
		randomInit();
	}

	public int getWidth() {
		return width;
	}

	/**
	 * Initialize the world by randomly assigning to every square of the grid
	 * one of BADGER, FOX, RABBIT, GRASS, or EMPTY.
	 * 
	 * Every animal starts at age 0.
	 */
	public void randomInit() {
		Random generator = new Random();
		int width = getWidth(), rows = 0, cols = 0; // values for width, rows,
													// and columns of randomly
													// generated world

		for (rows = 0; rows < width; rows++) {
			for (cols = 0; cols < width; cols++) {
				int random = generator.nextInt(100);
				// Badger and Fox have equal chance of being generated (10
				// percent), Grass
				// and Rabbit have double the chance of Fox or Badger (20
				// percent), and Empty
				// has a 40 percent chance of being generated.
				if (random <= 10) {
					grid[rows][cols] = new Badger(this, rows, cols, 0);
				} else if (random <= 20) {
					grid[rows][cols] = new Fox(this, rows, cols, 0);
				} else if (random <= 40) {
					grid[rows][cols] = new Rabbit(this, rows, cols, 0);
				} else if (random <= 60) {
					grid[rows][cols] = new Grass(this, rows, cols);
				} else {
					grid[rows][cols] = new Empty(this, rows, cols);
				}
			}
		}
	}

	/**
	 * Output the world grid. For each square, output the first letter of the
	 * living form occupying the square. If the living form is an animal, then
	 * output the age of the animal followed by a blank space; otherwise, output
	 * two blanks.
	 */
	public String toString() {
		int width = getWidth(), rows = 0, cols = 0; // values for width, rows,
													// and columns of world
		String world = "";

		for (rows = 0; rows < width; rows++) {
			for (cols = 0; cols < width; cols++) {
				switch (grid[rows][cols].who()) {
				case BADGER:
					world += "B" + ((Animal) grid[rows][cols]).myAge() + " ";
					break;
				case RABBIT:
					world += "R" + ((Animal) grid[rows][cols]).myAge() + " ";
					break;
				case FOX:
					world += "F" + ((Animal) grid[rows][cols]).myAge() + " ";
					break;
				case EMPTY:
					world += "E  ";
					break;
				case GRASS:
					world += "G  ";
					break;
				}
			}
			world += "\n";
		}
		return world;
	}

	/**
	 * Write the world grid to an output file. Also useful for saving a randomly
	 * generated world for debugging purpose.
	 * 
	 * @throws FileNotFoundException
	 */
	public void write(String outputFileName) throws FileNotFoundException {
		PrintStream print = new PrintStream(outputFileName);
		PrintStream out = System.out;
		System.setOut(print);
		int width = getWidth(), rows = 0, cols = 0;
		String outputWorld = "";
		String space = " ";

		for (rows = 0; rows < width; rows++) {
			for (cols = 0; cols < width; cols++) {
				switch (grid[rows][cols].who()) {
				case BADGER:
					outputWorld += "B" + ((Animal) grid[rows][cols]).myAge()
							+ space;
					break;
				case RABBIT:
					outputWorld += "R" + ((Animal) grid[rows][cols]).myAge()
							+ space;
					break;
				case FOX:
					outputWorld += "F" + ((Animal) grid[rows][cols]).myAge()
							+ space;
					break;
				case EMPTY:
					outputWorld += "E  ";
					break;
				case GRASS:
					outputWorld += "G  ";
					break;
				}

			}

			outputWorld += "\n";
		}
		System.out.println(outputWorld);
		System.setOut(out);
		print.close();
	}
}
