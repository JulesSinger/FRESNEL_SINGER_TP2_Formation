package tests;


import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import classes.Etudiant;
import classes.Formation;
import classes.Identite;

public class Test_etudiant {
	
	 private Etudiant etu;

	    @Before
	    public void setUp() {
	        HashMap<String, Double> matieres = new HashMap<>();
	        matieres.put("Math", 3.0);
	        matieres.put("Francais", 1.0);
	        matieres.put("Informatique", 10.0);
	        Formation formation = new Formation("DUT_info", matieres);
	        etu = new Etudiant(new Identite("1", "Fresnel", "Hugo"), formation);
	    }
	    
	    /**
	     * test de la methode d'ajout d'une note
	     * @throws Exception
	     */
	    @Test
	    public void test_ajouterNote() throws Exception {
	    	etu.ajouterNote("Math", 17.5);
	    	etu.ajouterNote("Math", 1.5);
	    	ArrayList<Double> notes = etu.getResultats().get("Math");
	   
	    	assertEquals("la note devrait etre 17.5",(Double)17.5, notes.get(0));
	    	assertEquals("la note devrait etre 17.5",(Double)1.5, notes.get(1));
	    }
	    
	    /**
	     * ajout d'une note a une matiere qui n'existe pas, ca ne doit pas
	     * @throws Exception
	     */
	    @Test(expected = Exception.class)
	    public void ajouterNoteMatiereIncorrecte() throws Exception {
	        etu.ajouterNote("Histoire", 20.0);
	    }
	    
	    /**
	     * Test verifiant la moyenne d'un etudiant dans une matiere
	     * @throws Exception 
	     */
	    @Test
	    public void calculerMoyenne() throws Exception {
	        etu.ajouterNote("Informatique", 20);
	        etu.ajouterNote("Informatique", 0);
	        

	        Double moyenneCalculee = etu.moyenne("Informatique");

	        assertEquals("La moyenne devrait etre de 10",(Double)10.0, moyenneCalculee);
	    }
	    
	    /**
	     * Test verifiant la moyenne d'un etudiant dans une matiere
	     * @throws Exception 
	     */
	    @Test(expected = Exception.class)
	    public void calculerMoyenneIncorrecte() throws Exception {
	        etu.ajouterNote("Informatique", 20);
	        etu.ajouterNote("Informatique", 0);
	        
	        Double moyenneCalculee = etu.moyenne("Histoire");
	    }
	    
	    /**
	     * Test verifiant la moyenne general d'un eleve
	     * @throws Exception
	     */
	    @Test
	    public void calculerMoyenneGenerale() throws Exception {
	        etu.ajouterNote("Informatique", 20);
	        etu.ajouterNote("Informatique", 0);
	        etu.ajouterNote("Math", 15);
	        etu.ajouterNote("Math", 15);
	        
	        etu.ajouterNote("Francais", 5);

	        Double moyenneCalculee = etu.moyenneGenerale();
	        assertEquals("La moyenne devrait etre 10,71", (Double)10.71, moyenneCalculee  );
	    }
}
