package game;

import game.entites.Robot;

public class Nil implements Comportement {

	public static final Nil NIL = new Nil();
	private Nil(){}

	@Override
	public void appliquer(Robot r) {
		r.executerComportementSuivant();
	}

	@Override
	public boolean executable(Robot r) {
		return true;
	}

	@Override
	public String toString() {
		return "nil";
	}

}
