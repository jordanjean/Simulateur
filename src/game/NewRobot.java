package game;

import game.entites.Robot;

public class NewRobot extends Operateur implements Comportement {

	public NewRobot() {
	}

	@Override
	public void appliquer(Robot r) {
		System.out.println("NewRobot");
	}

	@Override
	public void appliquer(Robot r, int n) {
		System.out.println("NewRobot");
	}

	@Override
	public String toString() {
		return "N";
	}

	@Override
	public boolean executable(Robot r) {
		return true;
	}

}
