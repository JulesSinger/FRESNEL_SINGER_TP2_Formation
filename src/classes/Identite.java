package classes;

/**
 * Representation d'une identite
 */
public class Identite {
	/**
	 * Numero d’Identification Personnel
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
	 * @param n numero d'identification personnel
	 * @param no nom
	 * @param pr prenom
	 */
	public Identite(String n, String no, String pr) {
		this.nip = n;
		this.nom = no;
		this.prenom = pr;
	}
}
