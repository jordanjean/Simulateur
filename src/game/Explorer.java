package game;

import game.entites.Direction;
import game.entites.Robot;
import game.map.Map;

public class Explorer extends Operateur implements Comportement {

	public Explorer() {
	}

	@Override
	public void appliquer(Robot r) {
		System.out.println("Explorer");
	}

	@Override
	public void appliquer(Robot r, int n) {
		System.out.println("Explorer");
		
		Direction dir = r.getCurrentDirection();
		int remaining_steps = r.deplacer(dir, n);
		
		// il y a un obstacle
		if(remaining_steps != 0){
			r.setCurrentDirection(r.tournerAdroite(dir));
		}
	}

	@Override
	public String toString() {
		return "E";
	}

	@Override
	public boolean executable(Robot r) {
		return true;
	}

}
