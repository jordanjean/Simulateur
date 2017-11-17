package game;

import game.entites.Robot;

public class Alea extends Cons implements Comportement {

	private Comportement c1;
	private Comportement c2;

	public Alea(Comportement c1, Comportement c2) {
		this.c1 = c1;
		this.c2 = c2;
	}

	@Override
	public void appliquer(Robot r) {
		int alea = (int) (Math.random() % 2);
		if (alea == 0) {
			c1.appliquer(r);
			return;
		}
		if (alea == 1) {
			c2.appliquer(r);
			return;
		}
		throw new GameException("Erreur de l'application de alea.");
	}

	@Override
	public String toString() {
		return "(" + c1.toString() + "|" + c2.toString() + ")";
	}

	@Override
	public boolean executable(Robot r) {
		if (c1.executable(r) || c2.executable(r)) {
			return true;
		}
		return false;
	}

}
