package game.entites;

import java.util.*;
import game.*;
import game.map.Position;

public class Robot extends Entite {

	String DEFAULT_REGEXP = "*{E}";

	/* Liste actuelle des robots -> en file 1er arrivé sorti */
	// static listeRobots;

	private Comportement comportement;

	private int[][] visionMapInterne = new int[SeveralValues.HEIGHTMAP][SeveralValues.WIDTHMAP];

	private Type type;

	/* les deux peut être à revoir */
	private int estAttaque;
	private int seProtege;
	
	private Direction currentDirection;
	
	private Position position;

	private int id;
	static int lastId = 1;
	static ArrayList<Robot> listeRobots = new ArrayList<Robot>();
	Deque<Comportement> pileComportement = new ArrayDeque<Comportement>();

	/* more verbosity for debugging */
	static boolean DEBUG = true;

	/* Instancie un Robot */
	public Robot(Type type) {
		if (type == Type.AMI) {
			// ajouter comportement par défaut
		} else {
			// ajouter comportement par défaut
		}

		this.type = type;
		this.id = lastId;

		this.setVie(VIE_DEFAUT);
		this.setAttaque(ATTAQUE_DEFAUT);
		this.setVitesse(VITESSE_DEFAUT);

		lastId++;

		listeRobots.add(this);
	}

	/* Instancie un Robot avec un comportement défini */
	public Robot(Type type, Comportement c) {
		this.type = type;
		this.comportement = c;

		this.id = lastId;

		this.setVie(VIE_DEFAUT);
		this.setAttaque(ATTAQUE_DEFAUT);
		this.setVitesse(VITESSE_DEFAUT);

		lastId++;

		listeRobots.add(this);

		pileComportement.push(c);
	}

	/* NOT USED ANYMORE */
	public Position getPositionOnMap(game.map.Map m) {
		return m.getEntitePosition(this);
	}

	public Robot chercherPremierRobotAdjacent() {

		return null;
	}

	public Position getPosition(){
		return this.position;
	}
	
	public void setPosition(Position p){
		position = p;
	}
	/* Retourne une liste d'ID des robots amis */
	public static ArrayList<Integer> listeRobotAmis() {
		ArrayList<Integer> ra = new ArrayList<Integer>();

		listeRobots.forEach((r) -> {
			if (r.type == Type.AMI) {
				ra.add(r.id);
			}

		});

		return ra;
	}

	public ArrayList<Robot> listerRobotsAdjacents() {

		return null;
	}

	/* Not used - here for historical reasons */
	public void setRegexp(String s) {
		// regexp = s;

		// System.out.println("New regexp : " + regexp);
	}

	/* A renommer en setComportement() ? */
	public void comportement(Comportement c) {
		comportement = c;
		empilerComportement(c);
		
		// et quand on balance un nouveau comportement ?
	}
	
	/* Update le comportement du robot */
	/* TODO : A tester */
	public void updateComportement(Comportement c){
		comportement = c;
		
		pileComportement.clear();
		
		pileComportement.push(c);
	}

	public String toString() {
		//return "Robot: {Id: " + id + ", type: " + type.toString() + ", " + comportement.toString() + "}";
		return "Robot: {Id: " + id + ", type: " + type.toString() + "}";
	}

	public boolean estAmis() {
		return (type == Type.AMI);
	}

	public Type getType() {
		return type;
	}
	
	public Direction getCurrentDirection(){
		return currentDirection;
	}

	public void setCurrentDirection(Direction d){
		currentDirection = d;
	}
	
	public boolean tuer() {

		boolean res = listeRobots.remove(this);
		
		// liste qui tourne

		return res;
	}

	/* */
	public Direction tournerAdroite(Direction d){
		switch(d){
		  case NORD : return Direction.EST;
		  case EST : return Direction.SUD;
		  case SUD : return Direction.OUEST;
		  case OUEST : return Direction.NORD;
		}
		return null;
	}
	
	/* Application du comportement */
	public void executerComportementSuivant() {
		if (!pileComportement.isEmpty()) {
			try {
				pileComportement.pop().appliquer(this);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("La pile est vide");
		}
	}

	public void empilerComportement(Comportement c) {
		pileComportement.push(c);
	}

	/* for test */
	/* Un robot n'est pas définitivement supprimé !! */
	public static void main(String[] args) {

		Robot robotAmi1 = new Robot(Type.AMI);
		Robot robotEnnemi1 = new Robot(Type.ENNEMI);
		Robot robotAmi2 = new Robot(Type.AMI);

		System.out.println("RobotAmi1 toString : " + robotAmi1.toString());
		System.out.println("RobotAmi2 toString : " + robotAmi2.toString());
		System.out.println("RobotAmi1 est Ami (Oui) : " + robotAmi1.estAmis());
		System.out.println("RobotEnnemi1 est Ami (Non) : " + robotEnnemi1.estAmis());

		System.out.println("Liste des ID des robots Amis : " + listeRobotAmis());

		System.out.println("Suppression de RobotAmi1 : " + Boolean.toString(robotAmi1.tuer()));

		System.out.println("Liste des ID des robots Amis : " + listeRobotAmis());

		System.out.println("Vie de Robot1 : " + robotAmi1.getVie());
		
		System.out.println("Déplacement au Nord de 1 : ");
		robotAmi1.deplacer(Direction.NORD, 1);
		
		System.out.println("RobotAmi1 est un robot (oui) : " + ((Entite) robotAmi1).estRobot());
		
		

	}

}
