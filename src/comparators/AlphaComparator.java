package comparators;

import java.util.Comparator;

import classes.Etudiant;

/**
 * Classe permettant la comparaison par ordre alphabetique
 */
public class AlphaComparator implements Comparator<Etudiant> {

	@Override
	public int compare(Etudiant o1, Etudiant o2) {
		return o1.toString().compareTo(o2.toString());
	}
}