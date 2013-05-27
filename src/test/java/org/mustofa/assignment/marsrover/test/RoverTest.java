package org.mustofa.assignment.marsrover.test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.mustofa.assignment.marsrover.core.Rover;


@RunWith(value = Parameterized.class)
public class RoverTest {
	
	private Rover rover;
	private int x;
	private int y;
	private char direction;
	private String command;
	private String result;

	public RoverTest(int x, int y, char direction, String command,String result) {
		super();
		this.x = x;
		this.y = y;
		this.direction = direction;
		this.command = command;
		this.result = result;
	}

	@Before
	public void testInit() {
		rover = new Rover(0, 0, 'N');
	}

	@Parameters
	public static Collection<Object[]> data() {
		Object[][] data = new Object[][] { 
											{ 1, 2, 'N', "LMLMLMLMM","13N"},
											{ 3, 3, 'E', "MMRMMRMRRM","51E" }
										};
		return Arrays.asList(data);
	}

	@Test
	public void testMove() {
		rover.setOrigin(x, y, direction);
		rover.moveCommand(command);
		assertEquals(result, rover.getX() + "" + rover.getY() + "" + rover.getDirection());
		System.out.println(rover.getX() + " " + rover.getY() + " " + rover.getDirection());
	}
}
