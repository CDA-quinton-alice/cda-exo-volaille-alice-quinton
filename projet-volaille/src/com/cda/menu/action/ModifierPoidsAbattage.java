package com.cda.menu.action;

import static com.cda.tools.Ihm.IHM_INS;

import com.cda.model.abat.Canard;
import com.cda.model.abat.Poulet;

final class ModifierPoidsAbattage extends Action {

	private static final int ID = 4;
	private static final String DESC = "modifier poids abattage";
	
	ModifierPoidsAbattage() {
		super(ID, DESC);
	}

	@Override
	public boolean executer() {
		IHM_INS.afficher("choisissez un type de volaille :");
		IHM_INS.afficher("\t0)- Canard");
		IHM_INS.afficher("\t1)- Poulet");
		
		int vTypeVolaille = IHM_INS.lireEntier();
		
		IHM_INS.afficher("choisissez le poids d'abattage :");
		float vNouveauPoidsDAbattage = IHM_INS.lireFloat();
		
		if(vTypeVolaille == 0) {
			Canard.modifierPoidsDAbattage(vNouveauPoidsDAbattage);
		} else if(vTypeVolaille == 1) {
			Poulet.modifierPoidsDAbattage(vNouveauPoidsDAbattage);
		}
		return Boolean.TRUE;
	}

}
