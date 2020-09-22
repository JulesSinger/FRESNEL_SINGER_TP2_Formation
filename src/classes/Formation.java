package classes;

import java.util.HashMap;

/**
 * represente une formation constituee d'un identifiant et d'une liste de matieres
 */
public class Formation {
	
	//identifiant de la formation
	private String identifiant;
	
	
	//matieres de la formation
    private HashMap<String, Double> matieres;
    
    /**
     * Constructeur d'un objet Formation
     * @param id identifiant
     * @param mats matieres
     */
    public Formation(String id, HashMap<String, Double> mats) {
        this.identifiant = id;
        this.matieres = mats;
    }
    
    /**
     * Ajoute une matiere dans la liste des matieres
     * @param nomMat nom de la matiere
     * @param coeff coefficient de la matiere
     */
    public void ajouterMatiere(String nomMat, Double coeff) {
    	if(!matieres.containsKey(nomMat)) {
    		matieres.put(nomMat, coeff);
    	}
    }
    
    /**
     * Supprime une matiere de la liste des matieres
     * @param nomMat
     */
    public void supprimerMatiere(String nomMat) {
    	if(matieres.containsKey(nomMat)) {
    		matieres.remove(nomMat);
    	}
    }
    
    /**
     * donne le coefficient d'une matiere
     * @param matiere
     * @return le coefficient associe a la matiere
     */
    public double getCoefficientMatiere(String matiere) {
        if (matieres.containsKey(matiere))
            return matieres.get(matiere);

        return 0.0;
    }
}
