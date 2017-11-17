package game.map;

import game.Explorer;
import game.Operateur;
import game.entites.Direction;
import game.entites.Perso;
import game.entites.Robot;
import game.entites.Type;

public class test_map {

	public static void main(String[] args) {
		Map mamap = new Map();
		Perso perso = new Perso();
		Robot robot = new Robot(Type.AMI);
		Operateur expl = new Explorer();
		Operateur expl2 = new Explorer();
		
		mamap.initialisationMapEmpty();
		System.out.println(mamap.toString());
		System.out.println("\n");
		
		System.out.println("Initialisation map walled \n");
		Map mamap2 = new Map();
		mamap2.initialisationMapWalled();
		System.out.println(mamap2.toString());
		
		System.out.println("Ajout perso \n");
		mamap2.setCase(new Position(1, 1), perso);
		System.out.println(mamap2.toString());
		
		System.out.println("Déplacement EST \n");
		mamap2.avancer(Direction.EST,2,perso);
		System.out.println(mamap2.toString());
		
		System.out.println("Déplacement SUD \n");
		mamap2.avancer(Direction.SUD,2,perso);
		System.out.println(mamap2.toString());
		
		System.out.println("Déplacement NORD \n");
		mamap2.avancer(Direction.NORD,3,perso);
		System.out.println(mamap2.toString());
		
		System.out.println("Ajout robot, déplacement OUEST et collision \n");
		mamap2.setCase(new Position(1, 2), robot);
		mamap2.avancer(Direction.OUEST,2,perso);
		System.out.println(mamap2.toString());
		
		System.out.println("Ajout robot, déplacement OUEST et collision \n");
		mamap2.setCase(new Position(1, 2), robot);
		mamap2.avancer(Direction.OUEST,2,perso);
		System.out.println(mamap2.toString());
		
		System.out.println("Ajout Operateur \n");
		mamap2.setCase(new Position(1, 5), expl);
		System.out.println(mamap2.toString());
		
		System.out.println("Printf de l'inventaire du perso \n");;
		Perso.dumpInventairePerso();
		
		System.out.println("Capture de l'opérateur \n");
		mamap2.avancer(Direction.EST,4,perso);
		System.out.println(mamap2.toString());
		
		System.out.println("Printf de l'inventaire du perso \n");;
		Perso.dumpInventairePerso();
	}
}
