package com.cda.menu.action;

import static com.cda.model.Ferme.LA_FERME;
import static com.cda.tools.Ihm.IHM_INS;

import com.cda.model.Ferme;
import com.cda.model.Volaille;

final class AjouterVolailleAGarder extends Action {
	
	private static final int ID = 2;
	private static final String DESC = "ajouter une volaille à garder";
	
	AjouterVolailleAGarder() {
		super(ID, DESC);
	}

	@Override
	public boolean executer() {
		if(Ferme.MAX_NB_VOLAILLES == LA_FERME.getNbVolailles()) {
			IHM_INS.afficher("> il ne reste plus de place dans la ferme !");
		} else {

			IHM_INS.afficher("choisissez un type de volaille :");
			IHM_INS.afficher("\t0)- Paon");
			IHM_INS.afficher("\t1)- Cygne"); // il manquait le cygne
			

			int vTypeVolaille = IHM_INS.lireEntier();
			if( LA_FERME.ajoutPossible(false, vTypeVolaille)) { // changer en true pour que le menu puisse fonctionner
				Volaille vNouvelleVolaille = LA_FERME.ajouterVolailleAGarder(vTypeVolaille);
				IHM_INS.afficher("> la volaille suivante a été ajoutée : "+vNouvelleVolaille);
			} else {
				IHM_INS.afficher("> il ne reste plus de place dans la ferme !");
			}
			
		}

		return Boolean.TRUE;
	}

}
