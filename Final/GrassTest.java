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
public class GrassTest {

	Grass grass;
	World world;

	@Before
	public void createGrass() throws FileNotFoundException {
		world = new World("public1.txt");
		grass = new Grass(world, 0, 0);
	}

	@Test
	public void stateTest() {
		assertEquals("The state should be Grass.", State.GRASS, grass.who());
	}

	// TODO: Add more tests

}
