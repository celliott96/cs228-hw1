package edu.iastate.cs228.hw1;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author Clinton Elliott
 * 
 */
public class EmptyTest {

	Empty empty;
	World world;

	@Before
	public void createEmpty() throws FileNotFoundException {
		world = new World("public1.txt");
		empty = new Empty(world, 0, 0);
	}

	@Test
	public void stateTest() {
		assertEquals("The state should be Empty.", State.EMPTY, empty.who());
	}

	// TODO: Add more tests.

}
