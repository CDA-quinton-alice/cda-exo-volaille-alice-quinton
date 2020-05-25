package com.cda.zprog;

import java.util.TreeMap;

import com.cda.menu.action.Action;
import com.cda.menu.action.LesActions;
import static com.cda.tools.Ihm.IHM_INS;

public class Programme {

	public static void main(String[] args) {
		IHM_INS.changerMode(false,true);
		
		TreeMap<Integer,Action> actions = new TreeMap<>();
		ajouterAction(actions,LesActions.AFFICHER_LES_VOLAILLES);
		ajouterAction(actions,LesActions.AJOUTER_PAON);
		ajouterAction(actions,LesActions.AJOUTER_VOLAILLE);
		ajouterAction(actions,LesActions.QUITTER);
		ajouterAction(actions,LesActions.MODIFIER_POIDS_ABATTAGE);
		ajouterAction(actions,LesActions.MODIFIER_PRIX_DU_JOUR);
		ajouterAction(actions,LesActions.VENDRE_VOLAILLE);
		
		boolean vContinuer;
		int vActionSaisie;
		do {
			IHM_INS.afficher("\n*******************\nsaisissez une action");
			for (Action action : actions.values()) {
				IHM_INS.afficher("\t"+action.getId()+")- "+action.getDescription());
			}
			vActionSaisie = IHM_INS.lireEntier();
			vContinuer = actions.get(vActionSaisie).executer();
		} while (vContinuer);
	}

	private static void ajouterAction(TreeMap<Integer,Action> actions, Action pAction) {
		actions.put(pAction.getId(), pAction);
	}
}
