package com.cda.menu.action;

import static com.cda.tools.Ihm.IHM_INS;

import com.cda.model.abat.Canard;
import com.cda.model.abat.Poulet;

final class ModifierPrixDuJour extends Action {

	private static final int ID = 5;
	private static final String DESC = "modifier prix du jours";
	
	ModifierPrixDuJour() {
		super(ID, DESC);
	}

	@Override
	public boolean executer() {
		IHM_INS.afficher("choisissez un type de volaille :");
		IHM_INS.afficher("\t0)- Canard");
		IHM_INS.afficher("\t1)- Poulet");
		
		int vTypeVolaille = IHM_INS.lireEntier();
		
		IHM_INS.afficher("choisissez le prix du jour :");
		float vPrixDuJours = IHM_INS.lireFloat();
		
		if(vTypeVolaille == 0) {
			Canard.modifierPrixKg(vPrixDuJours);
		} else if(vTypeVolaille == 1) {
			Poulet.modifierPrixKg(vPrixDuJours);
		}

		return Boolean.TRUE;
	}

}
