package edu.iastate.cs228.hw1;

/**
 * @author Clinton Elliott
 * 
 *         Empty squares are competed by various forms of life.
 * 
 */
public class Empty extends Living {

	public Empty(World w, int r, int c) {
		world = w;
		row = r;
		column = c;
	}

	public State who() {
		return State.EMPTY;
	}

	/**
	 * An empty square will be occupied by a neighboring Badger, Fox, Rabbit, or
	 * Grass, or remain empty.
	 * 
	 * @param wNew
	 *            world of the next life cycle.
	 * @return Living life form in the next cycle.
	 */
	public Living next(World wNew) {
		int[] population = new int[5];
		super.census(population);
		world = wNew;

		if (population[RABBIT] > 1) {
			return new Rabbit(world, row, column, 0);
		} else if (population[FOX] > 1) {
			return new Fox(world, row, column, 0);
		} else if (population[BADGER] > 1) {
			return new Badger(world, row, column, 0);
		} else if (population[GRASS] >= 1) {
			return new Grass(world, row, column);
		} else {
			return new Empty(world, row, column);
		}
	}
}
