package classes;

import java.util.ArrayList;
import java.util.Collections;

import comparators.AlphaComparator;
import comparators.MeriteComparator;

/**
 * Represente un groupe de classe
 */
public class Groupe {

	/**
	 * Formation suivie par le groupe
	 */
	private Formation formation;

	/**
	 * Liste des etudiants dans le groupe
	 */
	private ArrayList<Etudiant> etudiants;

	/**
	 * Constructeur d'un groupe
	 * 
	 * @param forma formation suivie par le groupe
	 */
	public Groupe(Formation forma) {
		this.formation = forma;
		this.etudiants = new ArrayList<Etudiant>();
	}

	/**
	 * Ajoute un etudiant au groupe
	 * 
	 * @param e etudiant a ajouter
	 */
	public void ajouterEtudiant(Etudiant e) {
		if (e.getFormation().equals(this.formation) && !this.etudiants.contains(e)) {
			this.etudiants.add(e);
		}
	}

	/**
	 * Supprime un etudiant du groupe
	 * 
	 * @param e etudiant a supprimer
	 */
	public void supprimerEtudiant(Etudiant e) {
		this.etudiants.remove(e);
	}

	/**
	 * Calcule la moyenne du groupe pour une matiere
	 * 
	 * @param matiere matiere demandee
	 * @return la moyenne du groupe
	 * @throws Exception
	 */
	public double moyennePourMatiere(String matiere) throws Exception {
		if (!this.formation.getMatieres().containsKey(matiere))
			throw new Exception("La matiere n'est pas dans la formation suivie par le groupe.");
		
		double sum = 0.0;

		for (Etudiant e : this.etudiants) {
			sum += e.moyenne(matiere);
		}

		return Math.round(sum / this.etudiants.size() * 100.0) / 100.0;
	}

	/**
	 * Calcul la moyenne generale du groupe
	 * 
	 * @return moyenne generale du groupe
	 * @throws Exception
	 */
	public double moyenneGenerale() throws Exception {
		double sum = 0.0;
		double nb = 0.0;

		for (String matiere : this.formation.getMatieres().keySet()) {
			double coef = this.formation.getCoefficientMatiere(matiere);
			sum += this.moyennePourMatiere(matiere) * coef;
			nb += coef;
		}

		return Math.round(sum / nb * 100.0) / 100.0;
	}

	/**
	 * Recupere les etudiants du groupe
	 * 
	 * @return liste des etudiants du groupe
	 */
	public ArrayList<Etudiant> getEtudiants() {
		return this.etudiants;
	}

	/**
	 * Tri les etudiants par merite (moyenne generale decroissante)
	 */
	public void triParMerite() {
		Collections.sort(this.etudiants, new MeriteComparator());
	}
	
	/**
	 * Tri les etudiants par ordre alphabetique
	 */
	public void triAlpha() {
		Collections.sort(this.etudiants, new AlphaComparator());
	}
}
