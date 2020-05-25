package com.cda.model.nabat;

public final class Paon extends VolailleAGarder {
	public static final int NB_MAX = 3;
	
	private static int cmpt;

	@Override
	public String idSuivant() {
		return "PA-"+(++cmpt);
	}
	
	@Override
	protected String getTypeNom() {
		return "Paon";
	}
}
