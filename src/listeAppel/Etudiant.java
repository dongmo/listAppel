package listeAppel;

public class Etudiant {

	private String nom;
	private String matiere;
	private String filiere;
	
	public Etudiant(String nom, String matiere) {
		this.nom = nom;
		this.matiere = matiere;
	}
	
	/**
	 * @param nom
	 * @param matiere
	 * @param filiere
	 */
	public Etudiant(String nom, String matiere, String filiere) {
		super();
		this.nom = nom;
		this.matiere = matiere;
		this.filiere = filiere;
	}

	
	/**
	 * 
	 */
	public Etudiant() {
		
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the matiere
	 */
	public String getMatiere() {
		return matiere;
	}

	/**
	 * @param matiere the matiere to set
	 */
	public void setMatiere(String matiere) {
		this.matiere = matiere;
	}

	/**
	 * @return the filiere
	 */
	public String getFiliere() {
		return filiere;
	}

	/**
	 * @param filiere the filiere to set
	 */
	public void setFiliere(String filiere) {
		this.filiere = filiere;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Etudiant [nom=" + nom + ", matiere=" + matiere + ", filiere=" + filiere + "]";
	}
}
