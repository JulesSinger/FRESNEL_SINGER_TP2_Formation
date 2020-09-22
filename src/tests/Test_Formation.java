package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;

import org.junit.Test;

import classes.Formation;

/**
 * Classe de test pour la classe Formation
 */
public class Test_Formation {
	/**
	 * Test de la methode ajouterMatiere
	 */
	@Test
	public void testAjouterMatiere() {
		// Preparation des donnees
		Formation f = new Formation("Formation 1", new HashMap<String, Double>());
		
		// Methode testee
		f.ajouterMatiere("Maths", (Double) 2.5);
		f.ajouterMatiere("Anglais", (Double) 1.0);
		
		// Verifications
		assertEquals("Il ne devrait y avoir que 2 matieres", 2, f.getMatieres().size());
		assertTrue("La matiere Maths devrait etre ajoutee", f.getMatieres().containsKey("Maths"));
		assertTrue("La matiere Anglais devrait etre ajoutee", f.getMatieres().containsKey("Anglais"));
	}
	
	/**
	 * Test de la methode supprimerMatiere
	 */
	@Test
	public void testSupprimerMatiere() {
		// Preparation des donnees
		Formation f = new Formation("Formation 1", new HashMap<String, Double>());
		f.ajouterMatiere("Maths", (Double) 2.5);
		f.ajouterMatiere("Anglais", (Double) 1.0);
		
		// Methode testee
		f.supprimerMatiere("Maths");
		
		// Verifications
		assertEquals("Il ne devrait y avoir que 1 matiere", 1, f.getMatieres().size());
		assertFalse("La matiere Maths devrait etre supprimee", f.getMatieres().containsKey("Maths"));
		assertTrue("La matiere Anglais devrait toujours etre presente", f.getMatieres().containsKey("Anglais"));
	}
	
	
	/**
	 * Test de la methode getCoefficientMatiere
	 */
	@Test
	public void testGetCoefficientMatiere() {
		// Preparation des donnees
		Formation f = new Formation("Formation 1", new HashMap<String, Double>());
		f.ajouterMatiere("Maths", (Double) 2.5);
		f.ajouterMatiere("Anglais", (Double) 1.0);
		
		// Methode testee
		Double coef1 = f.getCoefficientMatiere("Maths");
		Double coef2 = f.getCoefficientMatiere("Anglais");
		Double coef3 = f.getCoefficientMatiere("???");
		
		// Verifications
		assertEquals("La matiere Maths devrait ne possede pas le bon coefficient", (Double) 2.5, coef1);
		assertEquals("La matiere Anglais devrait ne possede pas le bon coefficient", (Double) 1.0, coef2);
		assertEquals("Le coefficient devrait etre 0.0 pour une matiere qui n'est pas dans la formation", (Double) 0.0, coef3);
	}
}
