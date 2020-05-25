package com.cda.model.abat;

import com.cda.model.Volaille;
import com.cda.tools.Utils;

public abstract class VolailleAbattable extends Volaille implements IAbattable {
	
	protected float poids;
	
	public float getPoids() {
		return poids;
	}

	public void setPoids(float poids) {
		this.poids = poids;
	}
	
	public float calculerPrix() {
		return this.poids * this.getPrixAuKilo();
	}

	@Override
	public String toString() {
		return super.toString() 
				+ String.format(", poids=%5s Kg, prix=%5s €",
						Utils.formaterPrixOuPois(this.poids),
						Utils.formaterPrixOuPois(calculerPrix()));
	}
}
