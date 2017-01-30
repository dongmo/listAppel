package listeAppel;

import java.util.ArrayList;
import java.util.List;

public class Utils {

	public static ClasseForMatiere generateListClassByMatiere(String matiere,List<ClasseMatiere> classeMatieres ){
		
		
		List<ClasseForMatiere> classeForMatieres = new ArrayList<>();
		ClasseForMatiere classeForMatiere = new ClasseForMatiere(); 
		List<String> strings = new ArrayList<>();
		
		for(ClasseMatiere classeMatiere : classeMatieres ){
			if(classeMatiere.getMatiere().equals(matiere)){
				strings.add(classeMatiere.getClasse());
			}
		}
		classeForMatiere.setMatiere(matiere);
		classeForMatiere.setClasses(strings);
		
		return classeForMatiere;
	}
	
}
