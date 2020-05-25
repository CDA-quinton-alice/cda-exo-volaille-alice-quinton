package com.cda.model.abat;

public class Canard extends VolailleAbattable {
	public static final int NB_MAX = 4;
	
	private static int cmpt;
	private static float prixKg;
	private static float poidsDAbattage;
	
	@Override
	public String idSuivant() {
		return "CA-"+(++cmpt);
	}

	public static float getPrixKg() {
		return prixKg;
	}
	
	public static void modifierPrixKg(float pNouveauPrixKg) {
		prixKg = pNouveauPrixKg;
	}
	
	public static float getPoidsDAbattage() {
		return poidsDAbattage;
	}
	
	public static void modifierPoidsDAbattage(float pNouveauPoidsDAbattage) {
		poidsDAbattage = pNouveauPoidsDAbattage;
	}

	@Override
	protected String getTypeNom() {
		return "Canard";
	}
	
	@Override
	public float getPrixAuKilo() {
		return prixKg;
	}
}
