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
public class AnimalTest {

	World w;

	@Before
	public void createWorld() throws FileNotFoundException {
		w = new World("public1.txt");
	}

	@Test
	public void isAgeZero() {
		int age = ((Animal) w.grid[1][1]).myAge();
		assertEquals("The age of the animal should be 0.", 0, age);
	}

}
