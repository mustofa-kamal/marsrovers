package org.mustofa.assignment.marsrover;

public interface Operate {
	void setOrigin(int x, int y, char direction);
	void moveCommand(String commandStr);
}
