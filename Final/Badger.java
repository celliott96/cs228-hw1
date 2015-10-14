package edu.iastate.cs228.hw1;

/**
 * @author Clinton Elliott
 * 
 *         A badger eats a rabbit and competes against a fox.
 */
public class Badger extends Animal {

	/**
	 * Constructor
	 * 
	 * @param w
	 *            : world
	 * @param r
	 *            : row position
	 * @param c
	 *            : column position
	 * @param a
	 *            : age
	 */
	public Badger(World w, int r, int c, int a) {
		age = a;
		row = r;
		column = c;
		world = w;
	}

	/**
	 * A badger occupies the square.
	 */
	public State who() {
		return State.BADGER;
	}

	/**
	 * A badger dies of old age or hunger, from isolation and attack by a group
	 * of foxes.
	 * 
	 * @param wNew
	 *            world of the next cycle
	 * @return Living life form occupying the square in the next cycle.
	 */
	public Living next(World wNew) {
		int[] population = new int[5];
		census(population);
		world = wNew;

		if (age == 4) {
			return new Empty(world, row, column);
		} else if ((population[BADGER] == 1) && (population[FOX] > 1)) {
			return new Fox(world, row, column, 0);
		} else if ((population[BADGER] + population[FOX]) > population[RABBIT]) {
			return new Empty(world, row, column);
		} else {
			return new Badger(world, row, column, age += 1);
		}
	}

}
