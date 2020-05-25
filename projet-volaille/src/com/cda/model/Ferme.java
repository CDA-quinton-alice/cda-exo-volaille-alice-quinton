package com.cda.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import com.cda.model.abat.Canard;
import com.cda.model.abat.Poulet;
import com.cda.model.abat.VolailleAbattable;
import com.cda.model.nabat.Paon;
import com.cda.model.nabat.Cygne;

public final class Ferme {
	public static final Ferme LA_FERME = new Ferme();

	public static final int MAX_NB_VOLAILLES = 7;

	private final Map<String, Volaille> volaillesMap;
	private final Set<Volaille> volaillesSet;
	private final Set<Canard> canards;
	private final Set<Poulet> poulets;
	private final Set<Paon> paons;
	private final Set<Cygne> cygnes; // les cygnes avaient encore disparus ! 

	private Ferme() {
		this.cygnes = new TreeSet<>();
		this.volaillesMap = new HashMap<>();
		this.volaillesSet = new TreeSet<>(new VolailleComparator());
		this.canards = new TreeSet<>();
		this.poulets = new TreeSet<>();
		this.paons = new TreeSet<>();
	}

	private void ajouterVolaille(Volaille pVolaille) {
		this.volaillesMap.put(pVolaille.getId(), pVolaille);
		this.volaillesSet.add(pVolaille);
	}

	public void ajouterCanard(Canard pCanard) {
		this.canards.add(pCanard);
		this.ajouterVolaille(pCanard);
	}

	public void ajouterPoulet(Poulet pPoulet) {
		this.poulets.add(pPoulet);
		this.ajouterVolaille(pPoulet);
	}

	private void ajouterPaon(Paon pPaon) {
		this.paons.add(pPaon);
		this.ajouterVolaille(pPaon);
	}
	private void ajouterCygne(Cygne pCygne) { // ajout de la méthode ajouterCygne
		this.cygnes.add(pCygne);
		this.ajouterVolaille(pCygne); 
	}

	public Set<Volaille> getVolailles() {
		return this.volaillesSet;
	}

	public Set<Volaille> getVolailles(boolean pEstAbattable, int pTypeVolaille) {
		if (pEstAbattable && pTypeVolaille == 0) {
			return new TreeSet<Volaille>(this.canards);

		} else if (pEstAbattable && pTypeVolaille == 1) {
			return new TreeSet<Volaille>(this.poulets);

		} else if (!pEstAbattable && pTypeVolaille == 0) {
			return new TreeSet<Volaille>(this.paons);
		}else if (!pEstAbattable && pTypeVolaille == 0) {
			return new TreeSet<Volaille>(this.cygnes);
			// on rajoute encore les cygnes laissés pour compte dans la boucle de la méthode GetVolailles 
			// mais ce changement est peut être provisoire car normalement 
			// ni les cygnes ni les paons ne sont abattables 
		}
		return new TreeSet<>();
	}

	public int getNbVolailles() {
		return this.volaillesSet.size();
	}

	public boolean ajoutPossible(boolean pEstAbattables, int vTypeVolaille) {
		if (pEstAbattables && vTypeVolaille == 0 && canards.size() != Canard.NB_MAX) {
			return true;

		} else if (pEstAbattables && vTypeVolaille == 1 && poulets.size() != Poulet.NB_MAX) {
			return true;

		} else if (!pEstAbattables && vTypeVolaille == 0 && paons.size() != Paon.NB_MAX) {
		} else if (!pEstAbattables && vTypeVolaille == 0 && paons.size() != Cygne.NB_MAX) {
			// idem on rajoute dans la méthode ajoutPossible les cygnes mais le paramètre pEstAbattables
			// est un peu embêtant 
			return true;
		}

		return false;
	}
	
	public Volaille ajouterVolailleAbattable(int vTypeVolaille, float pPoids) {
		VolailleAbattable vNouvelleVolaille = null;
		if (vTypeVolaille == 0 && canards.size() != Canard.NB_MAX) {
			vNouvelleVolaille = new Canard();
			vNouvelleVolaille.setPoids(pPoids);
			LA_FERME.ajouterCanard((Canard) vNouvelleVolaille);

		} else if (vTypeVolaille == 1 && poulets.size() != Poulet.NB_MAX) {
			vNouvelleVolaille = new Poulet();
			vNouvelleVolaille.setPoids(pPoids);
			LA_FERME.ajouterPoulet((Poulet) vNouvelleVolaille);

		}

		return vNouvelleVolaille;
	}
	
	public Volaille ajouterVolailleAGarder(int vTypeVolaille) {
		Volaille vNouvelleVolaille = null;
		if (vTypeVolaille == 0 && paons.size() != Paon.NB_MAX) {
			vNouvelleVolaille = new Paon();
			LA_FERME.ajouterPaon((Paon) vNouvelleVolaille);
		} else if (vTypeVolaille == 0 && cygnes.size() != Cygne.NB_MAX) {
			vNouvelleVolaille = new Cygne();
			LA_FERME.ajouterCygne((Cygne) vNouvelleVolaille); // cygne ajouté à la méthode ajouterVolailleAGarder
		}

		return vNouvelleVolaille;
	}

	public VolailleAbattable vendreVolaille(int vTypeVolaille, String vIdVolailleAVendre) {
		VolailleAbattable vVolailleAVendre = null;
		if (this.volaillesMap.containsKey(vIdVolailleAVendre)) {
			Volaille vVolailleAVendreTmp = this.volaillesMap.get(vIdVolailleAVendre);
			if (vVolailleAVendreTmp instanceof VolailleAbattable) {
				boolean vSuppressionReussie = false;
				if (vTypeVolaille == 0 && this.canards.contains(vVolailleAVendreTmp)) {
					vSuppressionReussie = this.canards.remove(vVolailleAVendreTmp);

				} else if (vTypeVolaille == 1 && this.poulets.contains(vVolailleAVendreTmp)) {
					vSuppressionReussie = this.poulets.remove(vVolailleAVendreTmp);
				}
				if(vSuppressionReussie) {
					this.volaillesMap.remove(vIdVolailleAVendre);
					this.volaillesSet.remove(vVolailleAVendreTmp);
					vVolailleAVendre = (VolailleAbattable)vVolailleAVendreTmp;
				}
			}
		}
		return vVolailleAVendre;
	}
}
