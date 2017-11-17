package game;

import game.entites.Robot;

public class Pref extends Cons implements Comportement {

	private Comportement first;
	private Comportement suite;

	/*
	 * Constructeur d'une séquence préférentielle d'opérateurs
	 */
	public Pref(Comportement first, Comportement suite) {
		if (first instanceof Seq || first instanceof Pref) {
			throw new GameException("Une séquence préférentielle ne peut contenir que des opérateurs.");
		}
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
	public void appliquer(Robot r) {
		_appliquer(r, first, suite);
	}

	private void _appliquer(Robot r, Comportement first, Comportement suite) {
		if (suite == null) {
			first.appliquer(r);
		}
		if (((Operateur)first).executable(r)) {
			first.appliquer(r);
		}
		if (suite instanceof Pref) {
			_appliquer(r, ((Pref)suite).first(), ((Pref) suite).suite());
		}
		suite.appliquer(r);
	}

	@Override
	public String toString() {
		return "{" + first.toString() + toString(suite) + "}";
	}

	private String toString(Comportement c) {
		if(c == Nil.NIL){
			return "";
		}
		if (c instanceof Pref) {
			return ">" + ((Pref)c).first().toString() + toString(((Pref)c).suite());
		}
		return ">" + c.toString();
	}

	@Override
	public boolean executable(Robot r) {
		throw new GameException("executable non applicable dans Pref");
	}

}
