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
public class RabbitTest {

	Rabbit rabbit;
	World world;

	@Before
	public void createRabbit() throws FileNotFoundException {
		world = new World("public1.txt");
		rabbit = new Rabbit(world, 0, 0, 0);
	}

	@Test
	public void stateTest() {
		assertEquals("The state should be Rabbit.", State.RABBIT, rabbit.who());
	}

	// TODO: Add more tests.

}
