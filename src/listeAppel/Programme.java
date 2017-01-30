package listeAppel;

public class Programme {

	private String salle;
	private String classe;
	private String matiere;
	private long effectif;
	/**
	 * @return the salle
	 */
	public String getSalle() {
		return salle;
	}
	/**
	 * @param salle the salle to set
	 */
	public void setSalle(String salle) {
		this.salle = salle;
	}
	/**
	 * @return the classe
	 */
	public String getClasse() {
		return classe;
	}
	/**
	 * @param classe the classe to set
	 */
	public void setClasse(String classe) {
		this.classe = classe;
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
	 * @return the effectif
	 */
	public long getEffectif() {
		return effectif;
	}
	/**
	 * @param effectif the effectif to set
	 */
	public void setEffectif(long effectif) {
		this.effectif = effectif;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Programme [salle=" + salle + ", classe=" + classe + ", matiere=" + matiere + ", effectif=" + effectif
				+ "]";
	}
	
}
