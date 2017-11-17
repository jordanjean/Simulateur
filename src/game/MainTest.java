package game;

import game.*;
import game.entites.*;
import game.map.*;
import game.utils.*;

public class MainTest {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("<-------- Main test -------->");
		
		System.out.println(">> Initialisation d'une map");
		Map map = new Map();
		
		map.initialisationMapWalled();
		System.out.println(map.toString());
		
		System.out.println(">> Ajout d'un personnage");
		Perso p = new Perso();
		System.out.println(p.toString() + "\n");
		
		System.out.println(">> Ajout d'un robot ami");
		Robot ra1 = new Robot(Type.AMI);
		System.out.println(ra1.toString()+ "\n");
		
		System.out.println(">> Ajout d'un robot ennemi");
		Robot re1 = new Robot(Type.ENNEMI);
		System.out.println(re1.toString()+ "\n");
		
		System.out.println(">> Etat de la map");
		System.out.println(map.toString());
		
		System.out.println(">> Ajout du robot ami à la position (1,1)");
		map.setCase(new Position(1, 1), ra1);
		
		System.out.println(">> Etat de la map");
		System.out.println(map.toString());
		
		System.out.println(">> Ajout du robot ennemi à la position (1,1)");
		map.setCase(new Position(1, 1), re1);
		
		System.out.println(">> Etat de la map");
		System.out.println(map.toString());
		
		System.out.println(">> Ajout du robot ennemi à la position (2,1)");
		map.setCase(new Position(2, 1), re1);
		
		System.out.println(">> Etat de la map");
		System.out.println(map.toString());
		
		System.out.println(">> Déplacement NORD \n");
		System.out.println("Retourne : " + map.avancer(Direction.NORD,1, re1));
		
		System.out.println(">> Etat de la map");
		System.out.println(map.toString());
		
		System.out.println(">> Déplacement EST \n");
		System.out.println("Retourne : " + map.avancer(Direction.EST,0, re1));
		
		System.out.println(">> Etat de la map");
		System.out.println(map.toString());
		
		System.out.println(">> Robot Ami 1 explore");
		Comportement c = new Star(new Explorer());
		ra1.comportement(c);
		
		System.out.println(">> Etat de la map");
		System.out.println(map.toString());
		
		ra1.executerComportementSuivant();
		
		System.out.println(">> Etat de la map");
		System.out.println(map.toString());
		
		ra1.executerComportementSuivant();
		
		System.out.println(">> Etat de la map");
		System.out.println(map.toString());
		
		ra1.executerComportementSuivant();
		
		System.out.println(">> Etat de la map");
		System.out.println(map.toString());
		
		System.out.println(">> Ajout de l'opérateur Explorer à (1,3)");
		Operateur o = new Explorer();
		System.out.println("Retourne : " + map.setCase(new Position(2, 3), o));
		
		System.out.println(">> Etat de la map");
		System.out.println(map.toString());
		
		
		System.out.println(">> Déplacement EST de 2\n");
		System.out.println("Retourne : " + map.avancer(Direction.EST, 2, re1));
		
		System.out.println(">> Etat de la map");
		System.out.println(map.toString());
		
		System.out.println(">> Déplacement EST de 1\n");
		System.out.println("Retourne : " + map.avancer(Direction.EST, 1, re1));
		
		System.out.println(">> Etat de la map");
		System.out.println(map.toString());
		
		System.out.println("Inventaire Perso : ");
		Perso.dumpInventairePerso();
		
//		Comportement c1 = new Split();
		
		
		// proposition, diff, planning
	}
}
