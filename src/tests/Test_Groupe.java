package tests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import classes.Etudiant;
import classes.Formation;
import classes.Groupe;
import classes.Identite;

/**
 * Classe de test pour la classe Etudiant
 */
public class Test_Groupe {
	
	
	private Etudiant etu1;
	private Etudiant etu2;
	private Etudiant etu3;
	private Groupe gr;

	@Before
	public void init() {
		// premiere formation
		HashMap<String, Double> matieresForm1 = new HashMap<String,Double>();
		Formation form1 = new Formation("DUT_info", matieresForm1);
		form1.ajouterMatiere("info", 2.0);
		form1.ajouterMatiere("maths", 1.0);
		
		// deuxieme formation
		HashMap<String, Double> matieresForm2 = new HashMap<String,Double>();
		Formation form2 = new Formation("DUT_info", matieresForm1);
		form2.ajouterMatiere("info", 2.0);
		form2.ajouterMatiere("francais", 1.0);
		
		//etudiants
		 etu1 = new Etudiant(new Identite("1", "Fresnel", "Hugo"), form1);
		 etu2 = new Etudiant(new Identite("2", "Poirel", "Jeremy"), form1);
		 etu3 = new Etudiant(new Identite("3", "Singer", "Jules"), form2);
		
		 //groupe d'etudiants
		 gr = new Groupe(form1);
		
	}
	
	/**
	 * Test de la methode ajouterEtudiant avec les etudiants de bonne formation
	 */
	@Test
	public void testAjouterEtudiant() {
		// Methode testee
		gr.ajouterEtudiant(etu1);
		gr.ajouterEtudiant(etu2);
		
		// Verifications
		assertEquals("Il devrait y avoir deux etudiants dans le groupe", 2, gr.getEtudiants().size());
	}
	
	/**
	 * Test de la methode ajouterEtudiant avec un etudiant de mauvaise formation
	 */
	@Test
	public void testAjouterEtudiantIncorrecte() {
		// Methode testee
		gr.ajouterEtudiant(etu3);
		
		// Verifications
		assertEquals("Il ne devrait pas y avoir d'etudiants dans le groupe", 0, gr.getEtudiants().size());
	}
	
	/**
	 * Test de la methode supprimerEtudiant 
	 */
	@Test
	public void testSupprimerEtudiant() {
		
		//Preparation des donnees
		gr.ajouterEtudiant(etu1);
		gr.ajouterEtudiant(etu2);
		
		// Methode testee
		gr.supprimerEtudiant(etu1);
		
		// Verifications
		assertEquals("Il devrait n'y avoir qu'un seul etudiant dans le groupe", 1, gr.getEtudiants().size());
	}
	
	/**
	 * Test de la methode supprimerEtudiant quand l'etudiant supprime n'existe pas, la liste ne doit alors pas changer
	 */
	@Test
	public void testSupprimerEtudiantInexistant() {
		
		//Preparation des donnees
		gr.ajouterEtudiant(etu1);
		gr.ajouterEtudiant(etu2);
		
		// Methode testee
		gr.supprimerEtudiant(etu3);
		
		// Verifications
		assertEquals("Il devrait y avoir deux etudiants dans le groupe", 2, gr.getEtudiants().size());
	}
	
	/**
	 * Test de la methode moyennePourMatiere pour une matiere existante
	 * @throws Exception 
	 */
	@Test
	public void testMoyennePourMatiereExistante() throws Exception {
		//Preparation des donnees
		gr.ajouterEtudiant(etu1);
	   	etu1.ajouterNote("maths", 10.0);
		gr.ajouterEtudiant(etu2);
       	etu2.ajouterNote("maths", 16.0);
       	
		// Methode testee
		Double moyMatiere = gr.moyennePourMatiere("maths");
		
		// Verifications
		assertEquals("La moyenne devrait etre de 13", (Double)13.0, moyMatiere);
	}
	
	/**
	 * Test de la methode moyennePourMatiere pour une matiere inexistante
	 * @throws Exception 
	 */
	@Test(expected = Exception.class)
	public void testMoyennePourMatiereInexistante() throws Exception {
		//Preparation des donnees
		gr.ajouterEtudiant(etu1);
	   	etu1.ajouterNote("maths", 10.0);
		gr.ajouterEtudiant(etu2);
       	etu2.ajouterNote("maths", 16.0);
       	
		// Methode testee
		Double moyMatiere = gr.moyennePourMatiere("info");
	}
	
	/**
	 * Test de la methode moyenneGenerale pour un groupe non vide
	 * @throws Exception 
	 */
	public void testMoyenneGeneraleGroupeNonVide() throws Exception {
		//Preparation des donnees
		gr.ajouterEtudiant(etu1);
	   	etu1.ajouterNote("maths", 10.0);
	   	etu1.ajouterNote("info", 15.0);

		gr.ajouterEtudiant(etu2);
       	etu2.ajouterNote("maths", 20.0);
       	etu2.ajouterNote("info", 10.0);

		// Methode testee
		Double moyGenerale = gr.moyenneGenerale();
		
		// Verification
		assertEquals("La moyenne devrait etre de 15.0", (Double)15.0, moyGenerale);

	}
	
	/**
	 * Test de la methode moyenneGenerale pour un groupe vide
	 * @throws Exception 
	 */
	public void testMoyenneGeneraleGroupeVide() throws Exception {
		// Methode testee
		Double moyGenerale = gr.moyenneGenerale();
		
		// Verification
		assertEquals("La moyenne devrait etre de 0.0", (Double)0.0, moyGenerale);

	}
	
}
