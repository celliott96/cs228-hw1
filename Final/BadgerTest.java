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
public class BadgerTest {

	Badger badger;
	World world;

	@Before
	public void createBadger() throws FileNotFoundException {
		world = new World("public1.txt");
		badger = new Badger(world, 0, 0, 0);
	}

	@Test
	public void stateTest() {
		assertEquals("The state should be Badger.", State.BADGER, badger.who());
	}

	// TODO: Add more tests.

}
