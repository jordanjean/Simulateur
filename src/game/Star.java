package game;

import game.entites.*;

public class Star extends Cons implements Comportement {

	Comportement comportement;

	/*
	 * Constructeur de Star Param : Le comportement c à répéter à l'infini.
	 */
	public Star(Comportement c) {
		this.comportement = c;
	}

	@Override
	/*
	 * (non-Javadoc)
	 * 
	 * @see game.Comportement#appliquer(game.Robot)
	 */
	public void appliquer(Robot r) {
		r.empilerComportement(this);
		this.comportement.appliquer(r);
	}

	@Override
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "*" + comportement.toString();
	}

	@Override
	public boolean executable(Robot r) {
		return comportement.executable(r);
	}

}
