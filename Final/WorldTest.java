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
public class WorldTest {

	World world;

	@Before
	public void createWorld() throws FileNotFoundException {
		world = new World("public1.txt");
	}

	@Test
	public void widthTest() {
		assertEquals("Width should be 3.", 3, world.getWidth());
	}

	// TODO: Add more tests
}
