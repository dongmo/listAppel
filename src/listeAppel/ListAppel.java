package listeAppel;

/*
 * Objet contenant le nom de salle et la liste de ses étudiants
 */

import java.util.List;

public class ListAppel {

	private String libelleSalle;
	private List<Etudiant> etudiants;
	
	
	
	public ListAppel(String libelleSalle, List<Etudiant> etudiants) {
		this.libelleSalle = libelleSalle;
		this.etudiants = etudiants;
	}
	
	public String getLibelleSalle() {
		return libelleSalle;
	}
	public void setLibelleSalle(String libelleSalle) {
		this.libelleSalle = libelleSalle;
	}
	public List<Etudiant> getEtudiants() {
		return etudiants;
	}
	public void setEtudiants(List<Etudiant> etudiants) {
		this.etudiants = etudiants;
	}
}
