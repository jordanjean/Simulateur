package game;

import game.entites.Robot;

public class Equitable extends Cons implements Comportement {
	private Comportement c1;
	private Comportement c2;
	private int c = 1;

	public Equitable(Comportement c1, Comportement c2) {
		this.c1 = c1;
		this.c2 = c2;
	}

	@Override
	public void appliquer(Robot r) {
		if (c == 1) {
			c1.appliquer(r);
			c = 2;
		}
		c2.appliquer(r);
		c = 1;
	}

	@Override
	public String toString() {
		return "(" + c1.toString() + "||" + c2.toString() + ")";
	}

	@Override
	public boolean executable(Robot r) {
		if (c == 1) {
			return c1.executable(r);
		}
		if (c == 2) {
			return c2.executable(r);
		}
		throw new GameException("Erreur du test d'execution de equitable");
	}

}
