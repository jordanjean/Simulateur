package game.map;

import game.entites.Direction;
import game.entites.Entite;
import game.entites.Perso;
import game.entites.Robot;
import game.entites.Type;
import game.Operateur;
import game.SeveralValues;

public class Map {

	//Attributs
	private static Case lamap[][] = new Case[SeveralValues.HEIGHTMAP][SeveralValues.WIDTHMAP]; //TODO -> values
	
	// Constructeurs
	public Map(){
		initialisationMapWalled();
	}
	
	//Accesseur
	public static Case[][] getLamap() {
		return lamap;
	}

	public static void setLamap(Case[][] lamap) {
		Map.lamap = lamap;
	}

	public static Case getCase(Position p){
		return lamap[p.getX()][p.getY()];
	}
	
	//Methodes
	
	//Initialise notre map avec uniquement des cases vides
	public static void initialisationMapEmpty(){
		for( int i = 0 ; i < SeveralValues.HEIGHTMAP ; i++){
			for (int j = 0 ; j < SeveralValues.WIDTHMAP ; j++){
				lamap[i][j] = new CaseEmpty();
			}
		}
	}
	
	//Initialise notre map avec des cases vides et des murs autour (x = 0 || x = HEIGHTMAP-1 || y = 0 || y = WIDTHMAP-1)
	public static void initialisationMapWalled(){
		int i;
		int j;
		
		for (i = 0, j = 0; i < SeveralValues.HEIGHTMAP; i++ ){//colonne 0
			lamap[i][j] = new CaseWall();	
		}
		for (i = 0, j = (SeveralValues.WIDTHMAP-1);i < SeveralValues.HEIGHTMAP;i++  ){// avant dernière colonne
			lamap[i][j] = new CaseWall();
		}
		for (i = 0, j = 0; j < (SeveralValues.WIDTHMAP); j++){//ligne 1 
			lamap[i][j] = new CaseWall();	
		}
		for (i = (SeveralValues.HEIGHTMAP-1), j = 0; j < SeveralValues.WIDTHMAP; j++){	// avant derniere ligne
			lamap[i][j] = new CaseWall();
		}
		for(i = 1 ; i < (SeveralValues.HEIGHTMAP-1); i++){
			for (j = 1 ; j < (SeveralValues.WIDTHMAP-1) ; j++){
				lamap[i][j] = new CaseEmpty();
			}
		}
	}
	
	//Retourne un objet position si l'objet entite a été trouvé
	public static Position getEntitePosition(Entite e){
		for( int i = 0 ; i < SeveralValues.HEIGHTMAP ; i++){
			for (int j = 0 ; j < SeveralValues.WIDTHMAP ; j++){
				if (lamap[i][j] instanceof CaseEntite){
					CaseEntite uneCase = (CaseEntite)lamap[i][j];
					if (uneCase.getMonentite().equals(e)){
						return new Position(i, j);
					}
				}
			}
		}  
		return null;
	}
	
	//Retourne l'objet entite s'il existe à la position p
	public static Entite getEntiteAtPosition(Position p){
		if (lamap[p.getX()][p.getY()] instanceof CaseEntite){
			CaseEntite uneCase = (CaseEntite)lamap[p.getX()][p.getY()];
			return uneCase.getMonentite();
		}			
		return null;
	}
	
	//Set une position dans notre map avec l'objet o. en fonction
	//du type de cet objet on crée une case adéquate
	//0-> bien passé
	//-1 -> o pas reconnu comme un object assignable à notre map
	public static int setCase(Position p,Object o){ //TODO -> check des positions, validité de l'objet, améliorer
		if (o instanceof Entite){
			Entite e = (Entite)o;
			lamap[p.getX()][p.getY()]= new CaseEntite(e);
			e.setPosition(p);
			return 0;
		}
		else if (o instanceof Operateur){
			Operateur op = (Operateur)o;
			lamap[p.getX()][p.getY()]= new CaseOperateur(op);
			return 0;
		}
		return -1;
	}
	
