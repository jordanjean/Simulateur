package game.entites;

import java.util.*;
import java.util.Map.Entry;

import game.*;
import game.map.Position;

public class Perso extends Entite {

	/* peut-être à revoir */
	int seProtege;
	
	Position position;

	static HashMap<Operateur, Integer> inventaire = new HashMap<Operateur, Integer>();

	/**
	* Retourne l'inventaire du Personnage
	* @return l'inventaire
	*/
	public static HashMap<Operateur, Integer> getInventaire() {
		return inventaire;
	}

	@Override
	public Position getPosition(){
		return this.position;
	}
	
	@Override
	public void setPosition(Position p){
		this.position = p;
	}
	
	
	
	/**
	* Supprime une occurrence de l'objet o de l'inventaire du Personnage
	* @param l'opérateur 
	* @return le nouveau nombre d'occurence du type d'objet supprimé
	* @return -1 s'il n'y a pas d'objet à supprimer
	*/
	public static int supprimerInventaire(Operateur o) {
		if(inventaire.containsKey(o)){
			int v = inventaire.get(o);
			inventaire.put(o, v-1);
			return v-1;
		} else {
			return -1;
		}
	
	}

	/**
	* Ajoute une occurrence de l'objet o de l'inventaire du Personnage
	* @return le nouveau nombre d'occurrence du type d'objet ajouté : count(o)+1
	*/
	public static int ajouterInventaire(Operateur o) {
		if(inventaire.containsKey(o)){
			int v = inventaire.get(o);
			inventaire.put(o, v+1);
			return v+1;
		} else {
			inventaire.put(o, 1);
			return 1;
		}
	}

	/**
	* Récuèpre sous la forme d'une string les propriétés du Personnage
	* @return la chaîne de cractères avec ses propriétés
	*/
	public String toString() {
		return "Perso: {vie: " + Integer.toString(getVie()) + ", attaque: " + Integer.toString(getAttaque())
				+ ", vitesse: " + Integer.toString(getVitesse()) + "}";
	}
	
	/**
	* Affiche le contenu de l'inventaire du Personnage sur le terminal
	*/
	public static void dumpInventairePerso(){
		System.out.println("** Inventaire **");
		Set<Entry<Operateur, Integer>> set = inventaire.entrySet();
		Iterator<Entry<Operateur, Integer>> iterator = set.iterator();
		while (iterator.hasNext()) {
			Map.Entry<Operateur, Integer> mentry = (Map.Entry<Operateur, Integer>) iterator.next();
			System.out.print("Opérateur : " + mentry.getKey() + " - Nombre : ");
			System.out.println(mentry.getValue());
		}
		System.out.println("- Fin Inventaire -");
	}
	/* for test */
	public static void main(String[] args) {

		HashMap<Operateur, Integer> i;
		Perso p = new Perso();

		System.out.println(p.toString());
		
		Operateur o = new Explorer();

		ajouterInventaire(o);
		
		dumpInventairePerso();
		
		ajouterInventaire(o);
		
		dumpInventairePerso();
		
		supprimerInventaire(o);
		
		dumpInventairePerso();
		
		supprimerInventaire(o);
		
		dumpInventairePerso();
		
		System.out.println("Suppresion -1 : " + supprimerInventaire(o));

	}

	
}
