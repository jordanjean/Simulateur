package game.entites;

import game.map.Position;

public abstract class Entite {

	private int vie;
	private int vitesse;
	private int attaque;

	static int VIE_DEFAUT = 1;
	static int VITESSE_DEFAUT = 1;
	static int ATTAQUE_DEFAUT = 1;

	public int getVie() {
		return this.vie;
	}

	public int getVitesse() {
		return this.vitesse;
	}

	public int getAttaque() {
		return this.attaque;
	}

	public int setVie(int v) {
		this.vie = v;
		return this.vie;
	}

	public int setVitesse(int v) {
		this.vitesse = v;
		return this.vitesse;
	}

	public int setAttaque(int v) {
		this.attaque = v;
		return this.attaque;
	}
	
	public boolean estRobot(){
		return (this instanceof Robot);
	}
	
	public boolean estPerso(){
		return (this instanceof Perso);	
	}

	/* Mouvements possibles d'une entité */
	public int deplacer(Direction d, int accelaration) {
		// update entity position in Map model
		// leve une exception si pas < 0
		if (this instanceof Robot) {

		}
		return 0;
	}

	public abstract String toString();
	
	public abstract Position getPosition();
	
	public abstract void setPosition(Position p);

}
