package edu.iastate.cs228.hw1;

/**
 * @author Clinton Elliott
 * 
 *         A rabbit eats grass and lives no more than three years.
 */

public class Rabbit extends Animal {

	/**
	 * Creates a Rabbit object.
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
	public Rabbit(World w, int r, int c, int a) {
		age = a;
		row = r;
		column = c;
		world = w;
	}

	// Rabbit occupies the square.
	public State who() {
		return State.RABBIT;
	}

	/**
	 * A rabbit dies of old age or hunger, or it is eaten if there are as many
	 * foxes and badgers in the neighborhood.
	 * 
	 * @param wNew
	 *            world of the next cycle
	 * @return Living new life form occupying the same square
	 */
	public Living next(World wNew) {
		int[] population = new int[5];
		super.census(population);
		world = wNew;

		if (age == 3) {
			return new Empty(world, row, column);
		} else if (population[GRASS] == 0) {
			return new Empty(world, row, column);
		} else if (((population[BADGER] + population[FOX]) >= population[RABBIT])
				&& (population[BADGER] < population[FOX])) {
			return new Fox(world, row, column, 0);
		} else if (population[BADGER] > population[RABBIT]) {
			return new Badger(world, row, column, 0);
		} else {
			return new Rabbit(world, row, column, age += 1);
		}
	}
}
