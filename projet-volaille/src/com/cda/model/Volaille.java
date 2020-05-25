package com.cda.model;

public abstract class Volaille implements IGeneratriceDId, Comparable<Volaille> {
	protected final String id;
	protected final String typeNom;
	
	public Volaille() {
		this.id = this.idSuivant();
		this.typeNom = this.getTypeNom();
	}

	protected abstract String getTypeNom();

	public String getId() {
		return id;
	}

	@Override
	public String toString() {
		return typeNom + " : id=" + id;
	}
	
	@Override
	public int compareTo(Volaille pAutreVolaille) {
		return this.getId().compareToIgnoreCase(pAutreVolaille.getId());
	}
	
	@Override
	public boolean equals(Object obj) {
		if(! (obj instanceof Volaille) ) {
			return false;
		}
		return this.getId().equals(((Volaille)obj).getId());
	}
	
}
