package listeAppel;

public class Salle {

	private String libelle;
	private int nbPlace;
	
	public Salle(String libelle, int nbPlace) {
		this.libelle = libelle;
		this.nbPlace = nbPlace;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public int getNbPlace() {
		return nbPlace;
	}
	public void setNbPlace(int nbPlace) {
		this.nbPlace = nbPlace;
	}
	
	@Override
	public String toString() {
		return "Salle [libelle=" + libelle + ", nbPlace=" + nbPlace + "]";
	}
}
