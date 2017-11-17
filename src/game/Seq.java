package game;

import game.entites.*;

public class Seq extends Cons implements Comportement {

	private Comportement first;
	private Comportement suite;

	/*
	 * Constructeur de Seq Param : Le premier comportement de la liste et la
	 * suite de la liste.
	 */
	public Seq(Comportement first, Comportement suite) {
		this.first = first;
		this.suite = suite;
	}

	/* Accesseur du premier élément de la séquence */
	Comportement first() {
		return first;
	}

	/* Accesseur du premier élément de la séquence */
	Comportement suite() {
		return suite;
	}

	@Override
	/*
	 * (non-Javadoc)
	 * 
	 * @see game.Comportement#appliquer(game.Robot)
	 */
	public void appliquer(Robot r) {
		r.empilerComportement(suite);
		first.appliquer(r);
	}

	@Override
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "{" + first.toString() + toString(suite) + "}";
	}

	private String toString(Comportement c) {
		if(c == Nil.NIL){
			return "";
		}
		if (c instanceof Seq) {
			return ";" + ((Seq)c).first.toString() + toString(((Seq)c).suite());
		}
		return ";" + c.toString();
	}

	@Override
	public boolean executable(Robot r) {
		throw new GameException("executable non applicable dans Seq");
	}

}
