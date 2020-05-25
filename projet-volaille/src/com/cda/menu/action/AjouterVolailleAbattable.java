package com.cda.menu.action;

import static com.cda.model.Ferme.LA_FERME;
import static com.cda.tools.Ihm.IHM_INS;

import com.cda.model.Ferme;
import com.cda.model.Volaille;

final class AjouterVolailleAbattable extends Action {
	
	private static final int ID = 1;
	private static final String DESC = "ajouter une volaille";
	
	AjouterVolailleAbattable() {
		super(ID, DESC);
	}

	@Override
	public boolean executer() {
		if(Ferme.MAX_NB_VOLAILLES == LA_FERME.getNbVolailles()) {
			IHM_INS.afficher("> il ne reste plus de place dans la ferme !");
		} else {

			IHM_INS.afficher("choisissez un type de volaille :");
			IHM_INS.afficher("\t0)- Canard");
			IHM_INS.afficher("\t1)- Poulet");

			int vTypeVolaille = IHM_INS.lireEntier();
			if( LA_FERME.ajoutPossible(true, vTypeVolaille)) {
				IHM_INS.afficher("choisissez le poids initial :");
				float vPoids = IHM_INS.lireFloat();
				
				Volaille vNouvelleVolaille = LA_FERME.ajouterVolailleAbattable(vTypeVolaille,vPoids);
				IHM_INS.afficher("> la volaille suivante a été ajoutée : "+vNouvelleVolaille);
			} else {
				IHM_INS.afficher("> il ne reste plus de place dans la ferme !");
			}
			
		}

		return Boolean.TRUE;
	}

}
