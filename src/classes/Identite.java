package classes;

/**
 * Representation d'une identite
 */
public class Identite {
	/**
	 * Numero d'Identification Personnel
	 */
	private String nip;
	/**
	 * Nom
	 */
	private String nom;

	/**
	 * Prenom
	 */
	private String prenom;

	/**
	 * Constructeur de base d'une identite
	 * 
	 * @param n  numero d'identification personnel
	 * @param no nom
	 * @param pr prenom
	 */
	public Identite(String n, String no, String pr) {
		this.nip = n;
		this.nom = no;
		this.prenom = pr;
	}
	

	/**
	 * Recupere le NIP
	 * 
	 * @return NIP
	 */
	public String getNip() {
		return nip;
	}

	/**
	 * Recupere le nom
	 * 
	 * @return nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Recupere le prenom
	 * 
	 * @return prenom
	 */
	public String getPrenom() {
		return prenom;
	}

}
