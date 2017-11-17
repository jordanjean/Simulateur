package game.map;

public class CaseEmpty extends CaseVide {

	@Override
	public String toString() {
		return "CaseEmpty ";
	}

	@Override
	public Boolean equals(Case c) {
		if(c instanceof CaseEmpty){
			return true;
		}
		return false;
	}
}
