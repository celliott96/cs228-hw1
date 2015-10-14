package edu.iastate.cs228.hw1;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Clinton Elliott
 * 
 *         The PredatorPrey class performs the predator-prey simulation over a
 *         grid world with squares occupied by badgers, foxes, rabbits, grass,
 *         or none.
 *
 */
public class PredatorPrey {

	/**
	 * Update the new world from the old world in one cycle.
	 * 
	 * @param wOld
	 *            old world
	 * @param wNew
	 *            new world
	 */
	public static void updateWorld(World wOld, World wNew) {
		int oldWidth = wOld.getWidth(); // width of the old world
		int rows = 0, cols = 0; // values for rows and columns

		for (rows = 0; rows < oldWidth; rows++) {
			for (cols = 0; cols < oldWidth; cols++) {
				Living oldliving = wOld.grid[rows][cols];
				Living newliving = oldliving.next(wNew);
				wNew.grid[rows][cols] = newliving;
			}
		}
	}

	/**
	 * Repeatedly generates worlds either randomly or from reading files. Over
	 * each world, carries out an input number of cycles of evolution.
	 * 
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(System.in);
		int numTries = 1, numCycles = 0, width = 0, choice = 0; // values for
																// number of
		// times the user has tried
		// the program, cycles of
		// the world, width of
		// the world, and initial choice.
		boolean run = true; // program exits if false
		World initialWorld = new World(0); // initial world before it undergoes
											// cycles
		World even = new World(0); // the world after an even number of cycles
		World odd = new World(0); // the world after an odd number of cycles

		while (run == true) {
			System.out
					.print("The Predator-Prey Simulation \n Keys: 1 (Random world) 2 (File input) 3 (Exit) \n"
							+ "Trial " + numTries + ": ");
			choice = scan.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Random world selected");
				System.out.print("Enter grid width: ");
				width = scan.nextInt();
				initialWorld = new World(width);
				System.out.print("Enter the number of cycles: ");
				numCycles = scan.nextInt();
				System.out.println("Initial World:");
				System.out.println(initialWorld);
				odd = new World(width);
				even = new World(width);
				odd = initialWorld;
				even = initialWorld;
				for (int it = 0; it < numCycles; it++) {
					if (it % 2 == 0) {
						updateWorld(odd, even);
					} else {
						updateWorld(even, odd);
					}
				}
				System.out.println("Final World:");
				if ((numCycles % 2) == 0)
					System.out.println(odd);
				else
					System.out.println(even);
				break;

			case 2:
				System.out.println("World input from a file");
				System.out.print("File name: ");
				String fileName = scan.next();
				initialWorld = new World(fileName);
				System.out.print("Enter the number of cycles:");
				numCycles = scan.nextInt();
				System.out.println("Initial World: \n \n" + initialWorld);
				odd = new World(fileName);
				even = new World(fileName);
				for (int it = 0; it < numCycles; it++) {
					if (it % 2 == 0) {
						updateWorld(odd, even);
					} else {
						updateWorld(even, odd);
					}
				}
				System.out.println("Final World:");
				if (numCycles % 2 == 0) {
					System.out.println(odd);
				} else {
					System.out.println(even);
				}
				break;

			case 3:
				run = false;
				break;

			}
			numTries++;
		}
		scan.close();
	}
}
