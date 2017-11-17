package game;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import game.map.Case;
import game.map.CaseEmpty;
import game.map.CaseWall;
import game.map.Map;

public class PrintMap extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Case[][] map;

	public PrintMap(Case[][] m) {
		map = m;
		
	}

	public void paintComponent(Graphics g) {
		for (int i = 0; i < SeveralValues.WIDTHMAP; i++) {
			for (int j = 0; j < SeveralValues.HEIGHTMAP; j++) {
				if (map[j][i] instanceof CaseEmpty) {
					System.out.println("empty");
					g.setColor(Color.RED);
					g.fillRect(Fenetre.coord_tab_to_screen(i, j).getX(), Fenetre.coord_tab_to_screen(i, j).getY(), 10,
							10);
				} else if (map[j][i] instanceof CaseWall) {
					System.out.println("wall");
					g.setColor(Color.GREEN);
					g.fillRect(Fenetre.coord_tab_to_screen(i, j).getX(), Fenetre.coord_tab_to_screen(i, j).getY(), 10,
							10);
				} else {
					throw new GameException("Objet inconnu lors de l'initialisation");
				}
			}
		}

	}

}
