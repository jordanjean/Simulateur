package game;

import java.awt.event.ActionEvent;

public class BoutonListener implements java.awt.event.ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object source = e.getSource();
		String comportement1;
		String comportement2;
		String comportement3;
		
		if (source == Fenetre.appliquer1) {
			comportement1 = Fenetre.zonetext1.getText();
			//reader.read(comportement1);
			System.out.println(comportement1);
			
		} else if (source == Fenetre.appliquer2){
			comportement2 = Fenetre.zonetext2.getText();
			//reader.read(comportement2);
			System.out.println(comportement2);			
		} else if (source == Fenetre.appliquer3){
			comportement3 = Fenetre.zonetext3.getText();
			//reader.read(comportement2);
			System.out.println(comportement3);
		}

	}

}