	//fonction de déplacement d'un robot
	//uniquement NOSE
	//0 -> bien passé
	//-1 -> opération annulée
	// >=1 -> nbpas restants
	public static int avancer(Direction dir, int pas, Entite e){// TODO -> gestion des opérateurs
		if (pas==0)
			return 0; 
		if (pas< 0)
			return -1;
		
		
		Position posE = e.getPosition();
		int nbpasrestant = pas;
		int y = posE.getX();
		int x = posE.getY();
		
		if (dir == Direction.NORD){// y--
			y--;
			while (nbpasrestant > 0){
				if (lamap[y][x] instanceof CaseDecor){
					return nbpasrestant;
				}
				else{//ici, case vide ou contenant entite/operateur
					if (lamap[y][x] instanceof CaseEntite){
						return nbpasrestant;
					}
					else if (lamap[y][x] instanceof CaseOperateur){
						CaseOperateur temp = (CaseOperateur) lamap[y][x];
						if (e instanceof Robot){
							Robot r = (Robot)e;
							if (r.estAmis()){
								Perso.ajouterInventaire(temp.getMonOperateur());
							}
							//robot ennemi donc pas d'ajout inventaire
							lamap[y][x] = new CaseEntite(e);
							r.setPosition(new Position(y, x));
							lamap[y+1][x] = new CaseEmpty();
							
						}
						else{
							Perso.ajouterInventaire(temp.getMonOperateur());
							lamap[y][x] = new CaseEntite(e);
							e.setPosition(new Position(y, x));
							lamap[y+1][x] = new CaseEmpty();
						}
					}
					else{//ici, case vide, donc déplacement possible
						lamap[y][x] = new CaseEntite(e);
						e.setPosition(new Position(y, x));
						lamap[y+1][x] = new CaseEmpty();
					}
				}
				y--;
				nbpasrestant--;
			}
		}
		else if (dir == Direction.OUEST){//x--
			x--;
			while (nbpasrestant > 0){
				if (lamap[y][x] instanceof CaseDecor){
					return nbpasrestant;
				}
				else{//ici, case vide ou contenant entite/operateur
					if (lamap[y][x] instanceof CaseEntite){
						return nbpasrestant;
					}
					else if (lamap[y][x] instanceof CaseOperateur){ //TODO
						CaseOperateur temp = (CaseOperateur) lamap[y][x];
						if (e instanceof Robot){
							Robot r = (Robot)e;
							if (r.estAmis()){
								Perso.ajouterInventaire(temp.getMonOperateur());
							}
							//robot ennemi donc pas d'ajout inventaire
							lamap[y][x] = new CaseEntite(e);
							r.setPosition(new Position(y, x));
							lamap[y][x+1] = new CaseEmpty();
						}
						else{
							Perso.ajouterInventaire(temp.getMonOperateur());
							lamap[y][x] = new CaseEntite(e);
							e.setPosition(new Position(y, x));
							lamap[y][x-1] = new CaseEmpty();
						}
					}
					else{//ici, case vide, donc déplacement possible
						lamap[y][x] = new CaseEntite(e);
						e.setPosition(new Position(y, x));
						lamap[y][x+1] = new CaseEmpty();
					}
				}
				x--;
				nbpasrestant--;
			}
		}
		else if (dir == Direction.SUD){//y++
			y++;
			while (nbpasrestant > 0){
				if (lamap[y][x] instanceof CaseDecor){
					return nbpasrestant;
				}
				else{//ici, case vide ou contenant entite/operateur
					if (lamap[y][x] instanceof CaseEntite){
						return nbpasrestant;
					}
					else if (lamap[y][x] instanceof CaseOperateur){ //TODO
						CaseOperateur temp = (CaseOperateur) lamap[y][x];
						if (e instanceof Robot){
							Robot r = (Robot)e;
							if (r.estAmis()){
								Perso.ajouterInventaire(temp.getMonOperateur());
							}
							//robot ennemi donc pas d'ajout inventaire
							lamap[y][x] = new CaseEntite(e);
							r.setPosition(new Position(y, x));
							lamap[y-1][x] = new CaseEmpty();
						}
						else{
							Perso.ajouterInventaire(temp.getMonOperateur());
							lamap[y][x] = new CaseEntite(e);
							e.setPosition(new Position(y, x));
							lamap[y][x-1] = new CaseEmpty();
						}
					}
					else{//ici, case vide, donc déplacement possible
						lamap[y][x] = new CaseEntite(e);
						e.setPosition(new Position(y, x));
						lamap[y-1][x] = new CaseEmpty();
					}
				}
				y++;
				nbpasrestant--;
			}		
		}
		else{//x++
			x++;
			while (nbpasrestant > 0){
				if (lamap[y][x] instanceof CaseDecor){
					return nbpasrestant;
				}
				else{//ici, case vide ou contenant entite/operateur
					if (lamap[y][x] instanceof CaseEntite){
						return nbpasrestant;
					}
					else if (lamap[y][x] instanceof CaseOperateur){ //TODO
						CaseOperateur temp = (CaseOperateur) lamap[y][x];
						if (e instanceof Robot){
							Robot r = (Robot)e;
							if (r.estAmis()){
								Perso.ajouterInventaire(temp.getMonOperateur());
							}
							//robot ennemi donc pas d'ajout inventaire
							lamap[y][x] = new CaseEntite(e);
							r.setPosition(new Position(y, x));
							lamap[y][x-1] = new CaseEmpty();
						}
						else{ //Ici le personnage est donc le perso
							Perso.ajouterInventaire(temp.getMonOperateur());
							lamap[y][x] = new CaseEntite(e);
							e.setPosition(new Position(y, x));
							lamap[y][x-1] = new CaseEmpty();
						}
					}
					else{//ici, case vide, donc déplacement possible
						lamap[y][x] = new CaseEntite(e);
						e.setPosition(new Position(y, x));
						lamap[y][x-1] = new CaseEmpty();
					}
				}
				x++;
				nbpasrestant--;
			}
		}
		return 0;
	}
	
