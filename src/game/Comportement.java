package game;

import game.entites.Robot;

public interface Comportement {
	/*
	 * Application du comportement au robot r
	 */
	public void appliquer(Robot r);
	
	/* Retourne vraie si un comportement est exécutable */
	public boolean executable(Robot r); 
}
