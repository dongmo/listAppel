package listeAppel;

import java.util.List;

public class ClasseForMatiere {

	private String matiere;
	private List<String> classes;
	
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
	 * @return the classes
	 */
	public List<String> getClasses() {
		return classes;
	}
	/**
	 * @param classes the classes to set
	 */
	public void setClasses(List<String> classes) {
		this.classes = classes;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ClasseForMatiere [matiere=" + matiere + ", classes=" + classes + "]";
	}
	
}
