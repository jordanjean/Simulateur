package game;

import game.entites.*;

public class testComportment {

	public static void main(String[] args) throws ParseException {
		/*
		Comportement c = new Star(
				new Seq(new Alea(new Seq(new Explorer(), new Star(new Explorer())), new Explorer()), new Explorer()));
		Comportement c2 = new Star(new Explorer());
		Comportement c3 = new Seq(new Explorer(), new Seq(new Star(new Explorer()), Nil.NIL));
		*/
		Robot r = new Robot(Type.AMI, Reader.read("{E;E;(E|E);*{E;E}}"));
		while (true) {
			r.executerComportementSuivant();
		}
	}

}
