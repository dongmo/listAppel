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
	
	public ListAppel() {
		// TODO Auto-generated constructor stub
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ListAppel [libelleSalle=" + libelleSalle + ", etudiants=" + etudiants + "]";
	}

	
}
