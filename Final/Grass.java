package edu.iastate.cs228.hw1;

/**
 * @author Clinton Elliott
 * 
 *         Grass remains if more than rabbits in the neighborhood; otherwise, it
 *         is eaten.
 *
 */
public class Grass extends Living {

	/**
	 * Constructor
	 * 
	 * @param w
	 *            : world
	 * @param r
	 *            : row position
	 * @param c
	 *            : column position
	 */
	public Grass(World w, int r, int c) {
		world = w;
		row = r;
		column = c;
	}

	public State who() {
		return State.GRASS;
	}

	/**
	 * Grass can be eaten out by too many rabbits in the neighborhood. Rabbits
	 * may also multiply fast enough to take over Grass.
	 */
	public Living next(World wNew) {
		int[] population = new int[5];
		super.census(population);
		world = wNew;

		if (population[RABBIT] >= (population[GRASS] * 3)) {
			return new Empty(world, row, column);
		} else if (population[RABBIT] >= 3) {
			return new Rabbit(world, row, column, 0);
		} else {
			return new Grass(world, row, column);
		}
	}
}
