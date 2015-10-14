package edu.iastate.cs228.hw1;

/**
 * @author Clinton Elliott
 * 
 *         Living refers to the life form occupying a square in a world grid. It
 *         is a superclass of Empty, Grass, and Animal, the latter of which is
 *         in turn a superclass of Badger, Fox, and Rabbit. Living has two
 *         abstract methods awaiting implementation.
 *
 */
public abstract class Living {

	protected World world; // the world in which the life form resides
	protected int row; // location of the square on which
	protected int column; // the life form resides

	// constants to be used as indices.
	protected static final int BADGER = 0;
	protected static final int EMPTY = 1;
	protected static final int FOX = 2;
	protected static final int GRASS = 3;
	protected static final int RABBIT = 4;

	public static final int NUM_LIFE_FORMS = 5;

	// life expectancies
	public static final int BADGER_MAX_AGE = 4;
	public static final int FOX_MAX_AGE = 6;
	public static final int RABBIT_MAX_AGE = 3;

	/**
	 * Censuses all life forms in the 3 X 3 neighborhood in a world.
	 * 
	 * @param population
	 *            counts of all life forms
	 */
	protected void census(int population[]) {
		int width = world.getWidth(); // width of the world

		// switch statements to test different possibilities of the grid
		switch (world.grid[row][column].who()) {
		case BADGER:
			population[BADGER]++;
			break;
		case FOX:
			population[FOX]++;
			break;
		case RABBIT:
			population[RABBIT]++;
			break;
		case EMPTY:
			population[EMPTY]++;
			break;
		case GRASS:
			population[GRASS]++;
			break;
		}
		if (column < width - 1 && row < width - 1) {
			switch (world.grid[row + 1][column + 1].who()) {
			case BADGER:
				population[BADGER]++;
				break;
			case FOX:
				population[FOX]++;
				break;
			case RABBIT:
				population[RABBIT]++;
				break;
			case EMPTY:
				population[EMPTY]++;
				break;
			case GRASS:
				population[GRASS]++;
				break;
			}
		}

		if (column > 0 && row > 0) {
			switch (world.grid[row - 1][column - 1].who()) {
			case BADGER:
				population[BADGER]++;
				break;
			case FOX:
				population[FOX]++;
				break;
			case RABBIT:
				population[RABBIT]++;
				break;
			case EMPTY:
				population[EMPTY]++;
				break;
			case GRASS:
				population[GRASS]++;
				break;
			}
		}
		if (row < width - 1) {
			switch (world.grid[row + 1][column].who()) {
			case BADGER:
				population[BADGER]++;
				break;
			case FOX:
				population[FOX]++;
				break;
			case RABBIT:
				population[RABBIT]++;
				break;
			case EMPTY:
				population[EMPTY]++;
				break;
			case GRASS:
				population[GRASS]++;
				break;
			}
		}
		if (row > 0) {
			switch (world.grid[row - 1][column].who()) {
			case BADGER:
				population[BADGER]++;
				break;
			case FOX:
				population[FOX]++;
				break;
			case RABBIT:
				population[RABBIT]++;
				break;
			case EMPTY:
				population[EMPTY]++;
				break;
			case GRASS:
				population[GRASS]++;
				break;
			}
		}
		if (column < (width - 1)) {
			switch (world.grid[row][column + 1].who()) {
			case BADGER:
				population[BADGER]++;
				break;
			case FOX:
				population[FOX]++;
				break;
			case RABBIT:
				population[RABBIT]++;
				break;
			case EMPTY:
				population[EMPTY]++;
				break;
			case GRASS:
				population[GRASS]++;
				break;
			}
		}
		if (column > 0) {
			switch (world.grid[row][column - 1].who()) {
			case BADGER:
				population[BADGER]++;
				break;
			case FOX:
				population[FOX]++;
				break;
			case RABBIT:
				population[RABBIT]++;
				break;
			case EMPTY:
				population[EMPTY]++;
				break;
			case GRASS:
				population[GRASS]++;
				break;
			}
		}
		if (column > 0 && row < width - 1) {
			switch (world.grid[row + 1][column - 1].who()) {
			case BADGER:
				population[BADGER]++;
				break;
			case FOX:
				population[FOX]++;
				break;
			case RABBIT:
				population[RABBIT]++;
				break;
			case EMPTY:
				population[EMPTY]++;
				break;
			case GRASS:
				population[GRASS]++;
				break;
			}
		}
		if (column < width - 1 && row > 0) {
			switch (world.grid[row - 1][column + 1].who()) {
			case BADGER:
				population[BADGER]++;
				break;
			case FOX:
				population[FOX]++;
				break;
			case RABBIT:
				population[RABBIT]++;
				break;
			case EMPTY:
				population[EMPTY]++;
				break;
			case GRASS:
				population[GRASS]++;
				break;
			}
		}
	}

	/**
	 * Gets the identity of the life form on the square.
	 * 
	 * @return State
	 */
	public abstract State who();

	/**
	 * Determines the life form on the square in the next cycle.
	 * 
	 * @param wNew
	 *            world of the next cycle
	 * @return Living
	 */
	public abstract Living next(World wNew);

}