	public String toString(){
		String returned = "";
		for( int i = 0 ; i < SeveralValues.HEIGHTMAP ; i++){
			for (int j = 0 ; j < SeveralValues.WIDTHMAP ; j++){
				//returned+= lamap[i][j].toString() + new Position(i, j).toString();
				if(lamap[i][j] instanceof CaseWall){
					returned+="\u001B[33m"+ " W " + "\u001B[0m";
				}
				else if(lamap[i][j] instanceof CaseEmpty){
					returned+="\u001B[30m"+ " . " + "\u001B[0m";
				}
				else if(lamap[i][j] instanceof CaseOperateur){
					returned+="\u001B[35m"+ " " + (lamap[i][j].toString()).substring((lamap[i][j].toString()).length() - 1) + " " + "\u001B[0m";	
				}
				else if(lamap[i][j] instanceof CaseEntite){//Gerer si c'est un robot ou un perso
					CaseEntite temp = (CaseEntite) lamap[i][j];
					if((temp.getMonentite()) instanceof Robot){
						if(((Robot)((((CaseEntite) lamap[i][j]).getMonentite()))).getType() == Type.AMI){
							returned+="\u001B[32m"+ " R " + "\u001B[0m";
						}
						else if(((Robot)((((CaseEntite) lamap[i][j]).getMonentite()))).getType() == Type.ENNEMI){
							returned+="\u001B[31m"+ " R " + "\u001B[0m";
						}
						
					}
					else if(temp.getMonentite() instanceof Perso){
						returned+="\u001B[30m"+ " P " + "\u001B[0m";
					}
					
				}
				
			}
			returned+="\n";
		}
		return returned;
	}
	
	public Boolean equals(Map m){
		for( int i = 0 ; i < SeveralValues.HEIGHTMAP ; i++){
			for (int j = 0 ; j < SeveralValues.WIDTHMAP ; j++){
				if(!(lamap[i][j].equals(m.getLamap()[i][j]))){
					return false;
				}
			}
		}
		return true;
	}
	
	//fgdg
}
