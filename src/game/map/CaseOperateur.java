package game.map;

import game.Operateur;

public class CaseOperateur extends CaseVide {

	//Attributs
	private Operateur monOperateur;

	//Getter and Setter
	public Operateur getMonOperateur() {
		return monOperateur;
	}

	public void setMonOperateur(Operateur monOperateur) {
		this.monOperateur = monOperateur;
	}

	public CaseOperateur(Operateur op){
		this.monOperateur = op;
	}

	@Override
	public String toString() {
		return "CaseOperateur; ope :" + monOperateur.toString();
	}

	@Override
	public Boolean equals(Case c) {
		if (c instanceof CaseOperateur){
			CaseOperateur uneCase = (CaseOperateur)c;
			if (this.monOperateur.equals(uneCase.getMonOperateur())){
				return true;
			}
		}
		return false;
	}
}
