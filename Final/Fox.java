package edu.iastate.cs228.hw1;

/**
 * @author Clinton Elliott
 * 
 *         A fox eats rabbits and competes against a badger.
 */
public class Fox extends Animal {

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
	public Fox(World w, int r, int c, int a) {
		age = a;
		row = r;
		column = c;
		world = w;
	}

	/**
	 * A fox occupies the square.
	 */
	public State who() {
		return State.FOX;
	}

	/**
	 * A fox dies of old age or hunger, or from attack by numerically superior
	 * badgers.
	 * 
	 * @param wNew
	 *            world of the next cycle
	 * @return Living life form occupying the square in the next cycle.
	 */
	public Living next(World wNew) {
		int[] population = new int[5];
		super.census(population);
		world = wNew;

		if (age == 6) {
			return new Empty(world, row, column);
		} else if (population[BADGER] > population[FOX]) {
			return new Badger(world, row, column, 0);
		} else if (population[BADGER] + population[FOX] > population[RABBIT]) {
			return new Empty(world, row, column);
		} else {
			return new Fox(world, row, column, age += 1);
		}
	}
}
