package game;

import java.util.ArrayList;

import game.entites.*;
import game.map.Map;

public class maintestfenetre {

	public static void main(String[] args) {

		Fenetre fenetre = new Fenetre();
		Map m = new Map();
		PrintMap p = new PrintMap(m.getLamap());

	}
}
