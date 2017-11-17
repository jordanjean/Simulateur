package game;
import game.entites.*;

public abstract class Operateur implements Comportement {
	/* 
	 * Application de l'opérateur au robot r avec une répétition de n 
	 */
	public abstract void appliquer(Robot r, int n);
	
	/*
	 * Retourne vraie si l'opérateur est exécutable
	 */
	public abstract boolean executable(Robot r);
	
	@Override
	public abstract String toString();
}
