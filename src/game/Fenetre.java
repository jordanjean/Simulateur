package game;

import game.entites.*;
import game.map.*;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.swing.JTextField;

public class Fenetre {
	// fenetre d'affichage
	private JFrame fenetre;
	// différentes parties qui composent la fenêtre
	private JPanel map;
	private JPanel hud;
	private JPanel hud_n;
	private JPanel hud_c;
	private JPanel hud_s;
	private JPanel hud_apply;
	private JPanel hud_stat;
	// boutons et zones de texte pour le hud
	public static JButton appliquer1;
	public static JButton appliquer2;
	public static JButton appliquer3;
	public static JTextField zonetext1;
	public static JTextField zonetext2;
	public static JTextField zonetext3;
	private JComboBox<Object> select1;
	private JComboBox<Object> select2;
	private JComboBox<Object> select3;

	public static JButton pause;

	private JLabel stat_vie;
	private JLabel stat_att;
	private JLabel stat_vitesse;
	private JLabel split;
	private JLabel newrobot;
	private JLabel merge;
	private JLabel kamikaze;
	private JLabel follow;
	private JLabel split_val;
	private JLabel newrobot_val;
	private JLabel merge_val;
	private JLabel kamikaze_val;
	private JLabel follow_val;

	public Fenetre() {
		fenetre = new JFrame();
		map = new JPanel();
		hud = new JPanel();
		hud_n = new JPanel();
		hud_c = new JPanel();
		hud_s = new JPanel();
		hud_apply = new JPanel();
		hud_stat = new JPanel();

		appliquer1 = new JButton("Appliquer");
		appliquer2 = new JButton("Appliquer");
		appliquer3 = new JButton("Appliquer");
		zonetext1 = new JTextField();
		zonetext2 = new JTextField();
		zonetext3 = new JTextField();
		select1 = new JComboBox<Object>();
		select2 = new JComboBox<Object>();
		select3 = new JComboBox<Object>();

		pause = new JButton("Play/Pause");

		// JLabel modes_predef = new JLabel("Modes");
		stat_vie = new JLabel("PV : ");
		stat_att = new JLabel("PA : ");
		stat_vitesse = new JLabel("Speed : ");
		split = new JLabel("Split (S) :");
		newrobot = new JLabel("NewRobot (N) :");
		merge = new JLabel("Merge (M) :");
		kamikaze = new JLabel("Kamikaze (K) :");
		follow = new JLabel("Follow (F) :");
		split_val = new JLabel();
		newrobot_val = new JLabel();
		merge_val = new JLabel();
		kamikaze_val = new JLabel();
		follow_val = new JLabel();

		// Creation fenêtre
		fenetre.setTitle("Seul contre tous");
		fenetre.setSize(SeveralValues.WIDTH, SeveralValues.HEIGHT);
		fenetre.setLocation(0, 0);
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setVisible(true);
		fenetre.setResizable(false);

		// Creation zone map
		map.setSize(SeveralValues.WIDTH - SeveralValues.HUDWIDTH, SeveralValues.HEIGHT);
		map.setBackground(Color.GRAY);
		fenetre.add(map, BorderLayout.CENTER);
		map.setVisible(true);

		// Creation zone Hud
		hud.setSize(SeveralValues.HUDWIDTH, SeveralValues.HEIGHT);
		hud.setBackground(Color.WHITE);
		hud.setLayout(new BorderLayout());
		fenetre.add(hud, BorderLayout.WEST);
		hud.setVisible(true);

		// Creation du découpage du hud
		// Creation du nord
		hud.add(hud_n, BorderLayout.NORTH);
		hud_n.setLayout(new BorderLayout());
		hud_n.setBackground(Color.WHITE);

		// Creation Hud_apply (interactive)
		hud_n.add(hud_apply, BorderLayout.NORTH);
		hud_apply.setBackground(Color.WHITE);
		hud_apply.setLayout(new GridLayout(10, 2));
		
		for (int i = 0; i < 2; i++) { // Permet de laisser des espaces dans
										// l'affichage du Hud
			hud_apply.add(Box.createRigidArea(null));
		}
		hud_apply.add(select1);
		zonetext1.setColumns(10);
		hud_apply.add(zonetext1);
		hud_apply.add(Box.createRigidArea(null));
		hud_apply.add(appliquer1);

		for (int i = 0; i < 2; i++) { // Permet de laisser des espaces dans
			// l'affichage du Hud
			hud_apply.add(Box.createRigidArea(null));
		}
		hud_apply.add(select2);
		zonetext2.setColumns(10);
		hud_apply.add(zonetext2);
		hud_apply.add(Box.createRigidArea(null));
		hud_apply.add(appliquer2);

		for (int i = 0; i < 2; i++) { // Permet de laisser des espaces dans
			// l'affichage du Hud
			hud_apply.add(Box.createRigidArea(null));
		}

		hud_apply.add(select3);
		zonetext3.setColumns(10);
		hud_apply.add(zonetext3);
		hud_apply.add(Box.createRigidArea(null));
		hud_apply.add(appliquer3);
		
		for (int i = 0; i < 2; i++) { // Permet de laisser des espaces dans
										// l'affichage du Hud
			hud_apply.add(Box.createRigidArea(null));
		}
		
		
		hud_apply.setVisible(true);

		// Creation Hud Stat
		hud_n.add(hud_stat, BorderLayout.SOUTH);
		hud_stat.setBackground(Color.WHITE);
		hud_stat.setLayout(new FlowLayout());
		hud_stat.add(stat_vie);
		hud_stat.add(stat_att);
		hud_stat.add(stat_vitesse);

		hud_stat.setVisible(true);

		// Creation du centre (inventaire)
		hud.add(hud_c, BorderLayout.CENTER);
		hud_c.setLayout(new GridLayout(7, 2));
		hud_c.setBackground(Color.LIGHT_GRAY);
		hud_c.add(split);
		hud_c.add(split_val);
		hud_c.add(newrobot);
		hud_c.add(newrobot_val);
		hud_c.add(merge);
		hud_c.add(merge_val);
		hud_c.add(kamikaze);
		hud_c.add(kamikaze_val);
		hud_c.add(follow);
		hud_c.add(follow_val);
		hud_c.setVisible(true);

		
		// Creation du sud (Pause)
		hud.add(hud_s, BorderLayout.SOUTH);
		hud_s.setLayout(new FlowLayout());
		hud_s.setBackground(Color.WHITE);
		hud_s.add(pause);
		hud_s.setVisible(true);

		
		//affichage décor map
		fenetre.setContentPane(new PrintMap(Map.getLamap()));
		
		// hook window events so that we exit the Java Platform
		// when the window is closed by the end user.
		fenetre.addWindowListener(new WindowListener());
		// hook button events
		appliquer1.addActionListener(new BoutonListener());
		appliquer2.addActionListener(new BoutonListener());
		appliquer3.addActionListener(new BoutonListener());
		
		pause.addActionListener(new BoutonListener());

		fenetre.doLayout();
	}
//
//	public void select_robot(ArrayList<Integer> list) {
//		if (list.isEmpty()) {
//			return;
//		}
//		select.removeAllItems();
//		Iterator<Integer> iter = list.iterator();
//		while (iter.hasNext()) {
//			select.addItem("Robot " + iter.next().toString());
//		}
//		return;
//	}
//
//	public void refresh_inventaire(HashMap<Operateur, Integer> hmap) {
//		for (HashMap.Entry<Operateur, Integer> entry : hmap.entrySet()) {
//			if (entry.getKey() instanceof Split) {
//				split_val.setText(entry.getValue().toString());
//			} else if (entry.getKey() instanceof NewRobot) {
//				newrobot_val.setText(entry.getValue().toString());
//			} else if (entry.getKey() instanceof Merge) {
//				merge_val.setText(entry.getValue().toString());
//			} else if (entry.getKey() instanceof Kamikaze) {
//				kamikaze_val.setText(entry.getValue().toString());
//			} else if (entry.getKey() instanceof Follow) {
//				follow_val.setText(entry.getValue().toString());
//			} else {
//				throw new GameException("Operateur inconnu");
//			}
//		}
//	}

	// passe des coordonnées tableau aux réelles coordonnées écran
	public static Position coord_tab_to_screen(int i, int j) {
		return new Position(10 * i + SeveralValues.HUDWIDTH + 5, j * 10 + 5);
	}

}