package listeAppel;

public class Classe {

	private String libelle;

	/**
	 * @param libelle
	 */
	public Classe(String libelle) {
		this.libelle = libelle;
	}

	/**
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}

	/**
	 * @param libelle the libelle to set
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Classe [libelle=" + libelle + "]";
	}
	
	
}
