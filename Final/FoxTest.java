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
public class FoxTest {

	Fox fox;
	World world;

	@Before
	public void createFox() throws FileNotFoundException {
		world = new World("public1.txt");
		fox = new Fox(world, 0, 0, 0);
	}

	@Test
	public void stateTest() {
		assertEquals("The state should be Fox.", State.FOX, fox.who());
	}

	// TODO: Add more tests.

}
