package com.cda.model;

import java.util.Comparator;

import com.cda.model.abat.VolailleAbattable;
import com.cda.model.nabat.VolailleAGarder;

public class VolailleComparator implements Comparator<Volaille> {

	@Override
	public int compare(Volaille pVolailleA, Volaille pVolailleB) {
		if(pVolailleA instanceof VolailleAbattable) {
			if(pVolailleB instanceof VolailleAbattable) {
				int vResultat = Float.compare(
						((VolailleAbattable) pVolailleA).getPoids(),
						((VolailleAbattable) pVolailleB).getPoids());
				if(vResultat == 0) {
					vResultat = pVolailleA.id.compareTo(pVolailleB.id);
				}
				return vResultat;
			} else {
				return 1;
			}
		} else {
			if(pVolailleB instanceof VolailleAbattable) {
				return -1;
			} else {
				int vResultat = ((VolailleAGarder)pVolailleA).getDateDAccueil()
						.compareTo(((VolailleAGarder)pVolailleB).getDateDAccueil());
				if(vResultat == 0) {
					vResultat = pVolailleA.id.compareTo(pVolailleB.id);
				}
			}
		}
		return compare(pVolailleB,pVolailleA);
	}

}
