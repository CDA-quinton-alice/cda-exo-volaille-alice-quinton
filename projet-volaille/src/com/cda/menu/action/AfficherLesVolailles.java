package com.cda.menu.action;

import static com.cda.model.Ferme.LA_FERME;
import static com.cda.tools.Ihm.IHM_INS;

import java.util.Set;

import com.cda.model.Volaille;

final class AfficherLesVolailles extends Action {

	private static final int ID = 3;
	private static final String DESC = "afficher les volailles";
	
	AfficherLesVolailles() {
		super(ID, DESC);
	}

	@Override
	public boolean executer() {
		Set<Volaille> vVolailles = LA_FERME.getVolailles();
		IHM_INS.afficher("il y a "+vVolailles.size()+" volailles :");
		for (Volaille vVolaille : vVolailles) {
			IHM_INS.afficher(vVolaille.toString());
		}
		return Boolean.TRUE;
	}
	
	

}
