package game;

import game.entites.*;

public abstract class Cons implements Comportement {
	
	/* Retourne vraie si un comportement est exécutable */
	public abstract boolean executable(Robot r);
	
	@Override
	public abstract String toString();
}
