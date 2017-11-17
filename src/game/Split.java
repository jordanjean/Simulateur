package game;

import game.entites.Robot;
import game.map.Position;

public class Split extends Operateur implements Comportement {

	@Override
	public void appliquer(Robot r) {
		System.out.println("Split");		
	}
	
	@Override
	public void appliquer(Robot r, int n) {
		System.out.println("Split");
		Robot nr = new Robot(r.getType());
		
//		Position p = r.getPositionOnMap();
		
		
		
		
	}

	@Override
	public String toString() {
		return "S";
	}

	@Override
	public boolean executable(Robot r) {
		return true;
	}

}


// à tester : *(S; X)