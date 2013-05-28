package org.mustofa.assignment.marsrover.core;

import org.mustofa.assignment.marsrover.Operate;

/*A robotic rovers
 * 
 */
public class Rover implements Operate {
	private int x;
	private int y;
	private char direction;

	public Rover(int x, int y, char direction) {
		super();
		this.x = x;
		this.y = y;
		this.direction = direction;
	}

	public void setOrigin(int x, int y, char direction) {
		this.x = x;
		this.y = y;
		this.direction = direction;
	}

	public void moveCommand(String commandStr) {
		char command[] = commandStr.toCharArray();

		for (int i = 0; i < command.length; i++) {
			switch (command[i]) {
			case 'M':
				moveForward();
				break;
			case 'L':
				moveLeft();
				break;
			case 'R':
				moveRight();
				break;
			default:
				System.out.println("wrong command. It must be 'L', 'R', 'M'");
			}
		}
	}

	private void moveForward() {

		switch (getDirection()) {
		case 'N':
			setY(getY() + 1);
			break;
		case 'W':
			setX(getX() - 1);
			break;
		case 'S':
			setY(getY() - 1);
			break;
		case 'E':
			setX(getX() + 1);
			break;
		}

	}

	private void moveLeft() {
		switch (getDirection()) {
		case 'N':
			setDirection('W');
			break;
		case 'W':
			setDirection('S');
			break;
		case 'S':
			setDirection('E');
			break;
		case 'E':
			setDirection('N');
			break;
		}
	}

	private void moveRight() {

		switch (getDirection()) {
		case 'N':
			setDirection('E');
			break;
		case 'E':
			setDirection('S');
			break;
		case 'S':
			setDirection('W');
			break;
		case 'W':
			setDirection('N');
			break;

		}
	}

	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param x
	 *            the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y
	 *            the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * @return the direction
	 */
	public char getDirection() {
		return direction;
	}

	/**
	 * @param direction
	 *            the direction to set
	 */
	public void setDirection(char direction) {
		this.direction = direction;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + direction;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		Rover other = (Rover) obj;

		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Rover))
			return false;

		if (direction != other.direction)
			return false;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

}
