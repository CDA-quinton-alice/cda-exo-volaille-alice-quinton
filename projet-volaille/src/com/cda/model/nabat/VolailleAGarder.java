package com.cda.model.nabat;

import java.time.LocalDateTime;

import com.cda.model.Volaille;

public abstract class VolailleAGarder extends Volaille implements IAGarder {
	
	protected final LocalDateTime dateDAccueil;

	public VolailleAGarder() {
		this.dateDAccueil = LocalDateTime.now();
	}

	public LocalDateTime getDateDAccueil() {
		return dateDAccueil;
	}
	
}
