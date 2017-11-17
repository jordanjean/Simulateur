package game.map;

public class CaseWall extends CaseDecor {

	@Override
	public String toString() {
		return "CaseWall ";
	}

	@Override
	public Boolean equals(Case c) {
		if (c instanceof CaseWall){
			return true;
		}
		return false;
	}

	
}
