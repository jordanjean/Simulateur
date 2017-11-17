package game;
import game.entites.*;

public class Repeat extends Cons implements Comportement {

	private Comportement comportement;
	private int n;

	/*
	 * Constructeur de Repeat Param : Le comportement c avec une valeur de
	 * répétition n pour un tour. n doit être supérieur à 0.
	 */
	public Repeat(Comportement c, int n) {
		if (n == 0) {
			throw new GameException("La valeur de répétition doit être supérieure à 0.");
		}
		this.n = n;
		this.comportement = c;
	}

	@Override
	/*
	 * (non-Javadoc)
	 * 
	 * @see game.Comportement#appliquer(game.Robot)
	 */
	public void appliquer(Robot r) {
		if (!(comportement instanceof Operateur)) {
			throw new GameException("Mauvais usage du constructeur repeat.");
		}
		Operateur op = (Operateur) comportement;
		op.appliquer(r, n);
	}

	@Override
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		Integer n = new Integer(this.n);
		return comportement.toString() + ":" + n.toString();
	}

	@Override
	public boolean executable(Robot r) {
		return comportement.executable(r);
	}

}
