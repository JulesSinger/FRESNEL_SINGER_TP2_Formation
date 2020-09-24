package comparators;

import java.util.Comparator;

import classes.Etudiant;

/**
 * Classe permettant la comparaison par merite
 */
public class MeriteComparator implements Comparator<Etudiant> {

	@Override
	public int compare(Etudiant o1, Etudiant o2) {
		try {
			double moy1 = o1.moyenneGenerale();
			double moy2 = o2.moyenneGenerale();
			
			if (moy1 < moy2)
				return 1;
			else
				return -1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
}
