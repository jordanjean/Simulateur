package game.map;

import game.entites.Entite;

public class CaseEntite extends CaseVide {

	//Attribut
	private Entite monentite;

	public Entite getMonentite() {
		return monentite;
	}

	public void setMonentite(Entite monentite) {
		this.monentite = monentite;
	}

	public CaseEntite(Entite e){
		this.monentite = e;
	}

	@Override
	public String toString() {
		return "CaseEntite; entite :" + monentite.toString();
	}

	@Override
	public Boolean equals(Case c) {
		if(c instanceof CaseEntite){
			CaseEntite tempo  = (CaseEntite) c;
			if (this.monentite.equals(tempo.getMonentite())){
				return true;
			}
			return false;
		}
		return false;
	}
}
