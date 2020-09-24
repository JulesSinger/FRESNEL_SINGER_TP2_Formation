package classes;

import java.util.*;

/**
 * Represente un etudiant
 */
public class Etudiant {
	/**
	 * Identite de l'etudiant
	 */
	private Identite id;

	/**
	 * Formation de l'etudiant
	 */
	private Formation formation;

	/**
	 * Resultats de l'etudiant
	 */
	private HashMap<String, ArrayList<Double>> resultats;

	/**
	 * Constructeur d'un etudiant
	 * 
	 * @param identite identite de l'etudiant
	 * @param forma    formation de l'etudiant
	 */
	public Etudiant(Identite identite, Formation forma) {
		this.id = identite;
		this.formation = forma;
		this.resultats = new HashMap<String, ArrayList<Double>>();

		// Ajout des matieres dans les resultats
		for (String matiere : this.formation.getMatieres().keySet()) {
			this.resultats.put(matiere, new ArrayList<Double>());
		}
	}

	/**
	 * Ajoute une note aux resultats de l'etudiant
	 * 
	 * @param matiere matiere correspondant a la note
	 * @param note    note attribuee
	 * @throws Exception
	 */
	public void ajouterNote(String matiere, double note) throws Exception {
		if (note < 0 && note > 20)
			throw new Exception("La note n'est pas comprise entre 0 et 20");
		if (!this.resultats.containsKey(matiere))
			throw new Exception("L'etudiant ne suit pas le cours de " + matiere + " dans sa formation");

		this.resultats.get(matiere).add(note);
	}

	/**
	 * Donne la moyenne d'une matiere
	 * 
	 * @param matiere matiere
	 * @return moyenne de la matiere
	 * @throws Exception
	 */
	public double moyenne(String matiere) throws Exception {
		if (!this.resultats.containsKey(matiere))
			throw new Exception("L'etudiant ne suit pas le cours de " + matiere + " dans sa formation");

		double sum = 0;

		for (double note : this.resultats.get(matiere)) {
			sum += note;
		}

		return Math.round(sum / this.resultats.get(matiere).size() * 100.0) / 100.0;
	}

	/**
	 * Donne la moyenne generale de l'etudiant
	 * 
	 * @return moyenne generale de l'etudiant
	 * @throws Exception
	 */
	public double moyenneGenerale() throws Exception {
		double sum = 0;
		double nb = 0;

		for (String matiere : this.formation.getMatieres().keySet()) {
			double coef = this.formation.getMatieres().get(matiere);

			sum += this.moyenne(matiere) * coef;
			nb += coef;
		}
		return Math.round(sum / nb * 100.0) / 100.0;
	}

	/**
	 * Donne tous les resultats
	 * 
	 * @return resultats
	 */
	public HashMap<String, ArrayList<Double>> getResultats() {
		return this.resultats;
	}

	/**
	 * Recupere la formation de l'etudiant
	 * 
	 * @return formation de l'etudiant
	 */
	public Formation getFormation() {
		return this.formation;
	}
	
	/**
	 * Forme textuelle de l'etudiant
	 * 
	 * @return forme textuelle de l'etudiant
	 */
	public String toString() {
		return this.id.getNom() + " " + this.id.getPrenom() + " [" + this.id.getNip() + "]";
	}
}
