package com.cda.model.nabat;

public final class Cygne extends VolailleAGarder {
	public static final int NB_MAX = 2;
	private static int cmpt;

	@Override
	public String idSuivant() {
		return "CY-"+(++cmpt);
	}
	
	@Override
	protected String getTypeNom() {
		return "Cygne";
	}
}
