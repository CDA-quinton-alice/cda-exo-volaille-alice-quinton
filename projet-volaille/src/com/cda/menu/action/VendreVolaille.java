package com.cda.menu.action;

import static com.cda.model.Ferme.LA_FERME;
import static com.cda.tools.Ihm.IHM_INS;

import java.util.Set;

import com.cda.model.Volaille;
import com.cda.model.abat.VolailleAbattable;

final class VendreVolaille extends Action {

	private static final int ID = 6;
	private static final String DESC = "vendre une volaille";
	
	VendreVolaille() {
		super(ID, DESC);
	}

	@Override
	public boolean executer() {
		IHM_INS.afficher("choisissez un type de volaille :");
		IHM_INS.afficher("\t0)- Canard");
		IHM_INS.afficher("\t1)- Poulet");
		
		int vTypeVolaille = IHM_INS.lireEntier();
		
		IHM_INS.afficher("saisissez l'id de la volaille à vendre parmis :");
		Set<Volaille> vVolailles = LA_FERME.getVolailles(true,vTypeVolaille);
		for (Volaille vVolaille : vVolailles) {
			IHM_INS.afficher(vVolaille.toString());
		}
		
		String vIdVolailleAVendre = IHM_INS.lireMot();
		VolailleAbattable vVolailleVendue = LA_FERME.vendreVolaille(vTypeVolaille,vIdVolailleAVendre);
		if(vVolailleVendue == null) {
			IHM_INS.afficher("> erreur lors de la vente");
		} else {
			IHM_INS.afficher("> voici la volaille vendue "+vVolailleVendue);
		}
		
		return Boolean.TRUE;
	}

}
